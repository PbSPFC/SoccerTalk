package soccer.talk;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CriarFrame extends javax.swing.JFrame {

    public CriarFrame() {
        initComponents();
        try (Connection con = DriverManager.getConnection(LoginFrame.url, "scott", "tiger")){
            LoginFrame.clienteConta = LoginFrame.lerContas(con);
        } catch (SQLException ex) {
            Logger.getLogger(CriarFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTime = new javax.swing.ButtonGroup();
        bgSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblSenhaConfirm = new javax.swing.JLabel();
        lblLoginConfirm = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtSenhaConfirm = new javax.swing.JPasswordField();
        lblLoginInvalido = new javax.swing.JLabel();
        lblConfirm = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbFem = new javax.swing.JRadioButton();
        rbMasc = new javax.swing.JRadioButton();
        lblSexoTimeConfirm = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        panelTime = new javax.swing.JPanel();
        rbSFC = new javax.swing.JRadioButton();
        rbSPFC = new javax.swing.JRadioButton();
        rbSCCP = new javax.swing.JRadioButton();
        rbSEP = new javax.swing.JRadioButton();
        pnTime = new javax.swing.JPanel();
        imgTime = new javax.swing.JLabel();
        btnCriar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txtCelConfirm = new javax.swing.JFormattedTextField();
        txtCelular1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soccer Talk - Criar conta");
        setForeground(new java.awt.Color(51, 255, 51));
        setMaximumSize(new java.awt.Dimension(320, 480));
        setMinimumSize(new java.awt.Dimension(320, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(320, 480));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 102)));

        lblLogin.setBackground(new java.awt.Color(255, 255, 255));
        lblLogin.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblLogin.setText("Tel Celular:");

        lblSenha.setBackground(new java.awt.Color(255, 255, 255));
        lblSenha.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblSenha.setText("Senha:");

        lblSenhaConfirm.setBackground(new java.awt.Color(255, 255, 255));
        lblSenhaConfirm.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblSenhaConfirm.setText("Confirmar Senha: ");

        lblLoginConfirm.setBackground(new java.awt.Color(255, 255, 255));
        lblLoginConfirm.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblLoginConfirm.setText("Confirmar Tel: ");

        lblLoginInvalido.setBackground(new java.awt.Color(255, 255, 255));
        lblLoginInvalido.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLoginInvalido.setForeground(new java.awt.Color(255, 0, 0));

        lblConfirm.setBackground(new java.awt.Color(255, 255, 255));
        lblConfirm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblConfirm.setForeground(new java.awt.Color(255, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 102)), "Sexo:"));
        jPanel2.setToolTipText("");

        rbFem.setBackground(new java.awt.Color(255, 255, 255));
        bgSexo.add(rbFem);
        rbFem.setText("Feminino");

        rbMasc.setBackground(new java.awt.Color(255, 255, 255));
        bgSexo.add(rbMasc);
        rbMasc.setText("Masculino");

        lblSexoTimeConfirm.setBackground(new java.awt.Color(255, 255, 255));
        lblSexoTimeConfirm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblSexoTimeConfirm.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbMasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSexoTimeConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbFem)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSexoTimeConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbMasc)
                        .addComponent(rbFem)))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblNome.setText("Nome (Apelido): ");

        panelTime.setBackground(new java.awt.Color(255, 255, 255));
        panelTime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 102)), "Escolha seu Time:"));

        rbSFC.setBackground(new java.awt.Color(255, 255, 255));
        bgTime.add(rbSFC);
        rbSFC.setForeground(new java.awt.Color(102, 102, 102));
        rbSFC.setText("Santos F.C");
        rbSFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSFCActionPerformed(evt);
            }
        });

        rbSPFC.setBackground(new java.awt.Color(255, 255, 255));
        bgTime.add(rbSPFC);
        rbSPFC.setForeground(new java.awt.Color(255, 0, 0));
        rbSPFC.setText("São Paulo F.C");
        rbSPFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSPFCActionPerformed(evt);
            }
        });

        rbSCCP.setBackground(new java.awt.Color(255, 255, 255));
        bgTime.add(rbSCCP);
        rbSCCP.setText("S.C.Corinthians P.");
        rbSCCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSCCPActionPerformed(evt);
            }
        });

        rbSEP.setBackground(new java.awt.Color(255, 255, 255));
        bgTime.add(rbSEP);
        rbSEP.setForeground(new java.awt.Color(0, 102, 0));
        rbSEP.setText("S.E.Palmeiras");
        rbSEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSEPActionPerformed(evt);
            }
        });

        pnTime.setBackground(new java.awt.Color(255, 255, 255));
        pnTime.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 0)));
        pnTime.setMaximumSize(new java.awt.Dimension(110, 110));
        pnTime.setMinimumSize(new java.awt.Dimension(110, 110));

        javax.swing.GroupLayout pnTimeLayout = new javax.swing.GroupLayout(pnTime);
        pnTime.setLayout(pnTimeLayout);
        pnTimeLayout.setHorizontalGroup(
            pnTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnTimeLayout.setVerticalGroup(
            pnTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelTimeLayout = new javax.swing.GroupLayout(panelTime);
        panelTime.setLayout(panelTimeLayout);
        panelTimeLayout.setHorizontalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbSFC)
                    .addComponent(rbSPFC)
                    .addComponent(rbSCCP)
                    .addComponent(rbSEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(pnTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTimeLayout.setVerticalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbSFC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSPFC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSCCP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSEP))
        );

        btnCriar.setBackground(new java.awt.Color(255, 255, 0));
        btnCriar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCriar.setText("Criar Conta");
        btnCriar.setBorder(new javax.swing.border.MatteBorder(null));
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 0, 0));
        btnLimpar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorder(new javax.swing.border.MatteBorder(null));
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        try {
            txtCelConfirm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCelular1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLoginInvalido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLoginConfirm)
                                    .addComponent(lblSenhaConfirm)
                                    .addComponent(lblNome))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSenhaConfirm)
                                    .addComponent(txtNome)
                                    .addComponent(txtCelConfirm)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblConfirm)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblLogin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lblSenha)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblLoginInvalido, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoginConfirm)
                    .addComponent(txtCelConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaConfirm)
                    .addComponent(txtSenhaConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair)
                    .addComponent(btnLimpar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        try (Connection con = DriverManager.getConnection(LoginFrame.url, "scott", "tiger")) {
            LoginFrame.clienteConta = LoginFrame.lerContas(con);
            boolean vCelular = false, vSenha = false, vNome = false, vSexo = false, vTime = false;
            String sexo = "", time = "";

            lblConfirm.setText("");
            lblSexoTimeConfirm.setText("");
            lblLoginInvalido.setText("");

            if (!(txtCelConfirm.getText().equals(txtCelConfirm.getText()))) {
                lblConfirm.setText("Celular ou senha diferentes da confirmação, digite novamente!");
                vCelular = false;
            } else {
                vCelular = true;
            }

            if (!(txtSenha.getText().equals(txtSenhaConfirm.getText()))) {
                lblConfirm.setText("Celular ou senha diferentes da confirmação, digite novamente!");
                vSenha = false;
            } else {
                vSenha = true;
            }

            if (txtNome.equals("")) {
                lblSexoTimeConfirm.setText("Preencha o nome!");
                vNome = false;
            } else {
                vNome = true;
            }

            if (rbSFC.isSelected()) {
                time = "SFC";
                vTime = true;
            } else if (rbSPFC.isSelected()) {
                time = "SPFC";
                vTime = true;
            } else if (rbSCCP.isSelected()) {
                time = "SCCP";
                vTime = true;
            } else if (rbSEP.isSelected()) {
                time = "SEP";
                vTime = true;
            } else {
                lblSexoTimeConfirm.setText("Defina seu time do coração!");
                vTime = false;
            }

            if (rbMasc.isSelected()) {
                sexo = "Masculino";
                vSexo = true;
            } else if (rbFem.isSelected()) {
                sexo = "Feminino";
                vSexo = true;
            } else {
                lblSexoTimeConfirm.setText("Defina seu sexo!");
                vSexo = false;
            }

            for (ClienteConta conta : LoginFrame.clienteConta) {
                if (conta.getNome().equals(txtNome.getText())) {
                    lblSexoTimeConfirm.setText("Nome existente, tente outro nome!");
                    vCelular = false;
                } else {
                    vCelular = true;
                }
            }

            for (ClienteConta conta : LoginFrame.clienteConta) {
                if (conta.getCelular().equals(txtCelConfirm.getText())) {
                    lblLoginInvalido.setText("Celular existente, por favor tente outro login!");
                    vCelular = false;
                } else {
                    vCelular = true;
                }
            }

            if (txtCelConfirm.getText().isEmpty() || txtCelConfirm.getText().equals("")) {
                lblConfirm.setText("Celular ou senha diferentes da confirmação, digite novamente!");
                vCelular = false;
            } else if (txtCelConfirm.getText().isEmpty() || txtCelConfirm.getText().equals("")) {
                lblConfirm.setText("Celular ou senha diferentes da confirmação, digite novamente!");
                vCelular = false;
            } else if (txtNome.getText().isEmpty() || txtNome.getText().equals("")) {
                lblConfirm.setText("Celular ou senha diferentes da confirmação, digite novamente!");
                vNome = false;
            } else if (txtSenha.getText().isEmpty() || txtSenha.getText().equals("")) {
                lblConfirm.setText("Celular ou senha diferentes da confirmação, digite novamente!");
                vSenha = false;
            }

            if (vCelular && vSenha && vNome && vSexo && vTime) {
                LoginFrame.clienteContaSerializada.add(new ClienteConta(txtCelConfirm.getText(), txtSenha.getText(), txtNome.getText(), sexo, time));
                LoginFrame.criaContaSer((ArrayList<ClienteConta>) LoginFrame.clienteContaSerializada);
                LoginFrame.clienteConta.add(new ClienteConta(txtCelConfirm.getText(), txtSenha.getText(), txtNome.getText(), sexo, time));

                LoginFrame.criar(con, LoginFrame.clienteConta, txtCelConfirm.getText(), txtSenha.getText(), txtNome.getText(), sexo, time);

                JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
                new LoginFrame().setVisible(true);
                dispose();
            }

        } catch (IOException ex) {
            Logger.getLogger(CriarFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CriarFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtCelConfirm.setText("");
        txtCelConfirm.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtSenhaConfirm.setText("");
        bgSexo.clearSelection();
        bgTime.clearSelection();
        lblConfirm.setText("");
        lblSexoTimeConfirm.setText("");
        lblLoginInvalido.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        new LoginFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void rbSFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSFCActionPerformed
        imgTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SFCmini.jpg")));
    }//GEN-LAST:event_rbSFCActionPerformed

    private void rbSPFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSPFCActionPerformed
        imgTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SPFCmini.jpg")));
    }//GEN-LAST:event_rbSPFCActionPerformed

    private void rbSCCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSCCPActionPerformed
        imgTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SCCPmini.jpg")));
    }//GEN-LAST:event_rbSCCPActionPerformed

    private void rbSEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSEPActionPerformed
        imgTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SEPmini.jpg")));
    }//GEN-LAST:event_rbSEPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.ButtonGroup bgTime;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel imgTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginConfirm;
    private javax.swing.JLabel lblLoginInvalido;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaConfirm;
    private javax.swing.JLabel lblSexoTimeConfirm;
    private javax.swing.JPanel panelTime;
    private javax.swing.JPanel pnTime;
    private javax.swing.JRadioButton rbFem;
    private javax.swing.JRadioButton rbMasc;
    private javax.swing.JRadioButton rbSCCP;
    private javax.swing.JRadioButton rbSEP;
    private javax.swing.JRadioButton rbSFC;
    private javax.swing.JRadioButton rbSPFC;
    private javax.swing.JFormattedTextField txtCelConfirm;
    private javax.swing.JFormattedTextField txtCelular1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaConfirm;
    // End of variables declaration//GEN-END:variables
}
