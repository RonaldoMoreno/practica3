package interfacesRmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface objCoordinador extends Remote {

    //DEVUELVE EL INTERVALO DE TIEMPO
    int iniMonitor(String id) throws RemoteException; //LLAMADA POR LOS MONITORES

    //ENVIA EL VALOR DE LOADAVG DEL MONITOR
    void loadMonitor(String loadavg) throws RemoteException; //LLAMADA POR LOS MONITORES

    //DEVUELVE LA CANTIDAD DE MONITORES QUE HAY FUNCIONANDO
    int iniClient() throws RemoteException; //LLAMADA POR LOS CLIENTES

    //OBTIENE EL VALOR DE AVG DE LOS MONITORES
    String getLoadAvg() throws RemoteException; //LLAMADA POR LOS CLIENTES
}
