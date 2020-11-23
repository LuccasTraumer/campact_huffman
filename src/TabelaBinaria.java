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
    private List<RegistroOcorrencia> listaRegistros = new ArrayList();

    public void incluirOcorrencia(RegistroOcorrencia registro) throws Exception {
        if (!letraJaContida(registro)) {
            listaRegistros.add(registro);
        }
    }

    private boolean letraJaContida(RegistroOcorrencia registro) {
        return listaRegistros.contains(registro);
    }

    protected void organizarLista() {
        listaRegistros.sort(Comparator.comparing(RegistroOcorrencia::getOcorrencia).reversed());
    }

    public List<RegistroOcorrencia> getListaRegistros() {
        return this.listaRegistros;
    }
}
