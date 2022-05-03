import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//respons�vel por agrupar todas as opera��es de bd relacionadas aos clientes
public class ClienteDAO {

	// Vari�veis utilizadas para trabalhar com o JDBC
	private PreparedStatement p; // vari�vel configur�vel que executa as opera��es de banco (SQL)
	private String sql; // vari�vel para armazenar a instru��o SQL
	private ResultSet rs; // vari�vel que ser� utilizada para armazenar o resultado de um SELECT
	private Connection connection; // vari�vel utilizada para armazenar a conex�o com o banco de dados

	public ClienteDAO() {
		this.p = p;
		this.sql = sql;
		this.rs = rs;
		this.connection = connection;
	}

	public void inserir(Cliente cliente) {

		// inser��o de dados na tabela do banco
		sql = "insert into poo_cliente (cpf, nome, cidade) values(?, ?, ?)";
		connection = new Conexao().conectar();
		try {
			p = connection.prepareStatement(sql);
			p.setString(1, cliente.getCpf()); // 1� interroga��o ser� substituida pelo valor da vari�vel
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
