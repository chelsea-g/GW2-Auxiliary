$(document).ready(function() {

    if ($("#update-database").prop("disabled") == false) {

        $("#update-database").on("click", function() {

            if ($(".complete").length) {

                $(".complete").remove();

            }

            $(this).prop("disabled", true);
            //TODO: Change path when demo no longer needed.
            var update_path = $(location).attr("href") + "/../demo-update-item-database";
            $.ajax({url: update_path, success: function() {


                $("#update-database").prop("disabled", false);
                var complete = $("<p>").text("Update Complete!").attr("class", "complete");

                $(".admin").append(complete);


            }});
        });

    }



})