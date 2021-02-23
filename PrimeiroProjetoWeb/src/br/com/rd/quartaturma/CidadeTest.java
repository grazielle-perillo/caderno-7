package br.com.rd.quartaturma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.rd.quartaturma.dao.CidadeDAO;
import br.com.rd.quartaturma.vo.Cidade;

public class CidadeTest {

	public static void main(String args[]) {
		ConexaoMySql conexao = new ConexaoMySql();
		Connection conn = conexao.obterConexao();
		CidadeDAO cidadeDAO = new CidadeDAO(conn);
		try {
			//testeInsert(cidadeDAO);
			//testeConsulta(cidadeDAO);

		} catch (Exception e) {
			System.out.println("Erro ao consultar cidade" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private static void testeConsulta(CidadeDAO cidadeDAO) throws SQLException {
		List<Cidade> cidades = cidadeDAO.getCidades();//falei que esse array é igual ao array retornado pelo metodo;
		System.out.println(cidades);
		for (Cidade cidade : cidades ) {
			
			System.out.println(cidade.getCidade());//mostrando um atributo do objeto
		}
	}
	
	private static void testeInsert(CidadeDAO cidadeDAO) {
		Cidade cidade = new Cidade();
		cidade.setIdUf(1);
		cidade.setCidadeIbge(2);
		cidade.setCidade("Santo André");
		
		cidadeDAO.inserirCidade(cidade);
	}
}