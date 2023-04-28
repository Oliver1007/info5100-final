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
import model.Shipment;
import model.ShipmentDirectory;
import model.User;
import model.UserDirectory;

/**
 *
 * @author User
 */
public class DriverPanel extends javax.swing.JPanel {

    /**
     * Creates new form DriverPanel
     */
    public DriverPanel() {
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

        jButton1 = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        driverIDLabel = new javax.swing.JLabel();
        driverIDField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        shipmentTable = new javax.swing.JTable();
        subtitleLabel = new javax.swing.JLabel();
        pathLabel = new javax.swing.JLabel();
        pathField = new javax.swing.JTextField();
        finishButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        inProgressButton = new javax.swing.JButton();
        locationField = new javax.swing.JTextField();
        addArrivalButton = new javax.swing.JButton();
        locationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        pathLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("Driver");

        driverIDLabel.setText("DriverID");

        shipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TrackingNum", "pickup address", "destination", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shipmentTable);

        subtitleLabel.setText("Unfinished shippment:");

        pathLabel.setText("Path");

        finishButton.setText("Finish");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        inProgressButton.setText("In Progress");
        inProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inProgressButtonActionPerformed(evt);
            }
        });

        addArrivalButton.setText("Add New Arrival");
        addArrivalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArrivalButtonActionPerformed(evt);
            }
        });

        locationLabel.setText("Location :");

        dateLabel.setText("Date/Time:");

        pathLabel3.setText("Set Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtitleLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(driverIDLabel)
                                    .addGap(58, 58, 58)
                                    .addComponent(driverIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(refreshButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pathLabel)
                                    .addComponent(locationLabel))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(dateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(addArrivalButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(143, 143, 143))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pathLabel3)
                                .addGap(58, 58, 58)
                                .addComponent(inProgressButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(finishButton)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleLabel)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverIDLabel)
                    .addComponent(driverIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(subtitleLabel)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathLabel)
                    .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationLabel)
                    .addComponent(addArrivalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inProgressButton)
                    .addComponent(finishButton)
                    .addComponent(pathLabel3))
                .addContainerGap(270, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
        JOptionPane.showMessageDialog(this, "Table refreshed!");
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        // TODO add your handling code here:
        Shipment s;
        int selectedIndex = shipmentTable.getSelectedRow();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please selecr a row");
        } else {
            DefaultTableModel model = (DefaultTableModel) shipmentTable.getModel();
            s = (Shipment) model.getValueAt(selectedIndex, 0);
            s.setStatus("finished");
            try {
                DbUtil.getInstance().updateShipmenttoShipmentTable(s);
            } catch (SQLException ex) {
                Logger.getLogger(DriverPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        populateTable();
    }//GEN-LAST:event_finishButtonActionPerformed

    private void inProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inProgressButtonActionPerformed
        // TODO add your handling code here:
        Shipment s;
        int selectedIndex = shipmentTable.getSelectedRow();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please selecr a row");
        } else {
            DefaultTableModel model = (DefaultTableModel) shipmentTable.getModel();
            s = (Shipment) model.getValueAt(selectedIndex, 0);
            s.setStatus("in progress");
            try {
                DbUtil.getInstance().updateShipmenttoShipmentTable(s);
            } catch (SQLException ex) {
                Logger.getLogger(DriverPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        populateTable();
    }//GEN-LAST:event_inProgressButtonActionPerformed

    @SuppressWarnings("empty-statement")
    private void addArrivalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArrivalButtonActionPerformed
        // TODO add your handling code here:
        Shipment s;
        int selectedIndex = shipmentTable.getSelectedRow();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please selecr a row");
        } else {
            DefaultTableModel model = (DefaultTableModel) shipmentTable.getModel();
            s = (Shipment) model.getValueAt(selectedIndex, 0);
            if (!locationField.getText().isEmpty() && !dateField.getText().isEmpty()) {
                String arr[] = {"", ""};
                arr[0] = locationField.getText();
                arr[1] = dateField.getText();
                s.addArrival(arr);
                try {
                    DbUtil.getInstance().updateShipmenttoShipmentTable(s);
                    DbUtil.getInstance().addArrivalsToArrTable(s, arr);
                } catch (SQLException ex) {
                    Logger.getLogger(DriverPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "locationa and date cannot be empty!");
            }
        }
        populateTable();
    }//GEN-LAST:event_addArrivalButtonActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) shipmentTable.getModel();
        model.setRowCount(0);
        for (User u : UserDirectory.getInstance().getUsers()) {
            if (driverIDField.getText().isEmpty()) {
                break;
            }
            if (u.getType().equals("driver") && u.getId() == Integer.parseInt(driverIDField.getText())) {
                for (Shipment s : u.getShipments()) {
                    Object[] row = new Object[4];
                    row[0] = s;
                    row[1] = s.getStartAddress();
                    row[2] = s.getDesAddress();
                    row[3] = s.getStatus();
                    model.addRow(row);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addArrivalButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField driverIDField;
    private javax.swing.JLabel driverIDLabel;
    private javax.swing.JButton finishButton;
    private javax.swing.JButton inProgressButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField pathField;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JLabel pathLabel3;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable shipmentTable;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
