package todolist;

public class Tarefa {

	private String nome;
	private int[] dataLimite;
	private String status;
	
	public Tarefa(String nome, int[] dataLimite) {
		this.nome = nome;
		this.dataLimite = dataLimite;
		this.status = "Pendente";
	}
	
	public Tarefa(String nome, int[] dataLimite, String status) {
		this.nome = nome;
		this.dataLimite = dataLimite;
		this.status = status;
	}
	
	public String getNome() {
		return nome;
	}
	public int[] getDataLimite() {
		return dataLimite;
	}	
	public String getDataLimiteStr() {
		return dataLimite[0]+"/"+dataLimite[1]+"/"+dataLimite[2];
	}	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String data = dataLimite[0] + "/" + dataLimite[1] + "/" + dataLimite[2] ;
		return nome + "\nData Limite: " + data + "\nStatus: " + status;
	}

	
	
}
