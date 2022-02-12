package dpoo.taller1.modelo;

public class Ingrediente 
{
	// Atributos
	private String nombre;
	private int costoAdicional;
	
	// Constructor
	public Ingrediente(String nombre, int costoAdicional) 
	{
		this.nombre=nombre;
		this.costoAdicional=costoAdicional;
	}
	// M�todos class 
	public String getNombre() 
	{
		return nombre;
	}
	public int geCostoAdicional() 
	{
		return costoAdicional;
	}
	// M�todos herencia 0
}
