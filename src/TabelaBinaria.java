import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return listaRegistros.contains(registro);
    }

    protected void organizarListaMaiorParaMenor() {
        listaRegistros.sort(Comparator.comparing(No::getInformacao));
    }

    public List<No> getListaRegistros() {
        return this.listaRegistros;
    }
}
