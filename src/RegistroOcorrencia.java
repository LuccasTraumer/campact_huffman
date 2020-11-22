public class RegistroOcorrencia {
    private char caracter;
    private int ocorrencia;
    
    public RegistroOcorrencia(char caracter, int ocorrencia) {
        this.caracter = caracter;
        this.ocorrencia = ocorrencia;
    }
    public RegistroOcorrencia(int ocorrencia) {
        this('\0', ocorrencia);   // "barra zero"
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

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}
