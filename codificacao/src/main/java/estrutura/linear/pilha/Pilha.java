package estrutura.linear.pilha;

import estrutura.linear.Processo;

public class Pilha {

    public Processo processoAtual;
    public Pilha proximaPilha;

    public Pilha() {
        this.processoAtual = null;
        this.proximaPilha = null;
    }

    public void inserirpilha(Processo processoNovo) {
        if (this.processoAtual == null) {
            this.processoAtual = processoNovo;
        } else {
            Pilha novaPilha = new Pilha();
            novaPilha.processoAtual = this.processoAtual;
            novaPilha.proximaPilha = this.proximaPilha;
            this.processoAtual = processoNovo;
            this.proximaPilha = novaPilha;
        }
    }

    // Remove do topo
    public Processo removerPilha() {
        if (vaziaPilha()) {
            System.out.println("Pilha vazia!");
            return null;
        }

        Processo removido = this.processoAtual;

        if (this.proximaPilha != null) {
            this.processoAtual = this.proximaPilha.processoAtual;
            this.proximaPilha = this.proximaPilha.proximaPilha;
        } else {
            this.processoAtual = null;
        }

        return removido;
    }

    public boolean vaziaPilha() {
        return this.processoAtual == null && this.proximaPilha == null;
    }

    public void imprimirEstado() {
        Pilha atual = this;
        System.out.println("Pilha:");
        while (atual != null && !atual.vaziaPilha()) {
            if (atual.processoAtual != null) {
                System.out.println("- " + atual.processoAtual.getIdentificador());
            }
            atual = atual.proximaPilha;
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.inserirpilha(new Processo("Processo A"));
        pilha.inserirpilha(new Processo("Processo B"));
        pilha.removerPilha();
        pilha.imprimirEstado();
    }
}