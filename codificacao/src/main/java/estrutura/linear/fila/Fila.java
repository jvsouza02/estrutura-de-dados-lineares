package estrutura.linear.fila;

import estrutura.linear.Processo;

public class Fila {

    public Processo processoAtual;
    public Fila proximaFila;

    public Fila() {
        this.processoAtual = null;
        this.proximaFila = null;
    }

    public void inserirfila(Processo processoNovo) {
        if (this.processoAtual == null) {
            this.processoAtual = processoNovo;
            this.proximaFila = new Fila();
        } else {
            this.proximaFila.inserirfila(processoNovo);
        }
    }

    public Processo removerfila() {
        if (vaziafila()) {
            System.out.println("Fila vazia! Não é possível remover.");
            return null;
        }

        Processo removido = this.processoAtual;

        if (this.proximaFila != null) {
            this.processoAtual = this.proximaFila.processoAtual;
            this.proximaFila = this.proximaFila.proximaFila;
        } else {
            this.processoAtual = null;
        }

        return removido;
    }

    public boolean vaziafila() {
        return this.processoAtual == null && this.proximaFila == null;
    }

    public void imprimirEstado() {
        Fila atual = this;
        System.out.println("Fila:");
        while (atual != null && !atual.vaziafila()) {
            if (atual.processoAtual != null) {
                System.out.println("- " + atual.processoAtual.getIdentificador());
            }
            atual = atual.proximaFila;
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.inserirfila(new Processo("Processo 1"));
        fila.inserirfila(new Processo("Processo 2"));
        fila.inserirfila(new Processo("Processo 3"));

        fila.imprimirEstado();

        fila.removerfila();
        fila.imprimirEstado();

        fila.removerfila();
        fila.removerfila();
        fila.imprimirEstado();
        fila.removerfila();
    }
}