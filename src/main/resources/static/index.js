$(document).on('click', '#get-all-players-button', function(){
    // alert("button click")
    $.ajax({
        type:'get',  // type call
        url: 'tournament/allplayers',  // point to what url
        success: function(result) {  // do x with what comes back
            players = result;
            fillPlayerTable(players);
        }
    });
});

function fillPlayerTable($players){
    var content = '<table id = "allPlayers">';
    content += '<thead id = tableHeader>';
    content += '<tr> <th> Number </th>';
    content += '<th> Name </th>';
    content += '<th> DoB </th>';
    content += '<th> Wins </th>';
    content += '<th> Losses </th>';
    content += '<th> Draws </th>';
    content += '</thead>';
    content += '<tbody id = "tablebody">';
    console.log($players);

    $.each($players, function (index, value) {
        content += "<tr>";
        console.log(value);
        content += "<td>" + value.id + "</td>";
        content += '<td>' + value.firstName + " " + value.insertion + " " + value.lastName + '</td>';
        content += "<td>" + value.birthDate + "</td>";
        content += "<td>" + value.wonMatches + "</td>";
        content += "<td>" + value.lostMatches + "</td>";
        content += "<td>" + value.draw + "</td>";
        content += "</tr>";
    });
    content += '</tbody> </table> <div class = "row"></div>';
    $("#all-players-div").html(content);
}