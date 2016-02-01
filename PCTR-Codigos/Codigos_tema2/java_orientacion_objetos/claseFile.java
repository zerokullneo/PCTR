/**Fichero claseFile.java
 *Ejemplo de uso de la clase File
 * los objetos de esta clase son una representacion abstracta de rutas 
 * en el sistema de directorios del sistema.
 * @author Antonio Tomeu
 * @version 1.0
 */
 
import java.io.*;

public class claseFile
{
	public static void main(String[] args)
	{
		try {
			File Ruta = new File("antonio.dat");
			Ruta.createNewFile();     
			System.out.println(Ruta.getAbsolutePath());
			System.out.println(Ruta.getName());
			System.out.println(Ruta.getParent());
			if(Ruta.isFile()) System.out.println("es un fichero...");
			if(Ruta.isDirectory()) System.out.println("es un directorio...");
			if(Ruta.isHidden()) System.out.println("es un fichero oculto...");
			System.out.println("su tamaño es "+Ruta.length());
			String[] contenido;
			String camino = "C:"+"/";
			System.out.println(camino);
			File SistemaFichero = new File (camino);
			contenido = SistemaFichero.list();
			for(int i=0; i<contenido.length;i++)
			  System.out.println(contenido[i]);
			File Directorio = new File("NuevoDirectorio");  
			Directorio.mkdir  ();
			  
		} catch (IOException e) {return;}
			
	}		
}	