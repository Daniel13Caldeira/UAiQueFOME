/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import model.Ids;
import model.RestauranteDB;

/**
 *
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
public class Produto {
    
    private String codigo;
    private String restaurante;
    private String nome;
    private int quantidade;
    private float preco;
    private ArrayList<String> categorias = new ArrayList<>();
    private float precoPromocao;
    
    public float getPreco() {
        if (this.precoPromocao == -1) {
            return this.preco;
        }
        return this.precoPromocao;
    }
    
    public Produto(String restaurante, String nome, int quantidade, float preco, float precoPromocao) {
        this.restaurante = restaurante;
        this.codigo = Ids.setIdProduto();
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.precoPromocao = precoPromocao;
        RestauranteDB.addProduto(restaurante, this.codigo, nome, preco, precoPromocao, quantidade, categorias);
    }
    
    public Produto(String restaurante, String nome, int quantidade, float preco, float precoPromocao, ArrayList<String> categorias) {
        this.restaurante = restaurante;
        this.codigo = Ids.setIdProduto();
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.precoPromocao = precoPromocao;
        this.categorias = categorias;
        RestauranteDB.addProduto(restaurante, this.codigo, nome, preco, precoPromocao, quantidade, categorias);
    }
    
    public Produto(String codigo, String restaurante, String nome, int quantidade, float preco, float precoPromocao, ArrayList<String> categorias) {
        this.codigo = codigo;
        this.restaurante = restaurante;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.precoPromocao = precoPromocao;
        this.categorias = categorias;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getRestaurante() {
        return this.restaurante;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getQuantidade() {
        return RestauranteDB.getQuantidade(this.restaurante, this.codigo);
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        RestauranteDB.setQuantidade(this, quantidade);
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
        RestauranteDB.setPreco(this, preco);
    }
    
    public void setPrecoPromocao(float precoPromocao) {
        this.precoPromocao = precoPromocao;
        RestauranteDB.setPrecoPromocao(this, precoPromocao);
    }
    
    public float getPrecoPromocao() {
        return this.precoPromocao;
    }

    public void retirarPromocao() {
        setPrecoPromocao(-1);
    }
    
    public ArrayList<String> getCategorias() {
        return this.categorias;
    }
}
