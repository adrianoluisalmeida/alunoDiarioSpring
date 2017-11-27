<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/turmas/criar" class="btn btn-primary">Cadastrar nova Turma</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td width="40">#</td>
                    <td>Nome</td>
                    <td width="200">Ações</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="turma" items="${turmas}">
                    <tr>
                        <td>${turma.id}</td>
                        <td>${turma.nome}</td>
                        <td>
                            <a href="turmas/remove/${turma.id}" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
                            <a href="turmas/editar/${turma.id}" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

