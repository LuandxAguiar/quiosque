package br.senai.sp.quiosquel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import java.sql.Date;
import br.senai.sp.quiosquel.model.Cliente;
import br.senai.sp.quiosquel.model.FaixaEtaria;

public class ClienteDao {
	private Connection conexao;
	
	//contrutor 
	public ClienteDao() {
		conexao = ConnectionFactory.conectar();
	}
	public void inserir (Cliente cliente) {
		String sql ="insert into tb_clientes(nome,endereco,numero,email,genero,dataNascimento,faixa_Etaria,prodInt)"
				+ "values(?,?,?,?,?,?,?.?)";
		//substituir valores 
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getNumero());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getGenero());
			stmt.setDate(6,new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setInt(7, cliente.getFaixaEtaria().ordinal());
			stmt.setString(8, cliente.getProdInt());
			//fechar sempre
			
			stmt.execute();
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> listar(){
		String sql = "select * from tb_clientes order by nome asc";
		PreparedStatement stmt;
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			stmt = conexao .prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setNumero(rs.getString("numero"));
				c.setEmail(rs.getString("email"));
				c.setGenero(rs.getString("genero"));
				Calendar nascimento = Calendar.getInstance();
				//extrair o java
				Date nascDb = rs.getDate("dataNascimento");
				//passar o long do java.sql para Calendar 
				nascimento.setTimeInMillis(nascDb.getTime());
				c.setDataNascimento(nascimento);
				
				//Enum
				int posEnum = rs.getInt("faixaEtaria");
				//Obter a Faixa Etaria 
				c.setFaixaEtaria(FaixaEtaria.values()[posEnum]);
				c.setProdInt(rs.getString("prodInt"));
				lista.add(c);
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
		
		
	}
	
	
	// metodo Excluir 
		public void excluir (long idCliente) {
			String sql = "delete from tb_cliente where id = ?";
			PreparedStatement stmt;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, idCliente);
				stmt.execute();
				stmt.close();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		public void atualizar (Cliente cliente) {
			String sql ="update tb_clientes set nome = ?, endereco = ?, numero = ?, email = ?, genero = ?, dataNascimento = ?, faixa_Etaria = ?, prodInt = ? where id = ? ";
			PreparedStatement stmt;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cliente.getNome());
				stmt.setString(2, cliente.getEndereco());
				stmt.setString(3, cliente.getNumero());
				stmt.setString(4, cliente.getEmail());
				stmt.setString(5, cliente.getGenero());
				stmt.setDate(6,new Date(cliente.getDataNascimento().getTimeInMillis()));
				stmt.setInt(7, cliente.getFaixaEtaria().ordinal());
				stmt.setString(8, cliente.getProdInt());
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		public Cliente buscar(long idCliente) {
			String sql = "select * from tb_clientes where id = ?";
			PreparedStatement stmt;
			Cliente c = null;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, idCliente);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					c = new Cliente();
					c.setId(rs.getLong("id"));
					c.setNome(rs.getString("nome"));
					c.setNumero(rs.getString("numero"));
					c.setEndereco(rs.getString("email"));
					c.setGenero(rs.getString("genero"));
					Calendar nascimento = Calendar.getInstance();
					//extrair o java
					Date nascDb = rs.getDate("dataNascimento");
					//passar o long do java.sql para Calendar 
					nascimento.setTimeInMillis(nascDb.getTime());
					c.setDataNascimento(nascimento);
					
					//Enum
					int posEnum = rs.getInt("faixaEtaria");
					//Obter a Faixa Etaria 
					c.setFaixaEtaria(FaixaEtaria.values()[posEnum]);
					c.setProdInt(rs.getString("prodInt"));
				}
				rs.close();
				stmt.close();
				conexao.close();
				return c;
					
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
}