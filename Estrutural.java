class Estoque {
    private java.util.Map<String, Integer> produtos = new java.util.HashMap<>();

    public void adicionarProduto(String nomeProduto, int quantidade) {
        produtos.put(nomeProduto, produtos.getOrDefault(nomeProduto, 0) + quantidade);
    }

    public void removerProduto(String nomeProduto, int quantidade) {
        if (produtos.containsKey(nomeProduto) && produtos.get(nomeProduto) >= quantidade) {
            produtos.put(nomeProduto, produtos.get(nomeProduto) - quantidade);
        } else {
            System.out.println("Estoque insuficiente para remover.");
        }
    }

    public int obterEstoque(String nomeProduto) {
        return produtos.getOrDefault(nomeProduto, 0);
    }
}

class Precificacao {
    private java.util.Map<String, Double> precos = new java.util.HashMap<>();

    public void definirPreco(String nomeProduto, double preco) {
        precos.put(nomeProduto, preco);
    }

    public double obterPreco(String nomeProduto) {
        return precos.getOrDefault(nomeProduto, 0.0);
    }
}

class FacadeEstoque {
    private Estoque estoque = new Estoque();
    private Precificacao precificacao = new Precificacao();

    public void adicionarProduto(String nomeProduto, int quantidade, double preco) {
        estoque.adicionarProduto(nomeProduto, quantidade);
        precificacao.definirPreco(nomeProduto, preco);
    }

    public void venderProduto(String nomeProduto, int quantidade) {
        int estoqueAtual = estoque.obterEstoque(nomeProduto);
        if (estoqueAtual >= quantidade) {
            estoque.removerProduto(nomeProduto, quantidade);
            double precoTotal = precificacao.obterPreco(nomeProduto) * quantidade;
            System.out.println("Vendido " + quantidade + " de " + nomeProduto + " por R$" + precoTotal);
        } else {
            System.out.println("Estoque insuficiente para venda.");
        }
    }

    public String consultarProduto(String nomeProduto) {
        int estoqueAtual = estoque.obterEstoque(nomeProduto);
        double preco = precificacao.obterPreco(nomeProduto);
        return "Produto: " + nomeProduto + ", Estoque: " + estoqueAtual + ", Preço: R$" + preco;
    }
}

public class Main {
    public static void main(String[] args) {
        FacadeEstoque facade = new FacadeEstoque();
        facade.adicionarProduto("Notebook", 10, 3000.0);
        facade.adicionarProduto("Smartphone", 20, 1500.0);
        System.out.println(facade.consultarProduto("Notebook"));
        facade.venderProduto("Notebook", 5);
        System.out.println(facade.consultarProduto("Notebook"));
    }
}
