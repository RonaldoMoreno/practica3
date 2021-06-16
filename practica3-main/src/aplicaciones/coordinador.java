package aplicaciones;

import clasesRmi.classCoordinador;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class coordinador {

    //VARIABLE STATICA DEL TIEMPO
    public static int tiempo;
    
    //LISTA DE LOS MONITORES
    public static ArrayList<String> listaMonitor = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            //REGISTRO
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("miCoordinador", new classCoordinador());
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            System.exit(0);
        }

        //PEDIR
        System.out.print("Intervalo de medición de los monitores: ");
        Scanner leer = new Scanner(System.in);
        tiempo = leer.nextInt();
        
        //---
        System.out.println("Servidor en ejecucion...");
    }
}
