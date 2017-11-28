<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/profissionais/criar" class="btn btn-primary">Cadastrar novo Profissional</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td width="40">#</td>
                    <td>Nome</td>
                    <td>E-mail</td>
                    <td>Função</td>
                    <td>Sexo</td>
                    <td width="200">Ações</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="profissional" items="${profissionais}">
                    <tr>
                        <td>${profissional.id}</td>
                        <td>${profissional.nome}</td>
                        <td><a href="mailto:${profissional.email}">${profissional.email}</a></td>
                        <td>${profissional.funcao}</td>
                        <c:if test="${profissional.sexo eq 'm'}">         
                            <td>Masculino</td>
                        </c:if>
                        <c:if test="${profissional.sexo eq 'f'}">         
                            <td>Feminino</td>
                        </c:if>
                        <td>
                            <a href="profissionais/remove/${profissional.id}" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
                            <a href="profissionais/editar/${profissional.id}" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

