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
 * @author Ernesto Acevedo
 */

public class Create {
    Create() throws  SQLException{
        Scanner leer = new Scanner(System.in);
        Videojuego video = new Videojuego();
        
        System.out.println("-.-.-.  Creación de registros   .-.-.-");
        System.out.println("Nombre de videojuego");
        video.setNomvideojuego(leer.nextLine());

        System.out.println("Tipo de videojuego");
        video.setTipovideojuego(leer.nextLine());

        System.out.println("Compañia");
        video.setCompaniavideojuego(leer.nextLine());

        String tabla = "videojuego";
        String camposTabla = "nom_videojuego, tipo_videojuego, compania_videojuego";
        String valoresCampos = "'" + video.getNomvideojuego() + "','" + video.getTipovideojuego() + "','" + video.getCompaniavideojuego() + "'";
        Conexion utilerias = new Conexion();
        
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
        
        ModuloPrincipal.desplegarMenu();
        
    }
}
