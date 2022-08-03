
package Controller;

/**
 *
 * @author Daniel Caldeira, Igor Fam, Márcio Felipe
 */
public class Endereco {

    private String rua;
    private String bairro;
    private int numero;
    private String cep;

    public Endereco(String rua, String bairro, int numero, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }
}
