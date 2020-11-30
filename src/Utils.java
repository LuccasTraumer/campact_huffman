import java.util.List;

public class Utils {

    private Utils() { }
    public static int quntasOcorrenciasDaLetra(char letraDesejada, Arquivo arquivo) {
        int contadorOcorrencia = 0;
        for (char c: new String(arquivo.getCaracteres()).toCharArray()) {
            if (c == letraDesejada)
                contadorOcorrencia++;
        }

        return contadorOcorrencia;
    }

    static int quantasOcorrenciasComMenorValor(int menorValor, List<Ocorrencia> auxiliar) {
        int count = 0;
        for (Ocorrencia ocorencia: auxiliar) {
            if (ocorencia.getOcorrencia() == menorValor)
                count++;
        }
        return count;
    }
}
