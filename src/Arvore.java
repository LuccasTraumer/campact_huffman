import java.util.ArrayList;
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

    static List<Ocorrencia> gerarArvore(List<Ocorrencia> listaOcorrencias) throws Exception {
        List<Ocorrencia> auxiliar = new ArrayList<>(listaOcorrencias);
        ListaDados listaEmNo = ListaDados.gerarListaEmNo(listaOcorrencias);
        int menorOcorrencia = Ocorrencia.qualMenorOcorrencia(listaOcorrencias);
        int indice = 0;
        List<Arvore> semiArvores = new ArrayList<>();
        while (listaEmNo.getListaRegistros().size() != 1) {
            No nopBase = No.gerarNoBase(indice, auxiliar);
            listaEmNo = ListaDados.removerNoLista(nopBase, listaEmNo);
            auxiliar = Ocorrencia.removerNoLista(nopBase, auxiliar);
            listaEmNo.incluirNo(nopBase);
            listaEmNo.organizarListaMenorParaMaior();
            Arvore arvoreAuxiliar = new Arvore();
            arvoreAuxiliar.incluir(nopBase);
            semiArvores.add(arvoreAuxiliar);
            if (Ocorrencia.quantasRegistrosCom(menorOcorrencia, auxiliar) == 1 ||
                    Ocorrencia.quantasRegistrosCom(menorOcorrencia, auxiliar) == 0) {
                auxiliar = Huff.atualizarAuxiliar(listaEmNo);
                menorOcorrencia = Ocorrencia.qualMenorOcorrencia(auxiliar);
            }
        }
        Arvore test = new Arvore();
        test.incluir(listaEmNo.getListaRegistros().get(0));
        return auxiliar;
    }

     public String toString(){
         return visita(this.raiz);
     }

     private String visita(No Raiz){  // InOrdem

          if (Raiz == null) return "";

          return visita(Raiz.getEsquerda()) + " " +
                 Raiz.getInformacao() + " " +     // IN-ORDEM
                 visita(Raiz.getDireita());
     }
    
}
