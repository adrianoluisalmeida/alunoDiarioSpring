<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="form-group">
    <label for="nome">Descrição </label>
    <textarea name="descricao" class="form-control">${atividade.descricao}</textarea>
    <form:errors path="atividade.descricao" cssStyle="color:red"/>
</div>

<div class="form-group">
    <fmt:formatDate value="${atividade.data}"  
                    type="date" 
                    pattern="dd/MM/yyyy"
                    var="theFormattedDate" />

    <div class="form-group">
        <label for="data">Data da Atividade</label>
        <input type="text" data-date-format="dd/mm/yyyy" id="data" value="${theFormattedDate}" name="data" placeholder="Escolha uma data" class="form-control" required />
    </div>
</div>

<div class="form-group">
    <label for="data">Hora</label>
    <input type="text" name="hora" value="${atividade.hora}" class="form-control" required />
</div>

<div class="form-group">
    <label for="turma_id">Turma: </label>
    <select class="form-control" name="turma_id">
        <c:forEach var="turma" items="${turmas}">
            <option value="${turma.id}">${turma.nome}</option>
        </c:forEach>
    </select>
    <form:errors path="turma.turma_id" cssStyle="color:red"/>
</div>

<button type="submit" class="btn btn-primary pull-right">Salvar</button>