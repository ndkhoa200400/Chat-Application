/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.javaproject.guiproject;

import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ADMIN
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooseFileFrame = new javax.swing.JFrame();
        peopleOnlineFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        roomPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        showPeople = new javax.swing.JButton();
        nameRoomPanel = new javax.swing.JPanel();
        messageToolPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageType = new javax.swing.JTextArea();
        sendAttachment = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        screenMessagePane = new javax.swing.JTextPane();

        javax.swing.GroupLayout ChooseFileFrameLayout = new javax.swing.GroupLayout(ChooseFileFrame.getContentPane());
        ChooseFileFrame.getContentPane().setLayout(ChooseFileFrameLayout);
        ChooseFileFrameLayout.setHorizontalGroup(
            ChooseFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        ChooseFileFrameLayout.setVerticalGroup(
            ChooseFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout peopleOnlineFrameLayout = new javax.swing.GroupLayout(peopleOnlineFrame.getContentPane());
        peopleOnlineFrame.getContentPane().setLayout(peopleOnlineFrameLayout);
        peopleOnlineFrameLayout.setHorizontalGroup(
            peopleOnlineFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        peopleOnlineFrameLayout.setVerticalGroup(
            peopleOnlineFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Application");
        setMinimumSize(new java.awt.Dimension(900, 700));

        roomPanel.setBackground(new java.awt.Color(255, 255, 255));
        roomPanel.setAlignmentX(0.0F);
        roomPanel.setAlignmentY(0.0F);
        roomPanel.setMaximumSize(new java.awt.Dimension(250, 600));
        roomPanel.setMinimumSize(new java.awt.Dimension(250, 600));
        roomPanel.setName(""); // NOI18N

        showPeople.setText("jButton1");
        showPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPeopleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(showPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 177, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showPeople, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        nameRoomPanel.setBackground(new java.awt.Color(102, 102, 102));
        nameRoomPanel.setAlignmentX(0.0F);
        nameRoomPanel.setAlignmentY(0.0F);
        nameRoomPanel.setPreferredSize(new java.awt.Dimension(550, 50));

        javax.swing.GroupLayout nameRoomPanelLayout = new javax.swing.GroupLayout(nameRoomPanel);
        nameRoomPanel.setLayout(nameRoomPanelLayout);
        nameRoomPanelLayout.setHorizontalGroup(
            nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        nameRoomPanelLayout.setVerticalGroup(
            nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        messageToolPanel.setBackground(new java.awt.Color(153, 153, 153));
        messageToolPanel.setAlignmentX(0.0F);
        messageToolPanel.setAlignmentY(0.0F);
        messageToolPanel.setMaximumSize(new java.awt.Dimension(550, 550));
        messageToolPanel.setMinimumSize(new java.awt.Dimension(550, 100));

        messageType.setColumns(20);
        messageType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        messageType.setRows(4);
        messageType.setTabSize(4);
        messageType.setWrapStyleWord(true);
        messageType.setBorder(null);
        messageType.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        messageType.setMargin(new java.awt.Insets(10, 10, 10, 10));
        messageType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                messageTypeKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(messageType);

        sendAttachment.setIcon(new javax.swing.ImageIcon("E:\\Code\\Project Java\\javaProject\\src\\main\\java\\javaProject\\paperclip.png")); // NOI18N
        sendAttachment.setAlignmentY(0.0F);
        sendAttachment.setMaximumSize(new java.awt.Dimension(80, 80));
        sendAttachment.setMinimumSize(new java.awt.Dimension(80, 80));
        sendAttachment.setPreferredSize(new java.awt.Dimension(80, 80));
        sendAttachment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendAttachmentMouseClicked(evt);
            }
        });

        sendButton.setIcon(new javax.swing.ImageIcon("E:\\Code\\Project Java\\javaProject\\src\\main\\java\\javaProject\\send.png")); // NOI18N
        sendButton.setAlignmentY(0.0F);
        sendButton.setMaximumSize(new java.awt.Dimension(80, 80));
        sendButton.setMinimumSize(new java.awt.Dimension(80, 80));
        sendButton.setPreferredSize(new java.awt.Dimension(80, 80));
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout messageToolPanelLayout = new javax.swing.GroupLayout(messageToolPanel);
        messageToolPanel.setLayout(messageToolPanelLayout);
        messageToolPanelLayout.setHorizontalGroup(
            messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendAttachment, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        messageToolPanelLayout.setVerticalGroup(
            messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageToolPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sendAttachment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jScrollPane3.setAutoscrolls(true);

        screenMessagePane.setEditable(false);
        screenMessagePane.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        screenMessagePane.setAutoscrolls(false);
        jScrollPane3.setViewportView(screenMessagePane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameRoomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nameRoomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(messageToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void messageTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTypeKeyTyped
        // TODO add your handling code here
        java.awt.event.MouseEvent evt1 = null ;
        if(evt.getKeyChar() == '\n'){
            sendButtonMouseClicked(evt1);
        }
    }//GEN-LAST:event_messageTypeKeyTyped

    private void sendAttachmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendAttachmentMouseClicked
        // TODO add your handling code here:
        if(ChooseFileFrame.isVisible()){
            ChooseFileFrame.dispose();
        }
        else{
            ChooseFileFrame.setLocation(this.getX() + 150, this.getY() + 150);
            ChooseFileFrame.setSize(600,400);
            ChooseFileFrame.setVisible(true);
        }
        
    }//GEN-LAST:event_sendAttachmentMouseClicked

    private void showPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPeopleMouseClicked
        // TODO add your handling code here:
        if(peopleOnlineFrame.isVisible()){
            peopleOnlineFrame.dispose();
        }
        else{
            peopleOnlineFrame.setLocation(this.getX() - 290, this.getY());
            peopleOnlineFrame.setSize(300,700);
            peopleOnlineFrame.setVisible(true);
        }
        
    }//GEN-LAST:event_showPeopleMouseClicked
    private String formatMessage(String mess){
        int count = 0;
        for (int i = 0; i < mess.length(); i++) {
            if (mess.charAt(i) == 32 || mess.charAt(i) == '\n') {
                count++;
            }
        }
        if (count == mess.length())
            return "";

        if (mess.charAt(mess.length() - 1) == '\n')
            return mess.substring(0, mess.length() - 1);
        
        return mess;
    }
    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sendAttButtonMouseClicked
        // TODO add your handling code here:
        try{
            String mess = messageType.getText();
            StyledDocument doc = screenMessagePane.getStyledDocument();
            mess = formatMessage(mess);
            if (!mess.isEmpty()) {
                SimpleAttributeSet keyWord = new SimpleAttributeSet();
                StyleConstants.setForeground(keyWord, Color.GRAY);
                //StyleConstants.setBackground(keyWord, Color.YELLOW);
                doc.insertString(doc.getLength(),"You:\n", keyWord);
                StyleConstants.setForeground(keyWord, Color.BLACK);
                doc.insertString(doc.getLength(), mess + "\n\n", keyWord);
            }
            messageType.setText(null);
            revalidate();
        }
        catch(BadLocationException e){
            e.printStackTrace();
        }
    }// GEN-LAST:event_sendAttButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);

            }
        });
    }

    private Box vertical = Box.createVerticalBox();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ChooseFileFrame;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel messageToolPanel;
    private javax.swing.JTextArea messageType;
    private javax.swing.JPanel nameRoomPanel;
    private javax.swing.JFrame peopleOnlineFrame;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JTextPane screenMessagePane;
    private javax.swing.JButton sendAttachment;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton showPeople;
    // End of variables declaration//GEN-END:variables

}
