import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class TabelaBinaria {
    public List<RegistroOcorrencia> listaRegistros = new ArrayList();

    public void incluirOcorrencia(RegistroOcorrencia registro) throws Exception {
        if (!letraJaContida(registro.getCaracter())) {
            listaRegistros.add(registro);
        }
        else {
            throw new Exception("Registro a ser Incerido é Invalido");
        }
        organizarLista();
    }

    private boolean letraJaContida(char letra) {
        return listaRegistros.contains(letra);
    }

    private void organizarLista() {
        List sortedList = listaRegistros.stream().sorted().collect(Collectors.toList());
        listaRegistros = sortedList;
    }
}
