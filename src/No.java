/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class No {
        
     private RegistroOcorrencia informacao;
     
     private No esquerda, direita;   // Arvore

     
     public No(RegistroOcorrencia info){
         this.informacao = info;
         this.esquerda = this.direita = null;
     }

     public void setInformacao(RegistroOcorrencia informacao){ this.informacao = informacao;}
   
     public void setDireita(No direita) { this.direita = direita;}
     public void setEsquerda(No esquerda) { this.esquerda = esquerda;}


     public RegistroOcorrencia getInformacao() { return this.informacao;}
   
     public No getDireita() { return this.direita;}
     public No getEsquerda() { return this.esquerda;}
     public String toString(){
         return ""+ getInformacao();
     }

}
