/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer.talk;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PB
 */
public class LoginFrame extends javax.swing.JFrame {

    
    public static String sql = "select celular, senha, nome, sexo, equipe from soccertalk";
    
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static void criar(Connection con, ArrayList<ClienteConta> clienteConta, String celular, String senha, String nome, String sexo, String time) throws SQLException {
        String sql = "insert into soccertalk values(?,?,?,?,?)";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, celular);
            stm.setString(2, senha);
            stm.setString(3, nome);
            stm.setString(4, sexo);
            stm.setString(5, time);
            stm.executeUpdate();
        }
    }

    public static void alterarSenha(Connection con, ArrayList<ClienteConta> clienteConta, String celular, String senha) throws SQLException {
        String sql = "update soccertalk set senha=? where celular=?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, senha);
            stm.setString(2, celular);
            stm.executeUpdate();
        }
    }

    public static ArrayList<ClienteConta> lerContas(Connection con) throws SQLException{
		ArrayList<ClienteConta> listaST = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery()){
			while(rs.next()){
				listaST.add(new ClienteConta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		}
		return listaST;
	}
    
    
    
    static ArrayList<ClienteConta> clienteContaSerializada = new ArrayList<ClienteConta>();
    static ArrayList<ClienteConta> clienteConta = new ArrayList<ClienteConta>();
    private static String loginCelular = "";
    private static String loginSenha = "";
    private static String loginNome = "";
    private static String loginTime = "";
    private static String loginSexo = "";
    static boolean v = true;

    public static String getLoginCelular() {
        return loginCelular;
    }

    public static String getLoginSenha() {
        return loginSenha;
    }

    public static String getLoginNome() {
        return loginNome;
    }

    public static String getLoginTime() {
        return loginTime;
    }

    public static String getLoginSexo() {
        return loginSexo;
    }

    public LoginFrame() {
        initComponents();
        try {
            clienteContaSerializada.add(new ClienteConta("apae", "goec", "APAEGOEC", "Masculino", "SPFC"));
            criaContaSer(clienteConta);
            clienteContaSerializada = lerContasSer();
            
            v = true;
        } catch (IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<ClienteConta> lerContasSer() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("C:/lhegau/files/ContaSoccerTalk.ser")) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                return (ArrayList<ClienteConta>) ois.readObject();
            }
        }

    }

    public static void criaContaSer(ArrayList<ClienteConta> clienteConta) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("C:/lhegau/files/ContaSoccerTalk.ser")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(clienteConta);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblSenha = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();
        txtPass = new javax.swing.JPasswordField();
        btnConect = new javax.swing.JButton();
        btnSign = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(320, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(320, 480));

        jPanel4.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SoccerTalkLoginFull.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel1.setOpaque(false);

        lblSenha.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        lblSenha.setText("Senha: ");

        lblCelular.setBackground(new java.awt.Color(255, 255, 255));
        lblCelular.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        lblCelular.setText("Celular: ");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtPass.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        btnConect.setBackground(new java.awt.Color(255, 255, 0));
        btnConect.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnConect.setText("Conectar-se!");
        btnConect.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 204)));
        btnConect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectActionPerformed(evt);
            }
        });

        btnSign.setBackground(new java.awt.Color(255, 0, 0));
        btnSign.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnSign.setForeground(new java.awt.Color(255, 255, 255));
        btnSign.setText("Criar Conta!");
        btnSign.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 204)));
        btnSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConect, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSenha)
                            .addComponent(lblCelular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnSign)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(104, Short.MAX_VALUE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(lblCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSign)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(269, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectActionPerformed
        
        
        
        try(Connection con = DriverManager.getConnection(url, "scott", "tiger")){    
            
            
            clienteContaSerializada = lerContasSer();
            clienteConta = lerContas(con);
            
            for (ClienteConta xx : clienteConta) {
                System.out.println(xx.getCelular() + "\n");
                System.out.println(xx.getSenha()+ "\n");
            }
            
            boolean vv = false;

            for (ClienteConta conta : clienteConta) {
                if (v && txtCelular.getText().equals(conta.getCelular()) && txtPass.getText().equals(conta.getSenha())) {
                    vv = true;

                    loginCelular = conta.getCelular();
                    loginSenha = conta.getSenha();
                    loginNome = conta.getNome();
                    loginTime = conta.getTime();
                    loginSexo = conta.getSexo();

                    JOptionPane.showMessageDialog(this, "Conectado com sucesso!");
                    new ContaFrame().setVisible(true);
                    dispose();
                    break;
                }
            }
            if (vv == false) {
                JOptionPane.showMessageDialog(this, "Celular ou senha incorretos!");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnConectActionPerformed

    private void btnSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignActionPerformed
        new CriarFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSignActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnConect.doClick();
        }
    }//GEN-LAST:event_txtPassKeyPressed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConect;
    private javax.swing.JButton btnSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
