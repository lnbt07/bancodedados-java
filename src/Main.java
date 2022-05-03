
public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("1000", "Joaquim", "São Caetano do Sul");
		ClienteDAO dao = new ClienteDAO();
//		dao.inserir(cliente);
		
		cliente = dao.pesquisar("1000");
		System.out.println(cliente);
	}

}
