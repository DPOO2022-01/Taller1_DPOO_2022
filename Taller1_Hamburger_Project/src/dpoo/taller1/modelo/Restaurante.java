package dpoo.taller1.modelo;
import java.io.*;
import java.util.*;

public class Restaurante 
{
	//public List<productos> menu;
	public String producto;
	private List<Producto> menu;
	
	public static void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		System.out.println(nombreCliente+" - "+direccionCliente);
	}
	
	public static void cerrarYGuardarPedido()
	{
		
	}
	//private List<String> getPedidoEnCurso ()
	//{
		//String producto;
		//items = newArrayList<>();
		//return ;
	//}
	public List<Producto> getMenuBase()
	{
		menu=new ArrayList<>();
		return menu;
	}

	public void cargarInformacionRestaurante(File ingre, File menu, File combos)
	{
		try 
		{
			FileReader archivo = new FileReader("Ingredientes.txt");
			BufferedReader buff = new BufferedReader(archivo);
			String linea = buff.readLine();
			while(linea != null) 
			{
				linea = buff.readLine();
			}
			buff.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
}
