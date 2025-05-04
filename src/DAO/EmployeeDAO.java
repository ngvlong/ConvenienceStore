/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DLL.EmployeeDLL;
import config.JDBCUtil;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NAME
 */
public class EmployeeDAO implements Interface<EmployeeDLL>{
    Connection con;
    @Override
    public int insert(EmployeeDLL t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(EmployeeDLL t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<EmployeeDLL> selectAll(String mcn) {
        ArrayList<EmployeeDLL> result = new ArrayList<>();
        try {
            con = JDBCUtil.getOneConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            String sql = "SELECT * FROM NhanVien ";
            try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("maNV");
                String tennv = rs.getString("tenNV");
                String cn = rs.getString("maChinhanh");
                Date join = rs.getDate("ngayBatdau");
                Date birth = rs.getDate("ngaySinh");
                int gender = rs.getInt("gioiTinh");
                EmployeeDLL emp = new EmployeeDLL(id, cn, cn, join, birth, gender);
                result.add(emp);
            }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JDBCUtil.closeConnection(con);
            return result;
    }

    @Override
    public EmployeeDLL selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
