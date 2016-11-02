package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Pedido;
import br.com.fiap.bo.PedidoBO;

@SuppressWarnings("serial")
@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet{
	
	private PedidoBO bo = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":			
			cadastrarPedido(req, resp);			
			break;

		default:
			break;
		}		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		
		switch (acao) {
		case "listar":			
			listarPedidos(req, resp);			
			break;
			
		case "alterar":
			String id = req.getParameter("id");			
			try {
				bo = new PedidoBO();
				req.setAttribute("pedido", bo.buscar(Integer.parseInt(id)));
				req.getRequestDispatcher("alterar-pedido.jsp").forward(req, resp);
			} catch (Exception e) {
				req.setAttribute("tipoMensagem", "alert alert-danger");
				req.setAttribute("mensagem", "Erro ao acessar pedido: " + e.getMessage());
				req.getRequestDispatcher("listar-pedido.jsp").forward(req, resp);
			}
			break;

		default:
			break;
		}
	}

	private void listarPedidos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		bo = new PedidoBO();			
		req.setAttribute("lista", bo.buscaTodos());
		req.getRequestDispatcher("listar-pedido.jsp").forward(req, resp);
	}

	private void cadastrarPedido(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		bo = new PedidoBO();
		
		try {		
			bo.inserir(getFormulario(req));
			req.setAttribute("tipoMensagem", "alert alert-success");
			req.setAttribute("mensagem", "Cadastro efetuado!");
		} catch (Exception e) {
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Erro ao cadastrar: " + e.getMessage());
		}finally {
			req.getRequestDispatcher("cadastrar-pedido.jsp").forward(req, resp);
		}
	}

	private Pedido getFormulario(HttpServletRequest req) {
		String data = req.getParameter("data");
		String descricao = req.getParameter("descricao");
		String valor = req.getParameter("valor");
		String quarto = req.getParameter("quarto");	
		Pedido p = new Pedido(Integer.parseInt(quarto), Double.parseDouble(valor), descricao, "Aberto", data);
		return p;
	}
	
	
}
