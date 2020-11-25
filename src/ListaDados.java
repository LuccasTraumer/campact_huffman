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

    public void incluirOcorrencia(RegistroOcorrencia registro) throws Exception {
        if (!letraJaContida(registro)) {
            listaRegistros.add(new No(registro));
        }
    }

    public ListaDados() {
        listaRegistros = new ArrayList<>();
    }

    public void incluirNo(No no) {
        listaRegistros.add(no);
    }

    public void removerNo(No no) throws Exception {
        listaRegistros.remove(no);
    }

    private boolean letraJaContida(RegistroOcorrencia registro) {
        for (No no: listaRegistros) {
            if (no.getInformacao().getCaracter() == registro.getCaracter() &&
                no.getInformacao().getOcorrencia() == registro.getOcorrencia()) {
                return true;
            }
        }
        return false;
    }

    protected void organizarListaMaiorParaMenor() {
        listaRegistros.sort(Comparator.comparing(No::getInformacao));
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
