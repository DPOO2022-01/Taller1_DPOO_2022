package dpoo.taller1.modelo;

public class ProductoAjustado implements Producto 
{
	// Atributos
	private int[] agregados;
	private int[] eliminados;
	final private int base;
	
	// Constructor
	public ProductoAjustado(ProductoMenu base) 
	{
		this.base=1;
		//por definir...
	}
	
	// M�todos class  0 
	
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
