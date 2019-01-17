<%--
  Created by IntelliJ IDEA.
  User: DWWM
  Date: 08/01/2019
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>GestTrousseau - utilisateur</title>
    <link rel="stylesheet" href="../css/vendors/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="../css/vendors/bootstrap-grid.min.css">
    <link rel="stylesheet" href="../css/vendors/bootstrap.min.css">
    <link rel="stylesheet" href="../css/index.css">

</head>
<body>
    <header class="flex-container">
        <div class="col-2"></div>
<%-- titre de la page --%>
        <div class="col-8">
            <div class="flex-container">
                <h1>GestTrousseau</h1>
            </div>
            <div class="flex-container" id="bonjour">
                <p>Gestion des utilisateurs</p>
            </div>
        </div>
<%-- button de déconnexion de la session --%>
        <div class="col-2">
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Déconnexion
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="<%= request.getContextPath()%>/déconnexion">déconnexion</a>
            </div>
        </div>
    </header>
    <section id="main" class="flex-container ">
        <div class="bg-white text-dark rounded col-lg-10 col-8 container-fluid" id="clef">
<%-- affichage de la table des utilisateurs --%>
            <table class="table-bordered table-hover table-responsive">
                <thead>
                <tr>
                    <th></th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Entreprise</th>
                    <th>Fonction</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.registre}" var="personne">
                    <tr>
                        <td>${personne.id}</td>
                        <td>${personne.nom}</td>
                        <td>${personne.prenom}</td>
                        <td>${personne.entreprise}</td>
                        <td>${personne.fonction}</td>
                        <td>${personne.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        <br/>
<%-- mise en place des buttons drop-up de gestion d'utilisateur --%>
            <p>Gestion des informations liées aux utilisateurs</p>
            <div class="btn-group dropup overflow-hidden">
<%-- drop-up d'ajout d'utilisateur --%>
                <button type="button" class="btn dropdown-toggle" id="ajoutBtn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Ajouter
                </button>
                <div class="dropdown-menu" aria-labelledby="ajoutBtn">
                    <div class="dropdown-item">
                        <form method="POST" action="personne">
                            <div class="form-group flex-container">
                                <label >Ajouter un utilisateur</label>
                                <input type="hidden" name="choix" value="AJOUT">
                            </div>
                            <div class="form-group flex-container">
                                <label for="prenom">Prénom :</label>
                                <p></p>
                                <input id="prenom" name="prenom" placeholder="Prénom" type="text" class="form-control" required autofocus />
                            </div>
                            <div class="form-group flex-container">
                                <label for="nom">Nom :</label>
                                <p></p>
                                <input id="nom" name="nom" placeholder="Nom" type="text" class="form-control" required autofocus />
                            </div>
                            <div class="form-group flex-container">
                                <label for="email">Email :</label>
                                <p></p>
                                <input id="email" name="email" placeholder="Email" type="email" class="form-control" required autofocus />
                            </div>
                            <div class="form-group flex-container">
                                <label for="entreprise">Entreprise :</label>
                                <p></p>
                                <select id="entreprise" name="entreprise" autofocus>
                                    <c:forEach var="entreprise" items="${requestScope.listeEntreprise}">
                                        <option value="${entreprise.nom}">${entreprise.nom}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group flex-container">
                                <label for="fonction">Fonction :</label>
                                <p></p>
                                <select id="fonction" name="fonction" autofocus>
                                    <c:forEach var="fonction" items="${requestScope.listeFonction}">
                                        <option value="${fonction.libelle}">${fonction.libelle}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-white text-dark border-dark">Se Connecter</button>
                        </form>
                    </div>
                </div>
<%-- drop-up de modification d'infos utilisateurs --%>
                <button type="button" class="btn dropdown-toggle" id="modifBtn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Modifier
                </button>
<%-- drop-up de suppression d'utilisateur --%>
                <button type="button" class="btn dropdown-toggle" id="modifBtn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Supprimer
                </button>
            </div>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/js/vendors/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/bootstrap.bundle.min.js"></script>
</body>
</html>
