package estrutura.linear;

import java.util.Comparator;

public class ProcessoUrgenciaComparator implements Comparator<Processo> {
    @Override
    public int compare(Processo p1, Processo p2) {
        return Integer.compare(p1.getPrioridade(), p2.getPrioridade());
    }
}
