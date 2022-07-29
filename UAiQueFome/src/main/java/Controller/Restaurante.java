package Controller;

import java.util.ArrayList;

public class Restaurante {

    private String nome;
    private String cnpj;
    private Endereco endereco;
    private String senha;
    private ArrayList<String> categorias;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;

    public Restaurante(String nome, String cnpj, Endereco endereco, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Restaurante(Endereco endereco, String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
