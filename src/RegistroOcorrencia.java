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
}
