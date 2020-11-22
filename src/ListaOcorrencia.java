public class ListaOcorrencia {
    private No anterior, proximo;  // Lista Dupla

    public ListaOcorrencia() {
        this.anterior = this.proximo = null;
    }

    public No getAnterior() { return this.anterior;}
    public No getProximo() { return this.proximo;}

    public void setAnterior(No anterior) { this.anterior = anterior;}
    public void setProximo(No proximo) { this.proximo = proximo;}
}
