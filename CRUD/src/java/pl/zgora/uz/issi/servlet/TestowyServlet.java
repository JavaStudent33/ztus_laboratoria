package pl.zgora.uz.issi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.zgora.uz.issi.entities.PracownicyEntity;

@WebServlet(name = "TestowyServlet", urlPatterns = {"/TestowyServlet"})
public class TestowyServlet extends HttpServlet {
    
    @PersistenceContext(name="CRUDPU")
    private EntityManager entityManager;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Testowy Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Testowy Servlet</h1>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Imię</td>");
            out.println("<td>Nazwisko</td>");
            out.println("<td>Miejscowość</td>");
            out.println("<td>Telefon</td>");
            out.println("<td>Departament</td>");
            out.println("<td>Stanowisko</td>");
            out.println("</tr>");
            
            Query query = entityManager.createNamedQuery("PracownicyEntity.findAll");
            for(int i=0; i<query.getResultList().size(); i++)
            {
                PracownicyEntity p = (PracownicyEntity) query.getResultList().get(i);
                out.println("<tr>");
                out.println("<td>"+p.getImie()+"</td>");
                out.println("<td>"+p.getNazwisko()+"</td>");
                out.println("<td>"+p.getMiejscowosc()+"</td>");
                out.println("<td>"+p.getTelefon()+"</td>");
                out.println("<td>"+p.getDepartament().getNazwa()+"</td>");
                out.println("<td>"+p.getStanowisko().getNazwa()+"</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body></html>");
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
