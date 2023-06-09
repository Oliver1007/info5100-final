/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src;

import connect.util.DbUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Driver;
import model.Shipment;
import model.ShipmentDirectory;
import model.User;
import model.UserDirectory;

/**
 *
 * @author wenqing-mbp16
 */
public class distributePanel extends javax.swing.JPanel {

    /**
     * Creates new form distributePanel
     */
    public distributePanel() {
        initComponents();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        distributeTitleLabel = new javax.swing.JLabel();
        shipmentsTable = new javax.swing.JScrollPane();
        shipmentTable = new javax.swing.JTable();
        iDLabel = new javax.swing.JLabel();
        iDField = new javax.swing.JTextField();
        assignButton = new javax.swing.JButton();
        shipmentsTitleLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        distributeTitleLabel.setText("Distribute");

        shipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tracking Number", "Start Location", "Destination", "DriverID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        shipmentsTable.setViewportView(shipmentTable);

        iDLabel.setText("Driver ID ");

        iDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDFieldActionPerformed(evt);
            }
        });

        assignButton.setText("Assign");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        shipmentsTitleLabel.setText("Shipments");

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shipmentsTable)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(refreshButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shipmentsTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(distributeTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(assignButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(distributeTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(shipmentsTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shipmentsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(refreshButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iDLabel)
                    .addComponent(iDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(assignButton)
                .addContainerGap(276, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDFieldActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        // TODO add your handling code here:
        Shipment s;
        int selectedIndex = shipmentTable.getSelectedRow();
        if(selectedIndex < 0){
            JOptionPane.showMessageDialog(this, "Please selecr a row");
        }else{
            DefaultTableModel model = (DefaultTableModel) shipmentTable.getModel();
            s = (Shipment) model.getValueAt(selectedIndex, 0);
            
            User d = null;
            //TODO: search id in user dir
            for(User u : UserDirectory.getInstance().getUsers()){
                if(u.getId() == Integer.parseInt(iDField.getText()) &&  u.getType().equals("driver")){
                    d = u;
                    break;
                }
            }
            
            if(d == null){
                JOptionPane.showMessageDialog(this, "driver does not exist!");
            }else{
                s.setDriverID(Integer.parseInt(iDField.getText()));
                d.addShipment(s);
                try {
                    DbUtil.getInstance().updateShipmenttoShipmentTable(s);
                } catch (SQLException ex) {
                    Logger.getLogger(distributePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Assigned!");
            }
        }
        populateTable();
    }//GEN-LAST:event_assignButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
        JOptionPane.showMessageDialog(this, "updated!");
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) shipmentTable.getModel();
        model.setRowCount(0);
        for(Shipment s: ShipmentDirectory.getInstance().getShipment()){
            Object[] row = new Object[4];
            row[0] = s;
            row[1] = s.getStartAddress();
            row[2] = s.getDesAddress();
            row[3] = s.getDriverID();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JLabel distributeTitleLabel;
    private javax.swing.JTextField iDField;
    private javax.swing.JLabel iDLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable shipmentTable;
    private javax.swing.JScrollPane shipmentsTable;
    private javax.swing.JLabel shipmentsTitleLabel;
    // End of variables declaration//GEN-END:variables
}
