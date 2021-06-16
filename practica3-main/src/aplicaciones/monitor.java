package aplicaciones;

import interfacesRmi.objCoordinador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class monitor {

    public static void main(String[] args) {

        int segundos;
        String ip = "localhost";
        String id;
        String loadavg;

        //INGRESAR IP DEL SERVIDOR
        System.out.print("IP server: ");
        Scanner leerIP = new Scanner(System.in);
        ip = leerIP.nextLine();

        try {
            //REGISTRO DE LAS FUNCIONES
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            objCoordinador miCoordinador = (objCoordinador) registry.lookup("miCoordinador");

            //EXTRAER VALOR DEL FICHERO HOSTNAME
            BufferedReader br2 = new BufferedReader(new FileReader(new File("/etc/hostname")));
            id = br2.readLine();
            System.out.println("Monitor: " + id);

            //OBTENGO LOS SEGUNDOS Y ME REGISTRO
            segundos = miCoordinador.iniMonitor(id);

            while (true) {

                //EXTRAER VALOR DEL FICHERO
                BufferedReader br = new BufferedReader(new FileReader(new File("/proc/loadavg")));
                loadavg = br.readLine();

                //INSERTAR DATO DEL FICHERO LOADAVG
                miCoordinador.loadMonitor(id + ": " + loadavg);

                //ESPERAMOS X SEGUNDOS
                Thread.sleep(segundos * 1000);
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

    }

}
