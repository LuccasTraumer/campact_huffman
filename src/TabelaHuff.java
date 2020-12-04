import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Curso: 59 - Desenvolvimento de Sistemas Noturno
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class TabelaHuff {
    private No inicio;
    private List<Ocorrencia> tabela = new ArrayList<>();
    private List<Arvore> arvore = new ArrayList<>();


    public TabelaHuff(List<Ocorrencia> listaOcorrencia) {
        for (Ocorrencia ocorrencia: listaOcorrencia) {
            tabela.add(ocorrencia);
            Arvore novaArvore = new Arvore();
            novaArvore.incluir(new No(ocorrencia));
            arvore.add(novaArvore);
        }
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public List<Arvore> gerarArvore() throws Exception {
        int primeiraPosicao = 0;
        int segundaPosicao = 1;
        while (arvore.size() != 1) {
            if (arvore.get(primeiraPosicao) != null && arvore.get(segundaPosicao) != null) {
                Arvore primeiroElemento = arvore.get(primeiraPosicao);
                Arvore segundoElemento = arvore.get(segundaPosicao);
                Arvore novaArvore = new Arvore();
                int menorOcorrencia = Ocorrencia.qualMenorOcorrencia(arvore);
                int quantasOcorrenciasComMenorValor = Utils.quantasOcorrenciasComMenorValor(menorOcorrencia, arvore);
                arvore.remove(primeiroElemento);
                arvore.remove(segundoElemento);
                if (primeiroElemento.getRaiz().getInformacao().getOcorrencia() == segundoElemento.getRaiz().getInformacao().getOcorrencia()) {
                    novaArvore.incluir(new No(new Ocorrencia(segundoElemento.getRaiz().getInformacao().getOcorrencia() + primeiroElemento.getRaiz().getInformacao().getOcorrencia())));
                    novaArvore.getRaiz().setDireita(new No(primeiroElemento.getRaiz()));
                    novaArvore.getRaiz().setEsquerda(new No(segundoElemento.getRaiz().getInformacao()));
                    arvore.add(novaArvore);
                    arvore.sort(Comparator.comparing(Arvore::getRaiz));
                } else if (quantasOcorrenciasComMenorValor == 1 &&
                        primeiroElemento.getRaiz().getInformacao().getOcorrencia() != segundoElemento.getRaiz().getInformacao().getOcorrencia()) {
                    novaArvore.incluir(new No(new Ocorrencia(primeiroElemento.getRaiz().getInformacao().getOcorrencia() + segundoElemento.getRaiz().getInformacao().getOcorrencia())));
                    novaArvore.getRaiz().setDireita(new No(segundoElemento.getRaiz()));
                    novaArvore.getRaiz().setEsquerda(new No(primeiroElemento.getRaiz()));
                    arvore.add(novaArvore);
                    arvore.sort(Comparator.comparing(Arvore::getRaiz));
                }
            }
        }
        return arvore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabelaHuff that = (TabelaHuff) o;
        return Objects.equals(inicio, that.inicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inicio);
    }

    @Override
    public String toString() {
        return "TabelaHuff{" +
                "inicio=" + inicio +
                '}';
    }
}
