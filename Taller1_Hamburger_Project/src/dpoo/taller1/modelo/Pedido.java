package dpoo.taller1.modelo;

import java.io.*;
import java.util.*;

public class Pedido 
{
	private List<Producto> itemsPedido; //puede ser public
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
;
	
	
	public Pedido(String nombreClient, String direccionClient) 
	{
		itemsPedido = new ArrayList<>();
		numeroPedidos++;
		idPedido=0;
		this.nombreCliente=nombreClient;
		this.direccionCliente=direccionClient;
	}
	public int getIdPedido() 
	{
		return this.idPedido;
	}
	public void agregarProducto (Producto nuevoItem)
	{
		this.itemsPedido.add(nuevoItem);
	}
	//private int getPrecioNetoPedido ()
	//{
		//for()
		//{
		//	
		//}
	//}
	private int getPrecioTotalPedido()
	{
		return 0;
	}
	private int getPrecioIVAPedido()
	{
		return 0;
	}
	private String generarTextoFactura()
	{
		return "";
	}
	public void guardarFactura(String ruta)
	{
		File arch = new File (ruta);
		try 
		{
			if(arch.createNewFile())
			{
				System.out.println("File created: " + arch.getName());
			}
			else
			{
				System.out.println("File already exists.");
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
			writer.write("");;
			writer.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}

