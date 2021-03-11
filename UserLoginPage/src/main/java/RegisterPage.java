
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.user.EUser;
import com.user.HibernateUtil;

/**
 * Servlet implementation class RegisterPage
 */
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterPage() {
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
			String newFirstName = request.getParameter("newfirstname");
			String newLastName = request.getParameter("newlastname");
			String newEmail = request.getParameter("newemail");
			String newUsername = request.getParameter("newusername");
			String newPassword = request.getParameter("newpassword");
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			session.beginTransaction();
			Criteria search = session.createCriteria(EUser.class);
			Criterion username = Restrictions.ilike("username", newUsername);
			Criterion passwords = Restrictions.ilike("passwords", newPassword);
			LogicalExpression test = Restrictions.and(username, passwords);
			search.add(test);
			List<EUser> results = search.list();
			if (results.size() == 0) {
				EUser newUser = new EUser();
				newUser.setFirstname(newFirstName);
				newUser.setLastname(newLastName);
				newUser.setEmail(newEmail);
				newUser.setUsername(newUsername);
				newUser.setPasswords(newPassword);
				session.save(newUser);
				session.getTransaction().commit();
				request.setAttribute("fname", newFirstName);
				request.setAttribute("lname", newLastName);
				RequestDispatcher dispatcher =request.getRequestDispatcher("landing.jsp");
				dispatcher.forward(request, response);

			} else {
				out.println("<html><div>");
				out.println("An account with that username and password is already active!");
				out.println("</div></html>");
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
