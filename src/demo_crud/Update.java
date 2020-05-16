package demo_crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Update {
    Update () throws SQLException, IOException{

        Videojuego vid = new Videojuego();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Conexion utilerias = new Conexion();
        String n = "";

        System.out.println("ACTUALIZAR REGISTROS ");

        System.out.println("Ingresar el registro a modificar: ");
        n = br.readLine();
        vid.setIdvideojuego(Integer.parseInt(n));

        String tabla = "videojuego";
        String camposTabla = " id_videojuego, nom_videojuego, tipo_videojuego, compania_videojuego";
        String condicionBusqueda = "id_videojuego = " + vid.getIdvideojuego();

        utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);


        System.out.println("Nombre: ");
        vid.setNomvideojuego(br.readLine());

        System.out.println("tipo: ");
        vid.setTipovideojuego(br.readLine());

        System.out.println("compania: ");
        vid.setCompaniavideojuego(br.readLine());

        String valoresCamposNuevos = "nom_videojuego = '" + vid.getNomvideojuego() + "', tipo_videojuego = '"
            + vid.getTipovideojuego() + "', compania_videojuego = '" + vid.getCompaniavideojuego() + "'";

        utilerias.actualizarEliminarRegistros(tabla, valoresCamposNuevos, condicionBusqueda);
        System.out.println("Modificado Correctamente ");

        ModuloPrincipal.desplegarMenu();
    }
}