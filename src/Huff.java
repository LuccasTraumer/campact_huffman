/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Huff {
    public static void compactar(String arquivoEntrada, String arquivoSaida) throws Exception {
        Arquivo manipulacaoArquivo = new Arquivo(arquivoEntrada, arquivoSaida);
        // gerara tabela de ocorrencias
         ListaDados listaDados = Huff.gerarTabelaBinaria(manipulacaoArquivo);
        ListaDados tabela = Huff.gerarListaRaizBinaria(listaDados);
        Arvore arvoreDados = Huff.gerarArvore(listaDados);
        
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        ListaDados tabConversao = Huff.gerarTabelaConversao(arvoreDados);
        
        // releitura do texto convertendo pra codigo binário no BitSet
        gerarArquivoCompactado(arquivoEntrada, tabConversao, arquivoSaida );

    }

    /**
     * Cria a tabela Binaria Caracter e Ocorrencia.
     * */
    private static ListaDados gerarTabelaBinaria(Arquivo arquivo) throws Exception {
        ListaDados listaDados = new ListaDados();
        for (char caracter: new String(arquivo.getCaracteres()).toCharArray()) {
            listaDados.incluirOcorrencia(new RegistroOcorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo)));
        }

        listaDados.organizarListaMaiorParaMenor();
        return listaDados;
    }

    /**
     * Gera Arvore Binario. Vai criando o Nó que tem como ocorrencia a soma das folhas.
     * */
    private static ListaDados gerarListaRaizBinaria(ListaDados listaDados) throws Exception {

        ListaDados listaAux = new ListaDados();
        ListaDados registrosRemovidosDaLista = new ListaDados();
        if (listaDados.getListaRegistros().size() % 2 == 0) {
            for (int i = 0; i <= listaDados.getListaRegistros().size()-2; i+=2) {
                No auxiliar = Huff.criarNoBase(i, listaDados);
                listaAux.incluirNo(auxiliar);
                registrosRemovidosDaLista.getListaRegistros().add(listaDados.getListaRegistros().get(i));
                registrosRemovidosDaLista.getListaRegistros().add(listaDados.getListaRegistros().get(i+1));
            }
        } else {
            for (int i = 0; i <= listaDados.getListaRegistros().size(); i+=2) {
                No auxiliar = Huff.criarNoBase(i, listaDados);
                listaAux.incluirNo(auxiliar);
                registrosRemovidosDaLista.getListaRegistros().add(listaDados.getListaRegistros().get(i));
                registrosRemovidosDaLista.getListaRegistros().add(listaDados.getListaRegistros().get(i+1));
            }
        }
        return listaAux;
    }

    /**
     * Gera um No que ira ser criado a parir do Indice forneceido e da tabela.
     * */
    private static No criarNoBase(int indice, ListaDados tabela) throws Exception {
        int proximoIndice = indice + 1;
        No noAuxiliar = null;

        if (tabela.getListaRegistros().get(indice).getInformacao() != null &&
                tabela.getListaRegistros().get(proximoIndice).getInformacao() != null) {
            RegistroOcorrencia registroAuxiliar = new RegistroOcorrencia(
                    tabela.getListaRegistros().get(indice).getInformacao().getOcorrencia() +
                            tabela.getListaRegistros().get(proximoIndice).getInformacao().getOcorrencia());


            noAuxiliar = new No(registroAuxiliar);
            noAuxiliar.setEsquerda(tabela.getListaRegistros().get(indice));
            noAuxiliar.setDireita(tabela.getListaRegistros().get(proximoIndice));
        }

        if (noAuxiliar == null)
            throw new Exception("Index of out bound");
        return noAuxiliar;
    }

    private static void removerNo(No no, ListaDados tabela) throws Exception {
        try {
            tabela.removerNo(no);
        } catch (Exception e) {
            throw new Exception("Problema para remover No");
        }
    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
    
    private static Arvore gerarArvore(ListaDados lista) {
        return null;
    }
    
    private static ListaDados gerarTabelaConversao(Arvore arvore) {
       return null;
    }

    private static void gerarArquivoCompactado(String meuTexto, ListaDados tabConversao,
                                               String arquivoSaida ) {
    
    }
}
