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
        TabelaHuff tabelaHuff = new TabelaHuff();
        for (int i = 0; i <= tabelaBinaria.getListaRegistros().size(); i+=2) {
            RegistroOcorrencia registroAuxiliar = new RegistroOcorrencia(
                    tabelaBinaria.getListaRegistros().get(i).getOcorrencia() +
                    tabelaBinaria.getListaRegistros().get(i+1).getOcorrencia());


            No noAuxiliar = new No(registroAuxiliar);
            noAuxiliar.setEsquerda(new No(tabelaBinaria.getListaRegistros().get(i)));
            noAuxiliar.setDireita(new No(tabelaBinaria.getListaRegistros().get(i+1)));

        }

        return null;
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
