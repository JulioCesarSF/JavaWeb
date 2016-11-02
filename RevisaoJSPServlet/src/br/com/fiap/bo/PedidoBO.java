package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.bean.Pedido;

public class PedidoBO {
	
	private static ArrayList<Pedido> lista = new ArrayList<Pedido>();
	private static int contador = 1;
	
	public void inserir(Pedido pedido)throws Exception{
		pedido.setId(contador++);
		lista.add(pedido);
	}
		
	public ArrayList<Pedido> buscaTodos(){
		return lista;
	}
	
	public void atualizar(Pedido pedido) throws Exception{
		remover(pedido.getId());
		lista.add(pedido);
	}
	
	public void remover(int id) throws Exception {
		Pedido pedido = buscar(id);
		lista.remove(pedido);
	}

	public Pedido buscar(int codigoQuarto) throws Exception {
		for(Pedido p : lista){
			if(p.getId()==codigoQuarto){
				return p;
			}
		}
		throw new Exception("Pedido não encontrado");
	}
	
}
