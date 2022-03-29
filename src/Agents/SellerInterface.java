
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SellerInterface extends javax.swing.JFrame {

     
    
   private SellerAgent sellerAgent;
    public SellerInterface() {
        initComponents();
        this.setTitle("Seller space");
        this.setSize(850,600);
        jTextArea1.setEditable(false);
        
        
        
       
    sendButton.addActionListener(new ActionListener(){

       @Override
       public void actionPerformed(ActionEvent e) {
        String receiverName=agentNameField.getText();
        String price=priceField.getText();
        String act=actField.getText();
        
  
        GuiEvent gev=new GuiEvent(this,1);
        Map<String,Object> params =new HashMap<>();
        params.put("receiverAgent", receiverName);
        params.put("price", price);
        params.put("act", act);
        
      
        
        
        
        
        gev.addParameter(params);
        sellerAgent.onGuiEvent(gev);
        
        
            }
    });
        
   
    }
    
    public String getName(){
        String agentName=agentNameField.getText();
        return agentName;
    }
    
    
    public SellerAgent getSellerAgent() {
	return sellerAgent;
    }

    public void setSellerAgent(SellerAgent sellerAgent) {
	this.sellerAgent = sellerAgent;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        quantityField = new javax.swing.JTextField();
        quantity = new javax.swing.JLabel();
        priceField1 = new javax.swing.JTextField();
        price1 = new javax.swing.JLabel();
        bookNameField = new javax.swing.JTextField();
        bookName = new javax.swing.JLabel();
        chat1 = new javax.swing.JLabel();
        chat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        actField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        agentNameField = new javax.swing.JTextField();
        act = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        agentName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Price", "Quantity"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 320, 200));

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 102, 102));
        updateButton.setText("update");
        updateButton.setActionCommand("Add");
        updateButton.setBorder(null);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 70, 20));

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(0, 102, 102));
        deleteButton.setText("delete");
        deleteButton.setActionCommand("Add");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 70, 20));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(0, 102, 102));
        addButton.setText("add");
        addButton.setActionCommand("Add");
        addButton.setBorder(null);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, 20));

        jSeparator6.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator6.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, 20));

        jSeparator5.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator5.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 200, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 200, 10));

        quantityField.setBackground(new java.awt.Color(0, 0, 0));
        quantityField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        quantityField.setForeground(new java.awt.Color(255, 255, 255));
        quantityField.setBorder(null);
        jPanel1.add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 200, -1));

        quantity.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        quantity.setForeground(new java.awt.Color(0, 102, 102));
        quantity.setText("Quantity:");
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 60, -1));

        priceField1.setBackground(new java.awt.Color(0, 0, 0));
        priceField1.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        priceField1.setForeground(new java.awt.Color(255, 255, 255));
        priceField1.setBorder(null);
        jPanel1.add(priceField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 200, -1));

        price1.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        price1.setForeground(new java.awt.Color(0, 102, 102));
        price1.setText("Price:");
        jPanel1.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, -1));

        bookNameField.setBackground(new java.awt.Color(0, 0, 0));
        bookNameField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        bookNameField.setForeground(new java.awt.Color(255, 255, 255));
        bookNameField.setBorder(null);
        bookNameField.setOpaque(false);
        jPanel1.add(bookNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, -1));

        bookName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        bookName.setForeground(new java.awt.Color(0, 102, 102));
        bookName.setText("Book name:");
        jPanel1.add(bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, -1));

        chat1.setFont(new java.awt.Font("Berlin Sans FB", 1, 22)); // NOI18N
        chat1.setForeground(new java.awt.Color(0, 102, 102));
        chat1.setText("My store");
        jPanel1.add(chat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 120, 40));

        chat.setFont(new java.awt.Font("Berlin Sans FB", 1, 22)); // NOI18N
        chat.setForeground(new java.awt.Color(0, 102, 102));
        chat.setText("Chats");
        jPanel1.add(chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 120, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 370, 200));

        sendButton.setBackground(new java.awt.Color(255, 255, 255));
        sendButton.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        sendButton.setForeground(new java.awt.Color(0, 102, 102));
        sendButton.setText("Send");
        sendButton.setBorder(null);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 90, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 260, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 260, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 260, 10));

        actField.setBackground(new java.awt.Color(0, 0, 0));
        actField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        actField.setForeground(new java.awt.Color(255, 255, 255));
        actField.setBorder(null);
        jPanel1.add(actField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 270, -1));

        priceField.setBackground(new java.awt.Color(0, 0, 0));
        priceField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        priceField.setForeground(new java.awt.Color(255, 255, 255));
        priceField.setBorder(null);
        jPanel1.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 270, -1));

        agentNameField.setBackground(new java.awt.Color(0, 0, 0));
        agentNameField.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        agentNameField.setForeground(new java.awt.Color(255, 255, 255));
        agentNameField.setBorder(null);
        agentNameField.setOpaque(false);
        jPanel1.add(agentNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 260, -1));

        act.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        act.setForeground(new java.awt.Color(0, 102, 102));
        act.setText("Act:");
        jPanel1.add(act, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 60, -1));

        price.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        price.setForeground(new java.awt.Color(0, 102, 102));
        price.setText("Message:");
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 70, -1));

        agentName.setFont(new java.awt.Font("Berlin Sans FB", 0, 15)); // NOI18N
        agentName.setForeground(new java.awt.Color(0, 102, 102));
        agentName.setText("Agent name:");
        jPanel1.add(agentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\1920x1080-black-solid-color-background.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
         if(bookName.getText().equals("")||price.getText().equals("")||quantity.getText().equals(""))
        {
           JOptionPane.showMessageDialog(this,"please enter all data");
        }
        else
        {
            String book[]={bookNameField.getText(),priceField1.getText(),quantityField.getText()};
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
            model.addRow(book);
            bookNameField.setText("");
            priceField1.setText("");
            quantityField.setText("");
            
            
            
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        String bookNameNew =model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String priceNew =model.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String quantityNew =model.getValueAt(jTable1.getSelectedRow(), 2).toString();
        
         bookNameField.setText(bookNameNew);
         priceField1.setText(priceNew);
         quantityField.setText(quantityNew);
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
          DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
          if(jTable1.getSelectedRowCount()==1){
              
            String bookName=bookNameField.getText();
            String price=priceField1.getText();
            String quantity=quantityField.getText();
            
            model.setValueAt(bookName, jTable1.getSelectedRow(), 0);
            model.setValueAt(price, jTable1.getSelectedRow(), 1);
            model.setValueAt(quantity, jTable1.getSelectedRow(), 2);
             bookNameField.setText("");
            priceField1.setText("");
            quantityField.setText("");
            JOptionPane.showMessageDialog(this,"update successfully");
                  
          }
          else
               JOptionPane.showMessageDialog(this,"wawawawawaw");
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        
          DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
          if(jTable1.getSelectedRowCount()==1){
              model.removeRow(jTable1.getSelectedRow());
            bookNameField.setText("");
            priceField1.setText("");
            quantityField.setText("");
          }
              
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel act;
    private javax.swing.JTextField actField;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel agentName;
    private javax.swing.JTextField agentNameField;
    private javax.swing.JLabel bookName;
    private javax.swing.JTextField bookNameField;
    private javax.swing.JLabel chat;
    private javax.swing.JLabel chat1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel price;
    private javax.swing.JLabel price1;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField priceField1;
    private javax.swing.JLabel quantity;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
