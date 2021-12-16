
import java.rmi.Naming;
import java.util.Scanner;

public class ClienteAhorcado {
    
    public static void main(String[] args) throws Exception {
        IAhorcado servidor = (IAhorcado)Naming.lookup("//10.142.103.143/juegoahorcado");
        
        Scanner sc = new Scanner(System.in);
        while(servidor.estadoActual().contains("*")) {
            char c = sc.nextLine().charAt(0);
            servidor.enviarCaracter(c);
            System.out.println("El estado actual es: " + servidor.estadoActual());
        }
        
        System.out.println("Juego terminado. La palabra es " + servidor.estadoActual());
    }
    
    
}
