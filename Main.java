import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println(" ESTACIONAMENTO COM SEMÁFOROS");
        System.out.println("\n");
        System.out.println();
        System.out.print("Insira a quantidade de vagas do estacionamento: ");
        int numeroVagas = scanner.nextInt();
        int numeroCarros;
        
        do {
            System.out.print("Insira a quantidade de carros (deve ser maior que " + numeroVagas + "): ");
            numeroCarros = scanner.nextInt();
            
            if (numeroCarros <= numeroVagas) {
                System.out.println("ERRO: A quantidade de carros deve ser maior que a quantidade de vagas!");
            }
        } while (numeroCarros <= numeroVagas);
        
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("Iniciando simulação...");
        System.out.println("Vagas: " + numeroVagas);
        System.out.println("Carros: " + numeroCarros);
        System.out.println("------------------------------------------");
        System.out.println();
        
        Estacionamento estacionamento = new Estacionamento(numeroVagas);
        
        Carro[] carros = new Carro[numeroCarros];
        for (int i = 0; i < numeroCarros; i++) {
            carros[i] = new Carro(i + 1, estacionamento);
            carros[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        for (Carro carro : carros) {
            try {
                carro.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread principal foi interrompida");
            }
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Simulação finalizada!");
        System.out.println("Todos os carros entraram e saíram do estacionamento.");
        System.out.println("------------------------------------------");
        
        scanner.close();
    }
}
