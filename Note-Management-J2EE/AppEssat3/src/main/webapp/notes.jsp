
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des Notes</title>
    <!-- Liens vers Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Corps de la page pour le positionnement du pied de page */
        html {
            position: relative;
            min-height: 100%;
        }
        body {
            margin-bottom: 60px; /* Hauteur du pied de page */
        }
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px; /* Hauteur du pied de page */
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <!-- Barre de navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Gestion des Mati�res</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Accueil <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">� propos</a>
                </li>
                <!-- Ajoutez d'autres �l�ments de navigation si n�cessaire -->
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
        <h1>Liste des Notes</h1>
        <h4>�tudiant : ${etd.nom} ${etd.prenom}</h4>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Mati�re</th>
                    <th>Note</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${liste}" var="n">
                    <tr>
                        <td>${n.id}</td>
                        <td>${n.mt.titre}</td>
                        <td>${n.nt}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Pied de page -->
    <footer class="footer mt-auto py-3 bg-dark">
        <div class="container">
            <span class="text-muted">� 2024 - Maher</span>
        </div>
    </footer>

    <!-- Liens vers Bootstrap JS (pour les fonctionnalit�s avanc�es) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

