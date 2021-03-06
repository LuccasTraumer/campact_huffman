import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class ListaDados {
    private List<No> listaRegistros;

    public void incluirOcorrencia(Ocorrencia registro) throws Exception {
        if (!letraJaContida(registro)) {
            listaRegistros.add(new No(registro));
        }
    }

    public ListaDados() {
        listaRegistros = new ArrayList<>();
    }

    public void removerNo(No no) throws Exception {
        if (!listaRegistros.isEmpty() && no != null) {
            for (No aux: listaRegistros) {
                if (aux.getInformacao().getOcorrencia() == no.getInformacao().getOcorrencia() &&
                    aux.getInformacao().getCaracter() == no.getInformacao().getCaracter())
                    listaRegistros.remove(aux);
                break;
            }
        }
    }

    private boolean letraJaContida(Ocorrencia registro) {
        for (No no: listaRegistros) {
            if (no.getInformacao().getCaracter() == registro.getCaracter() &&
                no.getInformacao().getOcorrencia() == registro.getOcorrencia()) {
                return true;
            }
        }
        return false;
    }

    public List<No> getListaRegistros() {
        return this.listaRegistros;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ListaDados(ListaDados modelo) throws Exception {
        if (modelo != null) {
            this.listaRegistros = new ArrayList<>();
            for (No no: modelo.listaRegistros) {
                this.listaRegistros.add(no);
            }
        }
        else
            throw new Exception("Objeto Invalido para copia");
    }

    public Object clone() {
        ListaDados aux = null;
        try {
            aux = new ListaDados(this);
        } catch (Exception e) {
        }

        return aux;
    }
}
