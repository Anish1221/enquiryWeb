/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webapp.dao;

import com.example.webapp.entity.Enquiry;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface EnquiryDAO {
    int insert(Enquiry e) throws ClassNotFoundException, SQLException;
    List<Enquiry> getAll()throws ClassNotFoundException, SQLException;
}
