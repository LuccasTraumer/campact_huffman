import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class AppHuff {

    public static void main(String[] args) throws Exception{

        System.out.println("Vamos compactar ou descompactar?");
        Huff.compactar("textos/fileIn.txt", "textos/fileOut.txt");
        Huff.descompactar("Poesia.huff","Poesia_des.txt");
        
        
    }
    
}
