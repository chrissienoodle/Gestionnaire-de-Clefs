package servlet;
import bean.User;
import dao.DaoConnect;
import dao.DaoUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/connexion", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    //Attributes
    private static final long serialVersionUID=1L;

    @Override
    public void init() throws ServletException {
        DaoConnect.init(this.getServletContext());

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter( "login" );
        String password = request.getParameter( "pwd" );

        request.setAttribute("login", login);
        request.setAttribute("pwd", password);

        User identifiedUser = DaoUser.isValidLogin(login, password);

        if(identifiedUser != null){
            HttpSession session = request.getSession(true);
            response.sendRedirect(request.getContextPath()+"/accueil");
        } else{
            request.setAttribute("errorMessage", "identifiant ou mot de passe incorrect");
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login", "");
        request.setAttribute("password", "");
        request.getRequestDispatcher("/connexion.jsp").forward(request,response);
    }
}
