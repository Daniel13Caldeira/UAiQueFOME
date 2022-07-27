package model;

import Controller.Restaurante;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RestauranteDB {

    private static File abreArquivoRestaurante(String restaurante) {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //File arquivo = new File("caminho win");
            return new File("dados\\" + restaurante + ".txt");
        } else {
            //File arquivo = new File("caminho linux");
            return new File("dados//" + restaurante + ".txt");
        }
    }

    public static void cadastra(Restaurante restaurante) {
        //cria uma String com os dados do endereço do restaurante no formato padrão que está sendo utilizado
        String endereco = restaurante.getEndereco().getBairro() + ";" + restaurante.getEndereco().getRua() + ";" + String.valueOf(restaurante.getEndereco().getNumero());
        //define o arquivo de salvamento
        File arquivo = abreArquivoRestaurante(restaurante.getCnpj());
        try {
            FileWriter escrita = new FileWriter(arquivo, true); //define o escritor
            BufferedWriter escritor = new BufferedWriter(escrita);//buffer de escrita
            //escreve no arquivo e vai pra próxima linha
            escritor.write(restaurante.getNome());
            escritor.newLine();
            escritor.write(endereco);
            escritor.newLine();
            escritor.write("#:Produtos:#");
            escritor.newLine();
            escritor.write("#:categorias:#");
            escritor.newLine();
            escritor.write("#:vendas:#");
            escritor.newLine();
            escritor.flush();
            escritor.close();//fecha o buffer
            escrita.close();//fecha o escritor
        } catch (IOException ex) {
            //erro(arquivo);
        }
    }

    private static void altera(Restaurante restaurante) {
        //arquivo de onde os dados serão alterados
        File arquivo = abreArquivoRestaurante(restaurante.getCnpj());
        //lista com os atributos que não serão alterados
        ArrayList<String> salvar = new ArrayList<>();//armazena as linhas que não serão apagadas
        try {
            FileReader leitura = new FileReader(arquivo);//define o leitor
            BufferedReader leitor = new BufferedReader(leitura);//cria um buffer de leitura
            leitor.readLine();
            leitor.readLine();
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
            String endereco = restaurante.getEndereco().getBairro() + ";" + restaurante.getEndereco().getRua() + ";" + String.valueOf(restaurante.getEndereco().getNumero());
            escritor.write(restaurante.getNome());
            escritor.newLine();
            escritor.write(endereco);
            escritor.newLine();
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
}
