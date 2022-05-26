/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Controller.Cliente;
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
public class ClienteDB {

    //cpf;nome;bairro;rua;numero;
    private File abreArquivoClientes() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\clientes.txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//clientes.txt");
        }
    }

    public void cadastra(Cliente cliente) {
        //cria uma String com os dados do cliente no formato padrão que está sendo utilizado
        String info = cliente.getCpf() + ";" + cliente.getNome()+";"+cliente.getEndereco().getBairro()+";"+cliente.getEndereco().getRua()+";"+String.valueOf(cliente.getEndereco().getNumero())+";";
        //define o arquivo de salvamento
        File arquivo = abreArquivoClientes();
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
    
    private void remover(String cpf) {
        //arquivo de onde ele será removido
        File arquivo = abreArquivoClientes();
        //lista com os clientes que não serão removidos
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha
            while (linha != null) {//linha null = final do arquivo
                if (!(cpf.equalsIgnoreCase(linha.substring(0,linha.indexOf(";"))))) {//procura pelas linhas que não serão apagadas e as adiciona no array
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
    
    public void alterar(Cliente cliente){
        remover(cliente.getCpf());
        cadastra(cliente);
    }

    
}
