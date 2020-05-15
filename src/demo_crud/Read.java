/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

/**
 *
 * @author JCH
 */

import java.sql.SQLException;
public class Read {
    public void Read() throws SQLException{
        System.out.println("-.-.-.  Consulta de registros   .-.-.-");
        mostrarResultado();
    }
    
    private void mostrarResultado() throws SQLException {
        try {
            Conexion utilerias = new Conexion();
            String tabla = "videojuego";
            String camposTabla = "*";
            String condicionBusqueda = "";
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            ModuloPrincipal.desplegarMenu();
        }
        
    }
}
