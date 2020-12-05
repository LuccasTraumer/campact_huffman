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
