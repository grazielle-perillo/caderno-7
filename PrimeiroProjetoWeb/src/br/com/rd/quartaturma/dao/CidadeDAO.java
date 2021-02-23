package br.com.rd.quartaturma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.rd.quartaturma.vo.Cidade;

public class CidadeDAO {
	
private Connection conn;
	
	public CidadeDAO(Connection conexao) { //abre conexao
		this.conn = conexao;
	}
	
	public List<Cidade> getCidades() throws SQLException { //retorna array com as cidades do banco
		List<Cidade> cidades = new ArrayList<>();
		
		Statement stmt = conn.createStatement();//recebe o codigo sql para ir no banco, nao passa parametro.
		ResultSet sr = stmt.executeQuery("select ID_CIDADE,\n" //o resultado que vai trazer da busca.
				+ "		ID_UF,\n"
				+ "		CD_CIDADE_IBGE,\n"
				+ "		DS_CIDADE\n"
				+ " FROM TB_CIDADE");

		while(sr.next()) { //le a tabela toda
			
			Cidade cidade = new Cidade();
			cidade.setIdCidade(sr.getInt("ID_CIDADE"));
			cidade.setIdUf(sr.getInt("ID_UF"));
			cidade.setCidadeIbge(sr.getInt("CD_CIDADE_IBGE"));
			cidade.setCidade(sr.getString("DS_CIDADE"));
			
			cidades.add(cidade); // adicionei um objeto cidade no array
		}
		sr.close();
		stmt.close();
		conn.close();
		
		return cidades;
	}

	public Cidade getCidadeById(Integer id) throws SQLException { //retorna uma cidade especifica do banco
		String sqlConsulta = "select ID_CIDADE,\n"
				+ "		ID_UF,\n"
				+ "		CD_CIDADE_IBGE,\n"
				+ "		DS_CIDADE\n"
				+ " FROM TB_CIDADE where ID_CIDADE = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlConsulta); // quanto tiver interrogação;
		pstmt.setInt(1, id);//referente ao ponto de interrogação.
		
		ResultSet sr = pstmt.executeQuery();// vai receber o resultado da nossa busca
		
		Cidade cidade = new Cidade();
		if(sr.next()) {
			cidade.setIdCidade(sr.getInt("ID_CIDADE"));
			cidade.setIdUf(sr.getInt("ID_UF"));
			cidade.setCidadeIbge(sr.getInt("CD_CIDADE_IBGE"));
			cidade.setCidade(sr.getString("DS_CIDADE"));
		}

		sr.close();
		pstmt.close();
		conn.close();
		
		return cidade;
	}
	
	public boolean inserirCidade(Cidade cidade) { //insere uma cidade no banco
		
		String sqlInsert = "INSERT INTO TB_CIDADE (ID_CIDADE, "
				+ "		ID_UF,\n"
				+ "		CD_CIDADE_IBGE,\n"
				+ "		DS_CIDADE )\n"
				+ " VALUES(NULL, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, cidade.getIdUf());
			pstmt.setInt(2, cidade.getCidadeIbge());
			pstmt.setString(3, cidade.getCidade());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir cidade");
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean excluirCidade(Integer id) {
		String sqlDelete = "DELETE FROM TB_CIDADE WHERE ID_CIDADE = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, id);
				
			int quantidadeExcluidos = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			if(quantidadeExcluidos > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir usuário");
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean atualizarCidade(Cidade cidade) {
		String sqlUpdate = "UPDATE TB_CIDADE SET "
			+ "	CD_CIDADE_IBGE = coalesce(?, CD_CIDADE_IBGE),"
			+ "	DS_CIDADE = ?" 
			+ " WHERE ID_CIDADE = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, cidade.getCidadeIbge());
			pstmt.setString(2, cidade.getCidade());
			pstmt.setInt(3, cidade.getIdCidade());
		
			int quantidadeAtualizados = pstmt.executeUpdate();
		
			pstmt.close();
			conn.close();
		
			if(quantidadeAtualizados > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar cidade");
			e.printStackTrace();
		}
	
		return false;
	}
}
