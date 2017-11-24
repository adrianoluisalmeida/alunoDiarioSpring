<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a class="btn btn-primary">Cadastrar nova Turma</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Nome</td>
                    <td width="200">A��es</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="turma" items="${turmas}">
                    <tr>
                        <td>${turma.id}</td>
                        <td>${turma.nome}</td>
                        <td>
                            <a href="#" class="btn btn-danger">Remover</a>
                            <a href="turmas/editar/${turma.id}" class="btn btn-primary">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

