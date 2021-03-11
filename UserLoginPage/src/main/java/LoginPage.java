
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
			//out.println("<html><body>");
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
			if (results.size() == 0) {
				out.println("Invalid Credentials!");
			} else {
				response.sendRedirect("landing.jsp");
				out.println("<html><h2>");
				for (EUser p : results) {
					out.println(" Welcome " + p.getFirstname() + " " + p.getLastname() + " !");
				}
				out.println("</h2></html>");

			}

			t.commit();
			session.close();
			//out.println("</body></html>");

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
