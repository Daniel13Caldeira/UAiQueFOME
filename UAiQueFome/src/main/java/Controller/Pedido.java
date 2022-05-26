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
public class Pedido {

    private int codigo;
    private Cliente cliente;
    private Restaurante restaurante;
    private double valorTotal;

    public Pedido(int codigo, Cliente cliente, Restaurante restaurante) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.restaurante = restaurante;
        ArrayList<Produto>produtos = cliente.getCarrinho();
        valorTotal=0;
        for (int i = 0; i < produtos.size(); i++) {
            this.valorTotal += produtos.get(i).getPreco();
        }
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Restaurante getRestaurante() {
        return this.restaurante;
    }

    public ArrayList<Produto> getProdutos() {
        return this.cliente.getCarrinho();
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

}
