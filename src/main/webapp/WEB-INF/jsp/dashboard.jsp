<%-- 
    Document   : dashboard
    Created on : 06/09/2017, 15:50:24
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="recursos/css/bootstrap.min.css">
        <script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>
    </head>
    <body>


        Bom vindo(a) ${sessionScope['usuarioLogado'].login}
        <a href="http://localhost:8080/appWebBasic/tarefaServlet"> TAREFAS </a>

    </body>
</html>
