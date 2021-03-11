
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.user.EUser;
import com.user.HibernateUtil;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			String newUsername = request.getParameter("newusername");
			String newPassword = request.getParameter("newpassword");
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction t = session.beginTransaction();
			Criteria search = session.createCriteria(EUser.class);
			Criterion username = Restrictions.ilike("username", newUsername);
			Criterion passwords = Restrictions.ilike("passwords", newPassword);
			LogicalExpression andExp = Restrictions.and(username, passwords);
			search.add(andExp);
			List<EUser> results = search.list();
			t.commit();
			String firstName=null;
			String lastName=null;
			if (results.size() == 0) {
				out.println("<html><body>");
				out.println("Invalid Credentials!");
				out.println("</body></html>");
			} else {
				    for (EUser p: results) {
					firstName= p.getFirstname(); 
					lastName= p.getLastname();
				    }
				    
				request.setAttribute("fname", firstName);
				request.setAttribute("lname", lastName);
				RequestDispatcher dispatcher =request.getRequestDispatcher("landing.jsp");
				dispatcher.forward(request, response);
			}
			session.close();

		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
