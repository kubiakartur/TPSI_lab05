package tpsi.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Lab05_zadanie2"})
public class Lab05_zadanie2 extends HttpServlet {

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
        List<Person> lista;
       
        if (session.getAttribute("wypis_listy") == null){
            lista = new ArrayList<>();        
        } else {
            lista = (List<Person>) session.getAttribute("wypis_listy");
        }
        
        session.setAttribute("wypis_listy", lista);
        request.getRequestDispatcher("Lab05_z2.jsp").forward(request, response);
     }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {        
        HttpSession session = request.getSession();
        List<Person> lista;
        
        if (session.getAttribute("wypis_listy") == null){
            lista = new ArrayList<>();
        } else {
            lista = (List<Person>) session.getAttribute("wypis_listy");
        }      
        
        String imie = request.getParameter("firstName");
        String nazwisko = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        Person test = new Person(imie, nazwisko, email);
        lista.add(test);
                   
        session.setAttribute("wypis_listy", lista);    
        request.getRequestDispatcher("Lab05_z2.jsp").forward(request, response);
    }
}