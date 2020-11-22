public class AppHuff {

    public static void main(String[] args) throws Exception{
        
        System.out.println("Vamos compactar ou descompactar?");
        Huff.compactar("Poesia.txt", "Poesia.huff");
        Huff.descompactar("Poesia.huff","Poesia_des.txt");
        
        
    }
    
}
