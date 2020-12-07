import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class Arquivo {

    private String arquivoEntrada;
    private String arquivoSaida;

    private FileInputStream arquivoTexto;
    private BufferedInputStream buffReader;
    private DataInputStream data;
    private byte vetByte[];

    public Arquivo(String arquivoEntrada, String arquivoSaida) throws Exception {
        this.arquivoEntrada = arquivoEntrada;
        this.arquivoSaida = arquivoSaida;

        arquivoTexto = new FileInputStream(arquivoEntrada);
        buffReader = new BufferedInputStream(arquivoTexto);
        data = new DataInputStream(buffReader);
        vetByte = new byte[arquivoTexto.available()];
        inclusaoCaracteresVetor();
    }

    private void inclusaoCaracteresVetor() throws Exception {
        data.read(vetByte);
    }

    public String getArquivoEntrada() {
        return arquivoEntrada;
    }

    public byte[] getCaracteres() {
        return this.vetByte;
    }

    public void setArquivoEntrada(String arquivoEntrada) {
        this.arquivoEntrada = arquivoEntrada;
    }

    public String getArquivoSaida() {
        return arquivoSaida;
    }

    public void setArquivoSaida(String arquivoSaida) {
        this.arquivoSaida = arquivoSaida;
    }

    public void gerarArquivoSaida(List<CodigoBinario> listaBinarios, Arquivo arquivo) {
        final File test = new File(arquivoSaida);
        List<CodigoBinario> textoInOrdem = new ArrayList<>();

        for (byte caracter: arquivo.vetByte) {
            for (CodigoBinario cod: listaBinarios) {
                if (cod.getCaracter() == caracter) {
                    textoInOrdem.add(cod);
                    break;
                }
            }
        }

        try {
            if (!test.createNewFile() || !test.exists()) {
                FileWriter myWriter = new FileWriter(arquivoSaida);
                for (CodigoBinario cod : textoInOrdem) {
                    myWriter.write(cod.getSequenciaBinaria());
                }
                myWriter.close();
            } else {
                final FileWriter myWriter = new FileWriter(test.getName());
                for (CodigoBinario cod : textoInOrdem) {
                    myWriter.write(cod.getSequenciaBinaria());
                }
                myWriter.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
