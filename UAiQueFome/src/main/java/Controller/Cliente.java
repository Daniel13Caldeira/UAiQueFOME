/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import model.ClienteDB;
import model.Clientes;
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

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        ClienteDB.cadastra(cpf, nome, this.endereco, senha);
        Clientes.cadastra(cpf);
    }

    public Cliente(String cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return ClienteDB.getNome(this.cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public Endereco getEndereco() {
        String aux[] = ClienteDB.getEndereco(this.cpf).split(";");
        return new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3]);
    }

    public String findEndereco() {
        return ClienteDB.getEndereco(this.cpf);
    }

    public String getSenha() {
        return ClienteDB.getSenha(this.cpf);
    }

    public ArrayList<Produto> getCarrinho() {
        this.carrinho.clear();
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
            this.carrinho.add(new Produto(id, restaurante, nome, quantidades.get(i), preco, promocao, categorias));
        }
        return this.carrinho;
    }

    public ArrayList<String> getRestaurantesFavoritos() {
        this.restaurantesFavoritos = ClienteDB.getRestaurantesFavoritos(this.cpf);
        return this.restaurantesFavoritos;
    }

    public ArrayList<Pedido> getPedidos() {
        this.pedidos.clear();
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
            this.pedidos.add(new Pedido(pedidos_.get(i), new Restaurante(new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]),aux[3]), RestauranteDB.getNome(rest), rest), this, status));
        }
        return this.pedidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
        ClienteDB.altera(this.cpf, nome, this.endereco, this.senha);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        ClienteDB.altera(this.cpf, this.nome, endereco, this.senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
        ClienteDB.altera(this.cpf, this.nome, this.endereco, senha);
    }

    public void addProdutoAoCarrinho(Produto produto) {
        ClienteDB.addProduto(this.cpf, produto.getCodigo(), produto.getQuantidade(), produto.getRestaurante());
        RestauranteDB.setQuantidade(produto, false);
    }

    public void removeProdutoDoCarrinho(Produto produto) {
        ClienteDB.removerProduto(this.cpf, produto.getCodigo());
        RestauranteDB.setQuantidade(produto, true);
    }

    public void removeRestauranteFavorito(String restaurante) {
        ClienteDB.removeRestauranteFavorito(this.cpf, restaurante);
    }

    public void finalizarPedido() {
        String restaurante = ClienteDB.getRestaurante(this.cpf);
        String endAux = RestauranteDB.getEndereco(restaurante);
        String aux[] = endAux.split(";");
        new Pedido(this, new Restaurante(new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]),aux[3]), RestauranteDB.getNome(restaurante), restaurante));
    }

    public void addRestauranteFavorito(Restaurante restaurante) {
        ClienteDB.addRestauranteFavorito(this.cpf, restaurante.getCnpj());
    }

    public static ArrayList<String> getClientes() {
        return Clientes.getClientes();
    }
}
