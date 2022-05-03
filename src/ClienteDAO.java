import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//responsável por agrupar todas as operações de bd relacionadas aos clientes
public class ClienteDAO {

	// Variáveis utilizadas para trabalhar com o JDBC
	private PreparedStatement p; // variável configurável que executa as operações de banco (SQL)
	private String sql; // variável para armazenar a instrução SQL
	private ResultSet rs; // variável que será utilizada para armazenar o resultado de um SELECT
	private Connection connection; // variável utilizada para armazenar a conexão com o banco de dados

	public ClienteDAO() {
		this.p = p;
		this.sql = sql;
		this.rs = rs;
		this.connection = connection;
	}

	public void inserir(Cliente cliente) {

		// inserção de dados na tabela do banco
		sql = "insert into poo_cliente (cpf, nome, cidade) values(?, ?, ?)";
		connection = new Conexao().conectar();
		try {
			p = connection.prepareStatement(sql);
			p.setString(1, cliente.getCpf()); // 1ª interrogação será substituida pelo valor da variável
			p.setString(2, cliente.getNome());
			p.setString(3, cliente.getCidade());
			p.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados no banco\n" + e);
		}
	}

	public Cliente pesquisar(String cpf) {
		sql = "select * from cliente where cpf = ?";
		connection = new Conexao().conectar();
		Cliente cliente = null;
		try {
			p = connection.prepareStatement(sql);
			p.setString(1, cpf);
			rs = p.executeQuery(); // usado apenas para executar o SELECT
			if(rs.next()) {
				cliente = new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("cidade"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar cliente pelo CPF\n" + e);
		}
		return cliente;
	}
}
