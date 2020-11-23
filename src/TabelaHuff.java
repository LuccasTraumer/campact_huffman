import java.util.Objects;

/**
 * Curso: 59 - Desenvolvimento de Sistemas Noturno
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class TabelaHuff {
    private No inicio;

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
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
