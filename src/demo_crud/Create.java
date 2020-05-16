/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Ernesto Acevedo
 */

public class Create {
    Create() throws  SQLException, IOException{
        //Instanciamos clase y libreria
        Scanner leer = new Scanner(System.in);
        Videojuego video = new Videojuego();
        
        System.out.println("-.-.-.  Creación de registros   .-.-.-");
        
        //Solictud a ingresos de datos
        System.out.println("Nombre de videojuego");
        video.setNomvideojuego(leer.nextLine());

        System.out.println("Tipo de videojuego");
        video.setTipovideojuego(leer.nextLine());

        System.out.println("Compañia");
        video.setCompaniavideojuego(leer.nextLine());
        
        
         //preparacion del query
        String tabla = "videojuego";
        String camposTabla = "nom_videojuego, tipo_videojuego, compania_videojuego";
        String valoresCampos = "'" + video.getNomvideojuego() + "','" + video.getTipovideojuego() + "','" + video.getCompaniavideojuego() + "'";
        
        
        Conexion utilerias = new Conexion(); //Conexion a nuestra base de datos
        
        //Ejecutamos el metodo que permite aplicar el query
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
        
        //Volvemos a ejcutar el menu
        ModuloPrincipal.desplegarMenu();
        
    }
}
