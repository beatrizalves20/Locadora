/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author conta
 */
public class Cliente {
    private String nome;
    private Collection<Aluguel> fitasAlugadas;

    public Cliente(String nome) {
        this.nome = nome;
        this.fitasAlugadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        fitasAlugadas.add(aluguel);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        StringBuilder resultado = new StringBuilder("Registro de Alugueis de " + getNome() + fimDeLinha);

        for (Aluguel aluguel : fitasAlugadas) {
            double valorCorrente = calcularValorDoAluguel(aluguel);
            pontosDeAlugadorFrequente += calcularPontosDeAlugadorFrequente(aluguel);

            resultado.append("\t").append(aluguel.getFita().getTítulo()).append("\t").append(valorCorrente).append(fimDeLinha);
            valorTotal += valorCorrente;
        }

        resultado.append("Valor total devido: ").append(valorTotal).append(fimDeLinha);
        resultado.append("Você acumulou ").append(pontosDeAlugadorFrequente).append(" pontos de alugador frequente");

        return resultado.toString();
    }

    private double calcularValorDoAluguel(Aluguel aluguel) {
        double valorCorrente = 0.0;

        switch (aluguel.getFita().getCódigoDePreço()) {
            case Fita.NORMAL:
                valorCorrente += 2;
                if (aluguel.getDiasAlugada() > 2) {
                    valorCorrente += (aluguel.getDiasAlugada() - 2) * 1.5;
                }
                break;
            case Fita.LANÇAMENTO:
                valorCorrente += aluguel.getDiasAlugada() * 3;
                break;
            case Fita.INFANTIL:
                valorCorrente += 1.5;
                if (aluguel.getDiasAlugada() > 3) {
                    valorCorrente += (aluguel.getDiasAlugada() - 3) * 1.5;
                }
                break;
        }

        return valorCorrente;
    }

    private int calcularPontosDeAlugadorFrequente(Aluguel aluguel) {
        int pontos = 1;

        if (aluguel.getFita().getCódigoDePreço() == Fita.LANÇAMENTO && aluguel.getDiasAlugada() > 1) {
            pontos++;
        }

        return pontos;
    }
}
