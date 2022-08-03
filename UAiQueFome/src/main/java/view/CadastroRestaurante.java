package view;

import Controller.Endereco;
import Controller.Restaurante;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroRestaurante extends javax.swing.JFrame {

    public CadastroRestaurante() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        painel_dados = new javax.swing.JPanel();
        cnpjLB = new javax.swing.JLabel();
        ruaLB = new javax.swing.JLabel();
        nomeLB = new javax.swing.JLabel();
        senhaLB = new javax.swing.JLabel();
        bairroLB = new javax.swing.JLabel();
        numeroLB = new javax.swing.JLabel();
        cepLB = new javax.swing.JLabel();
        nomeTF = new javax.swing.JTextField();
        cnpjTF = new javax.swing.JTextField();
        senhaTF = new javax.swing.JTextField();
        ruaTF = new javax.swing.JTextField();
        numeroTF = new javax.swing.JTextField();
        bairroTF = new javax.swing.JTextField();
        cepTF = new javax.swing.JTextField();
        painel_cadastrarBTN = new javax.swing.JPanel();
        cadastrarBTN = new javax.swing.JButton();
        painel_do_titulo = new javax.swing.JPanel();
        tituloLB1 = new javax.swing.JLabel();
        tituloLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAiQueFome");
        setResizable(false);

        painel_principal.setBackground(new java.awt.Color(249, 160, 63));

        painel_dados.setBackground(new java.awt.Color(249, 160, 63));

        cnpjLB.setBackground(new java.awt.Color(249, 160, 63));
        cnpjLB.setForeground(new java.awt.Color(255, 255, 255));
        cnpjLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cnpjLB.setText("CNPJ");

        ruaLB.setBackground(new java.awt.Color(249, 160, 63));
        ruaLB.setForeground(new java.awt.Color(255, 255, 255));
        ruaLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ruaLB.setText("Rua");

        nomeLB.setBackground(new java.awt.Color(249, 160, 63));
        nomeLB.setForeground(new java.awt.Color(255, 255, 255));
        nomeLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeLB.setText("Nome");

        senhaLB.setBackground(new java.awt.Color(249, 160, 63));
        senhaLB.setForeground(new java.awt.Color(255, 255, 255));
        senhaLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        senhaLB.setText("Senha");

        bairroLB.setBackground(new java.awt.Color(249, 160, 63));
        bairroLB.setForeground(new java.awt.Color(255, 255, 255));
        bairroLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bairroLB.setText("Bairro");

        numeroLB.setBackground(new java.awt.Color(249, 160, 63));
        numeroLB.setForeground(new java.awt.Color(255, 255, 255));
        numeroLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroLB.setText("Numero");

        cepLB.setBackground(new java.awt.Color(249, 160, 63));
        cepLB.setForeground(new java.awt.Color(255, 255, 255));
        cepLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cepLB.setText("CEP");

        nomeTF.setBackground(java.awt.Color.darkGray);
        nomeTF.setForeground(new java.awt.Color(249, 160, 63));

        cnpjTF.setBackground(java.awt.Color.darkGray);
        cnpjTF.setForeground(new java.awt.Color(249, 160, 63));
        cnpjTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnpjTFKeyTyped(evt);
            }
        });

        senhaTF.setBackground(java.awt.Color.darkGray);
        senhaTF.setForeground(new java.awt.Color(249, 160, 63));

        ruaTF.setBackground(java.awt.Color.darkGray);
        ruaTF.setForeground(new java.awt.Color(249, 160, 63));

        numeroTF.setBackground(java.awt.Color.darkGray);
        numeroTF.setForeground(new java.awt.Color(249, 160, 63));
        numeroTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numeroTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroTFKeyTyped(evt);
            }
        });

        bairroTF.setBackground(java.awt.Color.darkGray);
        bairroTF.setForeground(new java.awt.Color(249, 160, 63));

        cepTF.setBackground(java.awt.Color.darkGray);
        cepTF.setForeground(new java.awt.Color(249, 160, 63));
        cepTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepTFActionPerformed(evt);
            }
        });
        cepTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cepTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cepTFKeyTyped(evt);
            }
        });

        painel_cadastrarBTN.setBackground(new java.awt.Color(249, 160, 63));

        cadastrarBTN.setBackground(java.awt.Color.darkGray);
        cadastrarBTN.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarBTN.setText("Cadastrar");
        cadastrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_cadastrarBTNLayout = new javax.swing.GroupLayout(painel_cadastrarBTN);
        painel_cadastrarBTN.setLayout(painel_cadastrarBTNLayout);
        painel_cadastrarBTNLayout.setHorizontalGroup(
            painel_cadastrarBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_cadastrarBTNLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(cadastrarBTN)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        painel_cadastrarBTNLayout.setVerticalGroup(
            painel_cadastrarBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_cadastrarBTNLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(cadastrarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        painel_do_titulo.setBackground(new java.awt.Color(249, 160, 63));

        tituloLB1.setBackground(new java.awt.Color(255, 125, 0));
        tituloLB1.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        tituloLB1.setForeground(new java.awt.Color(255, 255, 255));
        tituloLB1.setText("Que Fome");

        tituloLB.setBackground(new java.awt.Color(255, 125, 0));
        tituloLB.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        tituloLB.setForeground(new java.awt.Color(255, 255, 255));
        tituloLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLB.setText("UAi");

        javax.swing.GroupLayout painel_do_tituloLayout = new javax.swing.GroupLayout(painel_do_titulo);
        painel_do_titulo.setLayout(painel_do_tituloLayout);
        painel_do_tituloLayout.setHorizontalGroup(
            painel_do_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_do_tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_do_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                        .addComponent(tituloLB)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                        .addComponent(tituloLB1)
                        .addGap(48, 48, 48))))
        );
        painel_do_tituloLayout.setVerticalGroup(
            painel_do_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloLB1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_dadosLayout = new javax.swing.GroupLayout(painel_dados);
        painel_dados.setLayout(painel_dadosLayout);
        painel_dadosLayout.setHorizontalGroup(
            painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_dadosLayout.createSequentialGroup()
                        .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dadosLayout.createSequentialGroup()
                        .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpjLB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ruaLB)
                            .addComponent(bairroLB))
                        .addGap(18, 18, 18)
                        .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cnpjTF)
                            .addComponent(ruaTF)
                            .addComponent(bairroTF, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dadosLayout.createSequentialGroup()
                                .addComponent(senhaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(senhaTF))
                            .addGroup(painel_dadosLayout.createSequentialGroup()
                                .addComponent(numeroLB, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroTF))
                            .addGroup(painel_dadosLayout.createSequentialGroup()
                                .addComponent(cepLB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cepTF, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dadosLayout.createSequentialGroup()
                        .addComponent(painel_cadastrarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dadosLayout.createSequentialGroup()
                        .addComponent(painel_do_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        painel_dadosLayout.setVerticalGroup(
            painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_do_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnpjTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senhaTF)
                    .addComponent(cnpjLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ruaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ruaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numeroLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bairroLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bairroTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cepLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cepTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(painel_cadastrarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        nomeTF.setText(""); //Inicializa o campo de texto vazio
        cnpjTF.setText(""); //Inicializa o campo de texto vazio
        senhaTF.setText(""); //Inicializa o campo de texto vazio
        ruaTF.setText(""); //Inicializa o campo de texto vazio
        numeroTF.setText(""); //Inicializa o campo de texto vazio
        bairroTF.setText(""); //Inicializa o campo de texto vazio
        cepTF.setText(""); //Inicializa o campo de texto vazio

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(painel_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBTNActionPerformed
        boolean cadastro = true; // flag que define se o cadastro pode ser realizado
        if (nomeTF.getText().equals("") || cnpjTF.getText().equals("") || senhaTF.getText().equals("") || ruaTF.getText().equals("") || numeroTF.getText().equals("") || bairroTF.getText().equals("") || cepTF.getText().equals("")) {//verifica se algum campo foi deixado em branco
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso", JOptionPane.PLAIN_MESSAGE);
            cadastro = false;
        }
        if (!Restaurante.validaCnpj(cnpjTF.getText())) { //verifica se o cnpj informado é valido
            JOptionPane.showMessageDialog(null, "O CNPJ deve ser válido!", "Aviso", JOptionPane.PLAIN_MESSAGE);
            cadastro = false;
        }
        if (cepTF.getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "Um Cep deve ter 8 números!", "Aviso", JOptionPane.PLAIN_MESSAGE);
            cadastro = false;
        }
        if (cadastro) { //caso seja possivel é feito o cadastro
            Endereco end = new Endereco(ruaTF.getText(), bairroTF.getText(), Integer.parseInt(numeroTF.getText()), cepTF.getText());
            Restaurante new_Rest = new Restaurante(nomeTF.getText(), cnpjTF.getText(), end, senhaTF.getText());
            JOptionPane.showMessageDialog(null, "Cadastro Feito com sucesso!\nO id de usuário é o CNPJ informado:\n" + new_Rest.getCnpj(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_cadastrarBTNActionPerformed

    private void numeroTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTFKeyReleased
        mascaraInt(numeroTF);
    }//GEN-LAST:event_numeroTFKeyReleased

    private void numeroTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTFKeyTyped
        mascaraInt(numeroTF);
    }//GEN-LAST:event_numeroTFKeyTyped

    private void cepTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cepTFKeyReleased
        mascaraCEP(cepTF);
    }//GEN-LAST:event_cepTFKeyReleased

    private void cepTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cepTFKeyTyped
        mascaraCEP(cepTF);
    }//GEN-LAST:event_cepTFKeyTyped

    private void cepTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepTFActionPerformed

    private void cnpjTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjTFKeyReleased
        mascaraCnpj(cnpjTF);
    }//GEN-LAST:event_cnpjTFKeyReleased

    private void cnpjTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjTFKeyTyped
        mascaraCnpj(cnpjTF);
    }//GEN-LAST:event_cnpjTFKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairroLB;
    private javax.swing.JTextField bairroTF;
    private javax.swing.JButton cadastrarBTN;
    private javax.swing.JLabel cepLB;
    private javax.swing.JTextField cepTF;
    private javax.swing.JLabel cnpjLB;
    private javax.swing.JTextField cnpjTF;
    private javax.swing.JLabel nomeLB;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JLabel numeroLB;
    private javax.swing.JTextField numeroTF;
    private javax.swing.JPanel painel_cadastrarBTN;
    private javax.swing.JPanel painel_dados;
    private javax.swing.JPanel painel_do_titulo;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JLabel ruaLB;
    private javax.swing.JTextField ruaTF;
    private javax.swing.JLabel senhaLB;
    private javax.swing.JTextField senhaTF;
    private javax.swing.JLabel tituloLB;
    private javax.swing.JLabel tituloLB1;
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

    private void mascaraCEP(JTextField textField) {
        //Máscara que aceita apenas 8 números
        String texto = textField.getText();
        if (texto.length() > 0) {
            //Verifica o tamanho da string excedeu 8 caracteres e se o último caractere digitado é um número
            if (texto.length() > 8 || texto.charAt(texto.length() - 1) < '0' || texto.charAt(texto.length() - 1) > '9') {
                //Apaga o caractere digitado
                texto = texto.substring(0, texto.length() - 1);
            }
        }
        textField.setText(texto);
    }

    private void mascaraCnpj(JTextField textField) {
        //Máscara que aceita apenas 14 números
        String texto = textField.getText();
        if (texto.length() > 0) {
            //Verifica o tamanho da string excedeu 14 caracteres e se o último caractere digitado é um número
            if (texto.length() > 14 || texto.charAt(texto.length() - 1) < '0' || texto.charAt(texto.length() - 1) > '9') {
                //Apaga o caractere digitado
                texto = texto.substring(0, texto.length() - 1);
            }
        }
        textField.setText(texto);
    }
}
