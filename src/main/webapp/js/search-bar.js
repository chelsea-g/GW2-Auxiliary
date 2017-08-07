$(document).ready(function() {

    //TODO: Optimize search, try to access the database less and use gw2 id instead of name

    var dropdown = $("#search_dropdown");
    var dropdown_content = $("#results_dropdown");

    $("window").on("click", function() {

        dropdown.hide;

    });

    $("#search").on("click", function() {

        //if the search bar has more than 0 chars in it
        if ($("#search").val.length) {

            dropdown.show();

        } else {

            dropdown.hide();

        }

    }).keyup(function() {

        $("#results_dropdown").empty();

        if ($("#search").val.length) {

            var search_path = location.protocol + "//" + location.host + "/gw2auxiliary/process-search";

            var query = $("#search").val();

            var data_table = $("<table>");

            $.ajax({url: search_path, data: {"query" : query}, success: function(results) {

                $.each(results, function(key, result) {

                    var item_path = location.protocol + "//" + location.host + "/gw2auxiliary/item-page?item_name=" + result.item_name;
                    var data_row = $("<tr>").on("click", function() {

                        window.location = $(this).find("a").attr("href");


                    });

                    var icon = $("<td>").append($("<img/>").attr("src", result.item_icon));
                    var name = $("<td>").text(result.item_name).append($("<a>").attr("href", item_path));
                    var type = $("<td>").text(result.item_type);

                    data_row.append(icon);
                    data_row.append(name);
                    data_row.append(type);

                    data_table.append(data_row);

                });

            }});

            dropdown_content.append(data_table);

        }

    })

});