
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
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<String> restaurantesFavoritos = new ArrayList<>();
    private ArrayList<Produto> carrinho = new ArrayList<>();

    public Cliente(String cpf) {
        this.cpf = cpf;
        this.nome = ClienteDB.getNome(this.cpf);
        String aux[] = ClienteDB.getEndereco(this.cpf).split(";");
        this.endereco = new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3]);
        this.senha = ClienteDB.getSenha(this.cpf);
        this.restaurantesFavoritos = getRestaurantesFavoritos();
        this.pedidos = getPedidos();
        this.carrinho = getCarrinho();
    }

    public Cliente(String cpf, String nome, String senha, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        ClienteDB.cadastra(cpf, nome, this.endereco, senha);
        Clientes.cadastra(cpf);
    }

    public Cliente(String cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.senha = ClienteDB.getSenha(this.cpf);
        this.restaurantesFavoritos = getRestaurantesFavoritos();
        this.pedidos = getPedidos();
        this.carrinho = getCarrinho();
    }

    public Cliente(String cpf, Endereco endereco) {
        this.cpf = cpf;
        this.nome = getNome();
        this.endereco = endereco;
        this.senha = ClienteDB.getSenha(this.cpf);
    }

    public String getNome() {
        return ClienteDB.getNome(this.cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getPedido(String id, String rest) {
        return RestauranteDB.getPedido(rest, id);
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
        if (!carrinho.isEmpty()) {
            this.carrinho.clear();
        }
        String restaurante = ClienteDB.getRestaurante(this.cpf);
        ArrayList<String> produtos = ClienteDB.getProdutos(this.cpf);
        ArrayList<Integer> quantidades = new ArrayList<>();
        String produto;
        for (int i = 0; i < produtos.size() - 1; i++) {
            String aux[] = produtos.get(i).split(";");
            produtos.set(i, aux[0]);
            quantidades.add(Integer.parseInt(aux[1]));
            produto = RestauranteDB.getProduto(restaurante, produtos.get(i));
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
            preco *= quantidades.get(i);
            this.carrinho.add(new Produto(id, restaurante, nome, quantidades.get(i), preco, promocao, categorias));
        }
        return this.carrinho;
    }

    public String getRestaurante() {
        return ClienteDB.getRestaurante(this.cpf);
    }

    public ArrayList<String> getRestaurantesFavoritos() {
        this.restaurantesFavoritos = ClienteDB.getRestaurantesFavoritos(this.cpf);
        return this.restaurantesFavoritos;
    }

    public ArrayList<Pedido> getPedidos() {
        if (!pedidos.isEmpty()) {
            this.pedidos.clear();
        }
        ArrayList<String> pedidos_ = ClienteDB.getPedidos(this.cpf);
        ArrayList<String> restaurantes = new ArrayList<>();
        String pedido;
        for (int i = 0; i < pedidos_.size(); i++) {
            String aux[] = pedidos_.get(i).split(";");
            pedidos_.set(i, aux[0]);
            restaurantes.add(aux[1]);
            pedido = RestauranteDB.getPedido(restaurantes.get(i), pedidos_.get(i));
            //id;cliente;valorTotal;status;produto1 quantidade1,produto2 quantidade2,;
            aux = pedido.split(";");
            String status = aux[3];
            String endAux = RestauranteDB.getEndereco(restaurantes.get(i));
            aux = endAux.split(";");
            String rest = restaurantes.get(i);
            this.pedidos.add(new Pedido(pedidos_.get(i), new Restaurante(new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3]), RestauranteDB.getNome(rest), rest), this, status));
        }
        return this.pedidos;
    }

    public ArrayList<String> getStringPedidos() {
        return ClienteDB.getPedidos(cpf);
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

    public void addProdutoAoCarrinho(Produto produto, int quantidade) {
        ArrayList<String> prod = ClienteDB.getProdutos(this.cpf);
        int quantAtual = 0;
        for (int i = 0; i < prod.size(); i++) {
            if (prod.get(i).split(";")[0].equals(produto.getCodigo())) {
                quantAtual = Integer.parseInt(prod.get(i).split(";")[1]);
            }
            prod.set(i, prod.get(i).split(";")[0]);
        }
        if (prod.contains(produto.getCodigo())) {

            ClienteDB.alteraProduto(this.cpf, produto.getCodigo(), quantAtual + quantidade, produto.getRestaurante());
        } else {
            ClienteDB.addProduto(this.cpf, produto.getCodigo(), quantidade, produto.getRestaurante());
        }
        RestauranteDB.setQuantidade(produto, quantidade, false);
    }

    public void removeProdutoDoCarrinho(Produto produto) {
        ClienteDB.removerProduto(this.cpf, produto.getCodigo());
        RestauranteDB.setQuantidade(produto, produto.getQuantCarrinho(), true);
    }

    public void removeOUnicoProduto(Produto produto) {
        ClienteDB.removerUnicoProd(this.cpf, produto.getCodigo());
        RestauranteDB.setQuantidade(produto, produto.getQuantCarrinho(), true);
    }

    public void removeRestauranteFavorito(String cnpj) {
        ClienteDB.removeRestauranteFavorito(this.cpf, cnpj);
    }

    public void finalizarPedido() {
        String restaurante = ClienteDB.getRestaurante(this.cpf);
        String endAux = RestauranteDB.getEndereco(restaurante);
        String aux[] = endAux.split(";");
        new Pedido(this, new Restaurante(new Endereco(aux[1], aux[0], Integer.parseInt(aux[2]), aux[3]), RestauranteDB.getNome(restaurante), restaurante));
        FinalizaPed();
    }

    public void esvaziaCarrinho() {
        ArrayList<String> prods = ClienteDB.esvaziaCarrinho(this.cpf);
        for (int i = 0; i < prods.size() - 1; i++) {
            String[] aux = prods.get(i).split(";");
            String[] aux_prod = RestauranteDB.getProduto(prods.get(prods.size() - 1), aux[0]).split(";");
            String[] cat = aux_prod[5].split(",");
            ArrayList<String> catego = new ArrayList<>();
            for (int j = 0; j < cat.length; j++) {
                catego.add(cat[j]);
            }
            RestauranteDB.setQuantidade(new Produto(aux_prod[0], prods.get(prods.size() - 1), aux_prod[1], Integer.parseInt(aux_prod[4]), Float.parseFloat(aux_prod[2]), Float.parseFloat(aux_prod[3]), catego), Integer.parseInt(aux[1]), true);
        }
    }

    public void FinalizaPed() {
        ArrayList<String> prods = ClienteDB.esvaziaCarrinho(this.cpf);
    }

    public void addRestauranteFavorito(String cnpj) {
        ArrayList<String> rest = ClienteDB.getRestaurantesFavoritos(this.cpf);
        if (!rest.contains(cnpj)) {
            ClienteDB.addRestauranteFavorito(this.cpf, cnpj);
        }
    }

    public static ArrayList<String> getClientes() {
        return Clientes.getClientes();
    }

    public static boolean validaCPF(String cpf) {

        for (int i = 0; i < 10; i++) {
            int cont = 0;
            for (int j = 0; j < 11; j++) {
                if (i == Integer.parseInt(cpf.charAt(j) + "")) {
                    cont++;
                }
            }
            if (cont == 11) {
                return false;
            }
        }

        int j = 10, soma = 0;
        //soma os 9 primeiros dígitos do cpf com seus pesos respectivos
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(cpf.charAt(i) + "") * j;
            j--;
        }
        soma = 11 - (soma % 11);
        //se o valor da expressão 11 - (soma % 11) for maior do que 9, o 10° dígito é 0
        if (soma > 9) {
            soma = 0;
        }
        //se o valor da expressão 11 - (soma % 11) for menor ou igual a 9, o 10° dígito é o resultado da expressão
        //se o 10° dígito for diferente do obtido pela expressão, o cpf é inválido
        if (soma != Integer.parseInt(cpf.charAt(9) + "")) {
            return false;
        }
        j = 11;
        soma = 0;
        //soma os 10 primeiros dígitos do cpf com seus pesos respectivos
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(cpf.charAt(i) + "") * j;
            j--;
        }
        //se o valor da expressão 11 - (soma % 11) for maior do que 9, o 11° dígito é 0
        soma = 11 - (soma % 11);
        if (soma > 9) {
            soma = 0;
        }
        //se o valor da expressão 11 - (soma % 11) for menor ou igual a 9, o 11° dígito é o resultado da expressão
        //se o 11° dígito for diferente do obtido pela expressão, o cpf é inválido, se não, ele é válido
        if (soma != Integer.parseInt(cpf.charAt(10) + "")) {
            return false;
        }
        return true;
    }
}
