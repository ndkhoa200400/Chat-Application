
import com.formdev.flatlaf.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GUI extends javax.swing.JFrame implements Runnable {

    Thread listeningHandler;
    private String urlAvatar = new String("./scr/database/user_img/student.png");
    File avatar;

    BufferedImage bi;

    public GUI() throws IOException {
        initComponents();
        screenStateHash.put(0, screenMessagePane);
        currentScreen = screenMessagePane;
        currentIdRoom = 0;
        roomNameHash.put("PUBLIC CHAT", 0);
        Client.connectToServer();
        // Listening to server
        listeningHandler = new Thread(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        peopleOnlineFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        userOnlineList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        loginFrame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        signInButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        labelText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        wrongInputFrame = new javax.swing.JFrame();
        inputNameRoomFrame = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        inputRoomName = new javax.swing.JTextField();
        btnSaveRoomName = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        inviteToRoom = new javax.swing.JFrame();
        inputNameOfUser = new javax.swing.JTextField();
        inviteButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        roomPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        showPeople = new javax.swing.JButton();
        createRoom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomList = new javax.swing.JList<>();
        nameRoomPanel = new javax.swing.JPanel();
        lblNameRoom = new javax.swing.JLabel();
        addUserToRoom = new javax.swing.JButton();
        messageToolPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageType = new javax.swing.JTextArea();
        sendAttachment = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        screenMessagePane = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        modeLabel = new javax.swing.JLabel();
        changeAvabtn = new javax.swing.JButton();
        outbtn = new javax.swing.JButton();
        avaLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listAttach = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        saveAttachBtn = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        userOnlineList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        userOnlineList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userOnlineList.setModel(userListModel);
        jScrollPane4.setViewportView(userOnlineList);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Online Users");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(574, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");

        usernameInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordInputKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(signInButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signUpButton)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInButton)
                    .addComponent(signUpButton))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 0, 330, 410));

        labelText.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelText.setForeground(new java.awt.Color(255, 255, 255));
        labelText.setText("Chat Application");
        jPanel3.add(labelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("A small project from Vanism");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 260, 40));

        label.setIcon(new javax.swing.ImageIcon("./src/database/user_img/1547582.jpg")); // NOI18N
        jPanel3.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 410));

        javax.swing.GroupLayout loginFrameLayout = new javax.swing.GroupLayout(loginFrame.getContentPane());
        loginFrame.getContentPane().setLayout(loginFrameLayout);
        loginFrameLayout.setHorizontalGroup(
            loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginFrameLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        loginFrameLayout.setVerticalGroup(
            loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginFrameLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        inputNameRoomFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        inputRoomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRoomNameActionPerformed(evt);
            }
        });
        inputRoomName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputRoomNameKeyPressed(evt);
            }
        });

        btnSaveRoomName.setText("OK");
        btnSaveRoomName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveRoomNameMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Enter Name of Room");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(inputRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveRoomName))
                .addContainerGap())
        );

        javax.swing.GroupLayout inputNameRoomFrameLayout = new javax.swing.GroupLayout(inputNameRoomFrame.getContentPane());
        inputNameRoomFrame.getContentPane().setLayout(inputNameRoomFrameLayout);
        inputNameRoomFrameLayout.setHorizontalGroup(
            inputNameRoomFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        inputNameRoomFrameLayout.setVerticalGroup(
            inputNameRoomFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputNameRoomFrameLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        inviteToRoom.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        inputNameOfUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        inviteButton.setText("INVITE");
        inviteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inviteButtonMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Enter Username");

        javax.swing.GroupLayout inviteToRoomLayout = new javax.swing.GroupLayout(inviteToRoom.getContentPane());
        inviteToRoom.getContentPane().setLayout(inviteToRoomLayout);
        inviteToRoomLayout.setHorizontalGroup(
            inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inviteToRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(inviteToRoomLayout.createSequentialGroup()
                        .addComponent(inputNameOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inviteButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inviteToRoomLayout.setVerticalGroup(
            inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inviteToRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNameOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inviteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Application");
        setBackground(new java.awt.Color(204, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        roomPanel.setBackground(new java.awt.Color(0, 0, 102));
        roomPanel.setAlignmentX(0.0F);
        roomPanel.setAlignmentY(0.0F);
        roomPanel.setMaximumSize(new java.awt.Dimension(250, 600));
        roomPanel.setMinimumSize(new java.awt.Dimension(250, 600));
        roomPanel.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        showPeople.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group.png"))); // NOI18N
        showPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPeopleMouseClicked(evt);
            }
        });

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
                .addContainerGap()
                .addComponent(showPeople)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showPeople, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(204, 255, 255));

        roomList.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        roomList.setForeground(new java.awt.Color(51, 51, 51));
        listModel.addElement("PUBLIC CHAT");
        roomList.setModel(listModel);
        roomList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomList.setAlignmentX(1.0F);
        roomList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomList.setSelectionBackground(new java.awt.Color(153, 153, 153));
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        nameRoomPanel.setBackground(new java.awt.Color(0, 0, 102));
        nameRoomPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        nameRoomPanel.setAlignmentX(0.0F);
        nameRoomPanel.setAlignmentY(0.0F);
        nameRoomPanel.setPreferredSize(new java.awt.Dimension(550, 50));

        lblNameRoom.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblNameRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblNameRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameRoom.setText("PUBLIC CHAT");

        addUserToRoom.setText("Invite");
        addUserToRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserToRoomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nameRoomPanelLayout = new javax.swing.GroupLayout(nameRoomPanel);
        nameRoomPanel.setLayout(nameRoomPanelLayout);
        nameRoomPanelLayout.setHorizontalGroup(
            nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameRoomPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblNameRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addUserToRoom)
                .addContainerGap())
        );
        nameRoomPanelLayout.setVerticalGroup(
            nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameRoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserToRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameRoom))
                .addContainerGap())
        );

        messageToolPanel.setBackground(new java.awt.Color(204, 255, 255));
        messageToolPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                messageTypeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(messageType);

        sendAttachment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paperclip.png"))); // NOI18N
        sendAttachment.setAlignmentY(0.0F);
        sendAttachment.setMaximumSize(new java.awt.Dimension(80, 80));
        sendAttachment.setMinimumSize(new java.awt.Dimension(80, 80));
        sendAttachment.setPreferredSize(new java.awt.Dimension(80, 80));
        sendAttachment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendAttachmentMouseClicked(evt);
            }
        });

        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send.png"))); // NOI18N
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

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setAutoscrolls(true);

        screenMessagePane.setEditable(false);
        screenMessagePane.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jScrollPane3.setViewportView(screenMessagePane);

        javax.swing.GroupLayout messageToolPanelLayout = new javax.swing.GroupLayout(messageToolPanel);
        messageToolPanel.setLayout(messageToolPanelLayout);
        messageToolPanelLayout.setHorizontalGroup(
            messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendAttachment, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(messageToolPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        messageToolPanelLayout.setVerticalGroup(
            messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageToolPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sendAttachment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        usernameLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username");

        modeLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        modeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modeLabel.setText("Student");

        changeAvabtn.setText("Change Avatar");
        changeAvabtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changeAvabtnMouseReleased(evt);
            }
        });

        outbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outbtnMouseReleased(evt);
            }
        });

        listAttach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listAttach.setModel(fileListModel);
        jScrollPane5.setViewportView(listAttach);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("List attachments");

        saveAttachBtn.setText("Save");
        saveAttachBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveAttachBtnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(outbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(saveAttachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(modeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeAvabtn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(avaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeAvabtn)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(saveAttachBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nameRoomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(messageToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nameRoomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(messageToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showOnline(String users) {

        DefaultListModel<String> list = new DefaultListModel();
        String listUsers[] = users.split("\n");
        for (String user : listUsers) {
            list.addElement(user);

        }
        this.userOnlineList.setModel(list);
        peopleOnlineFrame.setVisible(true);
    }

    private void insertTextToPane(String msg, String name, String align, JTextPane screen) {
        try {

            StyledDocument doc = screen.getStyledDocument();
            msg = formatMessage(msg);
            SimpleAttributeSet keyWord = new SimpleAttributeSet();
            SimpleAttributeSet keyWordName = new SimpleAttributeSet();

            //StyleConstants.setLineSpacing(keyWord, (float)0.05);
            if (align.equals("right")) {
                // If this client chats
                StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_RIGHT);
                StyleConstants.setAlignment(keyWordName, StyleConstants.ALIGN_RIGHT);

                StyleConstants.setForeground(keyWord, Color.DARK_GRAY);
                StyleConstants.setForeground(keyWordName, Color.LIGHT_GRAY);

            } else {
                // Others send msg to this client
                StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_LEFT);
                StyleConstants.setAlignment(keyWordName, StyleConstants.ALIGN_LEFT);

                StyleConstants.setForeground(keyWord, Color.BLACK);
                StyleConstants.setForeground(keyWordName, Color.LIGHT_GRAY);

            }
            doc.setParagraphAttributes(doc.getLength(), 1, keyWord, true);
            doc.insertString(doc.getLength(), name + "\n", keyWordName);

            StyleConstants.setFontSize(keyWord, 18);
            StyleConstants.setFontSize(keyWordName, 18);

            doc.insertString(doc.getLength(), " " + msg + " " + "\n", keyWord);

            JScrollBar sb = jScrollPane3.getVerticalScrollBar();
            sb.setValue(sb.getMaximum());

        } catch (BadLocationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        // Listening from server 
        // Get message from server
        try {
            while (true) {

                String mess = Client.listen();
                // mess: "ROOM-username: msg"
                // if send to public chat => mess :"username: msg"
                // res[0]: destication
                // res[1]: username: msg
                System.out.println("Received message: " + mess);
                
                if(mess == null){
                    System.out.println("!! Message from server is null.");
                    break;
                }
                
                String res[] = mess.split("-");
                String destination = "0";
                int split;
                String name = "admin";

                // If send privately 
                if (res.length == 2) {
                    destination = res[0];
                    split = res[1].indexOf(": ");
                    // If message from a user
                    if (split > 0) {
                        name = res[1].substring(0, split);
                        mess = res[1].substring(split + 1);
                    } else {
                        mess = res[1];
                    }

                } // If send to public room
                else {
                    split = res[0].indexOf(": ");
                    if (split > 0) {
                        name = mess.substring(0, split);
                        mess = mess.substring(split + 1);

                        //if send file to all
                      
                    }
                }

                if (name.equals("admin")) {
                    String[] response = mess.split(" ");

                    switch (response[0]) {
                        // user creates new room
                        // get information of room from server;
                        // command: createroom idroom nameroom
                        case "createroom":
                            int commandIndex = "createroom".length();
                            int roomIDIndex = mess.indexOf(" ", commandIndex + 1);
                            createNewRoom(Integer.parseInt(mess.substring(commandIndex + 1, roomIDIndex)), mess.substring(roomIDIndex + 1));
                            break;
                        // user is invited to room
                        // command: invite room_id room_name  
                        case "invite":

                            // split substring based on whitespace
                            commandIndex = "invite".length();
                            roomIDIndex = mess.indexOf(" ", commandIndex + 1);

                            //insert that room to listroom
                            joinToRoom(mess.substring(commandIndex + 1, roomIDIndex), mess.substring(roomIDIndex + 1));
                            break;
                        case "showonline":
                            commandIndex = "showonline".length();
                            int usersIndex = mess.indexOf(" ");

                            showOnline(mess.substring(usersIndex + 1));
                            break;
                        case "sendfile": //add files have been sent to {listAtt}
                            String newMess = response[1] + " has sent a new file: " + response[2];
                            this.insertTextToPane(newMess, name, "left", this.screenStateHash.get(0));
                            //then add to listAtt
                            this.fileListModel.addElement(response[2]);
                            break;
//                        case "receivefile": //download the selected file in listAtt
//                            //get the selected fileName in listAtt
//                            //then send it to sever
//                            //Client.sendFile(server, fileName);
//                            
//                            break;
                        default:
                            insertTextToPane(mess, name, "left", this.screenStateHash.get(0));
                    }

                } else {

                    Integer roomID = Integer.parseInt(destination);

                    JTextPane roomPane = this.screenStateHash.get(roomID);

                    insertTextToPane(mess, name, "left", roomPane);

                }

            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void joinToRoom(String roomID, String roomName) {
        // When client is invited to a room

        JTextPane newMessScreen;
        newMessScreen = new javax.swing.JTextPane();
        newMessScreen.setEditable(false);
        newMessScreen.setBorder(null);
        newMessScreen.setFont(new java.awt.Font("Segoe UI Historic", 0, 16));
        newMessScreen.setAutoscrolls(false);
        newMessScreen.setText("");
        listModel.addElement(roomName);
        roomNameHash.put(roomName, Integer.parseInt(roomID));
        screenStateHash.put(Integer.parseInt(roomID), newMessScreen);
    }
    private void sendAttachmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendAttachmentMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setName("Chooser file...");
        chooser.setSize(500, 400);
        chooser.setVisible(true);
        int value = chooser.showOpenDialog(this);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String filePath = file.getPath();
            if (!filePath.isEmpty()) {
                try {
                    //gui file
                    Client.send("/sendfile " +filePath);
                    Client.sendFile(Client.server, filePath);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //sau khi send file thanh cong - add file vao listAttach
        //xu ly receive file xong add vao listAttach
    }//GEN-LAST:event_sendAttachmentMouseClicked

    private void showPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPeopleMouseClicked
        // TODO add your handling code here:
        if (peopleOnlineFrame.isVisible()) {
            peopleOnlineFrame.dispose();
        } else {
            peopleOnlineFrame.setLocation(this.getX() - 290, this.getY());
            peopleOnlineFrame.setSize(300, 700);

            Client.send("/showonline " + currentIdRoom);
            userListModel.addElement(roomNameString);
        }

    }//GEN-LAST:event_showPeopleMouseClicked

    private void signInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInButtonMouseClicked

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
                this.setTitle("Chatterbox - User: " + Client.account.getUserName());
                urlAvatar = Client.account.getAvatar_img();
                avatar = new File(urlAvatar);
                avaLabel.setIcon(new ImageIcon(new ImageIcon(urlAvatar).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                usernameLabel.setText(Client.account.getUserName());
                modeLabel.setText(Client.account.getMode());
                this.setVisible(true);
                listeningHandler.start();
            } else {
                JOptionPane.showMessageDialog(null, "Your password or username is incorrect!");
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
        loginFrame.pack();
        this.setVisible(false);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed

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
            if (isValid) {
                loginFrame.setVisible(false);
                loginFrame.dispose();
                this.setTitle("Chatterbox - User: " + Client.account.getUserName());
                urlAvatar = Client.account.getAvatar_img();
                avatar = new File(urlAvatar);
                avaLabel.setIcon(new ImageIcon(new ImageIcon(urlAvatar).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                usernameLabel.setText(Client.account.getUserName());
                modeLabel.setText(Client.account.getMode());
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

    }//GEN-LAST:event_sendButtonActionPerformed

    private void roomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomListMouseClicked
        // When user clicks to a room to chat
        String selectedRoomName = this.roomList.getSelectedValue();
        if (selectedRoomName != null) {
            this.currentScreen = this.screenStateHash.get(this.roomNameHash.get(selectedRoomName));
            this.currentIdRoom = this.roomNameHash.get(selectedRoomName);
            this.jScrollPane3.setViewportView(this.currentScreen);
            this.lblNameRoom.setText(selectedRoomName);

            // If user clicks to other room chat, online user list should be closed
            if (this.peopleOnlineFrame.isVisible()) {
                this.peopleOnlineFrame.setVisible(false);
            }
        }

    }//GEN-LAST:event_roomListMouseClicked
    private void createNewRoom(Integer idRoom, String nameRoom) {
        if (roomNameString.isEmpty()) {
            roomNameString = "Room " + nameRoom;
        }
        JTextPane newMessScreen;
        newMessScreen = new javax.swing.JTextPane();
        newMessScreen.setEditable(false);
        newMessScreen.setBackground(Color.WHITE);
        newMessScreen.setBorder(null);
        newMessScreen.setFont(new java.awt.Font("Segoe UI Historic", 0, 16));
        newMessScreen.setAutoscrolls(false);
        newMessScreen.setText("");
        listModel.addElement(roomNameString);
        roomNameHash.put(nameRoom, idRoom);
        screenStateHash.put(idRoom, newMessScreen);
    }
    private void createRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createRoomMouseClicked
        // TODO add your handling code here:
        inputNameRoomFrame.setVisible(true);
        inputNameRoomFrame.setLocationRelativeTo(this);
        inputNameRoomFrame.pack();
    }//GEN-LAST:event_createRoomMouseClicked

    private void btnSaveRoomNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveRoomNameMouseClicked
        // TODO add your handling code here:
        roomNameString = inputRoomName.getText();
        inputRoomName.setText("");
        inputNameRoomFrame.setVisible(false);
        inputNameRoomFrame.dispose();

        Client.send("/createroom " + roomNameString);
    }//GEN-LAST:event_btnSaveRoomNameMouseClicked

    private void addUserToRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserToRoomMouseClicked
        // TODO add your handling code here:
        if (roomNameHash.get("PUBLIC CHAT") != currentIdRoom) {
            inviteToRoom.setVisible(true);
            inviteToRoom.setLocationRelativeTo(this);
            inviteToRoom.pack();
        }
    }//GEN-LAST:event_addUserToRoomMouseClicked

    private void inviteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inviteButtonMouseClicked
        // TODO add your handling code here:
        String username = inputNameOfUser.getText();
        Client.send("/invite " + currentIdRoom + ": " + username);
        inputNameOfUser.setText("");
        inviteToRoom.dispose();
    }//GEN-LAST:event_inviteButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        this.listeningHandler.stop();
        Client.send("null");

        Client.close();
    }//GEN-LAST:event_formWindowClosing

    private void inputRoomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRoomNameActionPerformed

    }//GEN-LAST:event_inputRoomNameActionPerformed

    private void inputRoomNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputRoomNameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            this.btnSaveRoomNameMouseClicked(null);
        }
    }//GEN-LAST:event_inputRoomNameKeyPressed

    private void changeAvabtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeAvabtnMouseReleased
        JFileChooser chooser = new JFileChooser();
        chooser.setName("Chooser avatar...");
        chooser.setSize(500, 400);
        chooser.setVisible(true);
        int value = chooser.showOpenDialog(this);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            urlAvatar = file.getPath();
//            avatar.loadAvatar(urlAvatar, 100, 100);

            try {
                // display the image in a Jlabel
//            bi = ImageIO.read(file);
//            bi = bi.
                avaLabel.setIcon(new ImageIcon(new ImageIcon(urlAvatar).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

                Client.account.changeAvatar(urlAvatar);
                //System.out.println(urlAvatar);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_changeAvabtnMouseReleased
    }

    private void outbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outbtnMouseReleased
        Client.send("/out");
        dispose();
    }//GEN-LAST:event_outbtnMouseReleased

    private void passwordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            java.awt.event.MouseEvent evt1 = null;
            this.signInButtonMouseClicked(evt1);
        }
    }//GEN-LAST:event_passwordInputKeyPressed

    private void messageTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTypeKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && (evt.getModifiers() & InputEvent.SHIFT_MASK) != 0){
             this.messageType.setText(this.messageType.getText() + '\n');
        }
        else 
        if (evt.getKeyChar() == '\n' && (evt.getModifiers() & InputEvent.SHIFT_MASK) == 0) {
            java.awt.event.MouseEvent evt1 = null;
            sendButtonMouseClicked(evt1);
        }
    }//GEN-LAST:event_messageTypeKeyReleased

    private void saveAttachBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAttachBtnMouseReleased
        // TODO add your handling code here:
        String nameFile = this.listAttach.getSelectedValue();
        if(nameFile == null || nameFile.isEmpty()){
            this.wrongInputFrame.setSize(320, 150);
            javax.swing.JLabel msgErr = new javax.swing.JLabel("Please select a file to save.");
            msgErr.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
            msgErr.setBounds(20, this.wrongInputFrame.getHeight() / 5, 300, 50);
            this.wrongInputFrame.add(msgErr);
            msgErr.setBackground(Color.white);
            msgErr.setVisible(true);
            this.wrongInputFrame.setLocationRelativeTo(this);
            this.wrongInputFrame.setVisible(true);
        }
        else{
            Client.send("/receive " + nameFile);
            //Client.recvFile(Client.server, nameFile);
        }
    }//GEN-LAST:event_saveAttachBtnMouseReleased
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

    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // When client presses send button
        String mess = messageType.getText();
        mess = formatMessage(mess);
        if (!mess.isEmpty()) {
            insertTextToPane(mess, "You", "right", currentScreen);
        }
        if (currentIdRoom != 0) {
            mess = "/room " + currentIdRoom + ": " + mess;
        }
        Client.send(mess);

        messageType.setText(null);
        revalidate();
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
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
    javax.swing.DefaultListModel<String> userListModel = new javax.swing.DefaultListModel<>();
    javax.swing.DefaultListModel<String> fileListModel = new javax.swing.DefaultListModel<>();

    private final HashMap<Integer, JTextPane> screenStateHash = new HashMap<>();    // Mapping from id of a room to chatting screen
    private final HashMap<String, Integer> roomNameHash = new HashMap<>();  // Mapping from name of a room to its id

    private JTextPane currentScreen = new JTextPane();  // Pointer points to current chat screen 
    private int currentIdRoom;  // Store current id room that user is on chatting 
    private String roomNameString = "";      // Store current string room that user is on chatting 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserToRoom;
    private javax.swing.JLabel avaLabel;
    private javax.swing.JButton btnSaveRoomName;
    private javax.swing.JButton changeAvabtn;
    private javax.swing.JButton createRoom;
    private javax.swing.JTextField inputNameOfUser;
    private javax.swing.JFrame inputNameRoomFrame;
    private javax.swing.JTextField inputRoomName;
    private javax.swing.JButton inviteButton;
    private javax.swing.JFrame inviteToRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelText;
    private javax.swing.JLabel lblNameRoom;
    private javax.swing.JList<String> listAttach;
    private javax.swing.JFrame loginFrame;
    private javax.swing.JPanel messageToolPanel;
    private javax.swing.JTextArea messageType;
    private javax.swing.JLabel modeLabel;
    private javax.swing.JPanel nameRoomPanel;
    private javax.swing.JButton outbtn;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JFrame peopleOnlineFrame;
    private javax.swing.JList<String> roomList;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JButton saveAttachBtn;
    private javax.swing.JTextPane screenMessagePane;
    private javax.swing.JButton sendAttachment;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton showPeople;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JList<String> userOnlineList;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JFrame wrongInputFrame;
    // End of variables declaration//GEN-END:variables
}
