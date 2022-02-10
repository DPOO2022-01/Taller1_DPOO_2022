package dpoo.taller1.modelo;

public class Combo implements Producto
{
	// Atributos
	private double descuento;
	private String nombreCombo;
	private String[] itemsCombo; //puede ser public 

	// Constructor
	public Combo(String nombre, double descuento) 
	{
		this.descuento=descuento;
		nombreCombo=nombre;
	}
	
	// Métodos Class
	public void agregarItemACombo(Producto itemCombo) 
	{
		//itemsCombo .add ->  Producto.getNombre()  -
	}
	
	// Métodos Herencia
	public int getPrecio() 
	{
		return 0;
	}

	public String getNombre() 
	{
		return null;
	}

	public String generarTextoFactura() 
	{
		return null;
	}
	
}
