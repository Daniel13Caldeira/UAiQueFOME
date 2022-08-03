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
    private ArrayList<String> categorias = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Restaurante(String cnpj) {
        this.cnpj = cnpj;
        this.senha = RestauranteDB.getSenha(this.cnpj);
        this.nome = RestauranteDB.getNome(this.cnpj);
        String aux[] = RestauranteDB.getEndereco(this.cnpj).split(";");
        this.endereco = new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3]);
        this.categorias = RestauranteDB.getCategorias(this.cnpj);
        this.produtos = this.getProdutos();
        this.pedidos = this.getPedidos();
    }

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
        this.categorias = RestauranteDB.getCategorias(this.cnpj);
        this.produtos = this.getProdutos();
        this.pedidos = this.getPedidos();
        this.senha = RestauranteDB.getSenha(this.cnpj);
    }

    public String getPedido(String cod){
        return RestauranteDB.getPedido(this.cnpj, cod);
    }
    
    public String getNome() {
        return RestauranteDB.getNome(this.cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        String aux[] = RestauranteDB.getEndereco(this.cnpj).split(";");
        return new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3]);
    }

    public ArrayList<String> getCategorias() {
        categorias = RestauranteDB.getCategorias(this.cnpj);
        return categorias;
    }

    public String findProduto(String id) {
        return RestauranteDB.getProduto(cnpj, id);
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
        if (!pedidos.isEmpty()) {
            pedidos.clear();
        }
        for (int i = 0; i < ped.size(); i++) {
            String aux[] = ped.get(i).split(";");
            String id = aux[0];
            String cliente = aux[1];
            float valor = Float.parseFloat(aux[2]);
            String status = aux[3];
            String endAux = ClienteDB.getEndereco(cliente);
            aux = endAux.split(";");
            pedidos.add(new Pedido(id, new Cliente(cliente,new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3])), this, status,valor));
        }
        return pedidos;
    }

    private void addCategoria(String categoria) {
        RestauranteDB.addCategoria(this.cnpj, categoria);
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
        pedido.setStatus("Finalizado");

    }

    public void addProduto(String nome, int quantidade, float preco, float precoPromocao) {
        new Produto(this.cnpj, nome, quantidade, preco, precoPromocao);
    }

    public void addProduto(String nome, int quantidade, float preco, float precoPromocao, ArrayList<String> categorias) {
        new Produto(this.cnpj, nome, quantidade, preco, precoPromocao, categorias);
        ArrayList<String> categoriasAtuais = RestauranteDB.getCategorias(this.cnpj);
        for (int i = 0; i < categorias.size(); i++) {
            if (!categoriasAtuais.contains(categorias.get(i))) {
                addCategoria(categorias.get(i));
            }
        }
    }

    public void removeProduto(String produto) {
        RestauranteDB.removeProduto(this.cnpj, produto);
    }

    public static ArrayList<String> getRestaurantes() {
        return Restaurantes.getRestaurantes();
    }

    public static boolean validaCnpj(String cnpj) {//Método que valida cnpj
        //declaração dos vetores que possuem a sequência  usada para validar
        int[] k1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] k2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;//variavel que vai guardar os resultados das operações feitas
        String aux_cnpj = cnpj.substring(0, 12);
        for (int i = 0; i < 12; i++) { // soma recebe soma + o valor da posição i de k1 vezes o valor da posição i do cnpj
            soma += (k1[i] * Integer.parseInt(aux_cnpj.charAt(i) + ""));
        }
        //é feita a divisão da soma encontrada por 11 para encontrar o digito
        if ((soma % 11) < 2) {//se o resto  da divisão for menor que dois o digito x1 é 0
            aux_cnpj = aux_cnpj + "0";
        } else { //se não x1 recebe o valor da subtração a baixo
            int x1 = 11 - (soma % 11);
            aux_cnpj = aux_cnpj + Integer.toString(x1);
        }
        if (!aux_cnpj.equals(cnpj.substring(0, 13))) {
            return false;
        }
        soma = 0;// zera a variável soma para as novas operações
        //o mesmo processo é repetido , mas agora é feito a avaliação considerando o digito calculado anteriormente
        for (int i = 0; i < 13; i++) { // soma recebe soma + o valor da posição i de k1 vezes o valor da posição i do cnpj 
            soma += (k2[i] * Integer.parseInt(aux_cnpj.charAt(i) + ""));
        }
        //é feita a divisão da soma encontrada por 11 para encontrar o digito
        if ((soma % 11) < 2) {//se o resto  da divisão for menor que dois o digito x1 é 0
            aux_cnpj = aux_cnpj + "0";
        } else { //se não x2 recebe o valor da subtração a baixo
            int x2 = 11 - (soma % 11);
            aux_cnpj = aux_cnpj + Integer.toString(x2);
        }
        return aux_cnpj.equals(cnpj);
    }
}
