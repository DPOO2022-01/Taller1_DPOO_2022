package dpoo.taller1.modelo;

public class ProductoMenu implements Producto
{
	// Atributos 
	private String nombre;
	private int precioBase;
	
	// Constructor
	public ProductoMenu(String nombre, int precioBase) 
	{
		this.nombre=nombre;
		this.precioBase=precioBase;
	}
	
	// M�todos class
	
	// M�todos herencia
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
