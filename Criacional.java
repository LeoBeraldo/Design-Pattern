class Personagem {
    private String nome;
    private int forca;
    private int agilidade;
    private int inteligencia;
    private String arma;

    // Construtor privado para restringir criação direta
    private Personagem(String nome, int forca, int agilidade, int inteligencia, String arma) {
        this.nome = nome;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nForça: " + forca + "\nAgilidade: " + agilidade + "\nInteligência: " + inteligencia + "\nArma: " + arma;
    }

    // Classe interna para construir o personagem
    public static class PersonagemBuilder {
        private String nome;
        private int forca;
        private int agilidade;
        private int inteligencia;
        private String arma;

        public PersonagemBuilder definirNome(String nome) {
            this.nome = nome;
            return this;
        }

        public PersonagemBuilder definirForca(int forca) {
            this.forca = forca;
            return this;
        }

        public PersonagemBuilder definirAgilidade(int agilidade) {
            this.agilidade = agilidade;
            return this;
        }

        public PersonagemBuilder definirInteligencia(int inteligencia) {
            this.inteligencia = inteligencia;
            return this;
        }

        public PersonagemBuilder definirArma(String arma) {
            this.arma = arma;
            return this;
        }

        public Personagem construir() {
            return new Personagem(nome, forca, agilidade, inteligencia, arma);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Personagem guerreiro = new Personagem.PersonagemBuilder()
            .definirNome("Guerreiro")
            .definirForca(15)
            .definirAgilidade(5)
            .definirInteligencia(3)
            .definirArma("Espada")
            .construir();

        System.out.println(guerreiro);
    }
}
