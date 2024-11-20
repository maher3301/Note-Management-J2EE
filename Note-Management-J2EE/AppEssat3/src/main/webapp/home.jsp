<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des �tudiants</title>
    <meta charset="UTF-8">
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
        <a class="navbar-brand" href="#">Gestion des �tudiants</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Accueil <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">� propos</a>
                </li>
            </ul>
        </div>
    </nav>
    
    <div class="container mt-4">
        <h1>Liste des �tudiants</h1>
        <p>Bienvenue ${utilisateur.nom} (<a href="Dec">D�connexion</a>)</p>
       <c:if test="${utilisateur.role == 'admin'}">
    <div><a href="PreAjout" class="btn btn-primary mb-3">Ajouter une note aux �tudiants</a>
    <a href="AddEtudiant" class="btn btn-primary mb-3">Ajouter de nouveaux �tudiants</a></div>
</c:if>
       
        
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Pr�nom</th>
                    <th>Notes</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
    <c:forEach items="${liste}" var="etudiant">
    <c:if test="${utilisateur.role == 'admin' || etudiant.id eq utilisateur.id}">
        <tr>
            <td>${etudiant.id}</td>
            <td>${etudiant.nom}</td>
            <td>${etudiant.prenom}</td>
<td><a href="PreNote?id=${etudiant.id}">Voir les notes</a></td>
                  <td>
    <c:if test="${utilisateur.role == 'admin'}">
					<a href="Delete?id=${etudiant.id}" class="btn btn-danger">supprimer</a>
									</c:if>	
</td>

       </tr>     
    </c:if>
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
    
    <!-- Liens vers Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
