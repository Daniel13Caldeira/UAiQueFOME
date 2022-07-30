package Controller;

import java.util.ArrayList;
import model.ClienteDB;
import model.RestauranteDB;
import model.Restaurantes;

/**
 *
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
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
        RestauranteDB.cadastra(cnpj, nome, endereco, senha);
        Restaurantes.cadastra(cnpj, nome);
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
        categorias = RestauranteDB.getCategorias(this.cnpj);
        return categorias;
    }

    public ArrayList<Produto> getProdutos() {
        ArrayList<String> prod = RestauranteDB.getProdutos(this.cnpj);
        produtos.clear();
        for (int i = 0; i < prod.size(); i++) {
            String aux[] = prod.get(i).split(";");
            String id = aux[0];
            String nome = aux[1];
            float preco = Float.parseFloat(aux[2]);
            float promocao = Float.parseFloat(aux[3]);
            int quantidade = Integer.parseInt(aux[4]);
            aux = aux[5].split(",");
            ArrayList<String> cat = new ArrayList<>();
            for (int j = 0; j < aux.length; j++) {
                cat.add(aux[j]);
            }
            produtos.add(new Produto(id, this.cnpj, nome, quantidade, preco, promocao, cat));
        }
        return produtos;
    }

    public ArrayList<Pedido> getPedidos() {
        ArrayList<String> ped = RestauranteDB.getPedidos(this.cnpj);
        pedidos.clear();
        for (int i = 0; i < ped.size(); i++) {
            String aux[] = ped.get(i).split(";");
            String id = aux[0];
            String cliente = aux[1];
            float valor = Float.parseFloat(aux[2]);
            String status = aux[3];
            String endAux = ClienteDB.getEndereco(cliente);
            aux = endAux.split(";");
            pedidos.add(new Pedido(id, this, new Cliente(cliente, ClienteDB.getNome(cliente), new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]))), status));
        }
        return pedidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
        RestauranteDB.altera(this.cnpj, nome, this.endereco, this.senha);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        RestauranteDB.altera(this.cnpj, this.nome, endereco, this.senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
        RestauranteDB.altera(this.cnpj, this.nome, this.endereco, senha);
    }

    public String getSenha() {
        return RestauranteDB.getSenha(this.cnpj);
    }

    public void finalizarPedido(Pedido pedido) {
        pedido.setStatus("finalizado");

    }

    public void addProduto(String nome, int quantidade, float preco, float precoPromocao) {
        new Produto(this.cnpj,nome,quantidade,preco,precoPromocao);
    }
    
    public void addProduto(String nome, int quantidade, float preco, float precoPromocao,ArrayList<String> categorias) {
        new Produto(this.cnpj,nome,quantidade,preco,precoPromocao,categorias);
    }

    public void removeProduto(String produto) {
        RestauranteDB.removeProduto(this.cnpj, produto);
    }

    public static ArrayList<String> getRestaurantes() {
        return Restaurantes.getRestaurantes();
    }
}
