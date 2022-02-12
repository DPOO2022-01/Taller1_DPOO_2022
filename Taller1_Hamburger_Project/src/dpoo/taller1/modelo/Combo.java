package dpoo.taller1.modelo;
import java.util.*;

public class Combo implements Producto
{
	// Atributos
	private double descuento;
	private String nombreCombo;
	private List<ProductoMenu> itemsCombo; //puede ser public 

	// Constructor
	public Combo(String nombre, double descuento) 
	{
		this.descuento=descuento;
		nombreCombo=nombre;
		itemsCombo=new ArrayList<>(); //10 max lenght
	}
	
	// Métodos Class
	public void agregarItemACombo(ProductoMenu itemCombo) 
	{
		itemsCombo.add(itemCombo); //parametro(array de items) . add (obj ProductoMenu)
	}
	
	// Métodos Herencia
	public int getPrecio() 
	{
		int valorTotal=0;
		for(ProductoMenu cadaItem:itemsCombo) 
		{
			valorTotal+=cadaItem.getPrecio(); //get precio de cada productoMenu (item del combo)
		}
		return (int)(valorTotal*this.descuento); //return es int
	}

	public String getNombre() 
	{
		return nombreCombo;
	}

	public String generarTextoFactura() 
	{
		return "El precio del combo "+nombreCombo+" es: "+getPrecio()+"\n";
	}
	
}
