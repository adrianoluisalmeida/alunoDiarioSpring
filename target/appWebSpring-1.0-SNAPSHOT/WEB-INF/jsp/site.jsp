<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Aluno Diário</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/custom.css">
        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/bootstrap-datetimepicker.min.css">-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css">
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Aluno Diário</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a></li>
                        <li><a href="${pageContext.request.contextPath}/about">Sobre</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="${pageContext.request.contextPath}/cadastrar">Cadastrar</a></li>
                        <li><a href="${pageContext.request.contextPath}/login">Logar</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="banner-home" style="background: url(${pageContext.request.contextPath}/recursos/images/home.jpg) no-repeat;">
            <div class="text text-center">
                <h1>Mais que uma agenda escolar</h1>
                <h2>Conheça melhor seus alunos !</h2>
            </div>
        </div>

        <div class="container" style="min-height: 400px">
            <div>
                <br/>
                <br/>
                <br/>
                <h2 class="text-center">
                    Gerencie as atividades da sua escola<br/>
                    <small>Tenha um maior controle sobre seus alunos e evite problemas !</small>
                </h2>

                <br/>
                <br/>
                <br/>
                <br/>
                <br/>

                <div class="text-center">
                    <div class="col-md-4">
                        <div class="well">
                            <h3>Alunos</h3>
                            <hr/>
                            <p>Você pode cadastrar seus alunos por turmas, guardar as principais informações sobre eles, como nome, plano de saúde, data de nascimento e também pode acompanhar caso ele tome algum remédio controlado.</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="well">
                            <h3>Profissionais</h3>
                            <hr/>
                            <p>Tenha todas as informações necessárias sobre os profissionais da sua escola. Guarde também informações de quais as turmas ele trabalha e qual é o seu cargo.</p>
                            <br/>
                        </div>

                    </div>
                    <div class="col-md-4">
                        <div class="well">
                            <h3>Atividades</h3>
                            <hr/>
                            <p>Gerencie as atividades da sua escola e também acompanhe informações de quais alunos vão participar e quais os profissionais responsáveis.</p>
                            <br/>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <footer>
            <div style="color: #fff; padding: 50px; width: 100%; height: 100px; background-color: #2c3e50!important; margin-top: 100px" class="text-center">
                <p>Aluno Diário (C) 2017</p>
            </div> 
        </footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/_bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/custom.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/jquery.mask.js"></script>

    </body>
</html>
