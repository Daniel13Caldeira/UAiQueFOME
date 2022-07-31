/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import model.ClienteDB;
import model.Ids;
import model.RestauranteDB;

/**
 *
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
public class Pedido {

    private String codigo;
    private Cliente cliente;
    private Restaurante restaurante;
    private String status;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private float valorTotal;

    public Pedido(Cliente cliente, Restaurante restaurante) {
        this.codigo = Ids.setIdPedido();
        this.status = "enviado para o restaurante";
        this.cliente = cliente;
        this.restaurante = restaurante;
        produtos = cliente.getCarrinho();
        ArrayList<String> prod = new ArrayList<>();
        valorTotal = 0;
        for (int i = 0; i < produtos.size(); i++) {
            this.valorTotal += produtos.get(i).getPreco();
            prod.add(produtos.get(i).getCodigo());
        }
        RestauranteDB.addPedido(restaurante.getCnpj(), codigo, cliente.getCpf(), valorTotal, status, prod);
        ClienteDB.addPedido(cliente.getCpf(), codigo, restaurante.getCnpj());
    }

    public String getStatus() {
        return status;
    }

    public Pedido(String codigo, Restaurante restaurante, Cliente cliente, String status) {
        this.codigo = codigo;
        this.status = status;
        this.cliente = cliente;
        this.restaurante = restaurante;
        ArrayList<Produto> produtos = cliente.getCarrinho();
        valorTotal = 0;
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

    public float getValorTotal() {
        return this.valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setStatus(String status) {
        this.status = status;
        RestauranteDB.setStatusPedido(this.restaurante.getCnpj(), this, status);
    }
}
