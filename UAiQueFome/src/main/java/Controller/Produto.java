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
public class Produto {

    private int codigo;
    private String restaurante;
    private String nome;
    private int quantidade;
    private double preco;
    private ArrayList<String> categorias;
    private double precoPromocao;

    public double getPreco() {
        if (this.precoPromocao == -1) {
            return this.preco;
        }
        return this.precoPromocao;
    }

    public Produto(int codigo, String restaurante, String nome, int quantidade, double preco, double precoPromocao) {
        this.codigo = codigo;
        this.restaurante = restaurante;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.precoPromocao = precoPromocao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoPromocao() {
        return precoPromocao;
    }

}
