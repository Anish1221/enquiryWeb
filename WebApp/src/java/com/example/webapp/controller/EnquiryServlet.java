/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webapp.controller;

import com.example.webapp.dao.EnquiryDAO;
import com.example.webapp.dao.impl.EnquiryDAOImpl;
import com.example.webapp.entity.Enquiry;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */

@WebServlet(name = "enqServlet", urlPatterns = {"/enquiry/*"})
public class EnquiryServlet extends HttpServlet{

    private EnquiryDAO enqDAO = new EnquiryDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String uri = request.getRequestURI().toLowerCase();
            String view = "enquiries.jsp";
            
            if(uri.contains("/add")){
                view = "index.jsp";
            }else{
                request.setAttribute("enquiries", enqDAO.getAll());
            }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/" + view);
        rd.forward(request, response);
        }catch(ClassNotFoundException | SQLException se){
            System.out.println(se.getMessage());
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
            Enquiry enq = new Enquiry();
            enq.setFirstName(request.getParameter("first_name"));
            enq.setLastName(request.getParameter("last_name"));
            enq.setEmail(request.getParameter("email"));
            enq.setContactNo(request.getParameter("contact_no"));
            enq.setStatus(false);

            if (enqDAO.insert(enq) > 0) {
                response.sendRedirect(request.getContextPath() + "/enquiry");
            }
         }catch(ClassNotFoundException | SQLException se){
             System.out.println(se.getMessage());
         }
    }
    
    
    
}
