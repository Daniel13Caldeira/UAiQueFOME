
package view;

import javax.swing.JTextField;

public class ListaProdutos extends javax.swing.JFrame {


    public ListaProdutos() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(736, 503));
        setResizable(false);

        painel_listProdutos.setBackground(new java.awt.Color(249, 160, 63));

        lista_prodTB.setBackground(java.awt.Color.darkGray);
        lista_prodTB.setForeground(new java.awt.Color(255, 255, 255));
        lista_prodTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(lista_prodTB);

        painel_BTN.setBackground(new java.awt.Color(249, 160, 63));

        quantTF.setBackground(java.awt.Color.darkGray);
        quantTF.setForeground(new java.awt.Color(255, 255, 255));
        quantTF.setText("jTextField1");
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

        javax.swing.GroupLayout painel_BTNLayout = new javax.swing.GroupLayout(painel_BTN);
        painel_BTN.setLayout(painel_BTNLayout);
        painel_BTNLayout.setHorizontalGroup(
            painel_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_BTNLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(quantLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quantTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painel_BTNLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(add_carrinBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(46, Short.MAX_VALUE))
        );

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_carrinBTN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lista_prodTB;
    private javax.swing.JPanel painel_BTN;
    private javax.swing.JPanel painel_listProdutos;
    private javax.swing.JLabel quantLB;
    private javax.swing.JTextField quantTF;
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
}
