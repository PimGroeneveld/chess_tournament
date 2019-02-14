// submit the form
$("#add-player-form").submit(function () {

    var newPlayerForm = $(this).serializeArray();
    var newPlayer = {};  //DTO
    console.log(newPlayerForm);
    event.preventDefault();
    // $(newPlayerForm).each(function(i, field) {
    //     if (field.name == "dateOfBirth") {
    //         newPlayer[field.name] = field.value.toString()
    //     } else {
    //         newPlayer[field.name] = field.value
    //     }
    // });
    $(newPlayerForm).each(function(i, field) {
        if (field.name == "insertion" && field.name == null) {
            newPlayer[field.name] = "";
        } else {
            newPlayer[field.name] = field.value
        }
    });

    console.log(newPlayer);
    $.ajax({
        type: "POST",
        url : "tournament/allplayers/add",
        data : JSON.stringify(newPlayer),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success : function(result) {
            if(result.validated) {
                console.log("player added")
            }
            else {
                console.log("No player added")
            }
        }
    });
    window.location.href = '/index.html';
});