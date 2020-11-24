import java.util.ArrayList;
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
        TabelaBinaria tabelaBinaria = Huff.gerarTabelaBinaria(manipulacaoArquivo);
        TabelaHuff tabela = Huff.gerarArvoreBinaria(tabelaBinaria);
        Arvore arvHuff = Huff.gerarArvore(tabela);
        
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        TabelaBinaria tabConversao = Huff.gerarTabelaConversao(arvHuff);
        
        // releitura do texto convertendo pra codigo binário no BitSet
        gerarArquivoCompactado(arquivoEntrada, tabConversao, arquivoSaida );

    }

    private static TabelaHuff gerarArvoreBinaria(TabelaBinaria tabelaBinaria) throws Exception{
        Arvore arvore = new Arvore();
        List<No> listaDeNoBase = new ArrayList<>();
        for (int i = 0; i <= tabelaBinaria.getListaRegistros().size(); i+=2) {
            No auxiliar = Huff.criarNoBase(i, tabelaBinaria);
            listaDeNoBase.add(auxiliar);
        }

        return null;
    }

    private static No criarNoBase(int indice, TabelaBinaria tabela) throws Exception {
        int proximoIndice = indice + 1;
        RegistroOcorrencia registroAuxiliar = new RegistroOcorrencia(
                tabela.getListaRegistros().get(indice).getInformacao().getOcorrencia() +
                        tabela.getListaRegistros().get(proximoIndice).getInformacao().getOcorrencia());


        No noAuxiliar = new No(registroAuxiliar);
        noAuxiliar.setEsquerda(tabela.getListaRegistros().get(indice));
        noAuxiliar.setDireita(tabela.getListaRegistros().get(proximoIndice));
        return noAuxiliar;
    }

    private static TabelaBinaria gerarTabelaBinaria(Arquivo arquivo) throws Exception {
        TabelaBinaria tabelaBinaria = new TabelaBinaria();
        for (char caracter: new String(arquivo.getCaracteres()).toCharArray()) {
            tabelaBinaria.incluirOcorrencia(new RegistroOcorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo)));
        }

        tabelaBinaria.organizarListaMaiorParaMenor();
        return tabelaBinaria;
    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
    
    private static Arvore gerarArvore(TabelaHuff tabela) {
        return null;
    }
    
    private static TabelaBinaria gerarTabelaConversao(Arvore arvore) {
       return null;
    }

    private static void gerarArquivoCompactado(String meuTexto, TabelaBinaria tabConversao,
                                               String arquivoSaida ) {
    
    }
}
