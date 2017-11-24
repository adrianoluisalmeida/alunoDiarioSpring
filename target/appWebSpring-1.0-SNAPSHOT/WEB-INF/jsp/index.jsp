<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Aluno Diário</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/custom.css">

    </head>
    <body>

        <div class="jumbotron">
            <div class="text-center">
                <h2>Aluno Diário</h2>
            </div>        
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">


                    <br />
                    <form action="usuarioLogar" method="POST">
                        <div class="form-group">
                            <label for="login">LOGIN:</label>
                            <input type="text" class="form-control" name="login" />		
                        </div>

                        <div class="form-group">
                            <label for="senha">SENHA:</label>
                            <input type="text" class="form-control" name="senha" />
                        </div>

                        <button class="btn btn-primary pull-right" type="submit">LOGAR</button>		
                    </form>

                </div>
            </div>                
        </div>

        <c:if test="${not empty msg}">           
            <div class="alert alert-danger" role="alert">
                <h2>Usuário ou Senha incorretos</h2>
            </div>            
        </c:if>

    </body>
</html>