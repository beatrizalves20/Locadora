/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author conta
 */
public class Locadora {
    public static void main(String[] args) {
        Cliente c1 = criarClienteComAlugueis();
        System.out.println(c1.extrato());
    }

    private static Cliente criarClienteComAlugueis() {
        Cliente cliente = new Cliente("Juliana");
        adicionarAluguel(cliente, "O Exorcista", Fita.NORMAL, 3);
        adicionarAluguel(cliente, "Men in Black", Fita.NORMAL, 2);
        adicionarAluguel(cliente, "Jurassic Park III", Fita.LANÇAMENTO, 3);
        adicionarAluguel(cliente, "Planeta dos Macacos", Fita.LANÇAMENTO, 4);
        adicionarAluguel(cliente, "Pateta no Planeta dos Macacos", Fita.INFANTIL, 10);
        adicionarAluguel(cliente, "O Rei Leao", Fita.INFANTIL, 30);
        return cliente;
    }

    private static void adicionarAluguel(Cliente cliente, String titulo, int codigoDePreco, int diasAlugada) {
        Fita fita = new Fita(titulo, codigoDePreco);
        Aluguel aluguel = new Aluguel(fita, diasAlugada);
        cliente.adicionaAluguel(aluguel);
    }
}
