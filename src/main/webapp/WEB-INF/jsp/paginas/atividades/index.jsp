<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="m-top-20">
    <div class="panel panel-default">

        <div class="panel-heading">
            <div class="col-md-6 no-padding">
                <h3 class="panel-title">Calendário de Atividades<br/><small>  Lista de atividades das turmas da escola</small></h3>
            </div>
            <div class="col-md-6 no-padding">
                <a href="${pageContext.request.contextPath}/atividades/criar" class="btn btn-primary pull-right">Cadastrar nova atividade</a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="panel-body">
            <p class="lead">

            </p>

            <div class="agenda">
                <div class="table-responsive">
                    <table class="table table-condensed table-bordered">
                        <thead>
                            <tr>
                                <th>Data</th>
                                <th>Hora</th>
                                <th>Turma</th>
                                <th>Atividade</th>
                                <th width="200">Ações</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="atividade" items="${atividades}">
                                <!-- Single event in a single day -->

                                <tr>
                                    <td class="agenda-date" class="active" rowspan="1">
                                        <div class="dayofmonth">

                                        </div>
                                        <div class="dayofweek">
                                            <fmt:formatDate pattern="dd/MM/yyyy" value="${atividade.data}" />
                                        </div>
                                    </td>
                                    <td class="agenda-time">
                                          ${atividade.hora}
                                    </td>
                                    <td>
                                        ${atividade.turma.nome}
                                    </td>
                                    <td class="agenda-events">
                                        <div class="agenda-event">
                                            ${atividade.descricao}
                                        </div>
                                    </td>
                                    <td class="text-center" width="150">
                                        <a href="atividades/remove/${atividade.id}" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
                                        <a href="atividades/editar/${atividade.id}" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
                                        <a href="atividades/ver/${atividade.id}" class="btn btn-info"><i class="glyphicon glyphicon-eye-open"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>
