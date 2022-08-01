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

    public static String setIdProduto() {
        File arquivo = abreArquivo();
        String idProduto = "", idPedido = "";
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            idProduto = leitor.readLine();
            if (idProduto == null) {
                idProduto = "0";
                idPedido = "0";
            } else {
                idProduto = leitor.readLine() ;
                idPedido = leitor.readLine();
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        idProduto = String.valueOf(Integer.parseInt(idProduto) + 1);
        System.out.println(idProduto);
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
            //erro(arquivo);
        }
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            escritor.write(idProduto);
            escritor.newLine();
            escritor.write(idPedido);
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return idProduto;
    }

    public static String setIdPedido() {
        File arquivo = abreArquivo();
        String idProduto = "", idPedido = "";
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            idProduto = leitor.readLine();
            if (idProduto == null) {
                idProduto = "0";
                idPedido = "0";
            } else {
                idProduto = leitor.readLine() ;
                idPedido = leitor.readLine();
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        idPedido = String.valueOf(Integer.parseInt(idPedido) + 1);
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
            //erro(arquivo);
        }
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            escritor.write(idProduto);
            escritor.newLine();
            escritor.write(idPedido);
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return idPedido;
    }
}
