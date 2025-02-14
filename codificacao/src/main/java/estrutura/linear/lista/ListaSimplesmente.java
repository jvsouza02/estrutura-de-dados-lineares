package estrutura.linear.lista;

import estrutura.linear.Processo;

public class ListaSimplesmente {

    class No {
        Processo processo;
        No proximo;

        public No(Processo processo) {
            this.processo = processo;
            this.proximo = null;
        }
    }

    private No cabeca;

    public ListaSimplesmente() {
        this.cabeca = null;
    }

    public void inserir(Processo processoNovo) {
        No novoNo = new No(processoNovo);

        if (cabeca == null) {
            cabeca = novoNo;
        } else { 
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void remover(String nomeProcesso) {
        if (cabeca == null) return;

        if (cabeca.processo.getIdentificador().equals(nomeProcesso)) {
            cabeca = cabeca.proximo;
            return;
        }

        No anterior = cabeca;
        No atual = cabeca.proximo;

        while (atual != null) {
            if (atual.processo.getIdentificador().equals(nomeProcesso)) {
                anterior.proximo = atual.proximo;
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    public void imprimirEstado() {
        No atual = cabeca;
        System.out.println("Lista:");
        while (atual != null) {
            System.out.println("- " + atual.processo.getIdentificador());
            atual = atual.proximo;
        }
    }

    public static void main(String[] args) {
        ListaSimplesmente lista = new ListaSimplesmente();

        lista.inserir(new Processo("Processo X"));
        lista.inserir(new Processo("Processo Y"));
        lista.inserir(new Processo("Processo Z"));
        lista.imprimirEstado();
        
        lista.remover("Processo Y");
        lista.imprimirEstado();
    }
}