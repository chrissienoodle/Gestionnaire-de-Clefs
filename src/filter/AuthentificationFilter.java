package filter;

import bean.User;
import dao.DaoConnect;
import dao.DaoUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthentificationFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //cast
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //anonymisation d'une session
        HttpSession session = request.getSession(true);
        if (session.getAttribute("isAnon")==null){
            session.setAttribute("isAnon",true);
        }

        //vérification si utilisateur authentifié
        if(session.getAttribute("isAnon").equals(true)) {
            String login = (request.getParameter("login") == null) ? "" : request.getParameter("login");
            String pwd = (request.getParameter("pwd") == null) ? "" : request.getParameter("pwd");

            session.setAttribute("login", login);
            session.setAttribute("pwd", pwd);

           User identifiedUser = DaoUser.isValidLogin(login, pwd);

            if (identifiedUser != null) {
                identifiedUser.setConnectionNumber(identifiedUser.getConnectionNumber() + 1);
                DaoUser.incrementConnection(identifiedUser.getIdUser(), identifiedUser.getConnectionNumber());
                session.setAttribute("isAnon", false);

            } else {
                System.out.println(login + " " + pwd);
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
