
import com.formdev.flatlaf.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GUI extends javax.swing.JFrame implements Runnable {

    Thread listeningHandler;
    private String urlAvatar = new String("./scr/database/user_img/student.png");
    File avatar;
    //private Avatar avatar = new Avatar(urlAvatar, 100, 100);
    BufferedImage bi;

    /**
     * Creates new form GUI
     */
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

        ChooseFileFrame = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        peopleOnlineFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        userOnlineList = new javax.swing.JList<>();
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
        inviteToRoom = new javax.swing.JFrame();
        inputNameOfUser = new javax.swing.JTextField();
        inviteButton = new javax.swing.JButton();
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

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\"));

            javax.swing.GroupLayout ChooseFileFrameLayout = new javax.swing.GroupLayout(ChooseFileFrame.getContentPane());
            ChooseFileFrame.getContentPane().setLayout(ChooseFileFrameLayout);
            ChooseFileFrameLayout.setHorizontalGroup(
                ChooseFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            );
            ChooseFileFrameLayout.setVerticalGroup(
                ChooseFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jPanel2.setBackground(new java.awt.Color(255, 255, 255));

            userOnlineList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            userOnlineList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            userOnlineList.setModel(userListModel);
            jScrollPane4.setViewportView(userOnlineList);

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
            loginFrame.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    loginFrameKeyPressed(evt);
                }
            });

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
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signInButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(signUpButton)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addContainerGap(76, Short.MAX_VALUE))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(signInButton)
                        .addComponent(signUpButton))
                    .addContainerGap(166, Short.MAX_VALUE))
            );

            jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 0, 330, -1));

            labelText.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
            labelText.setForeground(new java.awt.Color(255, 255, 255));
            labelText.setText("Chat Application");
            jPanel3.add(labelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 70));

            jLabel3.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("A small project from Vanism");
            jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 260, 40));

            label.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\GitHub\\Chat-Application\\GUIProject\\src\\database\\user_img\\1547582.jpg")); // NOI18N
            label.setText("Chat");
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

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inputRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSaveRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(btnSaveRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

            inviteToRoom.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            inputNameOfUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

            inviteButton.setText("INVITE");
            inviteButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    inviteButtonMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout inviteToRoomLayout = new javax.swing.GroupLayout(inviteToRoom.getContentPane());
            inviteToRoom.getContentPane().setLayout(inviteToRoomLayout);
            inviteToRoomLayout.setHorizontalGroup(
                inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inviteToRoomLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inputNameOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(inviteButton)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            inviteToRoomLayout.setVerticalGroup(
                inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inviteToRoomLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(inviteToRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inviteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(inputNameOfUser))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Chat Application");
            setBackground(new java.awt.Color(204, 255, 255));
            setMinimumSize(new java.awt.Dimension(900, 700));
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowActivated(java.awt.event.WindowEvent evt) {
                    formWindowActivated(evt);
                }
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

            showPeople.setBackground(new java.awt.Color(255, 255, 255));
            showPeople.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group.png"))); // NOI18N
            showPeople.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    showPeopleMouseClicked(evt);
                }
            });
            showPeople.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    showPeopleActionPerformed(evt);
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
                    .addComponent(showPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(showPeople, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addComponent(createRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jScrollPane2.setBackground(new java.awt.Color(204, 255, 255));

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

            nameRoomPanel.setBackground(new java.awt.Color(0, 0, 102));
            nameRoomPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
            nameRoomPanel.setAlignmentX(0.0F);
            nameRoomPanel.setAlignmentY(0.0F);
            nameRoomPanel.setPreferredSize(new java.awt.Dimension(550, 50));

            lblNameRoom.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
            lblNameRoom.setForeground(new java.awt.Color(255, 255, 255));
            lblNameRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblNameRoom.setText("PUBLIC ROOM");

            addUserToRoom.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    addUserToRoomMouseClicked(evt);
                }
            });
            addUserToRoom.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    addUserToRoomActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout nameRoomPanelLayout = new javax.swing.GroupLayout(nameRoomPanel);
            nameRoomPanel.setLayout(nameRoomPanelLayout);
            nameRoomPanelLayout.setHorizontalGroup(
                nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameRoomPanelLayout.createSequentialGroup()
                    .addGap(185, 185, 185)
                    .addComponent(lblNameRoom)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                    .addComponent(addUserToRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            nameRoomPanelLayout.setVerticalGroup(
                nameRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(nameRoomPanelLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(lblNameRoom)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(addUserToRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    messageTypeKeyPressed(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    messageTypeKeyTyped(evt);
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

            jScrollPane3.setBackground(new java.awt.Color(204, 255, 255));
            jScrollPane3.setBorder(null);
            jScrollPane3.setAutoscrolls(true);

            screenMessagePane.setEditable(false);
            screenMessagePane.setBorder(null);
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(messageToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sendAttachment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12))
            );

            jPanel5.setBackground(new java.awt.Color(255, 255, 255));

            usernameLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
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

            outbtn.setBackground(new java.awt.Color(255, 255, 255));
            outbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\GitHub\\Chat-Application\\GUIProject\\src\\database\\user_img\\logout.png")); // NOI18N
            outbtn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    outbtnMouseReleased(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(modeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(avaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(42, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(changeAvabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(outbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49))))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(avaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(modeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(changeAvabtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outbtn)
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(roomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nameRoomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addComponent(messageToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(nameRoomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

            Client.send("/showonline " + currentIdRoom);
            userListModel.addElement(roomNameString);
        }

    }//GEN-LAST:event_showPeopleMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

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
                urlAvatar = Client.account.getAvatar_img() ;
                avatar = new File (urlAvatar);
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
        String selectedRoomName = roomList.getSelectedValue();
        if (selectedRoomName != null) {
            currentScreen = screenStateHash.get(roomNameHash.get(selectedRoomName));
            currentIdRoom = roomNameHash.get(selectedRoomName);
            jScrollPane3.setViewportView(currentScreen);
            this.lblNameRoom.setText(selectedRoomName);
            
            // If user clicks to other room chat, online user list should be closed
            if (this.peopleOnlineFrame.isVisible())
            {
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

    private void messageTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTypeKeyPressed

    }//GEN-LAST:event_messageTypeKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        this.listeningHandler.stop();
        Client.send("null");

        Client.close();
    }//GEN-LAST:event_formWindowClosing

    private void loginFrameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginFrameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            this.loginFrameKeyPressed(null);
        }
    }//GEN-LAST:event_loginFrameKeyPressed

    private void inputRoomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRoomNameActionPerformed

    }//GEN-LAST:event_inputRoomNameActionPerformed

    private void inputRoomNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputRoomNameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            this.btnSaveRoomNameMouseClicked(null);
        }
    }//GEN-LAST:event_inputRoomNameKeyPressed

    private void showPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPeopleActionPerformed
        // Show online members in selected rooms;


    }//GEN-LAST:event_showPeopleActionPerformed

    private void changeAvabtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeAvabtnMouseReleased
        JFileChooser chooser = new JFileChooser();
        chooser.setName("Chooser avatar...");
        chooser.setSize(500, 400);
        chooser.setVisible(true);
        int value = chooser.showOpenDialog(this);
        if (value == JFileChooser.APPROVE_OPTION)
        {
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

    private void addUserToRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserToRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addUserToRoomActionPerformed

    private void outbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outbtnMouseReleased
        Client.send("/out");
        dispose();
    }//GEN-LAST:event_outbtnMouseReleased
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

    private final HashMap<Integer, JTextPane> screenStateHash = new HashMap<>();    // Mapping from id of a room to chatting screen
    private final HashMap<String, Integer> roomNameHash = new HashMap<>();  // Mapping from name of a room to its id

    private JTextPane currentScreen = new JTextPane();  // Pointer points to current chat screen 
    private int currentIdRoom;  // Store current id room that user is on chatting 
    private String roomNameString = "";      // Store current string room that user is on chatting 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ChooseFileFrame;
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
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelText;
    private javax.swing.JLabel lblNameRoom;
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
