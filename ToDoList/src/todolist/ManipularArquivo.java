package todolist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ManipularArquivo {
	List<Tarefa> tarefas; 
//	public static void main(String[] args) {
//		
//	}
	
	public ManipularArquivo() {
		this.tarefas = new ArrayList<Tarefa>();
	}
	
	public void escrever(String conteudo) throws IOException {
		String caminho = "tarefas.txt";
		
		FileWriter escritor = new FileWriter(caminho);
		escritor.write(conteudo);
		escritor.close();
	}
	
	public List ler() throws FileNotFoundException {
		File file = new File("tarefas.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			String[] linha = sc.nextLine().split(" ");
			String[] dataAux = linha[1].split("/");
			int[] data = {Integer.parseInt(dataAux[0]),Integer.parseInt(dataAux[1]),Integer.parseInt(dataAux[2])};
			tarefas.add(new Tarefa(linha[0], data, linha[2]));
		}
		
		return tarefas;
	}
}
