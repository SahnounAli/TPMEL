
package Containers;


import Agents.*;
import Agents.BuyerAgent;

import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.awt.Color;
import jade.core.Runtime;

import jade.core.ProfileImpl;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;


public class SellerContainer extends javax.swing.JFrame {

     static AgentContainer agentContainer;
    
    public SellerContainer() {
        initComponents();
        this.setTitle("Sellers Factory");
        this.setSize(750,600);
        
        
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String agentName = agentNametField.getText();
                
              
                
                
                 try {
                     AgentController agentController = agentContainer.createNewAgent(agentName,
                            "Agents.SellerAgent", new Object[]{});      
                    agentController.start();
                    agentNametField.setText("");
                    
                    
                    
                    
                   

                } catch (StaleProxyException ex) {
                    Logger.getLogger(SellerContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                

               
            }
        });
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        agentNametField = new javax.swing.JTextField();
        agentName = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createButton.setBackground(new java.awt.Color(255, 255, 255));
        createButton.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        createButton.setForeground(new java.awt.Color(0, 102, 102));
        createButton.setText("Create");
        createButton.setBorder(null);
        jPanel1.add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 100, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 480, 10));

        agentNametField.setBackground(new java.awt.Color(0, 0, 0));
        agentNametField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        agentNametField.setForeground(new java.awt.Color(255, 255, 255));
        agentNametField.setBorder(null);
        agentNametField.setOpaque(false);
        jPanel1.add(agentNametField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 480, -1));

        agentName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        agentName.setForeground(new java.awt.Color(0, 102, 102));
        agentName.setText("Agent name:");
        jPanel1.add(agentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 90, -1));

        title.setFont(new java.awt.Font("Berlin Sans FB", 1, 45)); // NOI18N
        title.setForeground(new java.awt.Color(0, 102, 102));
        title.setText("Create new seller");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 400, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\1920x1080-black-solid-color-background.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\1920x1080-black-solid-color-background.jpg")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
Runtime runtime=Runtime.instance();
ProfileImpl  profileImpl = new ProfileImpl(false);   
 agentContainer = runtime.createAgentContainer(profileImpl); 
 profileImpl.setParameter(ProfileImpl.MAIN_HOST,"localhost");

 
     
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SellerContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellerContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellerContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellerContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellerContainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agentName;
    private javax.swing.JTextField agentNametField;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
