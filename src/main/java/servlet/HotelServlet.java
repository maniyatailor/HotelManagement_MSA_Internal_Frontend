/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import client.HotelClient;
import entity.HotelRoom;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author HP
 */
@WebServlet(name = "HotelServlet", urlPatterns = {"/HotelServlet"})
public class HotelServlet extends HttpServlet {

  @Inject 
  @RestClient HotelClient hcl;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HotelServlet</title>");            
            out.println("</head>");
            out.println("<body>");
    
            out.println("<h2>Hotel Search</h2>");
            
            out.println("<form method='post' action='HotelServlet'>");
            
            out.println("City : ");
            out.println("<input type='text' name='city' required>");
            
            out.println("<br><br>");
            
            out.println("Room Type");
            out.println("<input type='text' name='roomType' required>");
            
            out.println("<br><br>");
            
            out.println("<button type='submit'>Search</button>");
            
            out.println("</form>"); 
            
            String city=request.getParameter("city");
            String roomType=request.getParameter("roomType");
            
            if(city!=null&&roomType!=null&&!city.isEmpty()&&!roomType.isEmpty())
            {
                out.println("<hr>");
                out.println("<h2>Hotel Search Results</h2>");
                
                 try { 
                Collection<HotelRoom> hotels=hcl.getHotels(city, roomType);
                
                for(HotelRoom h:hotels)
                {
                    out.println("<h3>Hotel Details</h3>");
            
                    out.println("<p><b>Hotel Name : </b>"+h.getHotelid().getHotelname()+"</p>");
                    out.println("<p><b>Hotel Type : </b>"+h.getHotelid().getHoteltype()+"</p>");
                    out.println("<p><b>Hotel Address : </b>"+h.getHotelid().getAddress()+"</p>");
                    out.println("<p><b>Hotel City : </b>"+h.getHotelid().getCity()+"</p>");
                    out.println("<p><b>Room Types : </b>"+h.getRoomtypeid().getRtname()+"</p>");
                    out.println("<p><b>Room Charges :</b>"+h.getRoomtypeid().getCharge()+"</p>");
                    out.println("<p><b>Available Rooms : </b>"+h.getRoomtypeid().getAvailableRoom()+"</p>");
                }
                out.println("<hr>");
            }
            catch (Exception e) {

                    out.println("<p style='color:red;'>");
                    out.println("Error: " + e.getMessage());
                    out.println("</p>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


