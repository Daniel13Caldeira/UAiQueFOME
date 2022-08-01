/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
public class Ids {

    private static File abreArquivo() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\ids.txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//ids.txt");
        }
    }

    //busca o código do próximo produto a ser adicionado
    public static int buscaProduto() {
        //arquivo onde será feita a leitura
        File arquivo = abreArquivo();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha
            if (linha != null) {
                //retorna a linha 1, onde está o código do produto
                return Integer.parseInt(linha);
            }
        } catch (IOException ex) {
            //erro(arquivo);
        }
        //se a linha estiver vazia retorna o valor 0
        return 0;
    }

    //busca o código do próximo funcionário a ser adicionado
    public static int buscaPedido() {
        //arquivo onde vai ser feita a leitura
        File arquivo = abreArquivo();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            String linha = leitor.readLine();
            if (linha != null) {
                //retorna a linha 2, onde está o código do funcionário
                return Integer.parseInt(linha);
            }
        } catch (IOException ex) {
            //erro(arquivo);
        }
        //se a linha estiver vazia retorna o valor 0
        return 0;
    }

    public static void alteraPedido() {
        //pega o código do carrinho, do produto e do funcionário
        int produto = buscaProduto();
        int pedido = buscaPedido() + 1;//adiciona 1 no funcionário
        //apaga todo o arquivo
        apagar();
        //insere os códigos atualizados
        escreve(produto, pedido);
    }

    public static void alterarPrduto() {
        //pega o código do carrinho, do produto e do funcionário
        int produto = buscaProduto() + 1;//adiciona 1 no produto
        int pedido = buscaPedido();
        //apaga todo o arquivo
        apagar();
        //insere os códigos atualizados
        escreve(produto, pedido);
    }

    private static void escreve(int codProduto, int codFuncionario) {
        //arquivo onde será feita a escrita
        File arquivo = abreArquivo();
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //insere os códigos
            escritor.write(codProduto + "");
            escritor.newLine();
            escritor.write(codFuncionario + "");
            escritor.flush();
            escritor.close();
            escrita.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    private static void apagar() {
        File arquivo = abreArquivo();
        try {
            FileWriter escrita = new FileWriter(arquivo, false); //apaga todo o arquivo
            escrita.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }
}