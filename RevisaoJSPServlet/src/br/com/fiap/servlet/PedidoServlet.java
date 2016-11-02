package br.com.fiap.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Pedido;
import br.com.fiap.bo.PedidoBO;

@SuppressWarnings("serial")
@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {

	private PedidoBO bo = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrarPedido(req, resp);
			break;

		case "alterar":
			alterarPedidoPost(req, resp);
			break;
			
		case "excluir":
			excluirPedido(req, resp);
			break;

		default:
			break;
		}
	}

	private void excluirPedido(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		bo = new PedidoBO();
		
		try {
			String id = req.getParameter("id");
			bo.remover(Integer.parseInt(id));
			req.setAttribute("tipoMensagem", "alert alert-success");
			req.setAttribute("mensagem", "Pedido excluído!");
			System.out.println("Excluir sucesso");
		} catch (Exception e) {
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Erro ao excluir: " + e.getMessage());
			e.printStackTrace();
		}finally {
			req.setAttribute("lista", bo.buscaTodos());
			req.getRequestDispatcher("listar-pedido.jsp").forward(req, resp);
			System.out.println("REquest listar-pedido.jsp");
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
			getAlterar(req, resp);
			break;

		default:
			break;
		}
	}
	
	private void alterarPedidoPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		bo = new PedidoBO();
		try {				
			bo.atualizar(getFormularioAlteracao(req));
			req.setAttribute("tipoMensagem", "alert alert-success");
			req.setAttribute("mensagem", "Pedido atualizado!");
			req.setAttribute("lista", bo.buscaTodos());
			req.getRequestDispatcher("listar-pedido.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Erro ao alterar:" + e.getMessage());
			req.getRequestDispatcher("alterar-pedido.jsp").forward(req, resp);
		}
	}
	
	private Pedido getFormularioAlteracao(HttpServletRequest req) {
		String id = req.getParameter("id");
		String descricao = req.getParameter("descricao");
		String valor = req.getParameter("valor");
		String status = req.getParameter("status");
		String data = req.getParameter("data");
		String quarto = req.getParameter("quarto");		
		
		return new Pedido(Integer.parseInt(id), Integer.parseInt(quarto), Double.parseDouble(valor), descricao, status,
				dataStringLocalDate(data));
	}

	private LocalDate dataStringLocalDate(String data) {
		System.out.println("Data do input:" + data);			
		LocalDate date = LocalDate.parse(data, 
				DateTimeFormatter.ofPattern("yyyy-MM-dd")
				.withLocale(new Locale("pt", "br"))
				);
		return date;
	}

	private void getAlterar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			e.printStackTrace();
		} finally {
			req.getRequestDispatcher("cadastrar-pedido.jsp").forward(req, resp);
		}
	}

		private Pedido getFormulario(HttpServletRequest req) {
		String data = req.getParameter("data");
		String descricao = req.getParameter("descricao");
		String valor = req.getParameter("valor");
		String quarto = req.getParameter("quarto");
		Pedido p = new Pedido(Integer.parseInt(quarto), Double.parseDouble(valor), descricao, "Aberto", dataStringLocalDate(data));
		return p;
	}

}
