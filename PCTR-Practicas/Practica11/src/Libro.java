/**
 * @author David Moreno Del Valle
 */

import java.io.Serializable.*;
public class Libro implements java.io.Serializable{

	String Autor;
	String Titulo;

    public Libro() {}

    public Libro(String Titulo, String Autor){
    	this.Titulo = Titulo;
    	this.Autor = Autor;
    }

    public String VerAutor(){
    	return Autor;
    }

    public String VerTitulo(){
    	return Titulo;
    }

}
