/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Irvin Cortez
 */
public class Delete {
    public Delete() throws SQLException{
        //Instanciamos clase y libreria
        Scanner leer = new Scanner(System.in);
        Conexion utileriasConexion = new Conexion();
        
        System.out.println("___ ELIMINAR REGISTRO ___");
        
        //Solicitamos el Nº identificador del regitri
        System.out.println("Ingrese el id del registro");
        String id_videojuego = leer.next();
       
        //Preparamos el query que se ejecutara
        String tabla = "videojuego";
        String campos = "*";
        String condicio = "id_videojuego = " + id_videojuego;
        
        //Ejecuta el query que se preparo en la clase Conexion que muestra el registro solictado
        utileriasConexion.desplegarRegistros(tabla, campos, condicio);
        
        //Solicitamos verificacion para proceder con la instruccion
        System.out.println("Presione << Y >> para confirmar");
        String confirmar_borrar = leer.next();
        
        //Si el usuario lo confirma
        if("Y".equals(confirmar_borrar.toUpperCase())){
            String valores_campos_nuevos = "";
            
            //Ejecuta el query que borra el registro
            utileriasConexion.actualizarEliminarRegistros(tabla, valores_campos_nuevos, condicio);
            System.out.println("Registro borrado correctamente");
        }
        ModuloPrincipal.desplegarMenu();
    }
}
