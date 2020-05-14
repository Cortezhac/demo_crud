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
            String sqlQueryStatement = "INSERT INTO * "+ tabla + "(" + camposTabla + ") VALUES (" + valoresCampos + ")"; 
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
    
}
