/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Shipment;
import model.ShipmentDirectory;
import model.UserDirectory;
import model.User;

/**
 *
 * @author yulon
 */
public class DbUtil {

    private String dbUrl = "jdbc:mysql://localhost:3306/new_database";
    private String dbUserName = "root";
    private String dbPassword = "Bran@123";
    private String jdbcName = "com.mysql.jdbc.Driver";

    Connection conn = null;
    ResultSet rs = null;
    Statement st;
    PreparedStatement pst;

    private static volatile DbUtil instance = null;

    private DbUtil() {
        try {
            getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            importDataToUserDir();
            importShipmentDataToDir();
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DbUtil getInstance() {
        if (instance == null) {
            synchronized (DbUtil.class) {
                if (instance == null) {
                    instance = new DbUtil();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws ClassNotFoundException {
        try {
            int log = 1;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_database", "root", "Bran@123");
            st = (Statement) conn.createStatement();
            System.out.println("connection succeed!");
        } catch (SQLException ex) {
            System.out.println("connection failed");
        }
        return this.conn;
    }

    public ResultSet getRS(String query) throws SQLException {
        st = (Statement) conn.createStatement();
        rs = st.executeQuery(query);
        return rs;
    }

    public void importDataToUserDir() throws SQLException {
        rs = st.executeQuery("select * from t_user");
        while (rs.next()) {
            //username and password comparison
            User u = new User();
            u.setId(rs.getInt(1));
            u.setUserName(rs.getString(2));
            u.setPassword(rs.getString(3));
            u.setType(rs.getString(4));
            u.setName(rs.getString(5));
            u.setAddress(rs.getString(6));
            u.setLocation(rs.getString(7));
            u.setLicensePlate(rs.getString(8));
            UserDirectory.getInstance().addUser(u);
        }

        System.out.println("users info imported" + ": " + UserDirectory.getInstance().getUsers().size());
    }

    public void importShipmentDataToDir() throws SQLException {
        rs = st.executeQuery("select * from t_shipment");
        while (rs.next()) {
            Shipment s = new Shipment();
            s.setTrackingNum(rs.getInt(1));
            s.setDesAddress(rs.getString(2));
            s.setStartAddress(rs.getString(3));
            s.setDriverID(rs.getInt(4));
            ShipmentDirectory.getInstance().addShipment(s);
        }
        System.out.println("shipments info imported" + ": " + ShipmentDirectory.getInstance().getShipment().size());
    }

    public void addUserToUserTable(User u) throws SQLException {
        pst = conn.prepareStatement("insert into t_user(id, username, password, type, name, address, location, license)value(?,?,?,?,?,?,?,?)");
        pst.setInt(1, u.getId());
        pst.setString(2, u.getUserName());
        pst.setString(3, u.getPassword());
        pst.setString(4, u.getType());
        pst.setString(5, u.getName());
        pst.setString(6, u.getAddress());
        pst.setString(7, u.getLocation());
        pst.setString(8, u.getLicensePlate());
        pst.executeUpdate();
    }

    public void removeUserFromUserTable(int id) throws SQLException {
        pst = conn.prepareStatement("delete from t_user where id = ?");
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    public void updateUsertoUserTable(User u) throws SQLException{
        removeUserFromUserTable(u.getId());
        addUserToUserTable(u);
    }
    
    public void addShipmentToShipTable(Shipment s) throws SQLException {
        pst = conn.prepareStatement("insert into t_shipment(tracking_num, des_address, start_address, driver_id)value(?,?,?,?)");
        pst.setInt(1, s.getTrackingNum());
        pst.setString(2, s.getDesAddress());
        pst.setString(3, s.getStartAddress());
        pst.setInt(4, s.getDriverID());
        pst.executeUpdate();
    }

    public void removeShipmentFromShippingTable(int trackingNum) throws SQLException {
        pst = conn.prepareStatement("delete from t_shipment where tracking_num = ?");
        pst.setInt(1, trackingNum);
        pst.executeUpdate();
    }
    
    
    public void updateShipmenttoShipmentTable(Shipment s) throws SQLException{
        removeShipmentFromShippingTable(s.getTrackingNum());
        addShipmentToShipTable(s);
    }
}
