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
        // gerar tabela de ocorrencias
         List<Ocorrencia> listaDados = Ocorrencia.gerarListaOcorrencias(manipulacaoArquivo);
         //Organiza do menor pro Maior
         listaDados.sort(Comparator.comparing(Ocorrencia::getOcorrencia));
         // gera uma Lista de Arvore
        TabelaHuff tabelaHuff = new TabelaHuff(listaDados);
        // gera Arvore com as sub-arvores
        tabelaHuff.gerarArvore();
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        List<CodigoBinario> listaCodigoBinario = gerarBinarios(tabelaHuff.gerarArvore());
        // releitura do texto convertendo pra codigo binário no BitSet
    }

    private static List<CodigoBinario> gerarBinarios(List<Arvore> arvoreDados) throws Exception {
        List<CodigoBinario> auxiliar = new ArrayList<>();
        int index = 0;
        while(auxiliar.size() != arvoreDados.size()) {
            auxiliar.add(arvoreDados.get(index).criaCodigoBinario());
            index++;
        }
        return auxiliar;
    }


    private static void gerarArquivoCompactado(String meuTexto, ListaDados tabConversao,
                                               String arquivoSaida ) {

    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
}
