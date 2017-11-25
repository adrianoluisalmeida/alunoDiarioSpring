<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/profissionais/criar" class="btn btn-primary">Cadastrar novo Profissional</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Nome</td>
                    <td width="200">Ações</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="profissional" items="${profissionais}">
                    <tr>
                        <td>${profissional.id}</td>
                        <td>${profissional.nome}</td>
                        <td>
                            <a href="profissionais/remove/${profissional.id}" class="btn btn-danger">Remover</a>
                            <a href="profissionais/editar/${profissional.id}" class="btn btn-primary">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

