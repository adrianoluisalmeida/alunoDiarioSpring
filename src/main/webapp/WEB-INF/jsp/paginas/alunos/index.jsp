<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/alunos/criar" class="btn btn-primary">Cadastrar novo Aluno</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td width="40">#</td>
                    <td>Nome</td>
                    <td>Sexo</td>
                    <td>Plano Saúde</td>
                    <td>Plano Número</td>
                    <td width="300">Ações</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="aluno" items="${alunos}">
                    <!-- Modal -->
                <div class="modal fade" id="medicamento-${aluno.id}" tabindex="-1" role="dialog" aria-labelledby="medicamento-${aluno.id}">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="medicamentosStore" data-id="${aluno.id}" class="" name="form-medicamentos" method="POST">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Medicamentos - <b>#${aluno.nome}</b></h4>
                                </div>
                                <div class="modal-body">

                                    <div id="medicamentos-success-${aluno.id}" class="alert alert-success" style="display: none">
                                        Medicamento foi inserido com sucesso !
                                    </div>

                                    <div id="medicamentos-error-${aluno.id}" class="alert alert-danger" style="display: none">
                                        Verifique os dados informados !
                                    </div>

                                    <div id="tableMedicamentos-${aluno.id}"></div>


                                    <h3>Novo medicamento</h3>

                                    <input type="hidden" value="${aluno.id}" name="aluno_id">
                                    <div class="form-group">
                                        <label>Nome</label>
                                        <input type="text" name="nome" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Descrição</label>
                                        <textarea type="text" name="descricao" class="form-control"></textarea>
                                    </div>


                                    <div class="clearfix"></div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary pull-right">Salvar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.plano_saude}</td>
                    <td>${aluno.plano_numero}</td>
                    <c:if test="${aluno.sexo eq 'm'}">         
                        <td>Masculino</td>
                    </c:if>
                    <c:if test="${aluno.sexo eq 'f'}">         
                        <td>Feminino</td>
                    </c:if>
                    <td>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-default" data-toggle="modal" onclick="loadMedicamentos(${aluno.id})" data-target="#medicamento-${aluno.id}">
                            Medicamentos
                        </button>

                        <!--<a href="" class="btn btn-danger">Medicamentos</a>-->
                        <a href="alunos/remove/${aluno.id}" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
                        <a href="alunos/editar/${aluno.id}" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
