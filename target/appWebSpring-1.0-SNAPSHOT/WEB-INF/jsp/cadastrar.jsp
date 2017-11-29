<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Aluno Diário - Cadastro de usuário</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/custom.css">

    </head>
    <body>

        <div class="jumbotron">
            <div class="text-center">
                <h2>Aluno Diário - Cadastro</h2>
            </div>        
            <p class="text-center">
                Preencha o formulário abaixo para efetuar seu cadastro.
            </p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">


                    <br />
                    <form action="usuarioCadastrar" method="POST">
                        <div class="form-group">
                            <label for="login">LOGIN:</label>
                            <input value="${usuario.login}" type="text" class="form-control" name="login" />	
                            <form:errors path="usuario.login" cssStyle="color:red"/>
                        </div>

                        <div class="form-group">
                            <label for="senha">SENHA:</label>
                            <input  type="password" class="form-control" name="senha" />
                            <form:errors path="usuario.senha" cssStyle="color:red"/>
                        </div>

                        <a href="login" class="btn btn-default pull-left" >voltar ao login</a>		
                        <button class="btn btn-primary pull-right" type="submit">CADASTRAR</button>		
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