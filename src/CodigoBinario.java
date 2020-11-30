import java.util.Objects;

public class CodigoBinario {

    private char caracter;
    private String sequenciaBinaria;

    public CodigoBinario(char caracter, String sequenciaBinaria) throws Exception {
        if (!sequenciaBinaria.isEmpty()) {
            this.caracter = caracter;
            this.sequenciaBinaria = sequenciaBinaria;
        } else
            throw new Exception("Sequencia Binaria Invalida");
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public String getSequenciaBinaria() {
        return sequenciaBinaria;
    }

    public void setSequenciaBinaria(String sequenciaBinaria) {
        this.sequenciaBinaria = sequenciaBinaria;
    }

    @Override
    public String toString() {
        return "CodigoBinario{" +
                "caracter=" + caracter +
                ", sequenciaBinaria='" + sequenciaBinaria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoBinario that = (CodigoBinario) o;
        return caracter == that.caracter &&
                Objects.equals(sequenciaBinaria, that.sequenciaBinaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caracter, sequenciaBinaria);
    }
}
