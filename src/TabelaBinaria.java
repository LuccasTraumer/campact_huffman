import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class TabelaBinaria {
    private List<No> listaRegistros = new ArrayList();

    public void incluirOcorrencia(RegistroOcorrencia registro) throws Exception {
        if (!letraJaContida(registro)) {
            listaRegistros.add(new No(registro));
        }
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
}
