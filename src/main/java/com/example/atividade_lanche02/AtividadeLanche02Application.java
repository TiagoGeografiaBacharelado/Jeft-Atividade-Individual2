package com.example.atividade_lanche02;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.atividade_lanche02.applications.LancheApplication;
import com.example.atividade_lanche02.entities.Lanche;
import com.example.atividade_lanche02.facade.LancheFacade;
import com.example.atividade_lanche02.repositories.LancheRepository;
import com.example.atividade_lanche02.services.LancheService;

@SpringBootApplication
public class AtividadeLanche02Application {

	public static LancheRepository lancheRepository;
	public static LancheService lancheService;
	public static LancheApplication lancheApplication;
	public static LancheFacade lancheFacade;

	private static void injectDependencies() {
		lancheRepository = new LancheRepository();
		lancheService = new LancheService();
		lancheApplication = new LancheApplication(lancheRepository, lancheService);
		lancheFacade = new LancheFacade(lancheApplication);
	}

	public static void main(String[] args) {
        injectDependencies();
		int codigo = 1;
        boolean quit = false;
        
        while(!quit){
            System.out.println("""
                            Bem vindo à lanchonete 'Mega Charles do Lanche'
                            Escolha uma opção:
                            1 - Cadastrar lanche
                            2 - Atualizar lanche
                            3 - Remover lanche
                            4 - Listar lanches
                            5 - Comprar lanche
                            6 - Sair""");
            int op = Integer.parseInt(System.console().readLine());
            switch(op){
                case 1 -> {
                    System.out.println("Nome do lanche:");
                    String nome = System.console().readLine();
                    System.out.println("Preço:");
                    double preco = Double.parseDouble(System.console().readLine());
                    System.out.println("URL da imagem:"); //... ou aqui
                    String img_url = System.console().readLine();
                    
                    lancheFacade.cadastrar(new Lanche(nome, img_url, preco, codigo++));
                    System.out.println("Lanche cadastrado com sucesso\n");
                }
                case 2 -> {
                    if(lancheFacade.buscar().isEmpty()){
                        System.out.println("Nenhum lanche cadastrado\n");
                    } else {
                        System.out.println("Código do lanche:");
                        int cod = Integer.parseInt(System.console().readLine());
                        System.out.println("Nome do lanche:");
                        String nome = System.console().readLine();
                        System.out.println("Preço:");
                        double preco = Double.parseDouble(System.console().readLine());
                        System.out.println("URL da img_url:");
                        String img_url = System.console().readLine();
                        
                        lancheFacade.atualizar(cod, new Lanche(nome, img_url, preco, cod));
                        System.out.println("Lanche atualizado com sucesso\n");
                    }
                }
                case 3 -> {
                    if(lancheFacade.buscar().isEmpty()){
                        System.out.println("Nenhum lanche cadastrado\n");
                    } else {
                        System.out.println("Código do lanche:");
                        int cod = Integer.parseInt(System.console().readLine());
                        lancheFacade.remover(cod);
                        System.out.println("Lanche removido com sucesso\n");
                    }
                }
                case 4 -> {
                    System.out.println("--------------------------------------\n CÓDIGO\tNOME\t\tPRECO\n--------------------------------------");
                    if(lancheFacade.buscar().isEmpty()){
                        System.out.println("Nenhum lanche cadastrado\n");
                    } else {
                        List<Lanche> lanches = lancheFacade.buscar();
                        for(Lanche l : lanches){
                            System.out.println(l.getCodigo() + "\t\t" + l.getNome() + "\t\t" + l.getPreco() + "\n\n");
                        }
                    }
                }
                case 5 -> {
                    if(lancheFacade.buscar().isEmpty()){
                        System.out.println("Nenhum lanche cadastrado\n");
                    } else {
                        System.out.println("Código do lanche:");
                        int cod = Integer.parseInt(System.console().readLine());
                        System.out.println("Quantidade:");
                        int quantidade = Integer.parseInt(System.console().readLine());
                        Lanche lanche = lancheFacade.buscarPorCodigo(cod);
                        System.out.println("Total: " + lancheFacade.calcularLanche(lanche, quantidade) + "\n");
                    }
                }
                case 6 -> quit = true;
            }
        }
	}
}
