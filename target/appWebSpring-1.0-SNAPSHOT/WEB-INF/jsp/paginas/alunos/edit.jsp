<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="col-md-6 col-md-offset-3 m-top-20">
    <form action="${pageContext.request.contextPath}/alunos/update/${id}" commandName="aluno" accept-charset="iso-8859-1,utf-8" method="POST">
        <jsp:include page="form.jsp" flush="true" />
    </form>
</div>