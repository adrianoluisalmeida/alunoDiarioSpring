<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/alunos/criar" class="btn btn-primary">Cadastrar novo Aluno</a>
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

                <c:forEach var="aluno" items="${alunos}">
                    <tr>
                        <td>${aluno.id}</td>
                        <td>${aluno.nome}</td>
                        <td>
                            <a href="alunos/remove/${aluno.id}" class="btn btn-danger">Remover</a>
                            <a href="alunos/editar/${aluno.id}" class="btn btn-primary">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

