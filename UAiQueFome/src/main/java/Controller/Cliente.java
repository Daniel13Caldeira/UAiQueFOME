/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import model.ClienteDB;
import model.RestauranteDB;

/**
 *
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
public class Cliente {

    private String cpf;
    private String nome;
    private String senha;
    private Endereco endereco;
    private ArrayList<Pedido> pedidos;
    private ArrayList<String> restaurantesFavoritos;
    private ArrayList<Produto> carrinho;

    public Cliente(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        ClienteDB.cadastra(cpf, nome, endereco, senha);
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
        String restaurante = ClienteDB.getRestaurante(this.cpf);
        ArrayList<String> produtos = ClienteDB.getProdutos(this.cpf);
        ArrayList<Integer> quantidades = new ArrayList<>();
        String produto;
        for (int i = 0; i < produtos.size(); i++) {
            String aux[] = produtos.get(i).split(" ");
            produtos.set(i, aux[0]);
            quantidades.add(Integer.parseInt(aux[1]));
            produto = RestauranteDB.getProduto(this.cpf, produtos.get(i));
            aux = produto.split(";");
            String id = aux[0];
            String nome = aux[1];
            float preco = Float.parseFloat(aux[2]);
            float promocao = Float.parseFloat(aux[3]);
            aux = aux[5].split(",");
            ArrayList<String> categorias = new ArrayList<>();
            for (int j = 0; j < aux.length; j++) {
                categorias.add(aux[j]);
            }
            carrinho.add(new Produto(id, restaurante, nome, quantidades.get(i), preco, promocao, categorias));
        }
        return carrinho;
    }

    public ArrayList<String> getRestaurantesFavoritos() {
        return ClienteDB.getRestaurantesFavoritos(this.cpf);
    }

    public ArrayList<Pedido> getPedidos() {
        ArrayList<String> pedidos_ = ClienteDB.getPedidos(this.cpf);
        ArrayList<String> restaurantes = new ArrayList<>();
        String pedido;
        for (int i = 0; i < pedidos_.size(); i++) {
            String aux[] = pedidos_.get(i).split(";");
            pedidos_.set(i, aux[0]);
            restaurantes.add(aux[1]);
            pedido = RestauranteDB.getPedido(this.cpf, pedidos_.get(i));
            aux = pedido.split(";");
            //id;cliente;valorTotal;status;produto1 quantidade1,produto2 quantidade2,;
            String id = aux[0];
            String idCliente = aux[1];
            float valorTotal = Float.parseFloat(aux[2]);
            String status = aux[3];
            String endAux = RestauranteDB.getEndereco(restaurantes.get(i));
            aux = endAux.split(";");
            String rest = restaurantes.get(i);
            pedidos.add(new Pedido(pedidos_.get(i), new Restaurante(new Endereco(aux[1], aux[0], Integer.parseInt(aux[2])), RestauranteDB.getNome(rest), rest), this));
        }
        return pedidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
        ClienteDB.altera(cpf, nome, endereco, senha);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        ClienteDB.altera(cpf, nome, endereco, senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
        ClienteDB.altera(cpf, nome, endereco, senha);
    }

    public void addProdutoAoCarrinho(Produto produto) {
        ClienteDB.addProduto(this.cpf, produto.getCodigo(), produto.getQuantidade(), produto.getRestaurante());
        RestauranteDB.setQuantidade(produto,false);
    }

    public void removeProdutoDoCarrinho(Produto produto) {
        ClienteDB.removerProduto(cpf, produto.getCodigo());
        RestauranteDB.setQuantidade(produto, true);
    }

    public void finalizarPedido() {
        String restaurante = ClienteDB.getRestaurante(this.cpf);
        String endAux = RestauranteDB.getEndereco(restaurante);
        String aux[] = endAux.split(";");
        new Pedido(this, new Restaurante(new Endereco(aux[1], aux[0], Integer.parseInt(aux[2])), RestauranteDB.getNome(restaurante), restaurante));
    }
}
