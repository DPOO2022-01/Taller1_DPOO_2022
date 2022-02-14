package dpoo.taller1.consola;
import dpoo.taller1.modelo.*;

import java.util.Scanner;

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
			int opcion;
			System.out.println("Bienvenido. \n");
			System.out.println("1. Ver el menu de productos disponibles.");
			System.out.println("2. Realizar una orden.");
			System.out.println("3. Verificar el estado de una orden.");
			System.out.println("0. Salir de la aplicacion.");
			Scanner entrada = new Scanner(System.in);
			System.out.println("\nSeleccione una opcion: ");
			opcion = entrada.nextInt();
			ejecutarOpcion(opcion);
		}
	}
	public static void ejecutarOpcion(int opcion)
	{
		Boolean seguir = true;
		while(seguir)
		{
			if (opcion==1)
			{
				seguir = false;
				Restaurante menu =new Restaurante();
				menu.getMenuBase();
			}
			else if (opcion==2)
			{
				seguir = false;
				//abrir opcion verificar orden
			}
			else if (opcion==3)
			{
				//Salir aplicacion
			}
			else if (opcion==0)
			{
				//Salir aplicacion
			}
			else
			{
				System.out.println("Opcion invalida.");
			}
		}
	}
}
