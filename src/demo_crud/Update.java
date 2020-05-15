package demo_crud;

import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    
Update () throws SQLException{

Scanner leer = new Scanner (System.in);
Videojuego vid = new Videojuego();
Conexion utilerias = new Conexion();
   
System.out.println("ACTUALIZAR REGISTROS ");
    
    System.out.println("Ingresar el registro a modificar: ");
    vid.setIdvideojuego(leer.nextInt());
    
String tablaV = "videojuego";
    String camposTabla = " id_videojuego, nom_videojuego, tipo_videojuego, compania_videojuego";
    String condicionBusqueda = "id_videojuego = " + vid.getIdvideojuego();
   
    utilerias.desplegarRegistros(tablaV, camposTabla, condicionBusqueda);
    
    
    System.out.println("Nombre: ");
    vid.setNomvideojuego(leer.next());
    
    System.out.println("tipo: ");
    vid.setTipovideojuego(leer.next());
    
    System.out.println("compania: ");
    vid.setCompaniavideojuego(leer.next());
    
    String tabla = "videojuego";
    String valoresCamposNuevos = "nom_videojuego = " + vid.getNomvideojuego() + "', tipo_videojuego = '"
            + vid.getTipovideojuego() + "', compania_videojuego = '" + vid.getCompaniavideojuego() + "'";
    
    utilerias.actualizarEliminarRegistros(tabla, valoresCamposNuevos, condicionBusqueda);
    System.out.println("Modificado Correctamente ");
  
    ModuloPrincipal.desplegarMenu();

}




}