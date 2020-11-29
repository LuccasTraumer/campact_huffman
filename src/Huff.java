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
         ListaDados listaDados = Huff.gerarListaRegistroOcorrencia(manipulacaoArquivo);
        ListaDados tabela = Huff.gerarListaRaizBinaria(listaDados);
        Arvore arvoreDados = Huff.gerarArvore(tabela);
        
        // gerar os códigos "BINARIO" para cada caracter em uma Lista

        
        // releitura do texto convertendo pra codigo binário no BitSet


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
        ListaDados listaAux = (ListaDados) listaDados.clone();
        ListaDados listOrdenada = new ListaDados();
        ListaDados listSomaDosMenoresOcorrencias = new ListaDados();

        while(listaAux.getListaRegistros().size() != 1) {
            listSomaDosMenoresOcorrencias = somarNoComMenoresOcorrencias(listaAux);
            listaAux = removerRegistroComMenoresOcorrencias(listaDados, listSomaDosMenoresOcorrencias);
            listaAux = juntarListasDeNoOrdenadas(listaAux, listSomaDosMenoresOcorrencias);
        }


        return listaAux;
    }

    private static ListaDados juntarListasDeNoOrdenadas(ListaDados listaAux, ListaDados listSomaDosMenoresOcorrencias) {
        ListaDados aux = new ListaDados();
        for (No no: listSomaDosMenoresOcorrencias.getListaRegistros()) {
            aux.incluirNo(no);
        }
        for (No no: listaAux.getListaRegistros()) {
            aux.incluirNo(no);
        }
        aux.organizarListaMenorParaMaior();
        return aux;
    }


    private static ListaDados removerRegistroComMenoresOcorrencias(ListaDados listaDados, ListaDados valoresASeremRemovidos) throws Exception {
        ListaDados auxiliar = new ListaDados();
        ListaDados clone = (ListaDados) listaDados.clone();
        for (No no: valoresASeremRemovidos.getListaRegistros()) {
            if(listaDados.getListaRegistros().contains(no.getDireita()) &&
                    listaDados.getListaRegistros().contains(no.getEsquerda())) {
                auxiliar.incluirNo(no.getDireita());
                auxiliar.incluirNo(no.getEsquerda());
            }
        }
        for (No no: auxiliar.getListaRegistros()) {
            clone.removerNo(no);
        }

        return clone;
    }

    private static ListaDados somarNoComMenoresOcorrencias(ListaDados listaDados) throws Exception {
        int menorOcorrencia = qualMenorOcorrencia(listaDados);
        List<No> elementosSeremRemovidos = new ArrayList<>();
        ListaDados listaAuxiliar = new ListaDados();
        listaDados.organizarListaMenorParaMaior();
        for (int i = 0; i <= listaDados.getListaRegistros().size()-2; i+=2) {
            if (listaDados.getListaRegistros().get(i).getInformacao().getOcorrencia() == menorOcorrencia &&
                    listaDados.getListaRegistros().get(i+1).getInformacao().getOcorrencia() == menorOcorrencia) {
                No auxiliar = Huff.criarNoBase(i, listaDados);
                listaAuxiliar.incluirNo(auxiliar);
                elementosSeremRemovidos.add(listaDados.getListaRegistros().get(i));
                elementosSeremRemovidos.add(listaDados.getListaRegistros().get(i+1));
            }
            else
                break;
        }

        return listaAuxiliar;
    }

    private static ListaDados removerElementos(List<No> elementosSeremRemovidos, ListaDados lista) throws Exception {
        ListaDados aux = (ListaDados) lista.clone();
        for (No no: elementosSeremRemovidos) {
            if (lista.getListaRegistros().contains(no))
                aux.removerNo(no);
        }
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

    private static void gerarArquivoCompactado(String meuTexto, ListaDados tabConversao,
                                               String arquivoSaida ) {
    
    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
}
