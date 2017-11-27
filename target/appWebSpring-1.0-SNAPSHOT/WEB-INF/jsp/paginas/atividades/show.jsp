<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="m-top-20">
    <div class="panel panel-success">

        <div class="panel-body">

            <div class="page-header header-m">
                <h3>Informações <small> atividade</small></h3>
            </div>

            <div class="col-md-12 no-padding">
                <p>
                    <!--<b>Classificação da Atividade</b>-->
                    <!--Física, Visual-->
                </p>

            </div>
            <div class="col-md-6 no-padding">
                <p>
                    <b>Data:</b>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${atividade.data}" />
                </p>
                <p>
                    <b>Hora</b>
                    ${atividade.hora}
                </p>
            </div>
            <div class="col-md-6 no-padding">
                <p>
                    <b>Turma</b>
                    ${atividade.turma.nome}
                </p>
                <!--<p>-->
                <!--<b>Atividade</b>-->
                <!--Passeio no parque-->
                <!--</p>-->
            </div>
            <div class="col-m-12 no-padding">
                <p>
                    <b>Descrição da atividade</b>
                    ${atividade.descricao}
                </p>
            </div>
            <div class="col-md-6 no-padding">
                <span class="label label-success">OK <span class="badge text-success">${totais.ok}</span></span>
                <span class="label label-warning">MEDICAMENTOS <span class="badge text-warning">${totais.medicamentos}</span></span>
                <!--<span class="label label-danger">RESTRIÇÕES <span class="badge text-danger">1</span></span>-->
            </div>

            <div class="clearfix"></div>
            <br/>

            <div class="page-header header-m">
                <h3>Alunos <small> </small></h3>
            </div>
            <c:forEach var="aluno" items="${alunos}">
                <div class="media">
                    <div class="media-left">
                        <a href="#">
                            <img alt="64x64" class="media-object" data-src="holder.js/64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNWVhN2M4MjMyMSB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE1ZWE3YzgyMzIxIj48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxMi4xNzk2ODc1IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
                        </a>
                    </div>

                    <div class="media-body">
                        <div class="col-md-11">
                            <h4 class="media-heading">${aluno.nome}</h4>
                            <c:if test = "${aluno.medicamentos > 0}">
                                <p class="text-warning">Situação: Precisa de Medicamento</p>
                            </c:if>
                            <c:if test = "${aluno.medicamentos <= 0}">
                                <p class="text-success">Situação: Ok !</p>
                            </c:if>

                        </div>
                        <div class="col-md-1">
                            <!--<button class="btn btn-danger  pull-right"><i class="glyphicon glyphicon-trash"></i></button>-->
                        </div>
                    </div>
                </div>




            </c:forEach>
            
                <div class="page-header header-m">
                <h3>Profissionais <small> </small></h3>
            </div>
            <c:forEach var="profissional" items="${profissionais}">
                <div class="media">
                    <div class="media-left">
                        <a href="#">
                            <img alt="64x64" class="media-object" data-src="holder.js/64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNWVhN2M4MjMyMSB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE1ZWE3YzgyMzIxIj48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxMi4xNzk2ODc1IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
                        </a>
                    </div>

                    <div class="media-body">
                        <div class="col-md-11">
                            <h4 class="media-heading">${profissional.nome}</h4>
                            <a href="mailto:${profissional.email}">${profissional.email}</p>

                        </div>
                        <div class="col-md-1">
                            <!--<button class="btn btn-danger  pull-right"><i class="glyphicon glyphicon-trash"></i></button>-->
                        </div>
                    </div>
                </div>




            </c:forEach>

        </div>
    </div>
</div>
