package br.com.santiago.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.santiago.modelo.entities.Cliente;

public class ClienteDAO {

	private Connection conexao;

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void add(Cliente cliente) {
		String sql = "INSERT INTO clientes" + "(nome, email, datanascimento)" + "values (?, ?, ?)";

		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Cliente> getLista() {
		String sql = "SELECT * FROM clientes";
		List<Cliente> clientes = new ArrayList<>();

		try (PreparedStatement ps = conexao.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDataNascimento(LocalDate.parse(rs.getString("datanascimento")));

				clientes.add(cliente);
			}

			return clientes;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void delete(Cliente cliente) {
		String sql = "DELETE FROM clientes WHERE id=?";

		try (PreparedStatement ps = conexao.prepareStatement(sql)) {

			ps.setLong(1, cliente.getId());
			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public Cliente searchById(Long id) {
		String sql = "SELECT * FROM clientes where id=?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			Cliente cliente = new Cliente();
			while(rs.next()) {
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDataNascimento(LocalDate.parse(rs.getString("datanascimento")));				
			}
			ps.close();
			rs.close();
			return cliente;
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void update(Cliente cliente) {
		String sql = "UPDATE clientes SET nome=?, email=?, datanascimento=? where id=?";
		
		try(PreparedStatement ps = conexao.prepareStatement(sql)) {
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
			ps.setLong(4, cliente.getId());
			ps.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
