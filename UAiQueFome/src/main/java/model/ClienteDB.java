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
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
public class ClienteDB {

    private File abreArquivo(String cpf) {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\" + cpf + ".txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//" + cpf + ".txt");
        }
    }

    public void cadastra(Cliente cliente) {
        //cria uma String com os dados do cliente no formato padrão que está sendo utilizado
        String endereco = cliente.getEndereco().getBairro() + ";" + cliente.getEndereco().getRua() + ";" + String.valueOf(cliente.getEndereco().getNumero()) + ";";
        //define o arquivo de salvamento
        File arquivo = abreArquivo(cliente.getCpf());
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            boolean flag = false;
            try {
                FileReader leitura = new FileReader(arquivo);//define o leitor
                BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
                String linha = leitor.readLine();//primeira linha a ser salva
                if (linha == null) {
                    flag = true;
                }
                leitor.close();
                leitura.close();
            } catch (IOException ex) {
                //erro(arquivo);
            }
            escritor.write(cliente.getNome());
            escritor.newLine();
            escritor.write(endereco);
            escritor.newLine();
            if (flag) {
                escritor.write("#:produtos:#");
                escritor.newLine();
                escritor.write("#:pedidos:#");
                escritor.newLine();
                escritor.write("#:restaurantes favoritos:#");
                escritor.newLine();
            }
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public void altera(Cliente cliente) {
        //arquivo de onde ele será removido
        File arquivo = abreArquivo(cliente.getCpf());
        //lista com os clientes que não serão removidos
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            leitor.readLine();
            String linha = leitor.readLine();//primeira linha a ser salva
            while (linha != null) {//linha null = final do arquivo
                salvar.add(linha);
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
        cadastra(cliente);
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

    public ArrayList<String> getProdutos(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> produtos = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            leitor.readLine();
            leitor.readLine();
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                produtos.add(linha);
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return produtos;
    }

    public ArrayList<String> getPedidos(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> pedidos = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != "#:pedidos:#") {
                linha = leitor.readLine();//pega proxima linha
            }
            linha = leitor.readLine();//pega proxima linha
            while (linha != null) {//linha null = final do arquivo
                pedidos.add(linha);
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return pedidos;
    }

    public ArrayList<String> getRestaurantesFavoritos(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> restaurantes = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != "#:restaurantes favoritos:#") {
                linha = leitor.readLine();//pega proxima linha
            }
            linha = leitor.readLine();//pega proxima linha
            while (linha != null) {//linha null = final do arquivo
                restaurantes.add(linha);
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return restaurantes;
    }

    public void addProduto(String cpf, String produto, String quantidade, String restaurante) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                salvar.add(linha);
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
                if (salvar.get(i) == "#:produtos:#") {
                    escritor.write(restaurante);
                    escritor.newLine();
                    escritor.write(produto + " " + quantidade);
                    escritor.newLine();
                }
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public void addProduto(String cpf, String produto, String quantidade) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                salvar.add(linha);
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
                if (salvar.get(i) == "#:produtos:#") {
                    escritor.write(produto + " " + quantidade);
                    escritor.newLine();
                }
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public void addPedido(String cpf, String id, String restaurante) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                salvar.add(linha);
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
                if (salvar.get(i) == "#:pedidos:#") {
                    escritor.write(id + " " + restaurante);
                    escritor.newLine();
                }
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public void addRestauranteFavorito(String cpf, String cnpj) {
        File arquivo = abreArquivo(cpf);
        try {
            FileWriter escrita = new FileWriter(arquivo, true);//define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            escritor.write(cnpj);
            escritor.newLine();
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }
}