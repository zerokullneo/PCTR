public class Vehiculo
{
	private String matricula;
	private int pasajeros;
	private boolean tripulacion;
	private int tripulantes;
	private enum tipo{coche,monovolumen,moto,bus,tren,barco,avion};
	
	public Vehiculo(String mat, tipo t, int psg, int tp)
	{
		switch(t)
		{
			case coche:
				pasajeros = 5;
				tripulacion = false;
				tripulantes = 0;
				break;
			case monovolumen:
				pasajeros = 9;
				tripulacion = false;
				tripulantes = 0;
				break;
			case moto:
				pasajeros = 2;
				tripulacion = false;
				tripulantes = 0;
				break;
			case bus:
				pasajeros = psg;
				tripulacion = true;
				tripulantes = tp;
				break;
			case tren:
				pasajeros = psg;
				tripulacion = true;
				tripulantes = tp;
				break;
			case barco:
				pasajeros = psg;
				tripulacion = true;
				tripulantes = tp;
				break;
			case avion:
				pasajeros = psg;
				tripulacion = true;
				tripulantes = tp;
				break;
			default:
				System.out.println("Tipo incorrecto.");
		}
	}
	
	public String leeMatricula(){return matricula;}
	public int leePasajeros(){return pasajeros;}
	public int leetripulantes(){return tripulantes;}
	//public tipo leeTipo(){return tipo;}
}
