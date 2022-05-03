import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		Connection connection = conexao.conectar();
		
		// Vari�veis utilizadas para trabalhar com o JDBC
		PreparedStatement p; // vari�vel configur�vel que executa as opera��es de banco (SQL)
		String sql; // vari�vel para armazenar a instru��o SQL
		ResultSet rs; // vari�vel que ser� utilizada para armazenar o resultado de um SELECT
		
		//dados que ser�o inseridos na tabela
		String cpf = "130.197.988-09";
		String nome = "Eduardo Bartoli";
		String cidade = "S�o Paulo";
		
		//inser��o de dados na tabela do banco
		sql = "insert into cliente (cpf, nome, cidade) values(?, ?, ?)";
		try {
			p = connection.prepareStatement(sql);
			p.setString(1, cpf); //1� interroga��o ser� substituida pelo valor da vari�vel
			p.setString(2, nome);
			p.setString(3, cidade);
			p.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados no banco\n"+e);
		}

	}

}
