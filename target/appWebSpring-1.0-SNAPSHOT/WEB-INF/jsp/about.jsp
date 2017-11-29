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
                        <li><a href="${pageContext.request.contextPath}/home">Home <span class="sr-only">(current)</span></a></li>
                        <li><a href="${pageContext.request.contextPath}/about">Sobre</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="${pageContext.request.contextPath}/cadastrar">Cadastrar</a></li>
                        <li><a href="${pageContext.request.contextPath}/login">Logar</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container" style="min-height: 400px">
            <div class="about">
                <h1>Aluno Diário</h1>
                <hr/>

                <h3><b>Problema</b></h3>

                <div class="bloco">
                    <p>Devido às obrigações pessoais dos pais, muitas crianças acabam indo bem cedo para a pré escola, com pouca idade e em alguns casos até bebês. As turmas da  pré-escola geralmente são formadas por muitas crianças. Comunicar os pais sobre algum evento ou até urgência, pode ser um problema. Além disso, algumas crianças necessitam de  cuidados especiais, como por exemplo, alergia ou remédio controlado.<br/></p>
                    <p>Acreditamos que a tradicional agenda em papel não funciona mais atualmente.  Como proposta de negócio, nosso objetivo é desenvolver uma aplicação que facilite a comunicação entre professores e pais de alunos. </p>
                </div>

                <h3><b>Solução e Proposta de Trabalho</b></h3>
                <div class="bloco">
                    <p>Por meio deste trabalho gostaria de propor uma possível aplicação que possa ajudar a gerenciar e amenizar os problemas apresentados.</p>
                </div>

                <h3><b>Considerações Finais</b></h3>
                <div class="bloco">
                    <p>O objetivo inicial do Projeto é atender o ensino infantil, aproximar pais e professores e facilitar o contato e informações gerais sobre as crianças que frequentam a pré escola.</p>
                    <p> O projeto foi realizado usando as tecnologias apresentadas em aula, como Java com Orientação a Objetos para a Web e banco de dados Postgres. </p>
                </div>

                <h3><b>Adriano Luis de Almeida</b></h3>
                <div class="bloco">
                    <p>
                        5º Semestre -  Sistemas de Informação - UFSM
                    </p>
                </div>

                <p> <a href="mailto: alalmeida@inf.ufsm.br">alalmeida@inf.ufsm.br</a> </p>
                <p> <a href="https://github.com/adrianoluisalmeida/alunoDiarioSpring" target="_blank">https://github.com/adrianoluisalmeida/alunoDiarioSpring</a> </p>
            </div>
        </div>
        <footer>
            <div class="text-center rodape">
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
