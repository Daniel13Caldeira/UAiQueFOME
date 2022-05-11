
package view;


public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cadastro_RestauranteBTN = new javax.swing.JButton();
        loginLB = new javax.swing.JLabel();
        senhaLB = new javax.swing.JLabel();
        loginTF = new javax.swing.JTextField();
        tituloLB = new javax.swing.JLabel();
        senhaPF = new javax.swing.JPasswordField();
        cadastro_ClienteBTN = new javax.swing.JButton();
        loginBTN = new javax.swing.JButton();
        tituloLB1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAiQueFome");
        setPreferredSize(new java.awt.Dimension(704, 486));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 160, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(704, 486));

        cadastro_RestauranteBTN.setBackground(new java.awt.Color(255, 125, 0));
        cadastro_RestauranteBTN.setForeground(new java.awt.Color(255, 255, 255));
        cadastro_RestauranteBTN.setText("Cadastrar Restaurante");

        loginLB.setBackground(new java.awt.Color(255, 125, 0));
        loginLB.setForeground(new java.awt.Color(255, 255, 255));
        loginLB.setText("jLabel1");

        senhaLB.setBackground(new java.awt.Color(255, 125, 0));
        senhaLB.setForeground(new java.awt.Color(255, 255, 255));
        senhaLB.setText("jLabel2");

        loginTF.setForeground(new java.awt.Color(249, 160, 63));
        loginTF.setText("jTextField1");

        tituloLB.setBackground(new java.awt.Color(255, 125, 0));
        tituloLB.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        tituloLB.setForeground(new java.awt.Color(255, 255, 255));
        tituloLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLB.setText("UAi");

        senhaPF.setForeground(new java.awt.Color(249, 160, 63));
        senhaPF.setText("jPasswordField1");

        cadastro_ClienteBTN.setBackground(new java.awt.Color(255, 125, 0));
        cadastro_ClienteBTN.setForeground(new java.awt.Color(255, 255, 255));
        cadastro_ClienteBTN.setText("Cadastrar Cliente");

        loginBTN.setBackground(new java.awt.Color(255, 125, 0));
        loginBTN.setForeground(new java.awt.Color(255, 255, 255));
        loginBTN.setText("Entrar");

        tituloLB1.setBackground(new java.awt.Color(255, 125, 0));
        tituloLB1.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        tituloLB1.setForeground(new java.awt.Color(255, 255, 255));
        tituloLB1.setText("Que Fome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(senhaLB)
                            .addGap(18, 18, 18)
                            .addComponent(senhaPF))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(loginLB)
                            .addGap(18, 18, 18)
                            .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cadastro_ClienteBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastro_RestauranteBTN)))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloLB1)
                    .addComponent(tituloLB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(tituloLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloLB1)
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLB)
                    .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLB)
                    .addComponent(senhaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBTN)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_RestauranteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_ClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBTN;
    private javax.swing.JLabel loginLB;
    private javax.swing.JTextField loginTF;
    private javax.swing.JLabel senhaLB;
    private javax.swing.JPasswordField senhaPF;
    private javax.swing.JLabel tituloLB;
    private javax.swing.JLabel tituloLB1;
    // End of variables declaration//GEN-END:variables
}
