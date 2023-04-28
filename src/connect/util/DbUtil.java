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
            importShipmentDataToDir();
            importDataToUserDir();
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
        rs = getRS("select * from t_user");
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
            assignShipmentToUser(u);
            UserDirectory.getInstance().addUser(u);
        }

        System.out.println("users info imported" + ": " + UserDirectory.getInstance().getUsers().size());
    }

    public void assignShipmentToUser(User u){
        for(Shipment s: ShipmentDirectory.getInstance().getShipment()){
            if(u.getId() == s.getDriverID()){
                u.addShipment(s);
            }
        }
    }
    
    public void importShipmentDataToDir() throws SQLException {
        rs = getRS("select * from t_shipment");
        while (rs.next()) {
            Shipment s = new Shipment();
            s.setTrackingNum(rs.getInt(1));
            s.setDesAddress(rs.getString(2));
            s.setStartAddress(rs.getString(3));
            s.setDriverID(rs.getInt(4));
            s.setShipper(rs.getString(5));
            s.setRecipients(rs.getString(6));
            s.setPhoneNum(rs.getInt(7));
            s.setStartDate(rs.getDate(8));
            s.setArriveDate(rs.getDate(9));
            s.setPackageInfo(rs.getString(10));
            s.setStatus(rs.getString(11));
            s.setShipEmail(rs.getString(12));
            s.setRecipientsEmail(rs.getString(13));

            ShipmentDirectory.getInstance().addShipment(s);
            importArrivalsToShipment(s);
        }
        System.out.println("shipments info imported" + ": " + ShipmentDirectory.getInstance().getShipment().size());
    }

    public void importArrivalsToShipment(Shipment s) throws SQLException {
        ResultSet tmprs = conn.createStatement().executeQuery("select * from t_arrivals where tracking_num = " + s.getTrackingNum());
        while (tmprs.next()) {
            String arr[] = {"", ""};
            arr[0] = tmprs.getString(2);
            arr[1] = tmprs.getString(3);
            s.addArrival(arr);
        }
    }
    
    public void addArrivalsToArrTable(Shipment s, String[] arr) throws SQLException{
        pst = conn.prepareStatement("insert into t_arrivals(tracking_num, location, date)value(?,?,?)");
        pst.setInt(1, s.getTrackingNum());
        pst.setString(2, arr[0]);
        pst.setString(3, arr[1]);
        pst.executeUpdate();
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

    public void updateUsertoUserTable(User u) throws SQLException {
        removeUserFromUserTable(u.getId());
        addUserToUserTable(u);
    }

    public void addShipmentToShipTable(Shipment s) throws SQLException {
        pst = conn.prepareStatement("insert into t_shipment(tracking_num, des_address, start_address, driver_id, shipper, "
                + "recipients, phone_num, start_date, arrive_date, package_info, status, ship_email, recipients_email)"
                + "value(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setInt(1, s.getTrackingNum());
        pst.setString(2, s.getDesAddress());
        pst.setString(3, s.getStartAddress());
        pst.setInt(4, s.getDriverID());
        pst.setString(5, s.getShipper());
        pst.setString(6, s.getRecipients());
        pst.setInt(7, s.getPhoneNum());
        pst.setDate(8, new java.sql.Date(s.getStartDate().getTime()));
        pst.setDate(9, new java.sql.Date(s.getArriveDate().getTime()));
        pst.setString(10, s.getPackageInfo());
        pst.setString(11, s.getStatus());
        pst.setString(12, s.getShipEmail());
        pst.setString(13, s.getRecipientsEmail());
        
        pst.executeUpdate();
    }

    public void removeShipmentFromShippingTable(int trackingNum) throws SQLException {
        pst = conn.prepareStatement("delete from t_shipment where tracking_num = ?");
        pst.setInt(1, trackingNum);
        pst.executeUpdate();
    }

    public void updateShipmenttoShipmentTable(Shipment s) throws SQLException {
        removeShipmentFromShippingTable(s.getTrackingNum());
        addShipmentToShipTable(s);
    }
}
