<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="form-group">
    <label for="nome">Turma: </label>
    <input name="nome" value="${turma.nome}" type="text" class="form-control" />
    <form:errors path="turma.nome" cssStyle="color:red"/>
</div>
<button type="submit" class="btn btn-primary pull-right">Salvar</button>