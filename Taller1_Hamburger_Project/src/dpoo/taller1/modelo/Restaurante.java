package dpoo.taller1.modelo;
import java.io.*;
import java.util.*;

public class Restaurante 
{
	private static int pedidoEnCurso;
	private static List<Pedido> pedidos;
	private List<ProductoMenu> menuBase;
	private List<Ingrediente> ingredientes;
	private List<Combo> combos;
	
	public Restaurante()
	{
		pedidoEnCurso=0;
		pedidos =new ArrayList<>();
		combos = new ArrayList<>();
		menuBase = new ArrayList<>(14);
		ingredientes = new ArrayList<>(23);
	}
	
	public static void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		//System.out.println(nombreCliente+" - "+direccionCliente);
		try
		{
			System.out.print("Inserte su nombre y unido por una ?,? adjunte su direcci?n actual");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linea= reader.readLine();
			String[] direccion= linea.split(",");
			pedidoEnCurso=1; //static para acceder desde clase y no desde obj
			Pedido pedido= new Pedido(direccion[0],direccion[1]);
			pedido.numeroPedidos+=1; //+1 deber?a ser por c/u objs creados
			System.out.println("Su pedido esta en curso, identifiquelo con el numero: "+pedido.getIdPedido());
			//cerrarYGuardarPedido(pedido);
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
	}
	
	public void cerrarYGuardarPedido(Pedido pedido) //se a?adi? par?metro
	{
		pedidos.add(pedido);//----- se necesita atributo static
		pedidoEnCurso=0;
	}
	
	public Pedido getPedidoEnCurso(int id)  //filtro por id, par?metro a?adido
	{
		Pedido a = null;
		if (pedidoEnCurso!=0) 
		{
			for(Pedido cadaPedido: pedidos) 
			{
				if (cadaPedido.getIdPedido()==id) 
				{
					a= cadaPedido;
				}
			}
		}
		return a;//obj pedido null si false
	}
	
	public List<ProductoMenu> getMenuBase()
	{
		return menuBase;
	}
	public List<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}

	public void cargarInformacionRestaurante(File archivoIngrendinetes, File archivoMenu, File archivoCombos)
	{
		cargarIngredinetes(archivoIngrendinetes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	private void cargarIngredinetes(File archivoIngrendientes) 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(archivoIngrendientes));
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
			BufferedReader reader = new BufferedReader(new FileReader(archivoMenu));
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
			BufferedReader reader = new BufferedReader(new FileReader(archivoCombos));
			String linea= reader.readLine();
			while (linea!= null) 
			{
				String[] listaCombo= linea.split(";");
				listaCombo[1].replaceFirst("%", "");
				double value=Double.parseDouble(listaCombo[1].replaceFirst("%", "")); 
				value=value/100;
				System.out.println("Post "+value);
				Combo combo= new Combo(listaCombo[0],value);
				this.combos.add(combo);
				System.out.println(combo);
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
