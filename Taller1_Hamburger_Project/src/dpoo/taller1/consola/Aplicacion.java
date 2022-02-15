package dpoo.taller1.consola;
import dpoo.taller1.modelo.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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
		System.out.println("2. Realizar una orden.");
		System.out.println("3. Verificar el estado de una orden.");
		System.out.println("4. Salir de la aplicacion.");
		
	}
	public static void ejecutarOpcion(String opcion)
	{
		Restaurante aplicacion =new Restaurante();
		Boolean seguir = true;
		while(seguir)
		{
			
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
					System.out.println("Error leyendo de la consola");
					e.printStackTrace();
				}
			}
			
			else if (opcion.equals("1"))
			{
				
				aplicacion.getMenuBase();
			}
			else if (opcion.equals("2"))
			{
				String nombre = "";
				String direccion = "";
				try
				{
					System.out.println("\nEscriba su nombre: ");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					nombre = reader.readLine();
					System.out.println("\nEscriba su direccion: ");
					BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
					direccion = reader1.readLine();
				}
				catch (IOException e)
				{
					System.out.println("Error leyendo la consola");
					e.printStackTrace();
				}
				Restaurante.iniciarPedido(nombre ,direccion);
			}
			else if (opcion.equals("3"))
			{
				//
			}
			else if (opcion.equals("4"))
			{
				seguir = false;
			}
			else
			{
				System.out.println("Opcion invalida.");
			}
			// redefinir opcion después de la primer vez
			try 
			{
				mostrarMenu();
				System.out.println("\nSeleccione una opcion: ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				opcion=reader.readLine();
			}
			catch (IOException e)
			{
				System.out.println("Error leyendo la consola");
				e.printStackTrace();
			}
			
			
			
			
			
		}
	}
}
