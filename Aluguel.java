/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author conta
 */
public class Aluguel {
    private Fita fita;
    private int diasAlugada;
    
    public Aluguel(Fita fita, int diasAlugada) {
        this.fita = fita;
        this.diasAlugada = diasAlugada;
    }
    
    public Fita getFita() {
        return fita;
    }
    
    public int getDiasAlugada() {
        return diasAlugada;
    }
}
