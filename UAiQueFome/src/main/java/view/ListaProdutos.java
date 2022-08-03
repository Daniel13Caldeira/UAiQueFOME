package view;

import Controller.Cliente;
import Controller.Produto;
import Controller.Restaurante;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Restaurantes;

public class ListaProdutos extends javax.swing.JFrame {

    private static String cod_prod; //variavel que vai guardar o codigo do produto

    private static String cnpj_rest;//variavel que vai guardar o codigo do restaurante

    public static String getCod_prod() {
        return cod_prod;
    }

    public ListaProdutos() {
        initComponents();
        preencheTab();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_listProdutos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_prodTB = new javax.swing.JTable();
        painel_BTN = new javax.swing.JPanel();
        quantTF = new javax.swing.JTextField();
        quantLB = new javax.swing.JLabel();
        add_carrinBTN = new javax.swing.JButton();
        voltarBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAiQueFome");
        setPreferredSize(new java.awt.Dimension(736, 503));
        setResizable(false);

        painel_listProdutos.setBackground(new java.awt.Color(249, 160, 63));

        lista_prodTB.setBackground(java.awt.Color.darkGray);
        lista_prodTB.setForeground(new java.awt.Color(255, 255, 255));
        lista_prodTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Quantidade", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(lista_prodTB);

        painel_BTN.setBackground(new java.awt.Color(249, 160, 63));

        quantTF.setBackground(java.awt.Color.darkGray);
        quantTF.setForeground(new java.awt.Color(249, 160, 63));
        quantTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantTFActionPerformed(evt);
            }
        });
        quantTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantTFKeyTyped(evt);
            }
        });

        quantLB.setBackground(new java.awt.Color(255, 255, 255));
        quantLB.setForeground(new java.awt.Color(255, 255, 255));
        quantLB.setText("Quantidade");

        add_carrinBTN.setBackground(java.awt.Color.darkGray);
        add_carrinBTN.setForeground(new java.awt.Color(255, 255, 255));
        add_carrinBTN.setText("Adicionar ao Carrinho");
        add_carrinBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_carrinBTNActionPerformed(evt);
            }
        });

        voltarBTN.setBackground(java.awt.Color.darkGray);
        voltarBTN.setForeground(new java.awt.Color(255, 255, 255));
        voltarBTN.setText("Voltar");
        voltarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_BTNLayout = new javax.swing.GroupLayout(painel_BTN);
        painel_BTN.setLayout(painel_BTNLayout);
        painel_BTNLayout.setHorizontalGroup(
            painel_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_BTNLayout.createSequentialGroup()
                .addGroup(painel_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_BTNLayout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addComponent(quantLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_BTNLayout.createSequentialGroup()
                        .addGroup(painel_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_BTNLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(add_carrinBTN))
                            .addGroup(painel_BTNLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(voltarBTN)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_BTNLayout.setVerticalGroup(
            painel_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_BTNLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painel_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantLB))
                .addGap(40, 40, 40)
                .addComponent(add_carrinBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(voltarBTN)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        quantTF.setText("");//inicializa o campo de texto vazio

        javax.swing.GroupLayout painel_listProdutosLayout = new javax.swing.GroupLayout(painel_listProdutos);
        painel_listProdutos.setLayout(painel_listProdutosLayout);
        painel_listProdutosLayout.setHorizontalGroup(
            painel_listProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_listProdutosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        painel_listProdutosLayout.setVerticalGroup(
            painel_listProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
            .addGroup(painel_listProdutosLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(painel_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_listProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_listProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantTFActionPerformed

    private void quantTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantTFKeyReleased
        mascaraInt(quantTF);
    }//GEN-LAST:event_quantTFKeyReleased

    private void quantTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantTFKeyTyped
        mascaraInt(quantTF);
    }//GEN-LAST:event_quantTFKeyTyped

    private void add_carrinBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_carrinBTNActionPerformed
        Cliente client = new Cliente(Login.getUser_cod());
        boolean flag = true; //flag que define se o produto pode ser adicionado
        if (lista_prodTB.getSelectedRow() != -1) { //verifica se alguma linha foi selecionada
            cod_prod = lista_prodTB.getValueAt(lista_prodTB.getSelectedRow(), 3).toString(); //guarda o codigo do produto selecionado
            if (quantTF.getText().equals("")) { //verifica se o campo de quantidade está em branco
                JOptionPane.showMessageDialog(null, "O campo de quantidade precisa ser informado!", "Aviso", JOptionPane.PLAIN_MESSAGE);
                flag = false;
            } else {
                if (Integer.parseInt(quantTF.getText()) <= 0 || Integer.parseInt(quantTF.getText()) > Integer.parseInt(lista_prodTB.getValueAt(lista_prodTB.getSelectedRow(), 2).toString())) {//verifica se a quantidade informada está fora do intervalo válido
                    JOptionPane.showMessageDialog(null, "A quantidade informada é inválida!", "Aviso", JOptionPane.PLAIN_MESSAGE);
                    flag = false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!", "Aviso", JOptionPane.PLAIN_MESSAGE);
            flag = false;
        }
        if (!client.getRestaurante().equals(InicioCliente.getPk_rest()) && client.getRestaurante().equals("")) {
            flag = false;
            JOptionPane.showMessageDialog(null, "Não é possível adicionar produtos de restaurantes diferentes em um mesmo carrinho!\nPor favor primeiro finalize seu pedido em aberto.", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
        if (flag) {//adiciona ao carrinho caso seja possível
            Produto produto = new Produto(cod_prod, cnpj_rest);
            int quantidade = Integer.parseInt(quantTF.getText());
            client.addProdutoAoCarrinho(produto, quantidade);
            atualizaTab();
        }
    }//GEN-LAST:event_add_carrinBTNActionPerformed

    private void voltarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBTNActionPerformed
        //volta para a tela de inicio do cliente
        setVisible(false);
        new InicioCliente().setVisible(true);
    }//GEN-LAST:event_voltarBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_carrinBTN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lista_prodTB;
    private javax.swing.JPanel painel_BTN;
    private javax.swing.JPanel painel_listProdutos;
    private javax.swing.JLabel quantLB;
    private javax.swing.JTextField quantTF;
    private javax.swing.JButton voltarBTN;
    // End of variables declaration//GEN-END:variables

    private void mascaraInt(JTextField textField) {
        //Máscara que aceita apenas números
        String texto = textField.getText();
        if (texto.length() > 0) {
            //Verifica se o último caractere digitado é um número
            if (texto.charAt(texto.length() - 1) < '0' || texto.charAt(texto.length() - 1) > '9') {
                //Apaga o caractere digitado
                texto = texto.substring(0, texto.length() - 1);
            }
        }
        textField.setText(texto);
    }

    private void preencheTab() {//Função que vai preencher as tabelas com os produtos do restaurante
        ArrayList<String> list_rests = Restaurantes.getRestaurantes();
        list_rests.removeAll(Arrays.asList("", null));//Lista com todos os restaurantes cadastrados
        int k = -1;//variavel para guardar o indice do restaurante
        String[] aux_rest; //Array que vai receber os atributos dos restaurantes no formato {"cnpj","nome"}
        for (int i = 0; i < list_rests.size(); i++) {//loop que vai localizar o indice do restaurante
            aux_rest = list_rests.get(i).split(";"); //separa a linha de atributos do restaurante
            if (aux_rest[0].equals(InicioCliente.getPk_rest())) {//verifica se os nomes são iguais e guarda o indice e o cnpj do restaurante
                cnpj_rest = aux_rest[0];
                k = i;
                break;
            }
        }
        if (k != -1) {//cria um novo objeto restaurante com os atributos encontrados  
            Restaurante rest = new Restaurante(cnpj_rest); //cria um objeto com o cnpj encontrado
            ArrayList<Produto> list_Prod = rest.getProdutos(); //obtem a lista de produtos do restaurante
            DefaultTableModel model = (DefaultTableModel) lista_prodTB.getModel();
            for (int i = 0; i < list_Prod.size(); i++) { //loop que preenche a tabela com os produtos, um em cada linha
                if (list_Prod.get(i).getQuantidade() > 0) {
                    Object[] linha = {list_Prod.get(i).getNome(), list_Prod.get(i).getPreco(), list_Prod.get(i).getQuantidade(), list_Prod.get(i).getCodigo()};
                    model.addRow(linha);
                }
            }
        }
        //Os passos abaixo mudam a cor do header da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.DARK_GRAY);
        headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < lista_prodTB.getModel().getColumnCount(); i++) {
            lista_prodTB.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    private void atualizaTab() {
        DefaultTableModel model = (DefaultTableModel) lista_prodTB.getModel();
        model.setRowCount(0);
        preencheTab();
    }
}
