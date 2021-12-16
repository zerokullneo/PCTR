import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado {
    String palabra = "universidad", estado = "universidad";
    
    public ServidorAhorcado() throws RemoteException {}
    
    public boolean enviarCaracter(char c) throws RemoteException {
        System.out.println("Se prueba con el caracter " + c);
        if(palabra.contains(""+c)) {
            char[] nuevoEstado = estado.toCharArray();
            for(int i=0;i<nuevoEstado.length;i++) {
                if(palabra.charAt(i)==c) {
                    nuevoEstado[i] = c;
                }
            }
            estado = new String(nuevoEstado);
            
            return true;
        } else {
            return false;
        }
    }

    public String estadoActual() throws RemoteException {
        System.out.println("El estado actual es " + estado);
        return estado;
    }
    
    public static void main(String[] args) throws Exception {
        ServidorAhorcado OServidor = new ServidorAhorcado();
        Naming.rebind("juegoahorcado", OServidor);
        System.out.println("Servidor remoto preparado");
    }
    
}
