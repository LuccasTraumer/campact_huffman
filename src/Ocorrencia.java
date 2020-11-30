import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Ocorrencia implements Comparable {
    private char caracter;
    private int ocorrencia;
    
    public Ocorrencia(char caracter, int ocorrencia) throws Exception{
            this.caracter = caracter;
            setOcorrencia(ocorrencia);
    }
    /**
     * Construtor que irá receber a ocorrencia mas não irá armazenar nenhum caracter,
     * isso por conta das sub-arvores que não terão caracteres mas terão ocorrencias
     * */
    public Ocorrencia(int ocorrencia) throws Exception {
        this('\0', ocorrencia);
    }

    /**
     * Cria a tabela Binaria Caracter e Ocorrencia.
     * */
    public static List<Ocorrencia> gerarListaOcorrencias(Arquivo arquivo) throws Exception {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        for (char caracter: new String(arquivo.getCaracteres()).toCharArray()) {
            Ocorrencia ocorrenciaAuxiliar = new Ocorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo));
            if(!ocorrencias.contains(ocorrenciaAuxiliar))
                ocorrencias.add(new Ocorrencia(caracter,Utils.quntasOcorrenciasDaLetra(caracter, arquivo)));
        }
        return ocorrencias;
    }

    static int quantasRegistrosCom(int menorOcorrencia, List<Ocorrencia> lista) {
        int contador = 0;
        for (Ocorrencia ocorrencia: lista) {
            if (ocorrencia.getOcorrencia() == menorOcorrencia)
                contador++;
        }
        return contador;
    }

    static int qualMenorOcorrencia(List<Ocorrencia> listaOcorrencias) {
        int value = Integer.MAX_VALUE;
        for (Ocorrencia ocorrencia: listaOcorrencias) {
            if (ocorrencia.getOcorrencia() < value)
                value = ocorrencia.getOcorrencia();
        }
        return value;
    }

    static List<Ocorrencia> removerNoLista(No no, List<Ocorrencia> listaOcorrencias) {
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

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getOcorrencia() {
        return ocorrencia;
    }

    /**
     * Um caracter que tenha Zero(0) ocorrencias não deveria estar sendo apresentado no texto.
     * */
    public void setOcorrencia(int ocorrencia) throws Exception {
        if (ocorrencia != 0) {
            this.ocorrencia = ocorrencia;
        } else {
            throw new Exception("Ocorrencia Invalidá!");
        }
    }

    @Override
    public String toString() {
        return "caracter = " + caracter + ", ocorrencia = " + ocorrencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocorrencia that = (Ocorrencia) o;
        return caracter == that.caracter &&
                ocorrencia == that.ocorrencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caracter, ocorrencia);
    }

    @Override
    public int compareTo(Object obj) {
        Ocorrencia ocorrencia = (Ocorrencia) obj;
        if (this.getOcorrencia() < ocorrencia.getOcorrencia())
            return -666;
        if (this.getOcorrencia() > ocorrencia.getOcorrencia())
            return 666;

        if (this.getOcorrencia() == ocorrencia.getOcorrencia() &&
            this.getCaracter() == ocorrencia.getCaracter())
            return 0;

        return 0;
    }
}
