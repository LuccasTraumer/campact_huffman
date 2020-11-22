/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Huff {
    private TabelaBinaria tabelaBinaria = new TabelaBinaria();
    public static void compactar(String arquivoEntrada, String arquivoSaida) throws Exception {
        Arquivo manipulacaoArquivo = new Arquivo(arquivoEntrada, arquivoSaida);
        // gerara tabela de ocorrencias
        Huff.gerarTabelaBinaria(manipulacaoArquivo);
        TabelaHuff tabela = Huff.gerarTabelaBinaria(arquivoEntrada);
        Arvore arvHuff = Huff.gerarArvore(tabela);
        
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        TabelaBinaria tabConversao = Huff.gerarTabelaConversao(arvHuff);
        
        // releitura do texto convertendo pra codigo binário no BitSet
        gerarArquivoCompactado(arquivoEntrada, tabConversao, arquivoSaida );
        
    }

    private static TabelaHuff gerarTabelaBinaria(String meuTexto) {
        return null;
    }

    private static void gerarTabelaBinaria(Arquivo arquivo) throws Exception {
        TabelaBinaria tabelaBinaria = new TabelaBinaria();
        for (char caracter: new String(arquivo.getCaracteres()).toCharArray()) {
            tabelaBinaria.incluirOcorrencia(new RegistroOcorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo)));
        }
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
