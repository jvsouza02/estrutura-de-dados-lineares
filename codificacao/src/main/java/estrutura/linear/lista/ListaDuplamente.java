package estrutura.linear.lista;

import estrutura.linear.Processo;

public class ListaDuplamente {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        
        lista.inserir(new Processo("Processo-1"));
        lista.inserir(new Processo("Processo-2"));
        lista.inserir(new Processo("Processo-3"));

        lista.imprimirEstado();
        
        lista.remover("Processo-2"); 
        lista.imprimirEstado();
    }
}

class No {
    Processo processo;
    No anterior;
    No proximo;

    public No(Processo processo, No anterior, No proximo) {
        this.processo = processo;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public Processo getProcesso() { return processo; }
    public No getAnterior() { return anterior; }
    public void setAnterior(No anterior) { this.anterior = anterior; }
    public No getProximo() { return proximo; }
    public void setProximo(No proximo) { this.proximo = proximo; }
}

class ListaLigada {
    private No cabeca = null;
    private No cauda = null;

    public void inserir(Processo processo) {
        No novoNo = new No(processo, null, null);
        
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.setAnterior(cauda);
            cauda.setProximo(novoNo); 
            cauda = novoNo;  
        }
    }

    public void remover(String nomeProcesso) {
        No atual = cabeca;
        
        while (atual != null) {
            if (atual.getProcesso().getIdentificador().equals(nomeProcesso)) {
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                } else {
                    cabeca = atual.getProximo();
                }
                
                if (atual.getProximo() != null) {
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    cauda = atual.getAnterior();
                }
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void imprimirEstado() {
        No atual = cabeca;
        System.out.println("Lista:");
        while (atual != null) {
            System.out.println("- " + atual.getProcesso().getIdentificador());
            atual = atual.getProximo();
        }
    }
}