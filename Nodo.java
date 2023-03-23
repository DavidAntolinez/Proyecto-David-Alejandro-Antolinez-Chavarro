package listas.enlazadas.po;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author David Antolinez
 */
public class Nodo {

    private int Dato;
    private Nodo LR;
    private Nodo LL;

    // metodos
    public Nodo(int d) {
        Dato = d;
        LR = null;
        LL = null;
    }

    public Nodo() {
        Dato = 0;
        LR = null;
        LL = null;
    }

    public int getDato() {
        return Dato;
    }

    public Nodo getLR() {
        return LR;
    }

    public Nodo getLL() {
        return LL;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public void setLR(Nodo Liga) {
        this.LR = Liga;
    }

    public void setLL(Nodo Liga) {
        this.LL = Liga;
    }
}