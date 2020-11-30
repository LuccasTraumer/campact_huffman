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

    static List<Ocorrencia> gerarArvore(List<Ocorrencia> listaOcorrencias) throws Exception {
        List<Ocorrencia> auxiliar = new ArrayList<>(listaOcorrencias);
        ListaDados listaEmNo = ListaDados.gerarListaEmNo(listaOcorrencias);
        int menorOcorrencia = Ocorrencia.qualMenorOcorrencia(listaOcorrencias);
        int indice = 0;
        List<Arvore> semiArvores = gerarArvoresPopular(listaEmNo);
        while (listaEmNo.getListaRegistros().size() != 1) {
            No nopBase = No.gerarNoBase(indice, auxiliar);
            listaEmNo = ListaDados.removerNoLista(nopBase, listaEmNo);
            auxiliar = Ocorrencia.removerNoLista(nopBase, auxiliar);
            semiArvores = Arvore.removerArvoreNoLista(nopBase, semiArvores);
            listaEmNo.incluirNo(nopBase);
            Arvore arvoreAuxiliar = new Arvore();
            arvoreAuxiliar.incluir(nopBase);
            semiArvores.add(arvoreAuxiliar);
            listaEmNo.organizarListaMenorParaMaior();
            semiArvores.sort(Comparator.comparing(Arvore::getRaiz));
            if (Ocorrencia.quantasRegistrosCom(menorOcorrencia, auxiliar) == 1 ||
                    Ocorrencia.quantasRegistrosCom(menorOcorrencia, auxiliar) == 0) {
                auxiliar = Huff.atualizarAuxiliar(listaEmNo);
                menorOcorrencia = Ocorrencia.qualMenorOcorrencia(auxiliar);
            }
        }
        return auxiliar;
    }

    private static List<Arvore> gerarArvoresPopular(ListaDados listaEmNo) {
         List<Arvore> auxiliar = new ArrayList<>();
        for (No no: listaEmNo.getListaRegistros()) {
            Arvore novaArvore = new Arvore();
            novaArvore.incluir(no);
            auxiliar.add(novaArvore);
        }
        return auxiliar;
    }

    private static List<Arvore> removerArvoreNoLista(No nopBase, List<Arvore> arvores) {
        Arvore dadoDireita = new Arvore();
        Arvore dadoEsquerda = new Arvore();
        if (nopBase != null && !arvores.isEmpty()) {
            if (nopBase.getDireita() != null && nopBase.getEsquerda() != null) {
                 dadoDireita.incluir(nopBase.getDireita());
                 dadoEsquerda.incluir(nopBase.getEsquerda());
             }
             if (existeArvoreIgual(dadoDireita, arvores))
                 arvores = removerArvore(dadoDireita, arvores);
             if (existeArvoreIgual(dadoEsquerda, arvores))
                 arvores = removerArvore(dadoEsquerda, arvores);
         }
        return arvores;
    }

    private static List<Arvore> removerArvore(Arvore dado, List<Arvore> arvores) {
        List<Arvore> auxiliar = new ArrayList<>();
        for (Arvore arv: arvores) {
            if (!dado.getRaiz().getInformacao().equals(arv.raiz.getInformacao())) {
                auxiliar.add(arv);
            }
        }
        return auxiliar;
    }

    private static boolean existeArvoreIgual(Arvore dado, List<Arvore> arvores) {
        for (Arvore auxiliar: arvores) {
            if (dado.getRaiz().getInformacao().equals(auxiliar.raiz.getInformacao()))
                return true;
        }
        return false;
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
