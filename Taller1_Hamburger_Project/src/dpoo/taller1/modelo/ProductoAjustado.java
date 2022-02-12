package dpoo.taller1.modelo;
import java.util.*;

public class ProductoAjustado implements Producto 
{
	// Atributos
	private List<Ingrediente> agregados;
	private List<Ingrediente> eliminados;
	final private ProductoMenu base;
	
	// Constructor
	public ProductoAjustado(ProductoMenu base) 
	{
		this.base=base;
		agregados = new ArrayList<>(); //max 10 lenght
		eliminados = new ArrayList<>(); //max 10 lenght
	}
	
	// Métodos class  0 
	
	// Métodos herencia  
	public int getPrecio() 
	{
		int valorTotal=0;
		for(Ingrediente cadaIngrediente:agregados) 
		{
			valorTotal+=cadaIngrediente.geCostoAdicional();
		}
		return valorTotal;
	}

	public String getNombre() 
	{
		return base.getNombre(); //return nombre de la base ---------- revisar
	}

	public String generarTextoFactura() 
	{
		return "El valor de "+base.getNombre()+" adicional a los productos agregados es: "+getPrecio()+"\n";
	}

}
