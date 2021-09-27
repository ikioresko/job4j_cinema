let num = 0;
let placeCounter = 0;

function getNum() {
    return ++num;
}

function count() {
    return placeCounter++;
}

$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/cinema/index',
        dataType: 'json',
        success: function (data) {
            let place = "";
            let w = 0;
            while (w < data.length) {
                let r = getNum();
                place += "<tr></tr><th> Ряд: " + r + "</th>";
                for (let x = 0; x < 3; x++) {
                    let doDisabled = "";
                    let placeRowCell = data[w]['row']
                        + ":" + data[w]['cell']
                        + ":" + data[w]['id'];
                    data[count()]['place'] === false ? doDisabled = "disabled" : "";
                    place += "<td><input type=radio name=place value="
                        + placeRowCell + " " + doDisabled + ">"
                        + " Ряд: " + data[w]['row']
                        + " Место: " + data[w]['cell']
                        + "</td>";
                    w++;
                }
            }
            $('#tb').append(place);
        }
    })
    setTimeout('window.location.reload()', 15000);
})