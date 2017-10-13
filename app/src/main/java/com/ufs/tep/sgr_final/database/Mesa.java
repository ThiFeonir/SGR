package com.ufs.tep.sgr_final.database;

public class Mesa {
    int numero;
    boolean isOcupada;

    public Mesa() {
    }

    public Mesa(int numero, boolean isOcupada) {
        this.numero = numero;
        this.isOcupada = isOcupada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return isOcupada;
    }

    public void setOcupada(boolean ocupada) {
        isOcupada = ocupada;
    }
}
