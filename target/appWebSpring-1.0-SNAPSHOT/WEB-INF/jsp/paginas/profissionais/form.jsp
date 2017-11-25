<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-group">
    <label for="nome">Profissional: </label>
    <input name="nome" value="${profissional.nome}" type="text" class="form-control" />
    <form:errors path="profissional.nome" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="email">E-mail: </label>
    <input name="email" value="${profissional.email}" type="text" class="form-control" />
    <form:errors path="profissional.email" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="funcao">Função: </label>
    <input name="funcao" value="${profissional.funcao}" type="text" class="form-control" />
    <form:errors path="profissional.funcao" cssStyle="color:red"/>
</div>

<div class="form-group">
    <label for="sexo">Sexo: </label>
    <select class="form-control" name="sexo">
        <option value="m">Masculina</option>
        <option value="f">Feminio</option>
    </select>
    <!--<input name="plano_numero" value="${profissional.sexo}" type="text" class="form-control" />-->
    <form:errors path="profissional.sexo" cssStyle="color:red"/>
</div>

<button type="submit" class="btn btn-primary pull-right">Salvar</button>