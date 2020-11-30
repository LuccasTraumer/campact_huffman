import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class No implements Comparable<No> {
        
     private Ocorrencia informacao;
     
     private No esquerda, direita;   // Arvore

     
     public No(Ocorrencia info){
         this.informacao = info;
         this.esquerda = this.direita = null;
     }

    /**
     * Gera Arvore Binario. Vai criando o Nó que tem como ocorrencia a soma das folhas.
     * */
    static ListaDados geraListaNo(List<Ocorrencia> ocorrencias) throws Exception {
        ListaDados auxiliar = new ListaDados();
        for (Ocorrencia ocorrencia: ocorrencias) {
            No no = new No(ocorrencia);
            auxiliar.incluirNo(no);
        }
        return auxiliar;
    }

    static No gerarNoBase(int indice, List<Ocorrencia> auxiliar) throws Exception {
        No noBase = null;

        if (auxiliar.get(indice) != null && auxiliar.get(indice+1)!= null) {
            Ocorrencia ocorrenciaAtual = auxiliar.get(indice);
            Ocorrencia proximoOcorrencia = auxiliar.get(indice + 1);
            int quantasOcorrenciasComMenorValor = Utils.quantasOcorrenciasComMenorValor(Ocorrencia.qualMenorOcorrencia(auxiliar), auxiliar);
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

     public void setInformacao(Ocorrencia informacao){ this.informacao = informacao;}
   
     public void setDireita(No direita) { this.direita = direita;}
     public void setEsquerda(No esquerda) { this.esquerda = esquerda;}


     public Ocorrencia getInformacao() { return this.informacao;}
   
     public No getDireita() { return this.direita;}
     public No getEsquerda() { return this.esquerda;}
     public String toString(){
         return ""+ getInformacao();
     }

    public No(No modelo) throws Exception {
        if (modelo != null) {
            this.informacao = modelo.informacao;
            this.direita = modelo.direita;
            this.esquerda = modelo.esquerda;
        }
        else
            throw new Exception("Objeto Invalido para copia");
    }

    public Object clone() {
            No aux = null;
        try {
            aux = new No(this);
        } catch (Exception e) {
        }

        return aux;
    }

    @Override
    public int compareTo(No aux) {
        if (this.getInformacao().getOcorrencia() < aux.getInformacao().getOcorrencia())
            return -666;
        if (this.getInformacao().getOcorrencia() > aux.getInformacao().getOcorrencia())
            return 666;
        if (this.getInformacao().getCaracter() == aux.getInformacao().getCaracter() &&
            this.getInformacao().getOcorrencia() == aux.getInformacao().getOcorrencia())
            return 0;

        return 0;
    }
}
