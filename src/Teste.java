import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		Connection connection = conexao.conectar();
		
		// Variáveis utilizadas para trabalhar com o JDBC
		PreparedStatement p; // variável configurável que executa as operações de banco (SQL)
		String sql; // variável para armazenar a instrução SQL
		ResultSet rs; // variável que será utilizada para armazenar o resultado de um SELECT
		
		//dados que serão inseridos na tabela
		String cpf = "130.197.988-09";
		String nome = "Eduardo Bartoli";
		String cidade = "São Paulo";
		
		//inserção de dados na tabela do banco
		sql = "insert into cliente (cpf, nome, cidade) values(?, ?, ?)";
		try {
			p = connection.prepareStatement(sql);
			p.setString(1, cpf); //1ª interrogação será substituida pelo valor da variável
			p.setString(2, nome);
			p.setString(3, cidade);
			p.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados no banco\n"+e);
		}

	}

}
