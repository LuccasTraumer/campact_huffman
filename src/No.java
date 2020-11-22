public class No {
        
     private RegistroOcorrencia informacao;
     
     private No esquerda, direita;   // Arvore
     private No anterior, proximo;  // Lista Dupla
     
     public No(RegistroOcorrencia info){
         this.informacao = info;
        
         this.esquerda = this.direita = null;
         this.anterior = this.proximo = null;
     }

     public void setInformacao(RegistroOcorrencia informacao){ this.informacao = informacao;}
   
     public void setDireita(No direita) { this.direita = direita;}
     public void setEsquerda(No esquerda) { this.esquerda = esquerda;}
     public void setAnterior(No anterior) { this.anterior = anterior;}
     public void setProximo(No proximo) { this.proximo = proximo;}

     public RegistroOcorrencia getInformacao() { return this.informacao;}
   
     public No getDireita() { return this.direita;}
     public No getEsquerda() { return this.esquerda;}
     public No getAnterior() { return this.anterior;}
     public No getProximo() { return this.proximo;}
     
     public String toString(){
         return ""+ getInformacao();
     }

}
