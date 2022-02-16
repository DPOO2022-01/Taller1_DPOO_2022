package dpoo.taller1.modelo;

import java.util.*;

public class Pedido 
{
	private List<Producto> itemsPedido; //puede ser public
	public int numeroPedidos=0; //debe ser public para poder filtrar por id, id va relacionado con # de pedidos
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	
	public Pedido(String nombreCliente, String direccionCliente) 
	{
		itemsPedido = new ArrayList<>();
		idPedido=numeroPedidos+1;
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
	}
	public int getIdPedido() 
	{
		return idPedido;
	}
}
