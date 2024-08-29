package todolist;

import java.util.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MenuToDo {
	private static List<Tarefa> tarefas; 
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		ManipularArquivo ma = new ManipularArquivo();
		
		tarefas = ma.ler();
		
		while(true) {
			exibirTarefas();
			System.out.println("---------------");
			menu(sc, ma);
		}
	}
	
	public static void menu(Scanner sc, ManipularArquivo ma) throws IOException {
		String opcoes = "(A) Adicionar tarefa"
					+ "\n(C) Concluir tarefa"
					+ "\n(R) Remover tarefa"
				    + "\n(S) Sair"
					+ "\nO que deseja fazer? ";
		
		String opc = lerEntrada(sc,opcoes).toLowerCase();
		
		switch(opc){
			case "a":
				adicionarTarefa(sc);
				break;
			case "c":
				concluirTarefa(sc);
				break;
			case "r":
				removerTarefa(sc);
				break;
			case "s":
				sair(ma);
				
			default:
				System.out.println("Entrada Inválida");
			
		}
		
	}
	
	private static void adicionarTarefa(Scanner sc) {
		String nome = lerEntrada(sc, "Nome da Tarefa: ");
		String dataAux = lerEntrada(sc, "Data Limite: ");
		
		int[] data =  new int[3];
		for(int i = 0; i<dataAux.split("/").length;i++) {
			data[i] = Integer.parseInt((dataAux.split("/"))[i]);
		}
		
		tarefas.add(new Tarefa(nome,data));
	}
	
	private static void concluirTarefa(Scanner sc) {
		int tarefa = Integer.parseInt(lerEntrada(sc, "Tarefa(num): "));
		tarefas.get(tarefa).setStatus("Concluída");
	}
	
	private static void removerTarefa(Scanner sc) {
		int tarefa = Integer.parseInt(lerEntrada(sc, "Tarefa(num): "));
		tarefas.remove(tarefa);
	}
	
	private static void exibirTarefas() {
		LocalDate hoje = LocalDate.now();
		for(int i = 1; i<=tarefas.size();i++) {
			int[] aux = tarefas.get(i-1).getDataLimite();
			LocalDateTime dataLimite = LocalDateTime.of(aux[2], aux[1], aux[0],0,0,0);
			
			System.out.println(i + " - " + tarefas.get(i-1));
			System.out.println("Tempo Restante: " + ChronoUnit.DAYS.between(hoje, dataLimite) + " dias");
		}
	}
	
	private static void sair(ManipularArquivo ma) throws IOException {
		String dados = "";
		for(Tarefa e: tarefas) {
			dados += e.getNome() +" "+  e.getDataLimiteStr() +" "+ e.getStatus();
		}
		ma.escrever(dados);
		System.out.println("Vlw Parça");
		System.exit(0);
	}
	
	private static String lerEntrada(Scanner sc, String txt) {
		System.out.print(txt);
		return sc.nextLine();
	}
}
