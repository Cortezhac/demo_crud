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
        Scanner leer = new Scanner(System.in);
        Conexion utileriasConexion = new Conexion();
        System.out.println("___ ELIMINAR REGISTRO ___");
        
        System.out.println("Ingrese el id del registro");
        String id_videojuego = leer.next();
        leer.next(); // Limpia buffer
        String tabla = "videojuegos";
        String campos = "*";
        String condicio = "id_videojuego = " + id_videojuego;
        
        utileriasConexion.desplegarRegistros(tabla, campos, condicio);
        System.out.println("Presione << Y >> para confirmar");
        String confirmar_borrar = leer.next();
        leer.next();//limpia buffer
        if("Y".equals(confirmar_borrar.toUpperCase())){
            String valores_campos_nuevos = "";
            
            utileriasConexion.actualizarEliminarRegistros(tabla, valores_campos_nuevos, condicio);
            System.out.println("Registro borrado correctamente");
        }
        ModuloPrincipal.desplegarMenu();
    }
}
