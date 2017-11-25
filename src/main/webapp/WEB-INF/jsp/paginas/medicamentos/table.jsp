<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-striped">
    <thead>
        <tr>
            <td><b>Nome</b></td>
            <td><b>Descrição</b></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="medicamento" items="${medicamentos}">
        <tr>
            <td>${medicamento.nome}</td>
            <td>${medicamento.descricao}</td>
        </tr>
    </c:forEach>
</tbody>
</table>