import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author amineelalaoui
 */
public class client extends javax.swing.JFrame {

	static Scanner  sc=new Scanner(System.in);
    private String hostname;
    private int port;
    private String userName;
    BufferedReader reader;
    PrintWriter writer;
    Thread envoi;
    
    
//    static Socket s;
//    static DataInputStream dis;
//    static DataOutputStream dout;
    static Box vertical = Box.createVerticalBox();
    JPanel a1;
    
    private static Socket socket ;
    public client(String hostname,int port) throws IOException {
    	
        initComponents();
        this.hostname = hostname;
        this.port = port;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
        socket= new Socket();
        envoi= new Thread(new Runnable() {
        	
            String msg;
            @Override
            public void run() {
            	System.out.println("entrer votre nom");
            	String userName = sc.nextLine();
                setUserName(userName);
                writer.println(userName);
         
                String text;
         
                	while(true) {
                		
                  msg=msg_text.getText();
				  JPanel p2 =formatLabel(msg);
				  msg_area.setLayout(new BorderLayout());
				  JPanel right = new JPanel(new BorderLayout());
				  right.add(p2, BorderLayout.LINE_END);
				  vertical.add(right);
				  vertical.add(Box.createVerticalStrut(15));
				  msg_area.add(vertical, BorderLayout.PAGE_START);
				  
//				  dout.writeUTF(msg);
				  msg_text.setText("");
                		
                		
                		
//                	System.out.println("--Utilisateur " + userName + "--: ");
//                	text = sc.nextLine();
                    writer.println(msg);
                	}
            }
         });
//         envoi.start();
         
         Thread recevoir= new Thread(new Runnable() {
             String msg ;
             @Override
             public void run() {
             	while (true) {
                     try {
                    	 
                         String response = reader.readLine();
//                         str=response;
                         show_mes_server(response); 
                         // prints the username after displaying the server's message
                         if (getUserName() != null) {
                             System.out.print("--Utilisateur " + getUserName() + "--: ");
                         }
                     } catch (IOException ex) {
                         System.out.println("Erreur: " + ex.getMessage());
                         ex.printStackTrace();
                         break;
                     }
                 }
                
            }
         });
         recevoir.start();
    }
    
    void setUserName(String userName) {
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
    
    public void show_mes_server(String sever_msg) {
        if(sever_msg.charAt(0)=='[') {
        	
        	jPanel1.removeAll();
        	JPanelUsers = new JPanel();
            JPanelUsers.setBounds(0, 82, 390, 406);
            jPanel1.add(JPanelUsers);
            JPanelUsers.setLayout(null);
        	
        	System.out.println("users : "+sever_msg);
        	 char[] ch = new char[sever_msg.length()];
             for (int i=0; i < sever_msg.length()-2; i++) {
                 ch[i] = sever_msg.charAt(i+1);
             }              
             String chaine=Character.toString(ch[0]);
             for (int i=1; i<sever_msg.length(); i++) {
            	 chaine=chaine+ch[i];
             }
        	String[] users=chaine.split(",");
        	for(int i=0,j=150;i<users.length;i++) {
        		
        		System.out.println(users[i]);
        		JLabel arrayJLs = new JLabel("jlabell"+i);
        		       		
        		arrayJLs.setBackground(Color.red);
        		arrayJLs.setText(users[i]);
//        		arrayJLs.setOpaque(true);
        		JPanelUsers.add(arrayJLs);
        		arrayJLs.setLocation(80,j);
        		arrayJLs.setSize(86, 14);
        		j=j+40;

        	}
        }else {
        	
        	JPanel p2 = formatLabel(sever_msg);
            
            JPanel left = new JPanel(new BorderLayout());
            left.add(p2, BorderLayout.LINE_START);
            vertical.add(left);
            
//        System.out.println("\n" + sever_msg);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        msg_text = new javax.swing.JTextField();
        ok = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        msg_send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        statut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 626));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(238, 238, 238)));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 526));

        jTextField1.setText("    Filter");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("First_username");
        jLabel1.setOpaque(true);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("First_username");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users.png"))); // NOI18N
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users.png"))); // NOI18N
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 324, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 90, 390, 540);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(238, 238, 238)));

        jLabel7.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contacts");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menus.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 390, 90);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 526));

        msg_text.setText("  Write your text...");
        msg_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msg_textKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                msg_textKeyReleased(evt);
            }
        });

        ok.setBackground(new java.awt.Color(51, 204, 255));
        ok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paper-plan.png"))); // NOI18N
        ok.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paper-cli.png"))); // NOI18N
        jLabel6.setOpaque(true);

        msg_send.setText("send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	envoi.start();
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(msg_send))
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        msg_area.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout msg_areaLayout = new javax.swing.GroupLayout(msg_area);
        msg_area.setLayout(msg_areaLayout);
        msg_areaLayout.setHorizontalGroup(
            msg_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        msg_areaLayout.setVerticalGroup(
            msg_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(msg_area);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(390, 90, 810, 510);

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel9.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("The_full_user_name_client");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circles.png"))); // NOI18N
        jLabel10.setText("Online");

        statut.setForeground(new java.awt.Color(255, 255, 255));
        statut.setText("active now");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statut, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(390, 0, 810, 102);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /*-----my function ----------*/
        public  static JPanel formatLabel(String out){
            
        JPanel p3 = new JPanel();
        
        
        JLabel l1 = new JLabel("<html><strong>Username2</strong>  <br/> "+out+"</html>");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        l1.setBackground(new Color(0,204,255)); 
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(2,2,7,50));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel l2 = new JLabel("<html><p style = \"width : 100px ; margin-left:10px;\">"+sdf.format(cal.getTime())+"</p></html>");
        l2.setText(sdf.format(cal.getTime()));
        
        
        l2.setForeground(new java.awt.Color(255, 255, 255));        
        p3.add(l1);
        p3.add(l2);
        return p3;
     }
     
//    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
//            msg_area.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//           try{
//            
//            String msg="";
//            msg=msg_text.getText();
//            JPanel p2 =formatLabel(msg);
//            
//            msg_area.setLayout(new BorderLayout());
//            
//            JPanel right = new JPanel(new BorderLayout());
//            right.add(p2, BorderLayout.LINE_END);
//            vertical.add(right);
//            vertical.add(Box.createVerticalStrut(15));
//            
//            msg_area.add(vertical, BorderLayout.PAGE_START);
//            
//            dout.writeUTF(msg);
//            msg_text.setText("");
//            }
//            catch(Exception e)
//            {
//                System.out.println(e);
//         }
//    }//GEN-LAST:event_msg_sendActionPerformed

    private void msg_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_textKeyPressed
        statut.setText("entrain d'ecrire..");
    }//GEN-LAST:event_msg_textKeyPressed

    private void msg_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_textKeyReleased
        statut.setText("active now");
    }//GEN-LAST:event_msg_textKeyReleased
     

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
            java.util.logging.Logger.getLogger(chattroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chattroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chattroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chattroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new client("localhost",2000).setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
//        try {
//        	socket= new Socket("localhost",2000);
//            String msgin = "";
////            s = new Socket("localhost",1201); 
//            while(true){
//            dis = new DataInputStream(socket.getInputStream());
//            dout = new DataOutputStream(socket.getOutputStream());
//
//            while (!msgin.equals("exit")) {
//                msgin = dis.readUTF();
//                JPanel p2 = formatLabel(msgin);
//                        
//                JPanel left = new JPanel(new BorderLayout());
//                left.add(p2, BorderLayout.LINE_START);
//                vertical.add(left);
//            }
//          }
//        } catch (Exception e) {
//            //handle the exception here
//        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel JPanelUsers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JPanel msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    private javax.swing.JLabel ok;
    private javax.swing.JLabel statut;
    // End of variables declaration//GEN-END:variables
}
