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
                        <li><a href="${pageContext.request.contextPath}/dashboard">Home <span class="sr-only">(current)</span></a></li>
                        <li><a href="${pageContext.request.contextPath}/turmas">Turmas</a></li>
                        <li><a href="${pageContext.request.contextPath}/alunos">Alunos</a></li>
                        <li><a href="${pageContext.request.contextPath}/profissionais">Profissionais</a></li>
                        <li><a href="${pageContext.request.contextPath}/atividades">Atividades</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usuarioLogado.login} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li role="separator" class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/logout">Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container">
            <c:if test = "${ fn:length(msg) gt 0 }">
                <br/>
                <div id="msg-returns" class="alert alert-success">${msg}</div> 
            </c:if>
            <jsp:include page="paginas/${page}.jsp" flush="true" />
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/_bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/medicamentos.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/jquery.mask.js"></script>
        <script type="text/javascript">

            $(document).ready(function () {
                setTimeout(function () {
                    $('#msg-returns').hide();
                }, 5000);
            });


            $("#data").datepicker({
                minDate: 0,
                dateFormat: "dd/mm/yyyy"
            });
            $("#data").mask("00/00/0000");
            $('[name="hora"]').mask('00:00:00');

        </script>

    </body>
</html>
