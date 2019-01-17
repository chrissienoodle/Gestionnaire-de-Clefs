package servlet;
import bean.Entreprise;
import bean.Fonction;
import bean.Personne;
import dao.DaoEntreprise;
import dao.DaoFonction;
import dao.DaoPersonne;
import org.omg.CORBA.DATA_CONVERSION;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "/accueil/personne", loadOnStartup = 1)
public class PersonneServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private static List<Personne> registre;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("choix")) {
            case "AJOUT":
                DaoPersonne.create(new Personne(request.getParameter("nom"),
                    request.getParameter("prenom"),
                    request.getParameter("fonction"),
                    request.getParameter("entreprise"),
                    request.getParameter("email")));
                registre = DaoPersonne.showAll();
                break;
            default:
                registre = DaoPersonne.searchByAttribute(request.getParameter("attribute"),request.getParameter("recherche"));
                switch (request.getParameter("choix")){
                    case "SUPPRESSION":
                        for (Personne personne:registre) {
                            DaoPersonne.delete(String.valueOf(personne.getId()));
                        }
                        registre = DaoPersonne.showAll();
                    break;
                    case "MODIFICATION":
                        HashMap<String,String> modif = new HashMap<>();
                        modif.put("prenom",request.getParameter("prenom"));
                        modif.put("nom", request.getParameter("nom"));
                        modif.put("email", request.getParameter("fonction"));
                        modif.put("code_entreprise", request.getParameter("entreprise"));
                        modif.put("code_fonction", request.getParameter("email"));

                        modif.forEach((attribut, value) -> {
                            if (!value.isEmpty()) {
                                for (Personne personne : registre) {
                                    DaoPersonne.update(String.valueOf(personne.getId()), attribut, value);
                                }
                            }
                        });
                    break;
                    default:
                    break;
                }

        }
        request.setAttribute("registre", registre);
        List<Fonction> listeFonction = DaoFonction.getAllFonctions();
        request.setAttribute("listeFonction", listeFonction);
        List<Entreprise> listeEntreprise = DaoEntreprise.getAllEntreprises();
        request.setAttribute("listeEntreprise", listeEntreprise);

        request.getRequestDispatcher("/personne.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        registre = DaoPersonne.showAll();
        request.setAttribute("registre", registre);
        List<Fonction> listeFonction = DaoFonction.getAllFonctions();
        request.setAttribute("listeFonction", listeFonction);
        List<Entreprise> listeEntreprise = DaoEntreprise.getAllEntreprises();
        request.setAttribute("listeEntreprise", listeEntreprise);

        request.getRequestDispatcher("/personne.jsp").forward(request,response);
    }
}
