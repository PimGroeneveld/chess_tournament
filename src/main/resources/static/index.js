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
    console.log($players);

    $.each($players, function (index, value) {
        content += "<tr>";
        console.log(value);
        content += "<td style='cursor: pointer;' id='guestId' onClick = showSingleGuest(this)>" + value.id + "</td>";
        content += '<td>' + value.firstName + " " + value.insertion + " " + value.lastName + '</td>';
        content += "<td>" + value.dateOfBirth + "</td>";
        content += "<td>" + value.wonMatches + "</td>";
        content += "<td>" + value.lostMatches + "</td>";
        content += "<td>" + value.draw + "</td>";
        content += "</tr>";
    });
    content += '</tbody> </table> <div class = "row"></div>';
    $("#all-players-div").html(content);
}

// open form
$(document).on('click', '#addChessPlayer', function(){
    window.location.href = '/addchessplayer.html';
});

// function that gets id of the field that is clicked on, and passes it to playerdetail.js
function showSingleGuest(clickId) {
    getval(clickId);

    function getval(cel) {
        console.log("getval")
        var playerId = cel.innerHTML;
        window.location.href = '/playerdetail.html?playerId=' + encodeURIComponent(playerId);
    }
}