/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import model.Categorias;
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

    public float getPreco_() {
        this.precoPromocao = getPrecoPromocao();
        if (this.precoPromocao == -1) {
            this.preco = getPreco();
            return this.preco;
        }
        return this.precoPromocao;
    }

    public Produto(String codigo, String nome, String quantidade, String preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = Integer.parseInt(quantidade);
        this.preco = Float.parseFloat(preco);
        this.restaurante = getRestaurante();
    }


    
    public Produto(String codigo, String restaurante) {
        this.codigo = codigo;
        this.restaurante = restaurante;
        String prod[] = RestauranteDB.getProduto(restaurante, codigo).split(";");
        this.nome = prod[1];
        this.preco = Float.parseFloat(prod[2]);
        this.precoPromocao = Float.parseFloat(prod[3]);
        this.quantidade = Integer.parseInt(prod[4]);
        prod = prod[5].split(",");
        for (int i = 0; i < prod.length; i++) {
            if (!categorias.contains(prod[i])) {
                this.categorias.add(prod[i]);
            }
        }
    }

    public Produto(String restaurante, String nome, int quantidade, float preco, float precoPromocao) {
        this.restaurante = restaurante;
        Ids.alterarPrduto();
        this.codigo = String.valueOf(Ids.buscaProduto());
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.precoPromocao = precoPromocao;
        RestauranteDB.addProduto(restaurante, this.codigo, nome, preco, precoPromocao, quantidade, categorias);

    }

    public Produto(String restaurante, String nome, int quantidade, float preco, float precoPromocao, ArrayList<String> categorias) {
        this.restaurante = restaurante;
        Ids.alterarPrduto();
        this.codigo = String.valueOf(Ids.buscaProduto());
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.precoPromocao = precoPromocao;
        this.categorias = categorias;
        RestauranteDB.addProduto(restaurante, this.codigo, nome, preco, precoPromocao, quantidade, categorias);
        ArrayList<String> categorias_ = Categorias.getCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            if (!categorias_.contains(categorias.get(i))) {
                Categorias.cadastra(categorias.get(i));
            }
        }
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

    public Produto(String codigo, String restaurante, String nome, int quantidade, float preco) {
        this.codigo = codigo;
        this.restaurante = restaurante;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getRestaurante() {
        return this.restaurante;
    }

    public String getNome() {
        return RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[1];
    }

    public int getQuantidade() {
        return Integer.parseInt(RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[4]);
    }

    public float getPreco() {
        if (Float.parseFloat(RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[3]) != -1) {
            return Float.parseFloat(RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[3]);
        } else {
            return Float.parseFloat(RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[2]);
        }
    }

    public void alteraQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoPromocao() {
        return Float.parseFloat(RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[3]);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        RestauranteDB.alteraProduto(this.restaurante, this.codigo, this.nome, this.preco, this.precoPromocao, this.quantidade, this.categorias);
    }

    public void setPreco(float preco) {
        this.preco = preco;
        RestauranteDB.alteraProduto(this.restaurante, this.codigo, this.nome, this.preco, this.precoPromocao, this.quantidade, this.categorias);
    }

    public void setPrecoPromocao(float precoPromocao) {
        this.precoPromocao = precoPromocao;
        RestauranteDB.alteraProduto(this.restaurante, this.codigo, this.nome, this.preco, this.precoPromocao, this.quantidade, this.categorias);
    }

    public void retirarPromocao() {
        setPrecoPromocao(-1);
    }

    public ArrayList<String> getCategorias() {
        ArrayList<String> categorias = new ArrayList<>();
        String aux = RestauranteDB.getProduto(this.restaurante, this.codigo).split(";")[5];
        String[] cate = aux.split(",");
        for (int i = 0; i < cate.length; i++) {
            categorias.add(cate[i]);
        }
        return categorias;
    }
}
