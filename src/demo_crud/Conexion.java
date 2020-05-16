/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;
import java.sql.*;//Libreria para la conexino de la BD
/**
 *
 * @author Irvin Cortez
 */
public class Conexion {
    
    private final String server = "jdbc:mysql://127.0.01:3306/bd_videojuegos";
    private final String usuario = "root"; // Por defecto root
    private final String clave = ""; // Por defecto ""
    private final String driverConnection = "com.mysql.jdbc.Driver";
    private static Connection conexion; // OBJ de Class java.sql
    
    /**
     * Contructor que inicializa la conexion con la base de datos
     * Editar los parametros de la conexion si la conexion no se realiza
     */
    public Conexion(){
        try{
            Class.forName(driverConnection);
            /**
             * Establecer conexion con el mysql
             */
            conexion = DriverManager.getConnection(server,usuario,clave);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion fallida!!!\n" + e.getMessage());
        }
    }
       
    public Connection getConnection(){
        return conexion;
    }
    /**
     * Permite almacenar los campos en la base de datos 
     * @param tabla Tabla destino en la BD
     * @param camposTabla Campos de la BD 
     * @param valoresCampos Valores del campo en el mismo orden que los campos
     */
    public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
        //Cargar la conexion
        Conexion conectar = new Conexion();
        Connection cone = conectar.getConnection();
        try {
            //Definir sentencia SQL
            String sqlQueryStatement = "INSERT INTO " + tabla + " (" + camposTabla + ") VALUES (" + valoresCampos + ");"; 
            //Establece la conexion entre la aplicacion y la BD
            Statement statement;
            statement = cone.createStatement();
            statement.executeUpdate(sqlQueryStatement);//Ejecutar comando SQL
            statement.close();
            cone.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Elimina o actualiza los campos de la Base de datos
     * @param tabla tanla que se utilizara
     * @param valoresCamposNuevos datos que seran reemplzados o actualizados
     * @param condicion condicion de busqueda
     */
    public void actualizarEliminarRegistros(String tabla ,String valoresCamposNuevos, String condicion){
        //Cargar conexion
        Conexion conectar = new Conexion();
        Connection cone = conectar.getConnection();
        try {
            Statement statement;
            String sqlQueryStatement;
            //Verfificar valorcamponuevo
            if(valoresCamposNuevos.isEmpty()){
                sqlQueryStatement = "DELETE FROM "+ tabla + " WHERE " + condicion + ":";
            }else {
                sqlQueryStatement = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
            }
            statement = cone.createStatement();
            statement.execute(sqlQueryStatement);// Ejecutar sql
            statement.close();
            cone.close();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido el siguiente error: " + e.getMessage());
        }
    }
    /**
     * 
     * @param tablasBusqueda
     * @param camposBusqueda
     * @param condicionBusqueda 
     */
    public void desplegarRegistros(String tablasBusqueda, String camposBusqueda,String condicionBusqueda){
        //Cargar la conexion
        Conexion conectar = new Conexion();
        Connection cone = conectar.getConnection();
        try {
            Statement statement;
            String sqlQueryStatement;
            if(condicionBusqueda.equals("")){
                sqlQueryStatement = "SELECT " + camposBusqueda + " FROM " + tablasBusqueda + ";";
            }else{
                sqlQueryStatement = "SELECT " + camposBusqueda + " FROM " + tablasBusqueda + " WHERE " + condicionBusqueda;
            }
            statement = cone.createStatement();
            statement.execute(sqlQueryStatement);// Ejecutar Query SQL
            // Leindicamos que ejecute la consulta de la tabla
            try (ResultSet miResultSet = statement.executeQuery(sqlQueryStatement)){
                if(miResultSet.next()){
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();// Numero de columnas de la consulta
                    System.err.println("<< REGISTROS ALMACENADOS >>\n");
                    for(int i = 1; i < numColumnas; i++){
                        //Muestra los titulos de las columnas
                        System.out.printf("%-25s\t", metaData.getColumnName(i));//%-25s\t separacion entre columnas
                    }
                    System.out.println();
                    //Imprimir los datos de miResultSet contenga
                    do {                        
                        for(int i = 1; i <= numColumnas; i++){
                            System.out.printf("%-25s\t", miResultSet.getObject(i));
                        }
                        System.out.println();
                    } while(miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close();
            }finally{
                //Cerra el statment y la conexion
                statement.close();
                cone.close();
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error " +e.getMessage());
        }
    }
}
