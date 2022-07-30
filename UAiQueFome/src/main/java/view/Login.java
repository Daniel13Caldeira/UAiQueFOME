package view;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private static String user_cod; //Atributo que vai receber o id do usuário logado. 

    //Get do codigo do usuário logado
    protected static String getUser_cod() {
        return user_cod;
    }

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_dos_dados = new javax.swing.JPanel();
        loginLB = new javax.swing.JLabel();
        senhaLB = new javax.swing.JLabel();
        loginTF = new javax.swing.JTextField();
        senhaPF = new javax.swing.JPasswordField();
        painel_do_titulo = new javax.swing.JPanel();
        tituloLB1 = new javax.swing.JLabel();
        tituloLB = new javax.swing.JLabel();
        loginBTN1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cadastroBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAiQueFome");
        setPreferredSize(new java.awt.Dimension(717, 503));
        setResizable(false);

        painel_dos_dados.setBackground(new java.awt.Color(249, 160, 63));

        loginLB.setBackground(new java.awt.Color(255, 125, 0));
        loginLB.setForeground(new java.awt.Color(255, 255, 255));
        loginLB.setText("Usuario");

        senhaLB.setBackground(new java.awt.Color(255, 125, 0));
        senhaLB.setForeground(new java.awt.Color(255, 255, 255));
        senhaLB.setText("Senha");

        loginTF.setForeground(new java.awt.Color(249, 160, 63));
        loginTF.setText("jTextField1");

        senhaPF.setForeground(new java.awt.Color(249, 160, 63));
        senhaPF.setText("jPasswordField1");

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
                .addGap(106, 106, 106)
                .addComponent(tituloLB1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_do_tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLB)
                .addGap(59, 59, 59))
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
        loginBTN1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        loginBTN1.setForeground(new java.awt.Color(255, 255, 255));
        loginBTN1.setText("Entrar");
        loginBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTN1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(249, 160, 63));

        cadastroBTN.setBackground(new java.awt.Color(255, 125, 0));
        cadastroBTN.setForeground(new java.awt.Color(255, 255, 255));
        cadastroBTN.setText("Cadastro");
        cadastroBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cadastroBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cadastroBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_dos_dadosLayout = new javax.swing.GroupLayout(painel_dos_dados);
        painel_dos_dados.setLayout(painel_dos_dadosLayout);
        painel_dos_dadosLayout.setHorizontalGroup(
            painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painel_dos_dadosLayout.createSequentialGroup()
                            .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(senhaLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loginTF, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                .addComponent(senhaPF)))
                        .addComponent(painel_do_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginBTN1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_dos_dadosLayout.setVerticalGroup(
            painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dos_dadosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(painel_do_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLB)
                    .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_dos_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLB)
                    .addComponent(senhaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBTN1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
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

    private void loginBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTN1ActionPerformed
        boolean flag = true; //Flag auxiliar que define a possibilidade de login
        
        //Verifica se o tamanho do id de usuario digitado é diferente de 14 ou 11 , ou se o campo de usuario foi preenchido pela info default. 
        if((loginTF.getText().length() != 11 && loginTF.getText().length() != 14) && !(loginTF.getText().equals("") || loginTF.getText().equals("Campo Obrigatório!")) ){
            JOptionPane.showMessageDialog(null,"Digite um usuário válido!", "Aviso", JOptionPane.PLAIN_MESSAGE, null);
            flag = false;
        }
        //Checa se os campos foram deixados em branco
        if (loginTF.getText().equals("") || loginTF.getText().equals("Campo Obrigatório!")) {
            loginTF.setText("Campo Obrigatório!");
            flag = false;
        }
        if (senhaPF.getText().equals("") || senhaPF.getText().equals("Campo Obrigatório!")) {
            senhaPF.setText("Campo Obrigatório!");
            flag = false;
        }
        if (flag) {
                  
        }


    }//GEN-LAST:event_loginBTN1ActionPerformed

    private void cadastroBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroBTNActionPerformed
        //Define as opções de cadastro.
        String[] options = {"Restaurante", "Cliente"};
        //Indice da opção de cadastro escolhida pelo novo usuário
        int op = JOptionPane.showOptionDialog(null, "Selecione o tipo de Cadastro do novo usuário", "Opções de Cadastro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        //Encaminhamento adequado para as telas de cadastro
        switch (op) {
            case 0:
            setVisible(false);
            new CadastroRestaurante().setVisible(true);
            break;
            case 1:
            setVisible(false);
            new CadastroCliente().setVisible(true);
            default:
            break;
        }
    }//GEN-LAST:event_cadastroBTNActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroBTN;
    private javax.swing.JPanel jPanel1;
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
