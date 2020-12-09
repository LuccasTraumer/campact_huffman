package tabelaBinaria;


import informacao.No;

import java.util.Objects;

public class TabelaBinaria {

    private No informacao;
    private byte binario;

    public TabelaBinaria(No no, byte binario) throws Exception {
        setBinario(binario);
        setInformacao(no);
    }

    public No getInformacao() {
        return informacao;
    }

    public void setInformacao(No informacao) throws Exception {
        if (informacao != null)
            this.informacao = (No)informacao.clone();
        else
            throw new Exception("Objeto informacao.No Invalido");
    }

    public byte getBinario() {
        return binario;
    }

    public void setBinario(byte binario) throws Exception {
        if (binario != 0 || binario != 1)
            throw new Exception("Valor Invalido para Bonario!");

        else
            this.binario = binario;
    }

    @Override
    public String toString() {
        return "informacao=" + informacao +
                ", binario=" + binario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabelaBinaria that = (TabelaBinaria) o;
        return binario == that.binario &&
                Objects.equals(informacao, that.informacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informacao, binario);
    }
}
