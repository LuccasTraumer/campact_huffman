import java.util.Objects;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class RegistroOcorrencia {
    private char caracter;
    private int ocorrencia;
    
    public RegistroOcorrencia(char caracter, int ocorrencia) throws Exception{
            this.caracter = caracter;
            setOcorrencia(ocorrencia);

    }
    /**
     * Construtor que irá receber a ocorrencia mas não irá armazenar nenhum caracter,
     * isso por conta das sub-arvores que não terão caracteres mas terão ocorrencias
     * */
    public RegistroOcorrencia(int ocorrencia) throws Exception {
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
        RegistroOcorrencia that = (RegistroOcorrencia) o;
        return caracter == that.caracter &&
                ocorrencia == that.ocorrencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caracter, ocorrencia);
    }
}
