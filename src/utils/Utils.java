package utils;

import arquivo.Arquivo;
import arvore.Arvore;

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

    public static int quantasOcorrenciasComMenorValor(int menorValor, List<Arvore> listaArvores) {
        int count = 0;
        for (Arvore arvore: listaArvores) {
            if (arvore.getRaiz().getInformacao().getOcorrencia() == menorValor)
                count++;
        }
        return count;
    }
}
