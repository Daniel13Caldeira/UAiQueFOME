/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Restaurante {
private String nome;
private String cnpj;
private Endereco endereco;
private ArrayList<String> categorias;
private ArrayList<Produto> produtos;
private ArrayList<Pedido> vendas;
private String horaAbertura;
private String horaFechamento;

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public Restaurante(String nome, String cnpj, String horaAbertura, String horaFechamento) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }
}
