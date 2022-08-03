
package Controller;

import java.util.ArrayList;
import model.ClienteDB;
import model.Ids;
import model.PedidoDB;
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
        Ids.alteraPedido();
        this.codigo = String.valueOf(Ids.buscaPedido());
        this.status = "Enviado para o restaurante";
        this.cliente = cliente;
        this.restaurante = restaurante;
        produtos = cliente.getCarrinho();
        ArrayList<String> prod = new ArrayList<>();
        valorTotal = 0;
        for (int i = 0; i < produtos.size(); i++) {
            this.valorTotal += produtos.get(i).getPrecoCarrinho();  
            prod.add(produtos.get(i).getCodigo());
        }
        RestauranteDB.addPedido(restaurante.getCnpj(), codigo, cliente.getCpf(), valorTotal, status, prod);
        ClienteDB.addPedido(cliente.getCpf(), codigo, restaurante.getCnpj());
    }

    public String getStatus() {
        return RestauranteDB.getPedido(this.restaurante.getCnpj(), this.codigo).split(";")[3];
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

    public Pedido(String codigo, Cliente cliente, Restaurante restaurante) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.status = getStatus();
    }
        public Pedido(String codigo, Cliente cliente, Restaurante restaurante,String status,Float valor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.status = status;
        this.valorTotal = valor;
        
        
        
        
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Restaurante getRestaurante() {
        return this.restaurante;
    }

    
    public ArrayList<Produto> getProdutos() {
        this.produtos = this.cliente.getCarrinho();
        return this.produtos;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setStatus(String status) {
        this.status = status;
        RestauranteDB.alteraPedido(this.restaurante.getCnpj(), codigo, this.cliente.getCpf(), valorTotal, status);
    }
}
