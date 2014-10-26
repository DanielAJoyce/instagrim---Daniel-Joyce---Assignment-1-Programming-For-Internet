package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.lib.Convertors;
import uk.ac.dundee.computing.aec.instagrim.models.PicModel;
import uk.ac.dundee.computing.aec.instagrim.models.User;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;

/**
 *
 * @author dragomirkolev
 */
//@WebServlet(name = "Login", urlPatterns = {"/Login"})
@WebServlet(name = "SingleImage", urlPatterns = ("/SingleImage/*"))
  
    //"/SingleImage/*"
   // "/SingleImageComments"
    //
//})
@MultipartConfig

public class SingleImage extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Cluster cluster;
    private HashMap CommandsMap = new HashMap();
    java.util.UUID savedImage;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleImage() {
         
        // TODO Auto-generated constructor stub
        CommandsMap.put("SingleImage", 1);
       // CommandsMap.put("SingleImageComments", 2);
      
        
       

    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
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
      //  processRequest(request, response);
    

 
        String args[] = Convertors.SplitRequestPath(request);
        
        int command;
        try {
            command = (Integer) CommandsMap.get(args[1]);
        } catch (Exception et) {
            error("Bad Operator", response);
            return;
        }
        switch (command) {
            case 1:
                System.out.println("faggot1");
                DisplaySingleImage(java.util.UUID.fromString(args[2]),request,response);
                
                System.out.println("faggot2");
                break;
                /*
           case 2:
                System.out.println("faggot3");
                 DisplayComments(java.util.UUID.fromString(args[2]),request,response);
                System.out.println("faggot4");
                */
            default:
            error("Bad Operator", response);
        
                
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String comment=request.getParameter("comment");
            System.out.println(comment);
     
            PicModel pic = new PicModel();
            pic.setCluster(cluster);
            pic.InsertComment(comment);
            System.out.println(savedImage);
            response.sendRedirect("/Instagrim/SingleImage/"+savedImage);
        
            
     
        
        
     
    }
    
     private void DisplaySingleImage(java.util.UUID picid, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        PicModel tm = new PicModel();
        tm.setCluster(cluster);
        savedImage = picid;
        savedImage.toString();
        System.out.println(savedImage);
        java.util.LinkedList<Pic> lsPics = tm.GetClickedPickture(picid);
     
        RequestDispatcher rd = request.getRequestDispatcher("/SingleImage.jsp");
      
        request.setAttribute("Pics", lsPics);
       
        rd.forward(request, response);
        
    }
     
      private void DisplayComments(java.util.UUID picid, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PicModel tm = new PicModel();
        tm.setCluster(cluster);
        java.util.LinkedList<Pic> lsPics = tm.GetAllComments(picid);
        RequestDispatcher rd = request.getRequestDispatcher("/SingleImages.jsp");
        request.setAttribute("Pics", lsPics);
        rd.forward(request, response);

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
        private void error(String mess, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = null;
        out = new PrintWriter(response.getOutputStream());
        out.println("<h1>You have a na error in your input</h1>");
        out.println("<h2>" + mess + "</h2>");
        out.close();
        return;
    }
        
       
}


