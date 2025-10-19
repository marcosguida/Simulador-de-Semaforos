import java.util.concurrent.Semaphore;

public class Estacionamento {
    private final Semaphore vagas;
    private final int totalVagas;
    private int vagasDisponiveis;

    public Estacionamento(int numeroVagas) {
        this.totalVagas = numeroVagas;
        this.vagasDisponiveis = numeroVagas;
        this.vagas = new Semaphore(numeroVagas, true); // true para garantir ordem FIFO
    }

    public void entrar(int idCarro) {
        try {
            System.out.println("Carro " + idCarro + " está procurando vaga...");
            
            vagas.acquire(); 
            
            synchronized (this) {
                vagasDisponiveis--;
                System.out.println(">>> Carro " + idCarro + " ENTROU no estacionamento");
                System.out.println("    Vagas disponíveis: " + vagasDisponiveis + "/" + totalVagas);
                System.out.println();
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Carro " + idCarro + " foi interrompido");
        }
    }

    public void sair(int idCarro) {
        synchronized (this) {
            vagasDisponiveis++;
            System.out.println("<<< Carro " + idCarro + " SAIU do estacionamento");
            System.out.println("    Vagas disponíveis: " + vagasDisponiveis + "/" + totalVagas);
            System.out.println();
        }
        
        vagas.release(); 
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public int getTotalVagas() {
        return totalVagas;
    }
}
