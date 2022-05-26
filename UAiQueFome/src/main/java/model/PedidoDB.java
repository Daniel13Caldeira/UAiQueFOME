/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Controller.Pedido;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class PedidoDB {

    private static File abreArquivoProdutos(int codigo) {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\pedidos\\"+codigo+".txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//pedidos//"+codigo+".txt");
        }
    }

    public static void cadastra(Pedido pedido) {
        //cria uma String com os dados do cliente no formato padrão que está sendo utilizado
        String info = String.valueOf(pedido.getCodigo()) + ";" + pedido.getRestaurante().getCnpj() + ";" + pedido.getCliente().getCpf()+ ";" + String.valueOf(pedido.getValorTotal()) + ";" ;
        //define o arquivo de salvamento
        File arquivo = abreArquivoProdutos(pedido.getCodigo());
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            escritor.write(info);
            escritor.newLine();
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    private static void remover(int codigo) {
        //arquivo de onde ele será removido
        File arquivo = abreArquivoProdutos(codigo);
        //lista com os clientes que não serão removidos
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha
            while (linha != null) {//linha null = final do arquivo
                if (!(codigo == Integer.parseInt(linha.substring(0, linha.indexOf(";"))))) {//procura pelas linhas que não serão apagadas e as adiciona no array
                    salvar.add(linha);
                }
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
            //erro(arquivo);
        }
        try {
            FileWriter escrita = new FileWriter(arquivo, true);//define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            for (int i = 0; i < salvar.size(); i++) {//escreve o que estava no array no arquivo
                escritor.write(salvar.get(i));
                escritor.newLine();
                escritor.flush();
            }
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static void alterarNome(Pedido produto, String nome) {
        remover(produto.getCodigo());
        cadastra(produto);
    }
}

