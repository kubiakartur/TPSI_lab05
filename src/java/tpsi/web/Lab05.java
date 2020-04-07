package tpsi.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Moya
 */
@WebServlet(urlPatterns = {"/Lab05"})
public class Lab05 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();        
        Integer licznik = (Integer) session.getAttribute("wyswietlenia");
        
        if (licznik == null) {
            licznik = 1;
        } else {
            licznik = licznik + 1;
        }
        
        session.setAttribute("wyswietlenia", licznik);        
        request.getRequestDispatcher("Lab05.jsp").forward(request, response);
    }
}