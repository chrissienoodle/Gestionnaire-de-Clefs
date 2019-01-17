<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>GestTrousseau - Identification</title>
    <link rel="stylesheet" href="css/vendors/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="css/vendors/bootstrap-grid.min.css">
    <link rel="stylesheet" href="css/vendors/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="script" href="js/vendors/bootstrap.js">
    <link rel="script" href="js/vendors/bootstrap.bundle.js">
</head>
<body>
    <header>
        <div class="flex-container">
            <h1>GestTrousseau</h1>
        </div>
      <div class="flex-container">
          <p>Bienvenue sur GestTrousseau</p>
      </div>
    </header>
    <section id="main" class="flex-container">
        <div></div>
        <div class="bg-white text-dark rounded col-8 col-lg-6 col-xl-4 flex-wrap" id="signin">
            <h2>Connection</h2>
            <p class="small"> Veuillez saisir vos identifiant et mot de passe pour accéder à votre session.</p>
            <form method="POST" action="accueil">
                <div class="form-group flex-container">
                    <label for="txtLogin">Identifiant :</label>
                    <p></p>
                    <input id="txtLogin" name="login" placeholder="identifiant" type="text" class="form-control" value="<%= session.getAttribute("login")%>" autofocus />
                </div>
                <div class="form-group flex-container">
                    <label for="pwd">Mot de passe :</label>
                    <p></p>
                    <input name="pwd" id="pwd" type="password" class="form-control" placeholder="mot de passe" value="<%= session.getAttribute("pwd")%>"/>
                </div>
                    <button type="submit" class="btn btn-white text-dark border-dark">Se Connecter</button>
            </form>
        </div>
        <div></div>
    </section>
</body>
</html>