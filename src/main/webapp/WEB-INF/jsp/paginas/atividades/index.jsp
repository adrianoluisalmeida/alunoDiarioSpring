<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/atividades/criar" class="btn btn-primary">Cadastrar nova atividade</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Nome</td>
                    <td width="300">Ações</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="atividade" items="${atividades}">
                <tr>
                    <td>${atividade.id}</td>
                    <td>${atividade.descricao}</td>
                    <td>
                        <a href="atividades/remove/${atividade.id}" class="btn btn-danger">Remover</a>
                        <a href="atividades/editar/${atividade.id}" class="btn btn-primary">Editar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
