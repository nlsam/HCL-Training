

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.versace.EClothes;
import com.versace.HibernateUtil;

/**
 * Servlet implementation class ListProducts
 */
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
             SessionFactory factory = HibernateUtil.getSessionFactory();
             
             Session session = factory.openSession();
             // using HQL
             List<EClothes> list = session.createQuery("from EClothes",EClothes.class).list();
             
             session.close();
             
              PrintWriter out = response.getWriter();
              out.println("<html><body>");
              out.println("<b>Product Listing</b><br>");
              for(EClothes p: list) {
                      out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                      ", Price: " + String.valueOf(p.getPrice()) + ", Size: " + String.valueOf(p.getSize()) + "<br>");
              }
              
          out.println("</body></html>");
          
          
      } catch (Exception ex) {
              throw ex;
      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
