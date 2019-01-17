<%--
  Created by IntelliJ IDEA.
  User: DWWM
  Date: 08/01/2019
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>GestTrousseau - clef</title>
    <link rel="stylesheet" href="../css/vendors/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="../css/vendors/bootstrap-grid.min.css">
    <link rel="stylesheet" href="../css/vendors/bootstrap.min.css">
    <link rel="stylesheet" href="../css/index.css">
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
                <p>Gestion des clefs</p>
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

        <div class="bg-white text-dark rounded col-lg-10 col-8 flex-wrap" id="clef">
            <p></p>
        </div>

    </section>
    <script src="${pageContext.request.contextPath}/js/vendors/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendors/bootstrap.bundle.min.js"></script>
</body>
</html>
