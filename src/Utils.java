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
}
