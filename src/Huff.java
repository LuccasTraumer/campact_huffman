import java.util.Comparator;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Huff {
    public static void compactar(String arquivoEntrada, String arquivoSaida) throws Exception {
        Arquivo manipulacaoArquivo = new Arquivo(arquivoEntrada, arquivoSaida);
        // gerara tabela de ocorrencias
         ListaDados listaDados = Huff.gerarListaRegistroOcorrencia(manipulacaoArquivo);
        ListaDados tabela = Huff.gerarListaRaizBinaria(listaDados);
        Arvore arvoreDados = Huff.gerarArvore(tabela);
        
        // gerar os códigos "BINARIO" para cada caracter em uma Lista
        ListaDados tabConversao = Huff.gerarTabelaConversao(arvoreDados);
        
        // releitura do texto convertendo pra codigo binário no BitSet
        gerarArquivoCompactado(arquivoEntrada, tabConversao, arquivoSaida );

    }

    /**
     * Cria a tabela Binaria Caracter e Ocorrencia.
     * */
    private static ListaDados gerarListaRegistroOcorrencia(Arquivo arquivo) throws Exception {
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
        ListaDados listOrdenada = new ListaDados();
        ListaDados listSomaDosMenoresOcorrencias = new ListaDados();
        if (numeroPar(listaDados.getListaRegistros().size())) {
            for (int i = 0; i <= listaDados.getListaRegistros().size()-2; i+=2) {
//                listOrdenada = ordenarLista(listaAux);
                listSomaDosMenoresOcorrencias = somarNoComMenoresOcorrencias(listaDados);
                listaAux = removerRegistroComMenoresOcorrencias(listaDados);
            }

        } else {
            for (int i = 0; i <= listaDados.getListaRegistros().size(); i+=2) {
                No auxiliar = Huff.criarNoBase(i, listaDados);
                listaAux.incluirNo(auxiliar);
            }
        }
        System.out.println("");
        return listaAux;
    }

    private static ListaDados removerRegistroComMenoresOcorrencias(ListaDados listaDados) throws Exception {
        int menorOcorencia = qualMenorOcorrencia(listaDados);
        ListaDados auxiliar = (ListaDados) listaDados.clone();
        for (No no: auxiliar.getListaRegistros()) {
            if (no.getInformacao().getOcorrencia() == menorOcorencia)
                auxiliar.removerNo(no);
        }

        return auxiliar;
    }

    private static ListaDados somarNoComMenoresOcorrencias(ListaDados listaDados) throws Exception {
        int menorOcorrencia = qualMenorOcorrencia(listaDados);
        ListaDados listaAuxiliar = new ListaDados();
        listaDados.organizarListaMenorParaMaior();
        for (int i = 0; i <= listaDados.getListaRegistros().size()-2; i+=2) {
            if (listaDados.getListaRegistros().get(i).getInformacao().getOcorrencia() == menorOcorrencia) {
                No auxiliar = Huff.criarNoBase(i, listaDados);
                listaAuxiliar.incluirNo(auxiliar);
            }
            else
                break;        }
        return listaAuxiliar;
    }

    private static ListaDados ordenarLista(ListaDados listaAux) {
        ListaDados aux = new ListaDados();

        aux = (ListaDados) listaAux.clone();

        aux.organizarListaMenorParaMaior();
        return aux;
    }

    private static int qualMenorOcorrencia(ListaDados listaDados) {
        int value = Integer.MAX_VALUE;
        for (No no: listaDados.getListaRegistros()) {
            if (no.getInformacao().getOcorrencia() < value)
                value = no.getInformacao().getOcorrencia();
        }
        return value;
    }

    private static boolean numeroPar(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Gera um No que ira ser criado a parir do Indice forneceido e da tabela.
     * */
    private static No criarNoBase(int indice, ListaDados tabela) throws Exception {
        int proximoIndice = indice + 1;
        No noAuxiliar = null;
        tabela.organizarListaMenorParaMaior();
        if (tabela.getListaRegistros().get(indice).getInformacao() != null &&
                tabela.getListaRegistros().get(proximoIndice).getInformacao() != null) {
            RegistroOcorrencia registroAuxiliar = new RegistroOcorrencia(
                    tabela.getListaRegistros().get(indice).getInformacao().getOcorrencia() +
                            tabela.getListaRegistros().get(proximoIndice).getInformacao().getOcorrencia());


            noAuxiliar = new No(registroAuxiliar);
            noAuxiliar.setEsquerda(tabela.getListaRegistros().get(indice));
            noAuxiliar.setDireita(tabela.getListaRegistros().get(proximoIndice));
        }
        if (tabela.getListaRegistros().get(indice).getInformacao() != null &&
                tabela.getListaRegistros().get(proximoIndice).getInformacao() == null) {
            noAuxiliar = new No(tabela.getListaRegistros().get(indice).getInformacao());
        }

        if (noAuxiliar == null)
            throw new Exception("Index of out bound");
        return noAuxiliar;
    }
    
    private static Arvore gerarArvore(ListaDados lista) {
        ListaDados aux = new ListaDados();
        Arvore arvore = new Arvore();
        int sum = 0;
        for (No no: lista.getListaRegistros()) {
            sum+= no.getInformacao().getOcorrencia();
        }

        return null;
    }
    
    private static ListaDados gerarTabelaConversao(Arvore arvore) {
       return null;
    }

    private static void gerarArquivoCompactado(String meuTexto, ListaDados tabConversao,
                                               String arquivoSaida ) {
    
    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
}
