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
