import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Arvore {
     private No raiz;
     
     public No getRaiz(){
         return this.raiz;
     }

     public void incluir (char Car, int Qtos) throws Exception{
         incluir(new No(new Ocorrencia(Car,Qtos)));
     }

     public void incluir (No novo){
         if (novo==null) return;
         if (this.raiz == null)  // primeiro No  (incluir no Nivel ZERO)
              this.raiz = novo;
         else
             incluir(this.raiz, novo);
     }

     private void incluir (No Raiz, No Novo){
         if (Novo.getInformacao().getCaracter() > Raiz.getInformacao().getCaracter()){ // direita
             if (Raiz.getDireita()==null)
                 Raiz.setDireita(Novo);
             else
                 incluir (Raiz.getDireita(), Novo);
         }
         else{ // esquerda
             if (Raiz.getEsquerda() == null)
                 Raiz.setEsquerda(Novo);
             else 
                 incluir(Raiz.getEsquerda(), Novo);
         }
     }

     public int somaValores(){
           return somaTudo(this.raiz);
     }

     private int somaTudo(No Raiz){
         if (Raiz==null)
             return 0;
         if ((Raiz.getEsquerda()==null) && (Raiz.getDireita()==null))  // Folha
             return Raiz.getInformacao().getOcorrencia();

         return
                somaTudo(Raiz.getEsquerda()) +
                somaTudo(Raiz.getDireita()) + Raiz.getInformacao().getOcorrencia();
     }

    public String toString(){
         return visita(this.raiz);
     }

    public String visita(No Raiz){  // InOrdem

          if (Raiz == null) return "";

          return visita(Raiz.getEsquerda()) + " " +
                 Raiz.getInformacao() + " " +     // IN-ORDEM
                 visita(Raiz.getDireita());
     }

    public CodigoBinario criaCodigoBinario() throws Exception {
         String sequenciaBinario = "";
        return percorreArvore(this.raiz, sequenciaBinario);
    }

    private CodigoBinario percorreArvore(No raiz, String sequenciaBinaria) throws Exception {
        if (raiz==null)
            return null;
        if ((raiz.getEsquerda()==null) && (raiz.getDireita()==null))  // Folha
            return new CodigoBinario((char) raiz.getInformacao().getOcorrencia(), sequenciaBinaria);

            if (raiz.getEsquerda() != null)
                return percorreArvore(raiz.getEsquerda(), sequenciaBinaria+="0");

            return raiz.getDireita() != null ? percorreArvore(raiz.getDireita(), sequenciaBinaria+= "1") : new CodigoBinario(raiz.getInformacao().getCaracter(), sequenciaBinaria);
    }

}
