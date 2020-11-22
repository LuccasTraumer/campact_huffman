/**
 * Curso: Desenvolvimento de Sistemas
 * Matéria: Estruturas de Dados II
 * Desenvolvedor: Lucas Silva de Jesus
 * */
public class AppHuff {

    public static void main(String[] args) throws Exception{

        Arquivo test = new Arquivo("textos/fileIn.txt", "textos/fileOut.txt");

        System.out.println("Vamos compactar ou descompactar?");
        Huff.compactar("Poesia.txt", "Poesia.huff");
        Huff.descompactar("Poesia.huff","Poesia_des.txt");
        
        
    }
    
}
