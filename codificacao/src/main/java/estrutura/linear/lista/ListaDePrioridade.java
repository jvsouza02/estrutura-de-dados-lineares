package estrutura.linear.lista;

import estrutura.linear.NoComUnicaLigacao;
import estrutura.linear.Processo;
import estrutura.linear.ProcessoUrgenciaComparator;
import java.util.Comparator;

/**
 * Classe que representa uma Lista de Prioridade. Os elementos são inseridos de 
 * forma ordenada conforme a prioridade do processo.
 */
public class ListaDePrioridade implements Iterable<Processo> {
    private NoComUnicaLigacao cabeca;
    private Comparator<Processo> comparator;
    
    public ListaDePrioridade() {
        this.cabeca = null;
        this.comparator = new ProcessoUrgenciaComparator();
    }
    
    /**
     * Insere um novo processo na lista de acordo com a prioridade.
     * @param processo O processo a ser inserido.
     */
    public void inserir(Processo processo) {
        NoComUnicaLigacao novo = new NoComUnicaLigacao(processo);
        
        /* Uso do comparator para definir a ordem de inserção por prioridade */
        if (cabeca == null || comparator.compare(processo, cabeca.processo) < 0) {
            novo.proximo = cabeca;
            cabeca = novo;
        } else {
            NoComUnicaLigacao atual = cabeca;
            while (atual.proximo != null &&
                   comparator.compare(atual.proximo.processo, processo) <= 0) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }
    
    /**
     * Remove o processo de maior prioridade (primeiro da lista).
     */
    public void remover() {
        if (cabeca != null) {
            cabeca = cabeca.proximo;
        }
    }
    
    /**
     * Imprime todos os processos na lista na ordem de prioridade.
     */
    public void imprimir() {
        NoComUnicaLigacao atual = cabeca;
        System.out.print("Lista de Prioridade: ");
        while (atual != null) {
            System.out.print(atual.processo.getIdentificador() + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
    
    /* Iterador */
    @Override
    public java.util.Iterator<Processo> iterator() {
        return new java.util.Iterator<Processo>() {
            private NoComUnicaLigacao atual = cabeca;
            
            @Override
            public boolean hasNext() {
                return atual != null;
            }
            
            @Override
            public Processo next() {
                Processo p = atual.processo;
                atual = atual.proximo;
                return p;
            }
        };
    }
    
    /**
     * Método principal para demonstrar o funcionamento da lista de prioridade.
     */
    public static void main(String[] args) {
        ListaDePrioridade lista = new ListaDePrioridade();
        
        lista.inserir(new Processo("Processo 1", 1));
        lista.inserir(new Processo("Processo 2", 2));
        lista.inserir(new Processo("Processo 3", 3));
        lista.inserir(new Processo("Processo 4", 2));
        
        System.out.println("Lista de prioridade após inserções:");
        lista.imprimir();
        
        System.out.println("Percorrendo a lista com Iterator:");
        for (Processo p : lista) {
            System.out.println(p.getIdentificador());
        }
        
        lista.remover();
        System.out.println("Lista de prioridade após remoção do mais prioritário:");
        lista.imprimir();
    }
}