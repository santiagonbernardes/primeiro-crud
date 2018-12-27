package br.com.santiago.controle.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.santiago.modelo.factory.ConexaoFactory;

@WebFilter(servletNames = "DispatcherServlet")
public class FiltroConexaoBD implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			Connection conexao = new ConexaoFactory().getConexao();

			request.setAttribute("conexao", conexao);

			chain.doFilter(request, response);

			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
