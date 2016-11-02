package br.com.fiap.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/buscaAluno")
public class AlunoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p = resp.getWriter();
		
		String sAluno = new String(req.getParameter("nome"));
		
		System.out.println("Nome do Aluno:\t" + sAluno);
		
		p.write("<html><body><p>" + sAluno + "</p></body></html>");
		
	}

}
