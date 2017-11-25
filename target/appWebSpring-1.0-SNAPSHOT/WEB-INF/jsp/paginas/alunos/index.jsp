<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default m-top-20">
    <div class="panel-heading">
        <a href="${pageContext.request.contextPath}/alunos/criar" class="btn btn-primary">Cadastrar novo Aluno</a>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Nome</td>
                    <td width="300">Ações</td>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="aluno" items="${alunos}">
                    <!-- Modal -->
                <div class="modal fade" id="medicamento-${aluno.id}" tabindex="-1" role="dialog" aria-labelledby="medicamento-${aluno.id}">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Medicamentos - #${aluno.nome}</h4>
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
                                <form action="medicamentosStore" data-id="${aluno.id}" class="" name="form-medicamentos" method="POST">
                                    <input type="hidden" value="${aluno.id}" name="aluno_id">
                                    <div class="form-group">
                                        <label>Nome</label>
                                        <input type="text" name="nome" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Descrição</label>
                                        <textarea type="text" name="descricao" class="form-control"></textarea>
                                    </div>

                                    <button type="submit" class="btn btn-primary pull-right">Salvar</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>

                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.nome}</td>
                    <td>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-toggle="modal" onclick="loadMedicamentos(${aluno.id})" data-target="#medicamento-${aluno.id}">
                            Medicamentos
                        </button>

                        <!--<a href="" class="btn btn-danger">Medicamentos</a>-->
                        <a href="alunos/remove/${aluno.id}" class="btn btn-danger">Remover</a>
                        <a href="alunos/editar/${aluno.id}" class="btn btn-primary">Editar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
