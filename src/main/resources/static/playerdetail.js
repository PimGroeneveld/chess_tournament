$(document).ready(function () {

    var url_string = window.location.href
    var url = new URL(url_string);
    var playerId = url.searchParams.get("playerId")

    $('#playerId').val(playerId)

    console.log(playerId);

    $.ajax({
        type: 'get',
        url: 'tournament/allplayers/' + playerId,
        success: function (result) {
            player = result;
            console.log(player);
            fillPlayerDetail(player);
        }
    });
});

function fillPlayerDetail($player) {
    // class adds some bootstrap table layout
    var content = '<table id = "allPlayers" class="table table-hover table-dark">';
    content += '<thead id = tableHeader>';
    content += '<tr> <th scope="col"> Number </th>';
    content += '<th scope="col"> Name </th>';
    content += '<th scope="col"> DoB </th>';
    content += '<th scope="col"> Wins </th>';
    content += '<th scope="col"> Losses </th>';
    content += '<th scope="col"> Draws </th>';
    content += '</thead>';
    content += '<tbody id = "tablebody">';
    console.log($player);

    content += "<tr>";
    content += "<td>" + player.id + "</td>";
    content += '<td>' + player.firstName + " " + player.insertion + " " + player.lastName + '</td>';
    content += "<td>" + player.dateOfBirth + "</td>";
    content += "<td>" + player.wonMatches + "</td>";
    content += "<td>" + player.lostMatches + "</td>";
    content += "<td>" + player.draw + "</td>";
    content += "</tr>";

    content += '<input id="deletePlayer" type="button" value="Delete player" onClick = deletePlayer(player.id) />';
    $("#player-detail-div").html(content);

}

// function that deletes guest on click, and small warning pop up
function deletePlayer(playerId) {

    if (confirm('Are you sure you want to delete this super smart dude?')) {
        var id = playerId;
        jQuery.ajax({
            url: 'tournament/allplayers/' + id + '/delete',
            type: 'DELETE',
            success: function() {

            }
        });
        window.location.href = '/index.html';
    } else {
        // window.location.href = '/hotel/guests/guests.html';
    }
}