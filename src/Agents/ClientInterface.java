
package Agents;


import Containers.*;
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
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientInterface extends javax.swing.JFrame {

     
    
   private ClientAgent clientAgent;
    public ClientInterface() {
        initComponents();
        this.setTitle("Client space");
        this.setSize(850,600);
        jTextArea1.setEditable(false);
        
        
        
       
    orderButton.addActionListener(new ActionListener(){

       @Override
       public void actionPerformed(ActionEvent e) {
        String receiverName=agentNametField.getText();
        String bookTitle=bookTitletField.getText();
        String act=actField.getText();
        
  
        GuiEvent gev=new GuiEvent(this,1);
        Map<String,Object> params =new HashMap<>();
        params.put("receiverAgent", receiverName);
        params.put("bookTitle", bookTitle);
        params.put("act", act);
        
        
        gev.addParameter(params);
        clientAgent.onGuiEvent(gev);
        
        
            }
    });
        
   
    }
    
    public String getName(){
        String agentName=agentNametField.getText();
        return agentName;
    }
    
    
    public ClientAgent getBuyerAgent() {
	return clientAgent;
    }

    public void setClientAgent(ClientAgent clientAgent) {
	this.clientAgent = clientAgent;
    }
    
    public void showMessage(String msg,boolean test) {
	if(test)
            jTextArea1.append(msg+"\n");
        else
            jTextArea1.setText(msg);
    }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        orderButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        actField = new javax.swing.JTextField();
        bookTitletField = new javax.swing.JTextField();
        agentNametField = new javax.swing.JTextField();
        budget = new javax.swing.JLabel();
        bookTitle = new javax.swing.JLabel();
        agentName = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chat.setFont(new java.awt.Font("Berlin Sans FB", 1, 22)); // NOI18N
        chat.setForeground(new java.awt.Color(0, 102, 102));
        chat.setText("Chats");
        jPanel1.add(chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 120, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 360, 390));

        orderButton.setBackground(new java.awt.Color(255, 255, 255));
        orderButton.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        orderButton.setForeground(new java.awt.Color(0, 102, 102));
        orderButton.setText("Order");
        orderButton.setBorder(null);
        jPanel1.add(orderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 100, 40));

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 270, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 260, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 270, 10));

        actField.setBackground(new java.awt.Color(0, 0, 0));
        actField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        actField.setForeground(new java.awt.Color(255, 255, 255));
        actField.setBorder(null);
        jPanel1.add(actField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 270, -1));

        bookTitletField.setBackground(new java.awt.Color(0, 0, 0));
        bookTitletField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        bookTitletField.setForeground(new java.awt.Color(255, 255, 255));
        bookTitletField.setBorder(null);
        jPanel1.add(bookTitletField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 270, -1));

        agentNametField.setBackground(new java.awt.Color(0, 0, 0));
        agentNametField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        agentNametField.setForeground(new java.awt.Color(255, 255, 255));
        agentNametField.setBorder(null);
        agentNametField.setOpaque(false);
        jPanel1.add(agentNametField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 260, -1));

        budget.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        budget.setForeground(new java.awt.Color(0, 102, 102));
        budget.setText("Act:");
        jPanel1.add(budget, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 60, -1));

        bookTitle.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        bookTitle.setForeground(new java.awt.Color(0, 102, 102));
        bookTitle.setText("Message:");
        jPanel1.add(bookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 70, -1));

        agentName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        agentName.setForeground(new java.awt.Color(0, 102, 102));
        agentName.setText("Agent name:");
        jPanel1.add(agentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 90, -1));

        title.setFont(new java.awt.Font("Berlin Sans FB", 1, 22)); // NOI18N
        title.setForeground(new java.awt.Color(0, 102, 102));
        title.setText("Order book");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\1920x1080-black-solid-color-background.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actField;
    private javax.swing.JLabel agentName;
    private javax.swing.JTextField agentNametField;
    private javax.swing.JLabel bookTitle;
    private javax.swing.JTextField bookTitletField;
    private javax.swing.JLabel budget;
    private javax.swing.JLabel chat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton orderButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
