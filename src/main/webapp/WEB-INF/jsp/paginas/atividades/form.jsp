<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-group">
    <label for="nome">Descrição </label>
    <textarea name="descricao" class="form-control">${atividade.descricao}</textarea>
    <form:errors path="atividade.descricao" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="dtp_input2" class="col-md-4 control-label">Data</label>
    <div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
        <input class="form-control" name="data" value="${atividade.data}" size="16" type="text" value="" readonly>
        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
    </div>
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

<!--

<h3>Medicação</h3>        
<div class="form-group">
    
    <input type="hidden" name="medicamentos[0][id]" value="" />
    
    <label>Nome do medicamento:</label>
    <input type="text" name="medicamentos[0]['nome']" class="form-control">
    
    <label>Descrição:</label>
    <input type="text" name="medicamentos[0]['descricao']" class="form-control">
</div>-->

<button type="submit" class="btn btn-primary pull-right">Salvar</button>