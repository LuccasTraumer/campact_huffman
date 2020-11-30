import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Huff {
    public static void compactar(String arquivoEntrada, String arquivoSaida) throws Exception {
        Arquivo manipulacaoArquivo = new Arquivo(arquivoEntrada, arquivoSaida);
        // gerara tabela de ocorrencias
         List<Ocorrencia> listaDados = Ocorrencia.gerarListaOcorrencias(manipulacaoArquivo);
         listaDados.sort(Comparator.comparing(Ocorrencia::getOcorrencia));
         // gera uma Lista de Nó
        List<Ocorrencia> arvoreDados = Arvore.gerarArvore(listaDados);
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        List<CodigoBinario> listaCodigoBinario = gerarBinarios(arvoreDados);
        // releitura do texto convertendo pra codigo binário no BitSet
    }

    private static List<CodigoBinario> gerarBinarios(List<Ocorrencia> arvoreDados) {
        List<CodigoBinario> auxiliar = new ArrayList<>();
//        while (arvoreDados.)

        return auxiliar;
    }


    protected static List<Ocorrencia> atualizarAuxiliar(ListaDados listaEmNo) {
        List<Ocorrencia> auxiliar = new ArrayList<>();
        for (No no: listaEmNo.getListaRegistros()) {
            auxiliar.add(no.getInformacao());
        }
        return auxiliar;
    }

    private static void gerarArquivoCompactado(String meuTexto, ListaDados tabConversao,
                                               String arquivoSaida ) {

    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
}
