
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
        String endereco_ = endereco.getBairro() + ";" + endereco.getRua() + ";" + String.valueOf(endereco.getNumero()) + ";" + endereco.getCep() + ";";
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
        }
    }

    public static ArrayList<String> esvaziaCarrinho(String cpf) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        ArrayList<String> prods = new ArrayList<>();//armazena os produtos que vão voltar para o restaurante
        try {
            boolean flag = true;
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salva
            while (linha != null) {//linha null = final do arquivo
                if (linha.equals("#:pedidos:#")) {
                    flag = true;
                }
                if (flag) {
                    salvar.add(linha);
                } else {
                    prods.add(linha);
                }
                if (linha.equals("#:produtos:#")) {
                    flag = false;
                }
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
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
        }
        return prods;
    }

    public static void altera(String cpf, String nome, Endereco endereco, String senha) {
        File arquivo = abreArquivo(cpf);
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
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
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
        }
    }

    public static void alteraProduto(String cpf, String id, int quantidade, String restaurante) {
        removeProduto(cpf, id);
        if (quantidade > 0) {
            addProduto(cpf, id, quantidade, restaurante);
        }
    }

    public static void removeProduto(String cpf, String produto) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (linha != null) {
                if (!produto.equals(linha.split(";")[0])) {
                    salvar.add(linha);
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
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
        }
    }

    public static String getRestaurante(String cpf) {
        File arquivo = abreArquivo(cpf);
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura

            String linha = leitor.readLine();//primeira linha a ser salv
            String linhaAux = linha;
            while (!linha.equals("#:pedidos:#")) {
                linhaAux = linha;
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
            return linhaAux;
        } catch (IOException ex) {
        }
        return "";
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
            while (!linha.equals("#:pedidos:#")) {//linha null = final do arquivo
                produtos.add(linha);
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
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
            while (!linha.equals("#:restaurantes favoritos:#")) {//linha null = final do arquivo
                pedidos.add(linha);
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
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
                if (!produto.equals(linha.split(";")[0])) {
                    salvar.add(linha);
                }
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
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
        }
    }
    
    public static void removerUnicoProd(String cpf, String produto) {
        File arquivo = abreArquivo(cpf);
        ArrayList<String> salvar = new ArrayList<String>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();//primeira linha a ser salvo
            while (linha != null) {//linha null = final do arquivo
                if (!produto.equals(linha.split(";")[0]) && !linha.equals(getRestaurante(cpf))) {
                    salvar.add(linha);
                }
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
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
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {

        }
        try {
            FileWriter escrita = new FileWriter(arquivo, true);//define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita

            for (int i = 0; i < salvar.size(); i++) {//escreve o que estava no array no arquivo
                escritor.write(salvar.get(i));
                escritor.newLine();

                if (salvar.get(i).equals("#:produtos:#")) {
                    escritor.write(produto + ";" + String.valueOf(quantidade));
                    escritor.newLine();
                    if (salvar.get(i + 1).equals("#:pedidos:#")) {
                        escritor.write(restaurante);
                        escritor.newLine();
                    }
                }
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
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
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
        }
        try {
            FileWriter escrita = new FileWriter(arquivo, true);//define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita

            for (int i = 0; i < salvar.size(); i++) {//escreve o que estava no array no arquivo
                escritor.write(salvar.get(i));
                escritor.newLine();
                if (salvar.get(i).equals("#:pedidos:#")) {
                    escritor.write(id + ";" + restaurante);
                    escritor.newLine();
                }
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
         
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
                }
                linha = leitor.readLine();//pega proxima linha
            }
            leitor.close();//fecha o buffer
            leitura.close();//fecha o leitor
        } catch (IOException ex) {
        }
        try {
            FileWriter escritaAux = new FileWriter(arquivo, false);//apaga todo o arquivo
            escritaAux.close();//fecha o escritot
        } catch (IOException ex) {
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
