<%--
  Created by IntelliJ IDEA.
  User: DWWM
  Date: 08/01/2019
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>GestTrousseau - accueil</title>
    <link rel="stylesheet" href="css/vendors/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="css/vendors/bootstrap-grid.min.css">
    <link rel="stylesheet" href="css/vendors/bootstrap.min.css">
    <link rel="stylesheet" href="css/accueil.css">
</head>
<body>
    <header class="flex-container">
        <div class="col-2"></div>
<%-- Titre de la page --%>
        <div class="col-8">
            <div class="flex-container">
                <h1>GestTrousseau</h1>
            </div>
            <div class="flex-container" id="bonjour">
                <p>Bonjour, <%= session.getAttribute("login")%></p>
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
    <section id="main" class="flex-container flex-wrap">
        <article class="card rounded col-10 col-sm-8 col-md-6 col-lg-4" style="padding: 2.5%;margin: 40px 20px;">
            <div class="card-body">
                <h2 class="card-title">Gestion des clefs</h2>
                <p class="card-text">Accéder à l'outil d'ajout, modification, recherche et suppression de clefs et de
                    trousseaux </p>
                <a href="<%= request.getContextPath()%>/accueil/clef" class="btn btn-white text-dark border-dark
                    container-fluid">En avant</a>
            </div>
        </article>
        <article class="card rounded col-10 col-sm-8 col-md-6 col-lg-4" style="padding: 2.5%;margin: 40px 20px;">
            <div class="card-body">
                <h2 class="card-title">Gestion des utilisateurs</h2>
                <p class="card-text">Accéder à l'outil d'ajout, modification, recherche et suppression des
                    utilisateurs </p>
                <a href="<%= request.getContextPath()%>/accueil/personne" class="btn btn-white text-dark border-dark
                    container-fluid">C'est parti</a>
            </div>
        </article>
    </section>

    <script src="${pageContext.request.contextPath}/js/vendors/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/bootstrap.bundle.min.js"></script>
</body>
</html>
