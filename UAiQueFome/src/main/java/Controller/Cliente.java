/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Cliente {

    private String cpf;
    private String nome;
    private Endereco endereco;
    private ArrayList<Pedido> pedidos;
    private ArrayList<String> restaurantesFavoritos;
    private ArrayList<Produto> carrinho;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }
}
