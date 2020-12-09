package huffman;

import arquivo.Arquivo;
import listaDados.ListaDados;
import ocorrencia.Ocorrencia;
import tabelaBinaria.CodigoBinario;

import java.util.ArrayList;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Huff {
    private static List<CodigoBinario> listaCodigoBinario = new ArrayList<>();
    private static Arquivo manipulacaoArquivo = null;
    public static void compactar(String arquivoEntrada, String arqSaida) throws Exception {
        manipulacaoArquivo = new Arquivo(arquivoEntrada, arqSaida);
         List<Ocorrencia> listaDados = Ocorrencia.gerarListaOcorrencias(manipulacaoArquivo);
        TabelaHuff tabelaHuff = new TabelaHuff(listaDados);
        tabelaHuff.gerarArvore();
        listaCodigoBinario = gerarBinarios(tabelaHuff);
        gerarArquivoCompactado(manipulacaoArquivo.getCaracteres().toString(),
                listaCodigoBinario,manipulacaoArquivo);
    }

    private static List<CodigoBinario> gerarBinarios(TabelaHuff tabelaHuff) throws Exception {
        List<CodigoBinario> auxiliar = new ArrayList<>();

        tabelaHuff.getArvore().get(0).criaCodigoBinario();
        auxiliar = tabelaHuff.getArvore().get(0).getListaSquenciaBinaria();
        return auxiliar;
    }


    private static void gerarArquivoCompactado(String meuTexto, List<CodigoBinario> binarios, Arquivo arquivo) {
        arquivo.gerarArquivoSaidaCompactado(binarios, arquivo);
    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
        Arquivo saida = new Arquivo(arquivoEntrada, arquivoSaida);
        manipulacaoArquivo.gerarArquivoSaidaDescompactado(listaCodigoBinario, saida);

    }
}
