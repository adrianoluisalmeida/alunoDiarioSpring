<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="form-group">
    <label for="nome">Turma: </label>
    <input name="nome" value="${turma.nome}" type="text" class="form-control" />
    <form:errors path="turma.nome" cssStyle="color:red"/>
</div>
<button type="submit" class="btn btn-primary pull-right">Salvar</button>