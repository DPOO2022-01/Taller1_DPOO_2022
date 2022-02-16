package dpoo.taller1.consola;
import dpoo.taller1.modelo.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Aplicacion
{
	public static void main(String[] argumentos) 
	{
		//Interacción Menu - usuario 
		try
		{
			mostrarMenu();
			System.out.println("\nSeleccione una opcion: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String opcion = reader.readLine();
			ejecutarOpcion(opcion);
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo la consola");
			e.printStackTrace();
		}
	}

	public static void mostrarMenu() 
	{
		System.out.println("Bienvenido. \n");
		System.out.println("0. Cargar Informacion. ");
		System.out.println("1. Ver el menu de productos disponibles.");
		System.out.println("2. Realizar un pedido.");
		System.out.println("3. Agregar elemento a pedido.");
		System.out.println("4. Salir de la aplicacion.");
		
	}
	public static void ejecutarOpcion(String opcion)
	{
		Restaurante aplicacion =new Restaurante();
		Boolean seguir = true;
		while(seguir)
		{
			int idPedido=1;
			if(opcion.equals("0")) 
			{
				try
				{
					System.out.print("Inserte la ubicación del archivo #1. Ingredientes\n");
					BufferedReader reader0 = new BufferedReader(new InputStreamReader(System.in));
					File ingredientesInfo= new File(reader0.readLine());
					System.out.print("Inserte la ubicación del archivo #2. Menu\n ");
					BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
					File menuInfo=new File(reader1.readLine());
					System.out.print("Inserte la ubicación del archivo #3. Combos\n ");
					BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
					File combosInfo=new File(reader2.readLine());
					//llamar metodo para cargar info
					aplicacion.cargarInformacionRestaurante(ingredientesInfo, menuInfo, combosInfo);
					System.out.println("Se han cargado los archivos locales");
					
				}
				catch (IOException e)
				{
					System.out.println("Error leyendo dirección de archivos o archivos");
					e.printStackTrace();
				}
			}
			
			else if (opcion.equals("1"))
			{
				int i=1;
				int j=1;
				System.out.println("Menú del restaurante: ");
				for (ProductoMenu cadaProductoMenu:aplicacion.getMenuBase()) 
				{
					System.out.println(i+". "+cadaProductoMenu.getNombre()+"......"+cadaProductoMenu.getPrecio());
					i++;
				}
				System.out.println("Acompañamientos y/o porciones extra:");
				for (Ingrediente cadaIngrediente:aplicacion.getIngredientes()) 
				{
					System.out.println(j+". "+cadaIngrediente.getNombre()+"......"+cadaIngrediente.getCostoAdicional());
					j++;
				}
				
			}
			else if (opcion.equals("2"))
			{
				try
				{
					System.out.println("\nEscriba su nombre: ");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String nombre = reader.readLine();
					System.out.println("\nEscriba su direccion: ");
					BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
					String direccion = reader1.readLine();
					Restaurante.iniciarPedido(nombre ,direccion);
					idPedido++;
					System.out.println("Pedido creado correctamente");
				}
				catch (IOException e)
				{
					System.out.println("Error opcion1");
					e.printStackTrace();
				}
				
			}
			else if (opcion.equals("3"))
			{
				try 
				{
					System.out.println("Digite el número del producto que desea: ");
					BufferedReader readerp = new BufferedReader(new InputStreamReader(System.in));
					String producto = readerp.readLine();
					System.out.println("Digite el número del acompañamiento: ");
					BufferedReader readera = new BufferedReader(new InputStreamReader(System.in));
					String extra = readera.readLine();
					int value1=Integer.parseInt(producto);
					int value2=Integer.parseInt(extra);
					List<ProductoMenu> listBase = aplicacion.getMenuBase();
					List<Ingrediente> listIngredientes = aplicacion.getIngredientes();
					Pedido p=aplicacion.getPedidoEnCurso(idPedido);
					int i=0;
					for(ProductoMenu cadaProductoMenu: listBase) 
					{
						if (i==value1-1) 
						{
							p.agregarNuevoProducto((Producto) cadaProductoMenu);
							System.out.println("Producto "+cadaProductoMenu.getNombre()+" añadido");
						}
						i++;
					}
					int j=0;
					for(Ingrediente cadaIngrediente: listIngredientes) 
					{
						if (j==value2-1) 
						{
							p.agregarNuevoProducto((Producto) cadaIngrediente);
							System.out.println("Ingrediente "+cadaIngrediente.getNombre()+" añadido");
						}
						j++;
					}
					
				}
				catch (IOException e)
				{
					System.out.println("Error opcion2");
					e.printStackTrace();
				}
				
			}
			else if (opcion.equals("4"))
			{
				Pedido p=aplicacion.getPedidoEnCurso(idPedido);
				aplicacion.cerrarYGuardarPedido(p);
				seguir = false;
			}
			else
			{
				System.out.println("Opcion invalida.");
			}
			try 
			{
				mostrarMenu();
				System.out.println("Seleccione una opcion: ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				opcion=reader.readLine();
			}
			catch (IOException e)
			{
				System.out.println("error mostrando consola");
				e.printStackTrace();
			}
		}
	}
	
}
