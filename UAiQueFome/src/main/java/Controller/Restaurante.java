package Controller;

import java.util.ArrayList;


public class Restaurante {
private String nome;
private String cnpj;
private Endereco endereco;
private ArrayList<String> categorias;
private ArrayList<Produto> produtos;
private ArrayList<Pedido> vendas;

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }


    public Restaurante(String nome, String cnpj, Endereco endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
}
