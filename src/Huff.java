public class Huff {
    public static void compactar(String arqEntrada, String arqSaida) throws Exception {
        
        // leitura dos dados do arquivo 
        // String meuTexto = Arquivo.qualConteudo(arqEntrada);
        
        String meuTexto="Batatinha quando nasce";  
        
        // gerara tabela de ocorrencias
        TabelaHuff tabela = Huff.gerarTabela(meuTexto);
        Arvore arvHuff = Huff.gerarArvore(tabela);
        
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        TabelaBinaria tabConversao = Huff.gerarTabelaConversao(arvHuff);
        
        // releitura do texto convertendo pra codigo binário no BitSet
        gerarArquivoCompactado(meuTexto, tabConversao, arqSaida );
        
    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
    
    private static TabelaHuff gerarTabela(String texto) {
        return null;
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
