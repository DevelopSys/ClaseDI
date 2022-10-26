package com.example.penstanias_ret.model;

public class CambioBase {

    private int numeroDecimal;
    private String numeroConv;
    private int base;

    public CambioBase(int numeroDecimal, int base) {
        this.numeroDecimal = numeroDecimal;
        this.base = base;
    }

    public void operacionCambioBase(){
        // TODO
        // método que pasa de base 10 a la base declarada
        numeroConv = "";
        numeroConv += 1;
        numeroConv += 1;
        numeroConv += 1;
        numeroConv += 0;
        // 3
    }

    public int getNumeroDecimal() {
        return numeroDecimal;
    }

    public void setNumeroDecimal(int numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public String getNumeroConv() {
        return numeroConv;
    }

    public void setNumeroConv(String numeroConv) {
        this.numeroConv = numeroConv;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
