package dpoo.taller1.consola;
import dpoo.taller1.modelo.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aplicacion
{
	public static void main(String[] argumentos) 
	{
		mostrarMenu();
	}

	public static void mostrarMenu() 
	{
		Boolean salir = false;
		while(!salir)
		{
			System.out.println("Bienvenido. \n");
			System.out.println("1. Ver el menu de productos disponibles.");
			System.out.println("2. Realizar una orden.");
			System.out.println("3. Verificar el estado de una orden.");
			System.out.println("0. Salir de la aplicacion.");
			try
			{
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
	}
	public static void ejecutarOpcion(String opcion)
	{
		Boolean seguir = true;
		while(seguir)
		{
			if (opcion.equals("1"))
			{
				seguir = false;
				Restaurante menu =new Restaurante();
				menu.getMenuBase();
			}
			else if (opcion.equals("2"))
			{
				String nombre = "";
				String direccion = "";
				seguir = false;
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
				//Salir aplicacion
			}
			else if (opcion.equals("0"))
			{
				seguir = false;
			}
			else
			{
				System.out.println("Opcion invalida.");
			}
		}
	}
}
