/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Controller.Endereco;
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

    private static File abreArquivo(String cpf) {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\clientes\\" + cpf + ".txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//clientes//" + cpf + ".txt");
        }
    }

    public static void cadastra(String cpf, String nome, Endereco endereco, String senha) {
        //cria uma String com os dados do cliente no formato padrão que está sendo utilizado
        String endereco_ = endereco.getBairro() + ";" + endereco.getRua() + ";" + String.valueOf(endereco.getNumero()) + ";" + endereco.getCep() + ";";
        //define o arquivo de salvamento
        File arquivo = abreArquivo(cpf);
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            if (null == leitor.readLine()) {
                flag = true;
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            escritor.write(nome);
            escritor.newLine();
            escritor.write(endereco_);
            escritor.newLine();
            escritor.write(senha);
            escritor.newLine();
            escritor.write("#:produtos:#");
            escritor.newLine();
            escritor.write("#:pedidos:#");
            escritor.newLine();
            escritor.write("#:restaurantes favoritos:#");
            escritor.newLine();
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static void altera(String cpf, String nome, Endereco endereco, String senha) {
        //arquivo de onde ele será removido
        File arquivo = abreArquivo(cpf);
        //lista com os clientes que não serão removidos
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
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
        String endereco_ = endereco.getBairro() + ";" + endereco.getRua() + ";" + String.valueOf(endereco.getNumero()) + ";" + endereco.getCep() + ";";
        try {
            FileWriter escrita = new FileWriter(arquivo, true);//define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            escritor.write(nome);
            escritor.newLine();
            escritor.write(endereco_);
            escritor.newLine();
            escritor.write(senha);
            escritor.newLine();
            for (int i = 0; i < salvar.size(); i++) {//escreve o que estava no array no arquivo
                escritor.write(salvar.get(i));
                escritor.newLine();
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static String getRestaurante(String cpf) {
        File arquivo = abreArquivo(cpf);
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            leitor.readLine();
            leitor.readLine();
            leitor.readLine();
            String linha = leitor.readLine();//primeira linha a ser salvo
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
            return linha;
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return null;
    }

    public static ArrayList<String> getProdutos(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> produtos = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            leitor.readLine();
            leitor.readLine();
            leitor.readLine();
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                produtos.add(linha);
                linha = leitor.readLine();//pega proxima linha
            }
            produtos.remove(0);
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return produtos;
    }

    public static ArrayList<String> getPedidos(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> pedidos = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (!linha.equals("#:pedidos:#")) {
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

    public static ArrayList<String> getRestaurantesFavoritos(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> restaurantes = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (!linha.equals("#:restaurantes favoritos:#")) {
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

    public static void removerProduto(String cpf, String produto) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                if (!produto.equals(linha.split(" ")[0])) {
                    salvar.add(linha);
                    linha = leitor.readLine();//pega proxima linha
                }
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
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static void addProduto(String cpf, String produto, int quantidade, String restaurante) {
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

                if (salvar.get(i).equals("#:produtos:#")) {
                    if (i < salvar.size() - 1) {
                        if (salvar.get(i + 1).equals("#:pedidos:#")) {
                            escritor.write(restaurante);
                            escritor.newLine();
                        }
                    }
                    escritor.write(produto + " " + String.valueOf(quantidade));
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

    public static void addPedido(String cpf, String id, String restaurante) {
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
                if (salvar.get(i).equals("#:pedidos:#")) {
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

    public static void addRestauranteFavorito(String cpf, String cnpj) {
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

    public static void removeRestauranteFavorito(String cpf, String cnpj) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<String>();
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                if (!cnpj.equals(linha)) {
                    salvar.add(linha);
                    linha = leitor.readLine();//pega proxima linha
                }
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
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static String getNome(String cnpj) {
        File arquivo = abreArquivo(cnpj);
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();
            leitor.close();
            leitura.close();
            return linha;
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return "";
    }

    public static String getEndereco(String cpf) {
        File arquivo = abreArquivo(cpf);
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            String linha = leitor.readLine();
            leitor.close();
            leitura.close();
            return linha;
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return "";
    }

    public static String getSenha(String cpf) {
        File arquivo = abreArquivo(cpf);
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            leitor.readLine();
            String linha = leitor.readLine();
            leitor.close();
            leitura.close();
            return linha;
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return "";
    }
}
