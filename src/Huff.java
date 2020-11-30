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
         List<Ocorrencia> listaDados = Huff.gerarListaOcorrencias(manipulacaoArquivo);
         listaDados.sort(Comparator.comparing(Ocorrencia::getOcorrencia));
         // gera uma Lista de Nó
        //ListaDados listaNos = Huff.geraListaNo(listaDados);
        // gera lista de Nó com a soma de Ocorencia das Folhas

        Arvore arvoreDados = Huff.gerarArvore(listaDados);

        // gerar os códigos "BINARIO" para cada caracter em uma Lista

        // releitura do texto convertendo pra codigo binário no BitSet
    }

    /**
     * Cria a tabela Binaria Caracter e Ocorrencia.
     * */
    private static List<Ocorrencia> gerarListaOcorrencias(Arquivo arquivo) throws Exception {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        for (char caracter: new String(arquivo.getCaracteres()).toCharArray()) {
            Ocorrencia ocorrenciaAuxiliar = new Ocorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo));
            if(!ocorrencias.contains(ocorrenciaAuxiliar))
                ocorrencias.add(new Ocorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo)));
        }
        return ocorrencias;
    }

    /**
     * Gera Arvore Binario. Vai criando o Nó que tem como ocorrencia a soma das folhas.
     * */
    private static ListaDados geraListaNo(List<Ocorrencia> ocorrencias) throws Exception {
        ListaDados auxiliar = new ListaDados();
        for (Ocorrencia ocorrencia: ocorrencias) {
            No no = new No(ocorrencia);
            auxiliar.incluirNo(no);
        }
        return auxiliar;
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
            Ocorrencia registroAuxiliar = new Ocorrencia(
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

    private static List<Ocorrencia> gerarArvore(List<Ocorrencia> listaOcorrencias) throws Exception {
        List<Ocorrencia> auxiliar = new ArrayList<>(listaOcorrencias);
        List<Arvore> semiArvores = new ArrayList<>();
        ListaDados listaEmNo = gerarListaEmNo(listaOcorrencias);
        int indice = 0;
        int menorOcorrencia = qualMenorOcorrencia(listaOcorrencias);
        while (listaEmNo.getListaRegistros().size() != 1) {
            No nopBase = gerarNoBase(indice, auxiliar);
            listaEmNo = removerNoLista(nopBase, listaEmNo);
            auxiliar = removerNoLista(nopBase, auxiliar);
            listaEmNo.incluirNo(nopBase);
            listaEmNo.organizarListaMenorParaMaior();
            Arvore arvoreAuxiliar = new Arvore();
            arvoreAuxiliar.incluir(nopBase);
            semiArvores.add(arvoreAuxiliar);
            if (quantasRegistrosCom(menorOcorrencia, auxiliar) == 1 ||
                    quantasRegistrosCom(menorOcorrencia, auxiliar) == 0) {
                auxiliar = atualizarAuxiliar(listaEmNo);
                menorOcorrencia = qualMenorOcorrencia(auxiliar);
            }
        }

        return auxiliar;
    }

    private static int quantasRegistrosCom(int menorOcorrencia, List<Ocorrencia> lista) {
        int contador = 0;
        for (Ocorrencia ocorrencia: lista) {
            if (ocorrencia.getOcorrencia() == menorOcorrencia)
                contador++;
        }
        return contador;
    }
    private static int qualMenorOcorrencia(List<Ocorrencia> listaOcorrencias) {
        int value = Integer.MAX_VALUE;
        for (Ocorrencia ocorrencia: listaOcorrencias) {
            if (ocorrencia.getOcorrencia() < value)
                value = ocorrencia.getOcorrencia();
        }
        return value;
    }

    private static List<Ocorrencia> atualizarAuxiliar(ListaDados listaEmNo) {
        List<Ocorrencia> auxiliar = new ArrayList<>();
        for (No no: listaEmNo.getListaRegistros()) {
            auxiliar.add(no.getInformacao());
        }
        return auxiliar;
    }

    private static ListaDados gerarListaEmNo(List<Ocorrencia> listaOcorrencias) throws Exception {
        ListaDados auxiliar = new ListaDados();
        for (Ocorrencia ocorrencia: listaOcorrencias) {
            auxiliar.incluirOcorrencia(ocorrencia);
        }
        return auxiliar;
    }

    private static List<Ocorrencia> removerNoLista(No no, List<Ocorrencia> listaOcorrencias) {
        if (no != null && !listaOcorrencias.isEmpty() && listaOcorrencias.size() > 1){
            if (no.getEsquerda() != null) {
                if (listaOcorrencias.contains(no.getEsquerda().getInformacao()))
                    listaOcorrencias.remove(no.getEsquerda().getInformacao());
            }
        }
        if (no != null && !listaOcorrencias.isEmpty() && listaOcorrencias.size() > 1){
            if (no.getDireita() != null) {
                if (listaOcorrencias.contains(no.getDireita().getInformacao()))
                    listaOcorrencias.remove(no.getDireita().getInformacao());
            }
        }
        return listaOcorrencias;
    }

    private static ListaDados removerNoLista(No no, ListaDados lista) throws Exception {
        if (no != null)
            lista.removerNo(no.getEsquerda());
        if (no != null)
            lista.removerNo(no.getDireita());
        return lista;
    }

    private static No gerarNoBase(int indice, List<Ocorrencia> auxiliar) throws Exception {
        No noBase = null;

        if (auxiliar.get(indice) != null && auxiliar.get(indice+1)!= null) {
            Ocorrencia ocorrenciaAtual = auxiliar.get(indice);
            Ocorrencia proximoOcorrencia = auxiliar.get(indice + 1);
            int quantasOcorrenciasComMenorValor = quantasOcorrenciasComMenorValor(qualMenorOcorrencia(auxiliar), auxiliar);
            if (ocorrenciaAtual.getOcorrencia() == proximoOcorrencia.getOcorrencia()) {
                Ocorrencia ocorrenciaRaiz = new Ocorrencia(ocorrenciaAtual.getOcorrencia() + proximoOcorrencia.getOcorrencia());
                noBase = new No(ocorrenciaRaiz);
                noBase.setDireita(new No(proximoOcorrencia));
                noBase.setEsquerda(new No(ocorrenciaAtual));
            } else if (auxiliar.get(indice) != null) {
                noBase = new No(auxiliar.get(indice));
            }
            if (quantasOcorrenciasComMenorValor == 1 && ocorrenciaAtual.getOcorrencia() != proximoOcorrencia.getOcorrencia()) {
                Ocorrencia ocorrenciaRaiz = new Ocorrencia(ocorrenciaAtual.getOcorrencia() + proximoOcorrencia.getOcorrencia());
                noBase = new No(ocorrenciaRaiz);
                noBase.setDireita(new No(proximoOcorrencia));
                noBase.setEsquerda(new No(ocorrenciaAtual));
            }
        }
        return noBase;
    }

    private static int quantasOcorrenciasComMenorValor(int menorValor, List<Ocorrencia> auxiliar) {
        int count = 0;
        for (Ocorrencia ocorencia: auxiliar) {
            if (ocorencia.getOcorrencia() == menorValor)
                count++;
        }
        return count;
    }

    private static void gerarArquivoCompactado(String meuTexto, ListaDados tabConversao,
                                               String arquivoSaida ) {

    }

    public static void descompactar(String arquivoEntrada, String arquivoSaida) throws Exception {
    }
}
