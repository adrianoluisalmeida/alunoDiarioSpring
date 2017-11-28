function loadMedicamentos(id) {
    $.ajax({
        url: "medicamentos/" + id,
        type: "GET", //POST
        success: function (response) { // em caso de sucesso

            $("#tableMedicamentos-" + id).html(response);
        }
    });
}

function removeMedicamento(id, aluno_id) {

    $.ajax({
        url: "medicamento/remove/" + id,
        type: "GET",
        success: function (response) {
            loadMedicamentos(aluno_id);
        }
    });

};

//Envia os dados do formulário de review
jQuery('[name="form-medicamentos"]').submit(function (e) {

    e.preventDefault(); //Evita que sai da pagina atual
//    alert("teste");
    var id = $(this).attr("data-id");


    $.ajax({
        url: $(this).attr('action'), // Url que deseja chamar, OBS; o retorno do metodo chamado deve ser um JSON
        type: $(this).attr('method'), //POST
//        dataType: 'json',
        data: $(this).serialize(), //Vare todos os campos do formuláiro form-comment
        success: function (response) { // em caso de sucesso

            loadMedicamentos(id);
            
            if (response === true) {
                $('#medicamentos-success-' + id).show(); //abre  div que estava em display none com a mensagem 
                setTimeout(function () {
                    $('#medicamentos-success-' + id).hide(); //some com a div da mensagem
                }, 5000);

                $('[name="form-comment"]')[0].reset(); //limpa campos do formulário
            } else {
                $('#medicamentos-error-' + id).show(); //abre  div que estava em display none com a mensagem 
                setTimeout(function () {
                    $('#medicamentos-error-' + id).hide(); //some com a div da mensagem
                }, 5000);

            }
        }
    });

    return false;
});