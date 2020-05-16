package demo_crud;

import java.sql.SQLException;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author Ernesto
 */

public class ModuloPrincipal {
    public static void main(String[] args) throws  SQLException, IOException, Exception{
        desplegarMenu();
    }
    
    public static void desplegarMenu() throws SQLException, IOException, Exception{
        Scanner opcionSeleccionada = new Scanner(System.in);
        String opcionMenu;
        //Menu 
        System.out.println("\033[34m---------------------------------------------");
        System.out.println("\033[34m||          \033[34m     VIDEOJUEGOS               "+"\033[34m||");
        System.out.println("\033[34m---------------------------------------------");
        System.out.println("\033[34m||          "+"\033[35mOpciones: ➡                    "+"\033[34m||");
        System.out.println("\033[34m||          "+"\033[34m1. Crear registros             "+"\033[34m||");
        System.out.println("\033[34m||          "+"\033[34m2. Consultar registros         "+"\033[34m||");
        System.out.println("\033[34m||          "+"\033[34m3. Actualizar registros        "+"\033[34m||"); 
        System.out.println("\033[34m||          4. \033[31mEliminar registros          "+"\033[34m||");
        System.out.println("||\033[34m          "+"\033[34m5. Salir                       "+"\033[34m||");
        System.out.println("\033[34m---------------------------------------------");
        System.out.println("\033[35mSeleccionar Opción: ➡"); 
        opcionMenu = opcionSeleccionada.next();
        
        

        switch(opcionMenu){
            case "1":
                Create create = new Create();
                break;
            case "2":
                Read read = new Read(); 
                break;
            case "3":
                Update update = new Update();
                break;
            case "4":
                Delete delete = new Delete();
                break;     
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("\033[31mSeleccion Invalida!!");
                break;
        }
    }
}

