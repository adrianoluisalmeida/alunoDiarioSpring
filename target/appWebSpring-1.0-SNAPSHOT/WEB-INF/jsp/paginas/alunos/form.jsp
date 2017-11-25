<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/form" prefix="form" %>--%>

<div class="form-group">
    <label for="nome">Aluno: </label>
    <input name="nome" value="${aluno.nome}" type="text" class="form-control" />
    <form:errors path="aluno.nome" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="plano_saude">Plano de Saúde: </label>
    <input name="plano_saude" value="${aluno.plano_saude}" type="text" class="form-control" />
    <form:errors path="aluno.plano_saude" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="plano_numero">Plano de Saúde Nº: </label>
    <input name="plano_numero" value="${aluno.plano_numero}" type="text" class="form-control" />
    <form:errors path="aluno.plano_numero" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="sexo">Sexo: </label>
    <select class="form-control" name="sexo">
        <option value="m">Masculina</option>
        <option value="f">Feminio</option>
    </select>
    <form:errors path="aluno.plano_numero" cssStyle="color:red"/>
</div>


<div class="form-group">
    <label for="turma_id">Turma: </label>
    <select class="form-control" name="turma_id">
        <c:forEach var="turma" items="${turmas}">
            <option value="${turma.id}">${turma.nome}</option>
        </c:forEach>
    </select>
    <form:errors path="aluno.plano_numero" cssStyle="color:red"/>
</div>

<div class="form-group">
    <fmt:formatDate value="${aluno.nascimento}"  
                    type="date" 
                    pattern="dd/MM/yyyy"
                    var="theFormattedDate" />
    
    <div class="form-group">
        <label for="nascimento">Data de Nascimento</label>
        <input type="text" data-date-format="dd/mm/yyyy" id="data" value="${theFormattedDate}" name="nascimento" placeholder="Escolha uma data" class="form-control" required />
    </div>
    
</div>

<button type="submit" class="btn btn-primary pull-right">Salvar</button>