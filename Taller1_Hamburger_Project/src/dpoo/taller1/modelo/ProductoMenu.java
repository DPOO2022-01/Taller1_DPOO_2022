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
		return precioBase;
	}

	public String getNombre() 
	{
		return nombre;
	}
	
	public String generarTextoFactura() 
	{
		return "Producto de Menu "+nombre+" cuesta: "+getPrecio()+"\n";
	}
	
}
