// Classe para representar um item do inventario
class No {
    String nome;
    double preco;
    int inventario;
    String id;
    No esquerda;
    No direita;

    public No(String nome, double preco, int inventario, String id) {
        this.nome = nome;
        this.preco = preco;
        this.inventario = inventario;
        this.id = id;
        this.esquerda = null;
        this.direita = null;
    }
}

// Classe da Arvore Binaria de Busca
class ArvoreBinaria {
    No raiz;

    public void inserir(String nome, double preco, int inventario, String id) {
        No novoNo = new No(nome, preco, inventario, id);
        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        No atual = raiz;
        while (true) {
            if (nome.compareTo(atual.nome) < 0) {
                if (atual.esquerda == null) {
                    atual.esquerda = novoNo;
                    return;
                }
                atual = atual.esquerda;
            } else if (nome.compareTo(atual.nome) > 0) {
                if (atual.direita == null) {
                    atual.direita = novoNo;
                    return;
                }
                atual = atual.direita;
            } else {
                // Produto ja existe: atualiza preco e inventario
                atual.preco = preco;
                atual.inventario = inventario;
                return;
            }
        }
    }

    public No buscar(String nome) {
        No atual = raiz;
        while (atual != null) {
            if (nome.equals(atual.nome)) {
                return atual;
            }
            atual = nome.compareTo(atual.nome) < 0 ? atual.esquerda : atual.direita;
        }
        return null;
    }

    public void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.esquerda);
        System.out.printf("%-15s | R$ %.2f | %3d unidades | ID: %s\n",
                no.nome, no.preco, no.inventario, no.id);
        emOrdem(no.direita);
    }

    public void exibirInventario() {
        System.out.println("Inventario:");
        System.out.println("----------------------------------------------");
        emOrdem(raiz);
    }
}

// Classe principal (sem public)
class InventarioLoja {
    public static void main(String[] args) {
        ArvoreBinaria loja = new ArvoreBinaria();

        loja.inserir("Lapis", 0.20, 175, "O8XV-5OIB-G4QV-EIJT");
        loja.inserir("Cadernos", 2.49, 200, "FDA9-65RX-QF35-IUPU");
        loja.inserir("Transferidores", 1.79, 82, "KN8C-B0TK-22PE-ZFN3");
        loja.inserir("Borrachas", 0.50, 88, "IQPL-T7QS-L1QI-3MPG");
        loja.inserir("Canetas", 0.75, 102, "P3PC-3P4E-HBN8-ZBJG");

        // Buscar um item especifico
        No item = loja.buscar("Canetas");
        if (item != null) {
            System.out.printf("Encontrado: %s - R$ %.2f - %d unidades - ID: %s\n",
                    item.nome, item.preco, item.inventario, item.id);
        } else {
            System.out.println("Item nao encontrado");
        }

        // Exibir todos os produtos
        loja.exibirInventario();
    }
}