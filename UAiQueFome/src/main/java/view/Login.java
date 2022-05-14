
package view;


public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_dos_dados = new javax.swing.JPanel();
        cadastro_RestauranteBTN = new javax.swing.JButton();
        loginLB = new javax.swing.JLabel();
        senhaLB = new javax.swing.JLabel();
        loginTF = new javax.swing.JTextField();
        senhaPF = new javax.swing.JPasswordField();
        cadastro_ClienteBTN = new javax.swing.JButton();
        loginBTN = new javax.swing.JButton();
        painel_do_titulo = new javax.swing.JPanel();
        tituloLB1 = new javax.swing.JLabel();
        tituloLB = new javax.swing.JLabel();
        loginBTN1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAiQueFome");
        setPreferredSize(new java.awt.Dimension(717, 503));
        setResizable(false);

        painel_dos_dados.setBackground(new java.awt.Color(249, 160, 63));

        cadastro_RestauranteBTN.setBackground(new java.awt.Color(255, 125, 0));
        cadastro_RestauranteBTN.setForeground(new java.awt.Color(255, 255, 255));
        cadastro_RestauranteBTN.setText("Cadastrar Restaurante");
        cadastro_RestauranteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_RestauranteBTNActionPerformed(evt);
            }
        });

        loginLB.setBackground(new java.awt.Color(255, 125, 0));
        loginLB.setForeground(new java.awt.Color(255, 255, 255));
        loginLB.setText("jLabel1");

        senhaLB.setBackground(new java.awt.Color(255, 125, 0));
        senhaLB.setForeground(new java.awt.Color(255, 255, 255));
        senhaLB.setText("jLabel2");

        loginTF.setForeground(new java.awt.Color(249, 160, 63));
        loginTF.setText("jTextField1");

        senhaPF.setForeground(new java.awt.Color(249, 160, 63));
        senhaPF.setText("jPasswordField1");

        cadastro_ClienteBTN.setBackground(new java.awt.Color(255, 125, 0));
        cadastro_ClienteBTN.setForeground(new java.awt.Color(255, 255, 255));
        cadastro_ClienteBTN.setText("Cadastrar Cliente");
        cadastro_ClienteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_ClienteBTNActionPerformed(evt);
            }
        });

        loginBTN.setBackground(new java.awt.Color(255, 125, 0));
        loginBTN.setForeground(new java.awt.Color(255, 255, 255));
        loginBTN.setText("Entrar Restaurante");
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });

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
                .addGap(47, 47, 47)
                .addGroup(painel_do_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                        .addComponent(tituloLB1)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                        .addComponent(tituloLB)
                        .addGap(100, 100, 100))))
        );
        painel_do_tituloLayout.setVerticalGroup(
            painel_do_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(tituloLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloLB1)
                .addGap(23, 23, 23))
        );

        loginBTN1.setBackground(new java.awt.Color(255, 125, 0));
        loginBTN1.setForeground(new java.awt.Color(255, 255, 255));
        loginBTN1.setText("Entrar Cliente");
        loginBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dos_dadosLayout = new javax.swing.GroupLayout(painel_dos_dados);
        painel_dos_dados.setLayout(painel_dos_dadosLayout);
        painel_dos_dadosLayout.setHorizontalGroup(
            painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                        .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                                        .addComponent(senhaLB)
                                        .addGap(18, 18, 18)
                                        .addComponent(senhaPF))
                                    .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                                        .addComponent(loginLB)
                                        .addGap(18, 18, 18)
                                        .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dos_dadosLayout.createSequentialGroup()
                                    .addComponent(cadastro_ClienteBTN)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_RestauranteBTN)))
                            .addComponent(painel_do_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(191, Short.MAX_VALUE))
                    .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                        .addComponent(loginBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBTN1)
                        .addGap(183, 183, 183))))
        );
        painel_dos_dadosLayout.setVerticalGroup(
            painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dos_dadosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(painel_do_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLB)
                    .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLB)
                    .addComponent(senhaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBTN)
                    .addComponent(loginBTN1))
                .addGap(36, 36, 36)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_RestauranteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_ClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_dos_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_dos_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_RestauranteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_RestauranteBTNActionPerformed
        setVisible(false);
        new CadastroRestaurante().setVisible(true);
    }//GEN-LAST:event_cadastro_RestauranteBTNActionPerformed

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        setVisible(false);
        new InicioRestaurante().setVisible(true);
    }//GEN-LAST:event_loginBTNActionPerformed

    private void loginBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTN1ActionPerformed
        setVisible(false);
        new InicioCliente().setVisible(true);
    }//GEN-LAST:event_loginBTN1ActionPerformed

    private void cadastro_ClienteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_ClienteBTNActionPerformed
        setVisible(false);
        new CadastroCliente().setVisible(true);
    }//GEN-LAST:event_cadastro_ClienteBTNActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastro_ClienteBTN;
    private javax.swing.JButton cadastro_RestauranteBTN;
    private javax.swing.JButton loginBTN;
    private javax.swing.JButton loginBTN1;
    private javax.swing.JLabel loginLB;
    private javax.swing.JTextField loginTF;
    private javax.swing.JPanel painel_do_titulo;
    private javax.swing.JPanel painel_dos_dados;
    private javax.swing.JLabel senhaLB;
    private javax.swing.JPasswordField senhaPF;
    private javax.swing.JLabel tituloLB;
    private javax.swing.JLabel tituloLB1;
    // End of variables declaration//GEN-END:variables
}
