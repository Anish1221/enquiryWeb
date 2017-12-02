/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webapp.dao.impl;

import com.example.webapp.dao.EnquiryDAO;
import com.example.webapp.dbutil.DbConnection;
import com.example.webapp.entity.Enquiry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class EnquiryDAOImpl implements EnquiryDAO{
     
    private DbConnection db =new DbConnection();
    
    @Override
    public int insert(Enquiry e) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "INSERT INTO tbl_enquiries(first_name, last_name, email, contact_no, status) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
        stmt.setString(3, e.getEmail());
        stmt.setString(4, e.getContactNo());
        stmt.setBoolean(5, false);
        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        List<Enquiry> enqList = new ArrayList<>();
        
        db.open();
        String sql = "SELECT * FROM tbl_enquiries";
        PreparedStatement stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while(rs.next()){
            Enquiry enq = new Enquiry();
            enq.setId(rs.getInt("enquiry_id"));
            enq.setFirstName(rs.getString("first_name"));
            enq.setLastName(rs.getString("last_name"));
            enq.setEmail(rs.getString("email"));
            enq.setContactNo(rs.getString("contact_no"));
            enq.setStatus(rs.getBoolean("status"));
            
            enqList.add(enq);
        }
       
        db.close();
        
        return enqList;
    }
    
}
