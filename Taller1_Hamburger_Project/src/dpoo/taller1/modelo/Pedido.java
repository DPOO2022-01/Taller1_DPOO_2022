package dpoo.taller1.modelo;

import java.util.*;

public class Pedido 
{
	private List<Producto> itemsPedido; //puede ser public
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	
	public Pedido(String nombreCliente, String direccionCliente) 
	{
		itemsPedido = new ArrayList<>();
		numeroPedidos=0;
		idPedido=0;
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
	}
	public int getIdPedido() 
	{
		return idPedido;
	}
}
