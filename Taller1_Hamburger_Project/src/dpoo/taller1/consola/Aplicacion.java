package dpoo.taller1.consola;


public class Aplicacion
{
	public static void main(String[] argumentos) 
	{
		Boolean salir = false;
		while (!salir)
		{
			System.out.println("Bienvenido.\nSeleccione una opcion: ");
			System.out.println("1. Ver el menu de productos disponibles.");
			System.out.println("2. Realizar una orden.");
			System.out.println("3. Verificar el estado de una orden.");
			System.out.println("0. Salir de la aplicacion.");
			//pedir opcion y mandarla como parametro a ejecutarOpcion()
		}
		
	}
	
	public void ejecutarOpcion(int opcion)
	{
		Boolean seguir = true;
		while(seguir)
		{
			if(opcion==1)
			{
				seguir = false;
				mostrarMenu();
			}
			else if (opcion==2)
			{
				seguir = false;
				//abrir opcion tomar orden
			}
			else if (opcion==3)
			{
				seguir = false;
				//abrir opcion verificar orden
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

	public void mostrarMenu() 
	{
		System.out.println("1. Producto 1.");
		System.out.println("2. Producto 2.");
		System.out.println("3. Producto 3.");
		System.out.println("4. Producto 4.");
		System.out.println("5. Combo 1.");
		System.out.println("6. Combo 2.");
		System.out.println("7. Combo 3.");
		System.out.println("8. Combo 4.");
	}
}
