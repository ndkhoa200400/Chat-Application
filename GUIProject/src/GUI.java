import com.formdev.flatlaf.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GUI extends javax.swing.JFrame {

    Thread listeningHandler;
    
    /**
     * Creates new form GUI
     */
    public GUI() throws IOException {
        initComponents();
        screenStateHash.put(0, screenMessagePane);
        currentScreen = screenMessagePane;
        roomNameHash.put("PUBLIC ROOM", 0);
        Client.connectToServer();
        // Listening to server
        listeningHandler = new Thread(() -> {
            try {
                getMessage();
            } catch (Exception ex) {
                System.out.println("Loi trong listening");
                ex.printStackTrace();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooseFileFrame = new javax.swing.JFrame();
        peopleOnlineFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        loginFrame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        usernameInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        passwordInput = new javax.swing.JPasswordField();
        wrongInputFrame = new javax.swing.JFrame();
        inputNameRoomFrame = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        inputRoomName = new javax.swing.JTextField();
        saveRoomName = new javax.swing.JButton();
        roomPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        showPeople = new javax.swing.JButton();
        createRoom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomList = new javax.swing.JList<>();
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jList2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane4.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addContainerGap()))
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

        loginFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        usernameInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        signInButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signInButton.setText("Sign in");
        signInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInButtonMouseClicked(evt);
            }
        });

        signUpButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signUpButton.setText("Sign up");
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameInput)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(passwordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(signInButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signUpButton)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInButton)
                    .addComponent(signUpButton))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginFrameLayout = new javax.swing.GroupLayout(loginFrame.getContentPane());
        loginFrame.getContentPane().setLayout(loginFrameLayout);
        loginFrameLayout.setHorizontalGroup(
            loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        loginFrameLayout.setVerticalGroup(
            loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout wrongInputFrameLayout = new javax.swing.GroupLayout(wrongInputFrame.getContentPane());
        wrongInputFrame.getContentPane().setLayout(wrongInputFrameLayout);
        wrongInputFrameLayout.setHorizontalGroup(
            wrongInputFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        wrongInputFrameLayout.setVerticalGroup(
            wrongInputFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        inputRoomName.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N

        saveRoomName.setText("OK");
        saveRoomName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveRoomNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(saveRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inputNameRoomFrameLayout = new javax.swing.GroupLayout(inputNameRoomFrame.getContentPane());
        inputNameRoomFrame.getContentPane().setLayout(inputNameRoomFrameLayout);
        inputNameRoomFrameLayout.setHorizontalGroup(
            inputNameRoomFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inputNameRoomFrameLayout.setVerticalGroup(
            inputNameRoomFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Application");
        setMinimumSize(new java.awt.Dimension(900, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        roomPanel.setBackground(new java.awt.Color(204, 204, 204));
        roomPanel.setAlignmentX(0.0F);
        roomPanel.setAlignmentY(0.0F);
        roomPanel.setMaximumSize(new java.awt.Dimension(250, 600));
        roomPanel.setMinimumSize(new java.awt.Dimension(250, 600));
        roomPanel.setName(""); // NOI18N

        showPeople.setBackground(new java.awt.Color(255, 255, 255));
        showPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPeopleMouseClicked(evt);
            }
        });

        createRoom.setBackground(new java.awt.Color(255, 255, 255));
        createRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createRoomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(showPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showPeople, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(createRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        roomList.setBackground(new java.awt.Color(204, 204, 204));
        roomList.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        roomList.setForeground(new java.awt.Color(51, 51, 51));
        listModel.addElement("PUBLIC CHAT");
        roomList.setModel(listModel);
        roomList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomList.setAlignmentX(1.0F);
        roomList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomList.setMaximumSize(new java.awt.Dimension(256, 0));
        roomList.setMinimumSize(new java.awt.Dimension(256, 554));
        roomList.setPreferredSize(new java.awt.Dimension(250, 550));
        roomList.setSelectionBackground(new java.awt.Color(255, 255, 255));
        roomList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        roomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(roomList);

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
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

        sendAttachment.setBackground(new java.awt.Color(255, 255, 255));
        sendAttachment.setAlignmentY(0.0F);
        sendAttachment.setMaximumSize(new java.awt.Dimension(80, 80));
        sendAttachment.setMinimumSize(new java.awt.Dimension(80, 80));
        sendAttachment.setPreferredSize(new java.awt.Dimension(80, 80));
        sendAttachment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendAttachmentMouseClicked(evt);
            }
        });

        sendButton.setBackground(new java.awt.Color(255, 255, 255));
        sendButton.setAlignmentY(0.0F);
        sendButton.setMaximumSize(new java.awt.Dimension(80, 80));
        sendButton.setMinimumSize(new java.awt.Dimension(80, 80));
        sendButton.setPreferredSize(new java.awt.Dimension(80, 80));
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendButtonMouseClicked(evt);
            }
        });
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
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

        jScrollPane3.setBorder(null);
        jScrollPane3.setAutoscrolls(true);

        screenMessagePane.setEditable(false);
        screenMessagePane.setBorder(null);
        screenMessagePane.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(messageToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void messageTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTypeKeyTyped
        // TODO add your handling code here
        java.awt.event.MouseEvent evt1 = null;
        if (evt.getKeyChar() == '\n') {
            sendButtonMouseClicked(evt1);
        }

    }//GEN-LAST:event_messageTypeKeyTyped

    private void insertTextToPane(String msg, String name, String align) {
        try {
            // Hi?n các text lên c?a s? chat c?a client
            StyledDocument doc = screenMessagePane.getStyledDocument();
            msg = formatMessage(msg);
            SimpleAttributeSet keyWord = new SimpleAttributeSet();
            SimpleAttributeSet keyWordName = new SimpleAttributeSet();
            
            StyleConstants.setLineSpacing(keyWord, (float)0.05);
            
            
            if (align.equals("right")) {
                StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_RIGHT);

                StyleConstants.setBackground(keyWord, Color.DARK_GRAY);
                StyleConstants.setForeground(keyWord, Color.WHITE);
                
                StyleConstants.setFontSize(keyWord, 16);
                doc.setParagraphAttributes(doc.getLength(), 1, keyWord, true);  
                doc.insertString(doc.getLength(), " " + msg + " " + "\n", keyWord); 
                
            } else {
                StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_LEFT);
                StyleConstants.setAlignment(keyWordName, StyleConstants.ALIGN_LEFT);
                
                StyleConstants.setBackground(keyWord, Color.lightGray);
                StyleConstants.setForeground(keyWord, Color.BLACK);
                
                StyleConstants.setForeground(keyWordName, Color.GRAY);

                doc.setParagraphAttributes(doc.getLength(), 1, keyWordName, true);
                
                StyleConstants.setFontSize(keyWordName, 14);
                doc.insertString(doc.getLength(), name + "\n", keyWordName);
                
                doc.setParagraphAttributes(doc.getLength(), 1, keyWord, true);  
                
                StyleConstants.setFontSize(keyWord, 16);
                doc.insertString(doc.getLength(), " " + msg + " " + "\n", keyWord);
            }
            
        } catch (BadLocationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getMessage() {

        try {
            while (true) {
                String mess = Client.listen();
                int split = mess.indexOf(": ");
                String name = "admin";
                if (split > 0) {
                    name = mess.substring(0, split);
                    mess = mess.substring(split + 1);
                }
                if(name.equals("admin"))
                {
                    String[] response = mess.split(" ");
                    switch(response[0]){
                        case "createroom":
                            createNewRoom(response[1]);
                            break;
                    }
                }
                insertTextToPane(mess, name, "left");
            }

        }catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void sendAttachmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendAttachmentMouseClicked
        // TODO add your handling code here:
        if (ChooseFileFrame.isVisible()) {
            ChooseFileFrame.dispose();
        } else {
            ChooseFileFrame.setLocation(this.getX() + 150, this.getY() + 150);
            ChooseFileFrame.setSize(600, 400);
            ChooseFileFrame.setVisible(true);
        }

    }//GEN-LAST:event_sendAttachmentMouseClicked

    private void showPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPeopleMouseClicked
        // TODO add your handling code here:
        if (peopleOnlineFrame.isVisible()) {
            peopleOnlineFrame.dispose();
        } else {
            peopleOnlineFrame.setLocation(this.getX() - 290, this.getY());
            peopleOnlineFrame.setSize(300, 700);
            peopleOnlineFrame.setVisible(true);
        }

    }//GEN-LAST:event_showPeopleMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void signInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInButtonMouseClicked
        // TODO add your handling code here:
        String username, password;

        username = usernameInput.getText();
        password = new String(passwordInput.getPassword());

        if (!username.isEmpty() && !password.isEmpty()) {

            boolean isValid = true;
            try {
                isValid = Client.logIn(username, password);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (isValid) {
                loginFrame.setVisible(false);
                loginFrame.dispose();
                this.setVisible(true);
                listeningHandler.start();
            } else {
                JOptionPane.showConfirmDialog(null, "Sai mk");
            }
        } else {
            wrongInputFrame.setSize(320, 150);
            javax.swing.JLabel msgErr = new javax.swing.JLabel("Password and Username can not empty");
            msgErr.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
            msgErr.setBounds(20, wrongInputFrame.getHeight() / 5, 300, 50);
            wrongInputFrame.add(msgErr);
            msgErr.setVisible(true);
            wrongInputFrame.setLocationRelativeTo(loginFrame);
            wrongInputFrame.setVisible(true);
        }
    }//GEN-LAST:event_signInButtonMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loginFrame.setSize(300, 260);
        loginFrame.setLocationRelativeTo(this);
        this.setVisible(false);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_usernameInputActionPerformed

    private void signUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseClicked
        // TODO add your handling code here:
        String username, password;

        username = usernameInput.getText();
        password = new String(passwordInput.getPassword());

        if (!username.isEmpty() && !password.isEmpty()) {
            boolean isValid = true;
            try {
                isValid = Client.signUp(username, password);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(isValid){
                loginFrame.setVisible(false);
                loginFrame.dispose();
                this.setVisible(true);
                listeningHandler.start();
            }
        } else {
            wrongInputFrame.setSize(320, 150);
            javax.swing.JLabel msgErr = new javax.swing.JLabel("Password and Username can not empty");
            msgErr.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
            msgErr.setBounds(20, wrongInputFrame.getHeight() / 5, 300, 50);
            wrongInputFrame.add(msgErr);
            msgErr.setVisible(true);
            wrongInputFrame.setLocationRelativeTo(loginFrame);
            wrongInputFrame.setVisible(true);
        }
    }//GEN-LAST:event_signUpButtonMouseClicked

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_sendButtonActionPerformed

    private void roomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomListMouseClicked
        // TODO add your handling code here:
        String select = roomList.getSelectedValue();
        System.out.println(select);
        if(select.equals("PUBLIC ROOM")){
            jScrollPane3.add(screenStateHash.get(0));
            
        }
        else{
            System.out.println(screenStateHash.get(roomNameHash.get(select)));
            
        }
    }//GEN-LAST:event_roomListMouseClicked
    private void createNewRoom(String idRoom){
        JTextPane newMessScreen = new JTextPane();
        
        newMessScreen = new javax.swing.JTextPane();
        newMessScreen.setEditable(false);
        newMessScreen.setBorder(null);
        newMessScreen.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        newMessScreen.setAutoscrolls(false);
        
        inputNameRoomFrame.setVisible(true);
        inputNameRoomFrame.setLocationRelativeTo(this);
        inputNameRoomFrame.pack();
        
        if(!inputNameRoomFrame.isActive()){
            // luu ten tu bien roomName
        }
        

        listModel.addElement(roomNameString);

        roomNameHash.put(roomNameString, Integer.parseInt(idRoom));
        screenStateHash.put(Integer.parseInt(idRoom), newMessScreen);
    }
    private void createRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createRoomMouseClicked
        // TODO add your handling code here:
        Client.send("/createroom");
    }//GEN-LAST:event_createRoomMouseClicked
    
    private String roomNameString = "";
    private void saveRoomNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveRoomNameMouseClicked
        // TODO add your handling code here:
        roomNameString = inputRoomName.getText();
        inputRoomName.setText("");
        
        inputNameRoomFrame.dispose();
        
    }//GEN-LAST:event_saveRoomNameMouseClicked
    private String formatMessage(String mess) {
        int count = 0;
        for (int i = 0; i < mess.length(); i++) {
            if (mess.charAt(i) == 32 || mess.charAt(i) == '\n') {
                count++;
            }
        }
        if (count == mess.length()) {
            return "";
        }

        if (mess.charAt(mess.length() - 1) == '\n') {
            return mess.substring(0, mess.length() - 1);
        }

        return mess;
    }

    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sendAttButtonMouseClicked
        // TODO add your handling code here:
        try {
            String mess = messageType.getText();
            StyledDocument doc = screenMessagePane.getStyledDocument();
            mess = formatMessage(mess);
            if (!mess.isEmpty()) {
                insertTextToPane(mess, "You", "right");
            }
            Client.send(mess);
            messageType.setText(null);
            revalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_sendAttButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                GUI g = new GUI();
                g.setVisible(true);
                
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    javax.swing.DefaultListModel<String> listModel = new javax.swing.DefaultListModel<>();
    private HashMap<Integer, JTextPane> screenStateHash = new HashMap<>();
    private HashMap<String, Integer> roomNameHash = new HashMap<>();
    private JTextPane currentScreen;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ChooseFileFrame;
    private javax.swing.JButton createRoom;
    private javax.swing.JFrame inputNameRoomFrame;
    private javax.swing.JTextField inputRoomName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JFrame loginFrame;
    private javax.swing.JPanel messageToolPanel;
    private javax.swing.JTextArea messageType;
    private javax.swing.JPanel nameRoomPanel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JFrame peopleOnlineFrame;
    private javax.swing.JList<String> roomList;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JButton saveRoomName;
    private javax.swing.JTextPane screenMessagePane;
    private javax.swing.JButton sendAttachment;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton showPeople;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JFrame wrongInputFrame;
    // End of variables declaration//GEN-END:variables

}
