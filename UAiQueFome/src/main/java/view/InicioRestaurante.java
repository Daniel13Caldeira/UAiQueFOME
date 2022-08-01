package view;

import Controller.Endereco;
import Controller.Pedido;
import Controller.Produto;
import Controller.Restaurante;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InicioRestaurante extends javax.swing.JFrame {

    private static String id_prod;
    private final Restaurante aux_rest = new Restaurante(Login.getUser_cod());//declara um objeto com o id do usuario logado

    public static String getId_prod() {
        return id_prod;
    }

    public InicioRestaurante() {
        initComponents();
        preencherTabListProd();
        preencherTabListPedAbertos();
        preencherTabVendas();
        //bloqueia a edição do nome e cnpj;
        nomeTF.setEnabled(false);
        cnpjTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        painel_aux = new javax.swing.JPanel();
        inicio_rest = new javax.swing.JTabbedPane();
        lista_de_produtos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_prodTB = new javax.swing.JTable();
        painel_buttons = new javax.swing.JPanel();
        add_prod = new javax.swing.JButton();
        remove_prod = new javax.swing.JButton();
        edit_prod = new javax.swing.JButton();
        painel_pedidosAbertos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_pedidosAbertTB = new javax.swing.JTable();
        painel_buttonsPed = new javax.swing.JPanel();
        remove_ped = new javax.swing.JButton();
        finalize_ped = new javax.swing.JButton();
        painel_vendas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_vendasTB = new javax.swing.JTable();
        painel_buttonsV = new javax.swing.JPanel();
        vizualizarPedBTN = new javax.swing.JButton();
        painel_perfil = new javax.swing.JPanel();
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
        painel_buttonsPf = new javax.swing.JPanel();
        edit_BTN = new javax.swing.JButton();
        sairBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAiQueFome");
        setResizable(false);

        painel_principal.setBackground(new java.awt.Color(249, 160, 63));

        painel_aux.setBackground(new java.awt.Color(249, 160, 63));
        painel_aux.setPreferredSize(new java.awt.Dimension(717, 503));

        inicio_rest.setBackground(java.awt.Color.darkGray);
        inicio_rest.setForeground(new java.awt.Color(255, 255, 255));
        inicio_rest.setToolTipText("Historico de Compras");
        inicio_rest.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);

        lista_de_produtos.setBackground(new java.awt.Color(249, 160, 63));

        list_prodTB.setBackground(java.awt.Color.darkGray);
        list_prodTB.setForeground(new java.awt.Color(255, 255, 255));
        list_prodTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preco", "Quantidade", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(list_prodTB);

        painel_buttons.setBackground(new java.awt.Color(249, 160, 63));

        add_prod.setBackground(java.awt.Color.darkGray);
        add_prod.setForeground(new java.awt.Color(255, 255, 255));
        add_prod.setText("Adicionar Produto");
        add_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_prodActionPerformed(evt);
            }
        });

        remove_prod.setBackground(java.awt.Color.darkGray);
        remove_prod.setForeground(new java.awt.Color(255, 255, 255));
        remove_prod.setText("Remover Produto");
        remove_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_prodActionPerformed(evt);
            }
        });

        edit_prod.setBackground(java.awt.Color.darkGray);
        edit_prod.setForeground(new java.awt.Color(255, 255, 255));
        edit_prod.setText("Editar Produto");
        edit_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_prodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_buttonsLayout = new javax.swing.GroupLayout(painel_buttons);
        painel_buttons.setLayout(painel_buttonsLayout);
        painel_buttonsLayout.setHorizontalGroup(
            painel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_prod, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(remove_prod, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(edit_prod, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        painel_buttonsLayout.setVerticalGroup(
            painel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_buttonsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(add_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remove_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lista_de_produtosLayout = new javax.swing.GroupLayout(lista_de_produtos);
        lista_de_produtos.setLayout(lista_de_produtosLayout);
        lista_de_produtosLayout.setHorizontalGroup(
            lista_de_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lista_de_produtosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painel_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lista_de_produtosLayout.setVerticalGroup(
            lista_de_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
            .addGroup(lista_de_produtosLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(painel_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inicio_rest.addTab("Lista de Produtos", lista_de_produtos);

        painel_pedidosAbertos.setBackground(new java.awt.Color(249, 160, 63));

        list_pedidosAbertTB.setBackground(java.awt.Color.darkGray);
        list_pedidosAbertTB.setForeground(new java.awt.Color(255, 255, 255));
        list_pedidosAbertTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(list_pedidosAbertTB);

        painel_buttonsPed.setBackground(new java.awt.Color(249, 160, 63));

        remove_ped.setBackground(java.awt.Color.darkGray);
        remove_ped.setForeground(new java.awt.Color(255, 255, 255));
        remove_ped.setText("Remover Pedido");
        remove_ped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_pedActionPerformed(evt);
            }
        });

        finalize_ped.setBackground(java.awt.Color.darkGray);
        finalize_ped.setForeground(new java.awt.Color(255, 255, 255));
        finalize_ped.setText("Finalizar Pedido");
        finalize_ped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalize_pedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_buttonsPedLayout = new javax.swing.GroupLayout(painel_buttonsPed);
        painel_buttonsPed.setLayout(painel_buttonsPedLayout);
        painel_buttonsPedLayout.setHorizontalGroup(
            painel_buttonsPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_buttonsPedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(remove_ped, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painel_buttonsPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painel_buttonsPedLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(finalize_ped, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painel_buttonsPedLayout.setVerticalGroup(
            painel_buttonsPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_buttonsPedLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(remove_ped, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(painel_buttonsPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painel_buttonsPedLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(finalize_ped, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(85, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout painel_pedidosAbertosLayout = new javax.swing.GroupLayout(painel_pedidosAbertos);
        painel_pedidosAbertos.setLayout(painel_pedidosAbertosLayout);
        painel_pedidosAbertosLayout.setHorizontalGroup(
            painel_pedidosAbertosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_pedidosAbertosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painel_buttonsPed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        painel_pedidosAbertosLayout.setVerticalGroup(
            painel_pedidosAbertosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(painel_pedidosAbertosLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(painel_buttonsPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inicio_rest.addTab("Pedidos Em Andamento", painel_pedidosAbertos);

        painel_vendas.setBackground(new java.awt.Color(249, 160, 63));

        list_vendasTB.setBackground(java.awt.Color.darkGray);
        list_vendasTB.setForeground(new java.awt.Color(255, 255, 255));
        list_vendasTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(list_vendasTB);

        painel_buttonsV.setBackground(new java.awt.Color(249, 160, 63));

        vizualizarPedBTN.setBackground(java.awt.Color.darkGray);
        vizualizarPedBTN.setForeground(new java.awt.Color(255, 255, 255));
        vizualizarPedBTN.setText("Vizualizar Pedido");
        vizualizarPedBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizualizarPedBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_buttonsVLayout = new javax.swing.GroupLayout(painel_buttonsV);
        painel_buttonsV.setLayout(painel_buttonsVLayout);
        painel_buttonsVLayout.setHorizontalGroup(
            painel_buttonsVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_buttonsVLayout.createSequentialGroup()
                .addComponent(vizualizarPedBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel_buttonsVLayout.setVerticalGroup(
            painel_buttonsVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_buttonsVLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(vizualizarPedBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout painel_vendasLayout = new javax.swing.GroupLayout(painel_vendas);
        painel_vendas.setLayout(painel_vendasLayout);
        painel_vendasLayout.setHorizontalGroup(
            painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_vendasLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(painel_buttonsV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painel_vendasLayout.setVerticalGroup(
            painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
            .addGroup(painel_vendasLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(painel_buttonsV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inicio_rest.addTab("Historico de vendas", painel_vendas);

        painel_perfil.setBackground(new java.awt.Color(249, 160, 63));

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
        nomeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTFActionPerformed(evt);
            }
        });

        cnpjTF.setBackground(java.awt.Color.darkGray);
        cnpjTF.setForeground(new java.awt.Color(249, 160, 63));

        senhaTF.setBackground(java.awt.Color.darkGray);
        senhaTF.setForeground(new java.awt.Color(249, 160, 63));

        ruaTF.setBackground(java.awt.Color.darkGray);
        ruaTF.setForeground(new java.awt.Color(249, 160, 63));

        numeroTF.setBackground(java.awt.Color.darkGray);
        numeroTF.setForeground(new java.awt.Color(249, 160, 63));
        numeroTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroTFActionPerformed(evt);
            }
        });
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
        cepTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cepTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cepTFKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painel_dadosLayout = new javax.swing.GroupLayout(painel_dados);
        painel_dados.setLayout(painel_dadosLayout);
        painel_dadosLayout.setHorizontalGroup(
            painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dadosLayout.createSequentialGroup()
                .addContainerGap()
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
                            .addComponent(cnpjTF, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(ruaTF)
                            .addComponent(bairroTF))
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
                                .addComponent(cepTF)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        painel_dadosLayout.setVerticalGroup(
            painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dadosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dadosLayout.createSequentialGroup()
                        .addComponent(cnpjLB, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(painel_dadosLayout.createSequentialGroup()
                        .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnpjTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(senhaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)))
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ruaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ruaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numeroLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bairroLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bairroTF)
                        .addComponent(cepLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cepTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );

        nomeTF.setText(aux_rest.getNome());//busca o nome do restaurante
        cnpjTF.setText(aux_rest.getCnpj());//busca o cnpj do restaurante
        senhaTF.setText(aux_rest.getSenha());//busca a senha do restaurante
        ruaTF.setText(aux_rest.getEndereco().getRua());//busca a rua do restaurante
        numeroTF.setText(String.valueOf(aux_rest.getEndereco().getNumero()));//busca o número do restaurante
        bairroTF.setText(aux_rest.getEndereco().getBairro());//busca o bairro do restaurante
        cepTF.setText(aux_rest.getEndereco().getCep());//busca o cep do restaurante

        painel_buttonsPf.setBackground(new java.awt.Color(249, 160, 63));

        edit_BTN.setBackground(java.awt.Color.darkGray);
        edit_BTN.setForeground(new java.awt.Color(255, 255, 255));
        edit_BTN.setText("Editar Perfil");
        edit_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_BTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_buttonsPfLayout = new javax.swing.GroupLayout(painel_buttonsPf);
        painel_buttonsPf.setLayout(painel_buttonsPfLayout);
        painel_buttonsPfLayout.setHorizontalGroup(
            painel_buttonsPfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        painel_buttonsPfLayout.setVerticalGroup(
            painel_buttonsPfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_buttonsPfLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edit_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout painel_perfilLayout = new javax.swing.GroupLayout(painel_perfil);
        painel_perfil.setLayout(painel_perfilLayout);
        painel_perfilLayout.setHorizontalGroup(
            painel_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_perfilLayout.createSequentialGroup()
                .addGap(599, 599, 599)
                .addComponent(painel_buttonsPf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(painel_perfilLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(painel_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_perfilLayout.setVerticalGroup(
            painel_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_perfilLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(painel_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painel_buttonsPf, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        inicio_rest.addTab("Perfil", painel_perfil);

        sairBTN.setBackground(java.awt.Color.darkGray);
        sairBTN.setForeground(new java.awt.Color(255, 255, 255));
        sairBTN.setText("Sair");
        sairBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_auxLayout = new javax.swing.GroupLayout(painel_aux);
        painel_aux.setLayout(painel_auxLayout);
        painel_auxLayout.setHorizontalGroup(
            painel_auxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio_rest)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_auxLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sairBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painel_auxLayout.setVerticalGroup(
            painel_auxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_auxLayout.createSequentialGroup()
                .addComponent(sairBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicio_rest, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_aux, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_principalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(painel_aux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void finalize_pedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalize_pedActionPerformed
        if (list_pedidosAbertTB.getSelectedRow() != -1) {//verifica se alguma linha foi selecionada
            String cod_ped = list_pedidosAbertTB.getValueAt(list_pedidosAbertTB.getSelectedRow(), 0).toString();//guarda o codigo do pedido selecionado
            ArrayList<Pedido> list_pedidos = aux_rest.getPedidos();//lista de pedidos do rest
            int k = -1;//variavel que vai guarda indice do pedido alvo
            for (int i = 0; i < list_pedidos.size(); i++) {//loop que procura o pedido alvo
                if (list_pedidos.get(i).getCodigo().equals(cod_ped)) {//guarda o indice do pedido alvo
                    k = i;
                    break;
                }
            }
            if (k != -1) {
                //finaliza o pedido alvo e após isso remove da tabela
                aux_rest.finalizarPedido(list_pedidos.get(k));
                DefaultTableModel defaultTablemodel = (DefaultTableModel) list_pedidosAbertTB.getModel();
                defaultTablemodel.removeRow(list_pedidosAbertTB.getSelectedRow());
                atualizaTabVendas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_finalize_pedActionPerformed

    private void edit_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_BTNActionPerformed
        boolean flag = true; //flag que vai verificar a possibilidade de edição
        if (senhaTF.getText().equals("")) {//verifica se algum campo editavel está vazio
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso!", JOptionPane.PLAIN_MESSAGE);
            flag = false;
        }
        if (ruaTF.getText().equals("") || bairroTF.getText().equals("") || numeroTF.getText().equals("") || cepTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso!", JOptionPane.PLAIN_MESSAGE);
            flag = false;
        }
        if (flag) {
            Endereco new_end = new Endereco(ruaTF.getText(), bairroTF.getText(), Integer.parseInt(numeroTF.getText()), cepTF.getText());
            aux_rest.setEndereco(new_end);
            if (!senhaTF.getText().equals(aux_rest.getSenha())) {
                aux_rest.setSenha(senhaTF.getText());
            }
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Aviso!", JOptionPane.PLAIN_MESSAGE);
            atualizaDados();
        }
    }//GEN-LAST:event_edit_BTNActionPerformed

    private void remove_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_prodActionPerformed
        if (list_prodTB.getSelectedRow() != -1) { //verifica se alguma linha foi selecionada
            DefaultTableModel defaultTablemodel = (DefaultTableModel) list_prodTB.getModel();
            String cod_prod = list_prodTB.getValueAt(list_prodTB.getSelectedRow(), 3).toString();
            defaultTablemodel.removeRow(list_prodTB.getSelectedRow());
            aux_rest.removeProduto(cod_prod);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_remove_prodActionPerformed

    private void add_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_prodActionPerformed
        setVisible(false);
        new CadastroProduto().setVisible(true);
    }//GEN-LAST:event_add_prodActionPerformed

    private void sairBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBTNActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_sairBTNActionPerformed

    private void edit_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_prodActionPerformed
        if (list_prodTB.getSelectedRow() != -1) {//verifica se alguma linha foi selecionada
            id_prod = list_prodTB.getValueAt(list_prodTB.getSelectedRow(), 3).toString();//atuliza a variavel com o valor do id do produto da linha selecionada
            String prod = aux_rest.findProduto(id_prod);//string com todos os atributos do produto
            String[] atributos_Prod = prod.split(";");//separa a linha de atributos em um vetor de string
            if (Float.parseFloat(atributos_Prod[3]) != -1.0) {//verifica se o produto está em promoção
                JOptionPane.showMessageDialog(null, "Produto está em promoção!\nPara retirar a promoção sem alterar o preço antigo selecione o botão Preço Normal e aperte Editar.\nCaso deseje alterar o preço Promocional ou Normal prossiga com a edição normalmente.", "Aviso!", JOptionPane.PLAIN_MESSAGE);
            }
            //encaminha para a tela de edição do produto
            setVisible(false);
            new EditarProduto().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_edit_prodActionPerformed

    private void nomeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTFActionPerformed

    private void numeroTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTFKeyReleased
        mascaraInt(numeroTF);
    }//GEN-LAST:event_numeroTFKeyReleased

    private void numeroTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTFKeyTyped
        mascaraInt(numeroTF);
    }//GEN-LAST:event_numeroTFKeyTyped

    private void numeroTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroTFActionPerformed

    }//GEN-LAST:event_numeroTFActionPerformed

    private void vizualizarPedBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizualizarPedBTNActionPerformed
        if (list_vendasTB.getSelectedRow() != -1) {
            String cod_ped = list_vendasTB.getValueAt(list_vendasTB.getSelectedRow(), 0).toString();
            ArrayList<Pedido> list_pedidos = aux_rest.getPedidos();//lista de pedidos do rest
            int k = -1;//variavel que vai guarda indice do pedido alvo
            for (int i = 0; i < list_pedidos.size(); i++) {//loop que procura o pedido alvo
                if (list_pedidos.get(i).getCodigo().equals(cod_ped)) {//guarda o indice do pedido alvo
                    k = i;
                    break;
                }
            }
            if (k != -1) {
                //definição dos textos usados no Cupom fiscal do pedido selecionado
                String titulo = "Dados do Pedido: " + list_pedidos.get(k).getCodigo();
                ArrayList<Produto> aux_ProdutosPed = list_pedidos.get(k).getProdutos();
                String header = "Codigo\tNome\tQuantidade\tPreço\n";
                String msg = header + "";
                for (Produto aux_ProdutosPed1 : aux_ProdutosPed) {//preenche a mensagem com os produtos do pedido
                    msg = msg + aux_ProdutosPed1.getCodigo() + "\t" + aux_ProdutosPed1.getNome() + "\t" + aux_ProdutosPed1.getQuantidade() + "\t" + aux_ProdutosPed1.getPreco() + "\n";
                }
                String fim = "Valor Total: " + list_pedidos.get(k).getValorTotal();
                msg = msg + fim;
                JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_vizualizarPedBTNActionPerformed

    private void remove_pedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_pedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remove_pedActionPerformed

    private void cepTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cepTFKeyReleased
        mascaraCEP(cepTF);
    }//GEN-LAST:event_cepTFKeyReleased

    private void cepTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cepTFKeyTyped
        mascaraCEP(cepTF);
    }//GEN-LAST:event_cepTFKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_prod;
    private javax.swing.JLabel bairroLB;
    private javax.swing.JTextField bairroTF;
    private javax.swing.JLabel cepLB;
    private javax.swing.JTextField cepTF;
    private javax.swing.JLabel cnpjLB;
    private javax.swing.JTextField cnpjTF;
    private javax.swing.JButton edit_BTN;
    private javax.swing.JButton edit_prod;
    private javax.swing.JButton finalize_ped;
    private javax.swing.JTabbedPane inicio_rest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable list_pedidosAbertTB;
    private javax.swing.JTable list_prodTB;
    private javax.swing.JTable list_vendasTB;
    private javax.swing.JPanel lista_de_produtos;
    private javax.swing.JLabel nomeLB;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JLabel numeroLB;
    private javax.swing.JTextField numeroTF;
    private javax.swing.JPanel painel_aux;
    private javax.swing.JPanel painel_buttons;
    private javax.swing.JPanel painel_buttonsPed;
    private javax.swing.JPanel painel_buttonsPf;
    private javax.swing.JPanel painel_buttonsV;
    private javax.swing.JPanel painel_dados;
    private javax.swing.JPanel painel_pedidosAbertos;
    private javax.swing.JPanel painel_perfil;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JPanel painel_vendas;
    private javax.swing.JButton remove_ped;
    private javax.swing.JButton remove_prod;
    private javax.swing.JLabel ruaLB;
    private javax.swing.JTextField ruaTF;
    private javax.swing.JButton sairBTN;
    private javax.swing.JLabel senhaLB;
    private javax.swing.JTextField senhaTF;
    private javax.swing.JButton vizualizarPedBTN;
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

    private void preencherTabListProd() {
        ArrayList<Produto> list_Prod = new ArrayList<>(); //lista de produtos
        list_Prod = aux_rest.getProdutos();
        DefaultTableModel model = (DefaultTableModel) list_prodTB.getModel();
        for (int i = 0; i < list_Prod.size(); i++) { //loop que preenche a tabela com os produtos, um em cada linha
            Object[] linha = {list_Prod.get(i).getNome(), list_Prod.get(i).getPreco(), list_Prod.get(i).getQuantidade(), list_Prod.get(i).getCodigo()};
            model.addRow(linha);
        }
        //Os passos abaixo mudam a cor do header da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.DARK_GRAY);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < list_prodTB.getModel().getColumnCount(); i++) {
            list_prodTB.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    private void preencherTabListPedAbertos() {
        ArrayList<Pedido> list_pedidos = aux_rest.getPedidos();//lista de todos os pedidos associados ao restaurantes
        DefaultTableModel model = (DefaultTableModel) list_pedidosAbertTB.getModel();
        for (int i = 0; i < list_pedidos.size(); i++) { //loop que preenche a tabela com os pedidos em aberto um em cada linha
            if (!list_pedidos.get(i).getStatus().equals("finalizado")) {
                Object[] linha = {list_pedidos.get(i).getCodigo(), list_pedidos.get(i).getCliente(), list_pedidos.get(i).getValorTotal()};
                model.addRow(linha);
            }
        }
        //Os passos abaixo mudam a cor do header da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.DARK_GRAY);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < list_pedidosAbertTB.getModel().getColumnCount(); i++) {
            list_pedidosAbertTB.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    private void atualizaTabVendas() {
        ((DefaultTableModel) list_vendasTB.getModel()).setRowCount(0);
        preencherTabVendas();
    }

    private void preencherTabVendas() {
        ArrayList<Pedido> list_pedidos = aux_rest.getPedidos();//lista de todos os pedidos associados ao restaurantes
        DefaultTableModel model = (DefaultTableModel) list_vendasTB.getModel();
        for (int i = 0; i < list_pedidos.size(); i++) { //loop que preenche a tabela com os pedidos finalizados um em cada linha
            if (list_pedidos.get(i).getStatus().equals("finalizado")) {
                Object[] linha = {list_pedidos.get(i).getCodigo(), list_pedidos.get(i).getCliente(), list_pedidos.get(i).getValorTotal()};
                model.addRow(linha);
            }
        }
        //Os passos abaixo mudam a cor do header da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.DARK_GRAY);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < list_vendasTB.getModel().getColumnCount(); i++) {
            list_vendasTB.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    private void atualizaDados() {
        senhaTF.setText(aux_rest.getSenha());
        Endereco end = aux_rest.getEndereco();
        bairroTF.setText(end.getBairro());
        numeroTF.setText(String.valueOf(end.getNumero()));
        cepTF.setText(end.getCep());
        ruaTF.setText(end.getRua());
    }
}
