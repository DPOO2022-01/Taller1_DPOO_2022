package dpoo.taller1.modelo;
import java.io.*;
import java.util.*;

public class Restaurante 
{
	private static int pedidoEnCurso;
	private List<Pedido> pedidos;
	private List<ProductoMenu> menuBase;
	private List<Ingrediente> ingredientes;
	private List<Combo> combos;
	
	public Restaurante()
	{
		pedidoEnCurso=0;
		pedidos =new ArrayList<>();
		menuBase = new ArrayList<>();
		ingredientes = new ArrayList<>();
	}
	
	public static void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		//System.out.println(nombreCliente+" - "+direccionCliente);
		try
		{
			System.out.print("Inserte su nombre y unido por una ´,´ adjunte su dirección actual");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linea= reader.readLine();
			String[] direccion= linea.split(",");
			pedidoEnCurso=1; //static para acceder desde clase y no desde obj
			Pedido pedido= new Pedido(direccion[0],direccion[1]);
			
			System.out.println("Su pedido esta en curso, identifiquelo con el numero: "+pedido.getIdPedido());
			
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
	}
	
	public static void cerrarYGuardarPedido()
	{
		//pedidos.add(pedido);----- se necesita parametro del obj pedido
	}
	//private List<String> getPedidoEnCurso ()
	//{
		//String producto;
		//items = newArrayList<>();
		//return ;
	//}
	public Pedido getPedidoEnCurso() 
	{
		if (pedidoEnCurso!=0) 
		{
			return null; //obj pedido
		}
		else 
		{
			return null;
		}
		
	}
	
	public List<Producto> getMenuBase()
	{
		return null;
	}
	public List<Ingrediente> getIngredientes()
	{
		return null;
	}

	public void cargarInformacionRestaurante(File archivoIngrendinetes, File archivoMenu, File archivoCombos)
	{
		cargarIngredinetes(archivoIngrendinetes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	private void cargarIngredinetes(File archivoIngrendinetes) 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linea= reader.readLine();
			while (linea!= null) 
			{
				String[] listaIngredientes= linea.split(";");
				int value=Integer.parseInt(listaIngredientes[1]);
				Ingrediente ingrediente= new Ingrediente(listaIngredientes[0],value);
				this.ingredientes.add(ingrediente);
				linea= reader.readLine(); //siguiente linea
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
	}
	private void cargarMenu(File archivoMenu) 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linea= reader.readLine();
			while (linea!= null) 
			{
				String[] listaMenu= linea.split(";");
				int value=Integer.parseInt(listaMenu[1]);
				ProductoMenu Menu= new ProductoMenu(listaMenu[0],value);
				this.menuBase.add(Menu);
				linea= reader.readLine(); //siguiente linea
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
	}
	private void cargarCombos(File archivoCombos) 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linea= reader.readLine();
			while (linea!= null) 
			{
				String[] listaCombo= linea.split(";");
				double value=Double.parseDouble(listaCombo[1]); // Porcentaje, revisar ------------------
				Combo combo= new Combo(listaCombo[0],value);
				for(int i=2;i<listaCombo.length;i++) 
				{
					for(ProductoMenu cadaProductoMenu: menuBase) 
					{
						if(cadaProductoMenu.getNombre().equals(listaCombo[i])) 
						{
							combo.agregarItemACombo(cadaProductoMenu);
						}
					}
				}
				this.combos.add(combo);
				linea= reader.readLine(); //siguiente linea
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
	}
	
}
