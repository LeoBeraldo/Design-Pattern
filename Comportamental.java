import java.util.ArrayList;
import java.util.List;

interface Observador {
    void atualizar(String mensagem);
}

class Usuario implements Observador {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }
}

class Assunto {
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensagem) {
        for (Observador observador : observadores) {
            observador.atualizar(mensagem);
        }
    }
}

class LancamentoProduto extends Assunto {
    private String nomeProduto;

    public LancamentoProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void lancarProduto() {
        notificarObservadores("O produto " + nomeProduto + " foi lançado!");
    }
}

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Alice");
        Usuario usuario2 = new Usuario("Bob");
        Usuario usuario3 = new Usuario("Carlos");

        LancamentoProduto lancamento = new LancamentoProduto("Smartwatch");

        lancamento.adicionarObservador(usuario1);
        lancamento.adicionarObservador(usuario2);

        lancamento.lancarProduto();  // Notifica Alice e Bob

        lancamento.removerObservador(usuario1);
        lancamento.adicionarObservador(usuario3);

        lancamento.lancarProduto();  // Notifica Bob e Carlos
    }
}
