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
public class PedidoDB {

    private static File abreArquivo() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\pedidos.txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//pedidos.txt");
        }
    }

    public static void cadastra(String pedido, String restaurante) {
        //cria uma String com os dados do cliente no formato padrão que está sendo utilizado
        //define o arquivo de salvamento
        File arquivo = abreArquivo();
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            escritor.write(pedido + ";" + restaurante);
            escritor.newLine();
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static String getPedido(String id) {
        File arquivo = abreArquivo();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                String sub = linha.substring(0, linha.indexOf(" "));
                if (sub.equals(id)) {
                    leitor.close();//fecha o buffer
                    leitura.close();//fecha o leitor
                    return linha;
                }
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return null;
    }
}
