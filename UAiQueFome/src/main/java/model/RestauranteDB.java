package model;

import Controller.Endereco;
import Controller.Pedido;
import Controller.Produto;
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
public class RestauranteDB {

    private static File abreArquivo(String restaurante) {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\restaurantes\\" + restaurante + ".txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//restaurantes//" + restaurante + ".txt");
        }
    }

    public static void cadastra(String cnpj, String nome, Endereco endereco, String senha) {
        //cria uma String com os dados do endereço do restaurante no formato padrão que está sendo utilizado
        String endereco_ = endereco.getBairro() + ";" + endereco.getRua() + ";" + String.valueOf(endereco.getNumero()) + ";" + endereco.getCep();
        //define o arquivo de salvamento
        File arquivo = abreArquivo(cnpj);
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
            escritor.write("#:categorias:#");
            escritor.newLine();
            escritor.write("#:pedidos:#");
            escritor.newLine();
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static void altera(String cnpj, String nome, Endereco endereco, String senha) {
        //arquivo de onde os dados serão alterados
        File arquivo = abreArquivo(cnpj);
        //lista com os atributos que não serão alterados
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            String linha = leitor.readLine();
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
            }
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    public static void addProduto(String cnpj, String id, String nome, float preco, float promocao, int quantidade, ArrayList<String> categorias) {
        File arquivo = abreArquivo(cnpj);
        //id;nome;preco;promocao;quantidade;categoria1,categoria2,;
        String info = id + ";" + nome + ";" + String.valueOf(preco) + ";" + String.valueOf(promocao) + ";" + String.valueOf(quantidade) + ";";
        for (int i = 0; i < categorias.size(); i++) {
            info += categorias.get(i) + ",";
        }
        info += ";";
        ArrayList<String> salvar = new ArrayList<>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (linha != null) {
                salvar.add(linha);
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
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
                    escritor.write(info);
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

    public static String getProduto(String cnpj, String id) {
        //id;nome;preco;promocao;quantidade;categoria1,categoria2,;
        File arquivo = abreArquivo(cnpj);
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (!linha.equals("#:categorias:#")) {
                if (id.equals(linha.split(";")[0])) {
                    leitor.close();
                    leitura.close();
                    return linha;
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return null;
    }

    public static ArrayList<String> getProdutos(String cnpj) {
        //id;nome;preco;promocao;quantidade;categoria1,categoria2,;
        File arquivo = abreArquivo(cnpj);
        ArrayList<String> produtos = new ArrayList<>();
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (!linha.equals("#:categorias:#")) {
                if (linha.equals("#:produtos:#")) {
                    flag = true;
                } else {
                    if (flag) {
                        produtos.add(linha);
                    }
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return produtos;
    }

    public static void addCategoria(String cnpj, String categoria) {
        File arquivo = abreArquivo(cnpj);
        ArrayList<String> salvar = new ArrayList<>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (linha != null) {
                salvar.add(linha);
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
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
                if (salvar.get(i).equals("#:categorias:#")) {
                    escritor.write(categoria);
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

    public static ArrayList<String> getCategorias(String cnpj) {
        File arquivo = abreArquivo(cnpj);
        ArrayList<String> categorias = new ArrayList<>();
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (!linha.equals("#:pedidos:#")) {
                if (linha.equals("#:categorias:#")) {
                    flag = true;
                } else {
                    if (flag) {
                        categorias.add(linha);
                    }
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return categorias;
    }

    //id;cliente;valorTotal;status;produto1 quantidade1,produto2 quantidade2,;
    public static void addPedido(String cnpj, String id, String cliente, float valorTotal, String status, ArrayList<String> produtos) {
        File arquivo = abreArquivo(cnpj);
        String info = id + ";" + cliente + ";" + String.valueOf(valorTotal) + ";" + status + ";";
        for (int i = 0; i < produtos.size(); i++) {
            info += produtos.get(i) + ",";
        }
        info += ";";
        try {
            FileWriter escrita = new FileWriter(arquivo, true);//define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            escritor.write(info);
            escritor.newLine();
            escritor.flush();
            escrita.close();
            escritor.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    //id;cliente;valorTotal;status;produto1 quantidade1,produto2 quantidade2,;
    public static String getPedido(String cnpj, String id) {
        File arquivo = abreArquivo(cnpj);
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (linha != null) {
                if (id.equals(linha.split(";")[0])) {
                    leitor.close();
                    leitura.close();
                    return linha;
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return null;
    }

    public static ArrayList<String> getPedidos(String cnpj) {
        File arquivo = abreArquivo(cnpj);
        ArrayList<String> pedidos = new ArrayList<>();
        boolean flag = false;
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (linha != null) {
                if (linha.equals("#:pedidos:#")) {
                    flag = true;
                } else {
                    if (flag) {
                        pedidos.add(linha);
                    }
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
        } catch (IOException ex) {
            //erro(arquivo);
        }
        return pedidos;
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

    public static String getEndereco(String cnpj) {
        File arquivo = abreArquivo(cnpj);
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

    public static String getSenha(String cnpj) {
        File arquivo = abreArquivo(cnpj);
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

    public static void removeProduto(String cnpj, String produto) {
        File arquivo = abreArquivo(cnpj);
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

    public static int getQuantidade(String cnpj, String produto) {
        int quantidade = Integer.parseInt(getProduto(cnpj, produto).split(";")[4]);
        if (quantidade == 0) {
            removeProduto(cnpj, produto);
        }
        return quantidade;
    }

    public static void setQuantidade(Produto produto, boolean flag) {
        int quantidade;
        if (flag) {
            quantidade = getQuantidade(produto.getRestaurante(), produto.getCodigo()) + produto.getQuantidade();
        } else {
            quantidade = getQuantidade(produto.getRestaurante(), produto.getCodigo()) - produto.getQuantidade();
        }
        removeProduto(produto.getRestaurante(), produto.getCodigo());
        if (quantidade > 0) {
            produto.setQuantidade(quantidade);
            addProduto(produto.getRestaurante(), produto.getCodigo(), produto.getNome(), produto.getPreco(), produto.getPrecoPromocao(), quantidade, produto.getCategorias());
        }
    }

    public static void setQuantidade(Produto produto, int quantidade) {
        removeProduto(produto.getRestaurante(), produto.getCodigo());
        if (quantidade > 0) {
            addProduto(produto.getRestaurante(), produto.getCodigo(), produto.getNome(), produto.getPreco(), produto.getPrecoPromocao(), quantidade, produto.getCategorias());
        }
    }

    public static void setPreco(Produto produto, float preco) {
        removeProduto(produto.getRestaurante(), produto.getCodigo());
        addProduto(produto.getRestaurante(), produto.getCodigo(), produto.getNome(), preco, produto.getPrecoPromocao(), produto.getQuantidade(), produto.getCategorias());
    }

    public static void setPrecoPromocao(Produto produto, float precoPromocao) {
        removeProduto(produto.getRestaurante(), produto.getCodigo());
        addProduto(produto.getRestaurante(), produto.getCodigo(), produto.getNome(), produto.getPreco(), precoPromocao, produto.getQuantidade(), produto.getCategorias());
    }

    public static void setStatusPedido(String cnpj, Pedido pedido, String status) {
        //String cnpj, String id, String cliente, float valorTotal, String status, ArrayList<String> produtos
        removePedido(cnpj, pedido.getCodigo());
        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Produto> prod = pedido.getProdutos();
        for (int i = 0; i < prod.size(); i++) {
            produtos.add(prod.get(i).getCodigo());
        }
        addPedido(cnpj, pedido.getCodigo(), pedido.getCliente().getCpf(), pedido.getValorTotal(), status, produtos);
    }

    public static void removePedido(String cnpj, String pedido) {
        File arquivo = abreArquivo(cnpj);
        ArrayList<String> salvar = new ArrayList<>();
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            //primeira linha a ser salva
            String linha = leitor.readLine();
            while (linha != null) {
                if (!pedido.equals(linha.split(";")[0])) {
                    salvar.add(linha);
                }
                linha = leitor.readLine();
            }
            leitor.close();
            leitura.close();
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
}
