/**
 * @(#)GradosProteccion.java
 * @author AT
 * @version 1.00 2011/10/20
 */


public class GradosProteccion 
{
	public    int todoquisque = 1;
	protected int losamigos   = 1;
	private   int sololaclase = 1;

    public GradosProteccion() {}
    public void CambiarPrivado(int v)
    {sololaclase = v;}
    public int ObservarPrivado()
    {return sololaclase;}
    private void CambiarAmigos(int v)
    {losamigos = v;}
    
    
    
    
}