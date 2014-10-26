package uk.ac.dundee.computing.aec.instagrim.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.models.User;

import com.datastax.driver.core.Cluster;
@WebServlet(name = "Edit", urlPatterns = {"/Edit"})

public class Edit extends HttpServlet {
	Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
}
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String username=request.getParameter("username");
    	 String currentPass=request.getParameter("currentPass");
        String newPass=request.getParameter("newPass");
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        
        User us=new User(); // creates instance of a user
        us.setCluster(cluster);
        us.EditUser(username, currentPass, newPass, firstName, lastName, email, sex);
        
        
        response.sendRedirect("/Instagrim");
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}	


