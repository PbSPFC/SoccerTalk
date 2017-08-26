/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer.talk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.DefaultCaret;
import soccer.talk.ChatMessage;
import soccer.talk.ChatMessage.Action;

/**
 *
 * @author PB
 */
public class ChatSCCPFrame extends javax.swing.JFrame {

    private Socket socket;
    private ChatMessage msg;
    private ClienteServiceSCCP service;
    private static String nome = "";
    private static String time = "";

    public ChatSCCPFrame() {
        initComponents();

        nome = ContaFrame.getNome();
        time = ContaFrame.getTime();
        if (!nome.isEmpty()) {
            this.msg = new ChatMessage();
            this.msg.setAction(Action.CONNECT);
            this.msg.setNome(nome);
            this.msg.setTime(time);

            this.service = new ClienteServiceSCCP();
            this.socket = this.service.connect();

            new Thread(new ListenerSocket(this.socket)).start();

            this.service.enviar(msg);
        }

    }

    private class ListenerSocket implements Runnable {

        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ChatSCCPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public void run() {
            ChatMessage msg = null;

            try {
                while ((msg = (ChatMessage) input.readObject()) != null) {
                    ChatMessage.Action action = msg.getAction();
                    if (action.equals(ChatMessage.Action.CONNECT)) {
                        connected(msg);
                    } else if (action.equals(ChatMessage.Action.DISCONNECT)) {
                        disconnected();
                        socket.close();
                    } else if (action.equals(ChatMessage.Action.SEND_PRIVATE)) {
                        recebePrivado(msg);
                    } else if (action.equals(ChatMessage.Action.USERS_ONLINE)) {
                        atualizar(msg);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatSCCPFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChatSCCPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void connected(ChatMessage msg) {
        if (msg.getText().equals("NO")) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro durante a conexão, tente novamente.");
            return;
        }

        this.msg = msg;
        this.btnSair.setEnabled(true);
        this.txtAreaMsg.setEnabled(true);
        this.txtAreaRecebe.setEnabled(true);
        this.btnEnviar.setEnabled(true);
        this.btnLimpar.setEnabled(true);

        JOptionPane.showMessageDialog(this, "Bem-Vindo ao chat!");
        this.txtAreaRecebe.append(msg.getNome() + " [" + msg.getTime() + "]" + " conectou-se! \"" + hora() + "\"\n\n");
    }

    private void disconnected() {
        this.txtAreaRecebe.append(msg.getNome() + " [" + msg.getTime() + "]" + " desconectou-se!\n\n");

        this.btnSair.setEnabled(false);
        this.txtAreaMsg.setEnabled(false);
        this.txtAreaRecebe.setEnabled(false);
        this.btnEnviar.setEnabled(false);
        this.btnLimpar.setEnabled(false);

        this.txtAreaRecebe.setText("");
        this.txtAreaMsg.setText("");
        JOptionPane.showMessageDialog(this, "Desconectado com sucesso!");

    }

    private void recebePrivado(ChatMessage msg) {
        if(msg.isPrivado()){
            this.txtAreaRecebe.append("[Privado][" + msg.getNome() + " [" + msg.getTime() + "] " + " \"" + hora() + "\"]:\n" + msg.getText() + "\n\n");
        }else{
            this.txtAreaRecebe.append("[" + msg.getNome() + " [" + msg.getTime() + "] " + " \"" + hora() + "\"]:\n" + msg.getText() + "\n\n");
        }
    }

    private void atualizar(ChatMessage msg) {
        Set<String> nomes = msg.getSetOnline();
        String[] array = (String[]) nomes.toArray(new String[nomes.size()]);
        this.listOnline.setListData(array);
        this.listOnline.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listOnline.setLayoutOrientation(JList.VERTICAL);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaRecebe = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMsg = new javax.swing.JTextArea();
        btnLimpar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOnline = new javax.swing.JList<>();
        btnDesmarcar = new javax.swing.JButton();
        panelFont = new javax.swing.JPanel();
        cbFontes = new javax.swing.JComboBox<>();
        lblFonteTeste = new javax.swing.JLabel();
        cbBold = new javax.swing.JCheckBox();
        cbItalic = new javax.swing.JCheckBox();
        btnFonteMudar = new javax.swing.JButton();
        cbTamanhoFonte = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        rbPreto = new javax.swing.JRadioButton();
        rbBranco = new javax.swing.JRadioButton();
        rbVermelho = new javax.swing.JRadioButton();
        rbVerde = new javax.swing.JRadioButton();
        rbAzul = new javax.swing.JRadioButton();
        rbAmarelo = new javax.swing.JRadioButton();
        rbCinza = new javax.swing.JRadioButton();
        rbLaranja = new javax.swing.JRadioButton();
        rbMarrom = new javax.swing.JRadioButton();
        rbRosa = new javax.swing.JRadioButton();
        rbRoxo = new javax.swing.JRadioButton();
        rbAzulClaro = new javax.swing.JRadioButton();
        rbVerdeClaro = new javax.swing.JRadioButton();
        rbGold = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SoccerTalk");
        setResizable(false);
        setSize(new java.awt.Dimension(320, 480));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(255, 255, 255)));

        jTabbedPane2.setBackground(new java.awt.Color(51, 255, 51));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        txtAreaRecebe.setEditable(false);
        txtAreaRecebe.setColumns(20);
        txtAreaRecebe.setFont(new java.awt.Font("Chaparral Pro", 0, 14)); // NOI18N
        txtAreaRecebe.setRows(5);
        txtAreaRecebe.setEnabled(false);
        txtAreaRecebe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaRecebeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaRecebe);
        DefaultCaret caret = (DefaultCaret) txtAreaRecebe.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        txtAreaMsg.setColumns(20);
        txtAreaMsg.setFont(new java.awt.Font("Chaparral Pro", 0, 14)); // NOI18N
        txtAreaMsg.setRows(5);
        txtAreaMsg.setEnabled(false);
        txtAreaMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaMsgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaMsgKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtAreaMsg);

        btnLimpar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(51, 51, 51));
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(51, 51, 51));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        btnSair.setEnabled(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnEnviar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Chat", jPanel3);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Onlines"));

        jScrollPane3.setViewportView(listOnline);

        btnDesmarcar.setBackground(new java.awt.Color(255, 255, 255));
        btnDesmarcar.setText("Desmarcar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDesmarcar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDesmarcar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Online", jPanel2);

        panelFont.setBackground(new java.awt.Color(0, 0, 0));
        panelFont.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        cbFontes.setBackground(new java.awt.Color(0, 0, 0));
        cbFontes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arial", "Comic Sans MS", "Footlight MT Light", "Tahoma", "Serif" }));
        cbFontes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFontesActionPerformed(evt);
            }
        });

        lblFonteTeste.setBackground(new java.awt.Color(0, 0, 0));
        lblFonteTeste.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        lblFonteTeste.setForeground(new java.awt.Color(204, 204, 204));
        lblFonteTeste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFonteTeste.setText("Soccer Talk - Free For All!");

        cbBold.setBackground(new java.awt.Color(0, 0, 0));
        cbBold.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbBold.setForeground(new java.awt.Color(255, 255, 255));
        cbBold.setText("Bold");
        cbBold.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBoldItemStateChanged(evt);
            }
        });

        cbItalic.setBackground(new java.awt.Color(0, 0, 0));
        cbItalic.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        cbItalic.setForeground(new java.awt.Color(255, 255, 255));
        cbItalic.setText("Italic");
        cbItalic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItalicItemStateChanged(evt);
            }
        });

        btnFonteMudar.setBackground(new java.awt.Color(0, 0, 0));
        btnFonteMudar.setForeground(new java.awt.Color(204, 255, 255));
        btnFonteMudar.setText("Mudar Fonte");
        btnFonteMudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFonteMudarActionPerformed(evt);
            }
        });

        cbTamanhoFonte.setBackground(new java.awt.Color(0, 0, 0));
        cbTamanhoFonte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "14", "18", "24", "36" }));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 204)));

        rbPreto.setBackground(new java.awt.Color(0, 0, 0));
        rbPreto.setForeground(new java.awt.Color(153, 153, 153));
        rbPreto.setText("Preto");

        rbBranco.setBackground(new java.awt.Color(0, 0, 0));
        rbBranco.setForeground(new java.awt.Color(255, 255, 255));
        rbBranco.setText("Branco");

        rbVermelho.setBackground(new java.awt.Color(0, 0, 0));
        rbVermelho.setForeground(new java.awt.Color(255, 0, 0));
        rbVermelho.setText("Vermelho");

        rbVerde.setBackground(new java.awt.Color(0, 0, 0));
        rbVerde.setForeground(new java.awt.Color(0, 153, 0));
        rbVerde.setText("Verde");

        rbAzul.setBackground(new java.awt.Color(0, 0, 0));
        rbAzul.setForeground(new java.awt.Color(0, 0, 255));
        rbAzul.setText("Azul");

        rbAmarelo.setBackground(new java.awt.Color(0, 0, 0));
        rbAmarelo.setForeground(new java.awt.Color(255, 255, 0));
        rbAmarelo.setText("Amarelo");

        rbCinza.setBackground(new java.awt.Color(0, 0, 0));
        rbCinza.setForeground(new java.awt.Color(102, 102, 102));
        rbCinza.setText("Cinza");

        rbLaranja.setBackground(new java.awt.Color(0, 0, 0));
        rbLaranja.setForeground(new java.awt.Color(255, 102, 0));
        rbLaranja.setText("Laranja");

        rbMarrom.setBackground(new java.awt.Color(0, 0, 0));
        rbMarrom.setForeground(new java.awt.Color(102, 51, 0));
        rbMarrom.setText("Marrom");

        rbRosa.setBackground(new java.awt.Color(0, 0, 0));
        rbRosa.setForeground(new java.awt.Color(255, 102, 204));
        rbRosa.setText("Rosa");

        rbRoxo.setBackground(new java.awt.Color(0, 0, 0));
        rbRoxo.setForeground(new java.awt.Color(153, 0, 153));
        rbRoxo.setText("Roxo");

        rbAzulClaro.setBackground(new java.awt.Color(0, 0, 0));
        rbAzulClaro.setForeground(new java.awt.Color(0, 255, 204));
        rbAzulClaro.setText("Azul Claro");

        rbVerdeClaro.setBackground(new java.awt.Color(0, 0, 0));
        rbVerdeClaro.setForeground(new java.awt.Color(0, 255, 0));
        rbVerdeClaro.setText("Verde Claro");

        rbGold.setBackground(new java.awt.Color(0, 0, 0));
        rbGold.setForeground(new java.awt.Color(204, 204, 0));
        rbGold.setText("Dourado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbPreto)
                    .addComponent(rbBranco)
                    .addComponent(rbVermelho)
                    .addComponent(rbVerde)
                    .addComponent(rbAzul)
                    .addComponent(rbAmarelo)
                    .addComponent(rbCinza))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbLaranja)
                    .addComponent(rbMarrom)
                    .addComponent(rbRosa)
                    .addComponent(rbAzulClaro)
                    .addComponent(rbRoxo)
                    .addComponent(rbVerdeClaro)
                    .addComponent(rbGold))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rbLaranja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbMarrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbRosa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbRoxo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAzulClaro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbVerdeClaro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbGold))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rbPreto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbBranco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbVermelho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAzul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbVerde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbAmarelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCinza)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFontLayout = new javax.swing.GroupLayout(panelFont);
        panelFont.setLayout(panelFontLayout);
        panelFontLayout.setHorizontalGroup(
            panelFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFontLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFonteTeste, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFontLayout.createSequentialGroup()
                        .addComponent(cbFontes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTamanhoFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbItalic)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFontLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFonteMudar)
                        .addGap(91, 91, 91)))
                .addContainerGap())
            .addGroup(panelFontLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFontLayout.setVerticalGroup(
            panelFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFontLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTamanhoFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFontes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBold)
                    .addComponent(cbItalic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFonteMudar)
                .addGap(18, 18, 18)
                .addComponent(lblFonteTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jTabbedPane2.addTab("Fonte", panelFont);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sport Clube Corinthians Paulista");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("Chat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        ChatMessage msg = new ChatMessage();
        msg.setNome(this.msg.getNome());
        msg.setTime(this.msg.getTime());
        msg.setAction(Action.DISCONNECT);
        this.service.enviar(msg);
        disconnected();
        new ContaFrame().setVisible(true);
        dispose();

    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtAreaMsg.setText("");
        txtAreaRecebe.setText("");
        this.listOnline.clearSelection();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        if (!txtAreaMsg.getText().isEmpty() || !txtAreaMsg.getText().equals("")) {
            
            btnEnviar.setEnabled(false);
            this.txtAreaMsg.setEditable(false);
            String t = this.txtAreaMsg.getText();
            String n = this.msg.getNome();
            this.time = ContaFrame.getTime();
            String h = hora();
            this.msg = new ChatMessage();
            this.msg.setNome(n);
            this.msg.setText(t);
            this.msg.setTime(time);

            if (this.listOnline.getSelectedIndex() != (-1)) {

                this.msg.setNomePrivado(this.listOnline.getSelectedValue());
                this.msg.setAction(Action.SEND_PRIVATE);
                this.msg.setPrivado(true);
                this.listOnline.clearSelection();
                this.txtAreaRecebe.append("[Privado][" + n + "[" + time + "]" + " \"" + h + "\"]:\n" + t + "\n\n");
                this.service.enviar(this.msg);
            } else {
                this.msg.setAction(Action.SEND_ALL);
                this.txtAreaRecebe.append("[" + n + "[" + time + "]" + " \"" + h + "\"]:\n" + t + "\n\n");
                this.service.enviar(this.msg);
            }


            this.txtAreaMsg.setText("");
            btnEnviar.setEnabled(true);
            this.txtAreaMsg.setEditable(true);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtAreaMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaMsgKeyPressed

    }//GEN-LAST:event_txtAreaMsgKeyPressed

    private void txtAreaRecebeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaRecebeKeyReleased
        
    }//GEN-LAST:event_txtAreaRecebeKeyReleased

    private void txtAreaMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaMsgKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtAreaMsg.getText().isEmpty() || !txtAreaMsg.getText().equals("")) {
                this.txtAreaMsg.setEnabled(false);

                if (txtAreaMsg.getText().length() > 0) {
                    String tt;
                    StringBuilder s1 = new StringBuilder(this.txtAreaMsg.getText());
                    s1.deleteCharAt(s1.length() - 1);
                    tt = s1.toString();
                    this.txtAreaMsg.setText(tt);
                }

                btnEnviar.doClick();

                try {
                    Thread.sleep(150);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChatPadraoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.txtAreaMsg.setEnabled(true);
                txtAreaMsg.requestFocus(true);
            }
        }
    }//GEN-LAST:event_txtAreaMsgKeyReleased

    private void cbFontesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFontesActionPerformed

    }//GEN-LAST:event_cbFontesActionPerformed

    private void cbBoldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBoldItemStateChanged

    }//GEN-LAST:event_cbBoldItemStateChanged

    private void cbItalicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItalicItemStateChanged

    }//GEN-LAST:event_cbItalicItemStateChanged

    private void btnFonteMudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFonteMudarActionPerformed
        String fonte = lblFonteTeste.getFont() + "";
        int estilo = Font.PLAIN;
        int tamanho = 12;

        if(cbFontes.getSelectedIndex() == 0){
            fonte = "Arial";
        }else if(cbFontes.getSelectedIndex() == 1){
            fonte = "Comic Sans MS";
        }else if(cbFontes.getSelectedIndex() == 2){
            fonte = "Footlight MT Light";
        }else if(cbFontes.getSelectedIndex() == 3){
            fonte = "Tahoma";
        }else if(cbFontes.getSelectedIndex() == 4){
            fonte = "Serif";
        }

        if (cbBold.isSelected() & cbItalic.isSelected()) {
            estilo = Font.BOLD | Font.ITALIC;
        } else if (cbBold.isSelected()) {
            estilo = Font.BOLD;
        } else if (cbItalic.isSelected()) {
            estilo = Font.ITALIC;
        } else {
            estilo = Font.PLAIN;
        }

        if(cbTamanhoFonte.getSelectedIndex() == 0){
            tamanho = 8;
        }else if(cbTamanhoFonte.getSelectedIndex() == 1){
            tamanho = 9;
        }else if(cbTamanhoFonte.getSelectedIndex() == 2){
            tamanho = 10;
        }else if(cbTamanhoFonte.getSelectedIndex() == 3){
            tamanho = 11;
        }else if(cbTamanhoFonte.getSelectedIndex() == 4){
            tamanho = 12;
        }else if(cbTamanhoFonte.getSelectedIndex() == 5){
            tamanho = 14;
        }else if(cbTamanhoFonte.getSelectedIndex() == 6){
            tamanho = 18;
        }else if(cbTamanhoFonte.getSelectedIndex() == 7){
            tamanho = 24;
        }else if(cbTamanhoFonte.getSelectedIndex() == 8){
            tamanho = 36;
        }

        if(rbAmarelo.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(255,255,0));
            txtAreaMsg.setForeground(new java.awt.Color(255,255,0));
            txtAreaRecebe.setForeground(new java.awt.Color(255,255,0));
        }else if(rbAzul.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(0,0,255));
            txtAreaMsg.setForeground(new java.awt.Color(0,0,255));
            txtAreaRecebe.setForeground(new java.awt.Color(0,0,255));
        }else if(rbAzulClaro.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(0,255,204));
            txtAreaMsg.setForeground(new java.awt.Color(0,255,204));
            txtAreaRecebe.setForeground(new java.awt.Color(0,255,204));
        }else if(rbBranco.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(255,255,255));
            txtAreaMsg.setForeground(new java.awt.Color(255,255,255));
            txtAreaRecebe.setForeground(new java.awt.Color(255,255,255));
        }else if(rbCinza.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(102,102,102));
            txtAreaMsg.setForeground(new java.awt.Color(102,102,102));
            txtAreaRecebe.setForeground(new java.awt.Color(102,102,102));
        }else if(rbGold.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(204,204,0));
            txtAreaMsg.setForeground(new java.awt.Color(204,204,0));
            txtAreaRecebe.setForeground(new java.awt.Color(204,204,0));
        }else if(rbLaranja.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(255,102,0));
            txtAreaMsg.setForeground(new java.awt.Color(255,102,0));
            txtAreaRecebe.setForeground(new java.awt.Color(255,102,0));
        }else if(rbMarrom.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(102,51,0));
            txtAreaMsg.setForeground(new java.awt.Color(102,51,0));
            txtAreaRecebe.setForeground(new java.awt.Color(102,51,0));
        }else if(rbPreto.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(0,0,0));
            txtAreaMsg.setForeground(new java.awt.Color(0,0,0));
            txtAreaRecebe.setForeground(new java.awt.Color(0,0,0));
        }else if(rbRosa.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(255,102,204));
            txtAreaMsg.setForeground(new java.awt.Color(255,102,204));
            txtAreaRecebe.setForeground(new java.awt.Color(255,102,204));
        }else if(rbRoxo.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(153,0,153));
            txtAreaMsg.setForeground(new java.awt.Color(153,0,153));
            txtAreaRecebe.setForeground(new java.awt.Color(153,0,153));
        }else if(rbVerde.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(0,153,0));
            txtAreaMsg.setForeground(new java.awt.Color(0,153,0));
            txtAreaRecebe.setForeground(new java.awt.Color(0,153,0));
        }else if(rbVerdeClaro.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(0,255,0));
            txtAreaMsg.setForeground(new java.awt.Color(0,255,0));
            txtAreaRecebe.setForeground(new java.awt.Color(0,255,0));
        }else if(rbVermelho.isSelected()){
            lblFonteTeste.setForeground(new java.awt.Color(255,0,0));
            txtAreaMsg.setForeground(new java.awt.Color(255,0,0));
            txtAreaRecebe.setForeground(new java.awt.Color(255,0,0));
        }

        Font novaFonte = new Font(fonte, estilo, tamanho);
        lblFonteTeste.setFont(novaFonte);
        txtAreaMsg.setFont(novaFonte);
        txtAreaRecebe.setFont(novaFonte);
        jLabel1.setFont(new Font(fonte, estilo, 24));
    }//GEN-LAST:event_btnFonteMudarActionPerformed

    private static String hora() {
        Calendar h = Calendar.getInstance();
        String hora = h.get(Calendar.HOUR_OF_DAY)
                + ":" + h.get(Calendar.MINUTE) + ":" + h.get(Calendar.SECOND);

        return hora;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesmarcar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnFonteMudar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox cbBold;
    private javax.swing.JComboBox<String> cbFontes;
    private javax.swing.JCheckBox cbItalic;
    private javax.swing.JComboBox<String> cbTamanhoFonte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblFonteTeste;
    private javax.swing.JList<String> listOnline;
    private javax.swing.JPanel panelFont;
    private javax.swing.JRadioButton rbAmarelo;
    private javax.swing.JRadioButton rbAzul;
    private javax.swing.JRadioButton rbAzulClaro;
    private javax.swing.JRadioButton rbBranco;
    private javax.swing.JRadioButton rbCinza;
    private javax.swing.JRadioButton rbGold;
    private javax.swing.JRadioButton rbLaranja;
    private javax.swing.JRadioButton rbMarrom;
    private javax.swing.JRadioButton rbPreto;
    private javax.swing.JRadioButton rbRosa;
    private javax.swing.JRadioButton rbRoxo;
    private javax.swing.JRadioButton rbVerde;
    private javax.swing.JRadioButton rbVerdeClaro;
    private javax.swing.JRadioButton rbVermelho;
    private javax.swing.JTextArea txtAreaMsg;
    private javax.swing.JTextArea txtAreaRecebe;
    // End of variables declaration//GEN-END:variables
}
