import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

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
}
