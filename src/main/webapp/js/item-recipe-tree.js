// $(document).ready(function() {
//
//     var recipe_path = location.protocol + "//" + location.host + "/gw2auxiliary/recipe";
//     var item_id = $("#item-id").val();
//     var item_tree = $(".item-recipe");
//
//     //ajax for item by gw2id using hidden field
//     $.ajax({url: recipe_path, data: {"item_id" : item_id}, success: function(result) {
//
//         var div_root_item = ($("<div class='root_item expandable'>").text(result.root_item_name + "\t" + result.root_item_rarity
//             + "\t" + result.root_item_type).prepend($("<img />").attr("src", result.root_item_icon)));
//
//         var btn_root_item_expand = $("<input>").attr("type", "button").val("v").on("click", function () {
//
//             div_root_item.toggle();
//
//         });
//
//         div_root_item.prepend(btn_root_item_expand);
//
//
//         $.each(result.recipes, function (key, recipe) {
//
//             var quantity;
//             var div_recipe_area = $("<div class='recipe_area' padding='25'>");
//
//
//             $.ajax({url: recipe_path, data: {"item_id" : recipe.item_id}, success: function(result) {
//
//                 var div_recipe = $("<div class='expandable recipe_item ' " + result.root_item_id + "'>").text(result.root_item_name
//                     + "\t" + result.root_item_rarity + "\t" + result.root_item_type).prepend($("<img />").attr("src", result.root_item_icon));
//                 var btn_recipe_expand = $("input").attr("type", "button").val("v").on("click", function () {
//
//                     div_recipe.toggle();
//
//                 });
//
//                 div_recipe.prepend(btn_recipe_expand);
//
//                 $.each(result.item_id, function (key, ingredient) {
//
//                    var div_ingredient = $("<div class='expandable ingredient'>").text(result.root_item_name
//                        + "\t" + result.root_item_rarity + "\t" + result.root_item_type).prepend($("<img />").attr("src", result.root_item_icon));
//
//                    var bu
//
//                    div_recipe.append(div_ingredient);
//                 });
//
//                 div_recipe_area.append(div_recipe);
//             }})
//
//             div_root_item.append(div_recipe_area);
//
//         });
//
//         item_tree.append(div_root_item)
//
//     }});


$(document).ready(function() {

    var recipe_path = location.protocol + "//" + location.host + "/gw2auxiliary/recipe";
    var item_id = $("#item-id").val();
    var item_tree = $(".item-recipe");

    //ajax for item by gw2id using hidden field
    $.ajax({url: recipe_path, data: {"item_id" : item_id}, success: function(result) {

        $.each(result.recipes, function (key, recipe) {

            $.ajax({url: recipe_path, data: {"item_id" : recipe.item_id}, success: function(result) {

                var recipe_table = $("<table class='recipe '" + item_id + ">");

                $.each(result.item_id, function (key, ingredient) {

                    var ingredient = $("<td>").text(ingredient.item_count_needed + "\t" + ingredient.item_id);
                    recipe_table.append(ingredient);
                });

                item_tree.append(recipe_table);

            }});


        });


    }});



    //if recipes not null for item, display item, then drop down for recipe,
    //var btn_expand = $("<input>").attr("type", button);

    //for each recipe in item.getrecipes() {
    //output dropdown button if item has recipes
    //dropdown button.on(click) display recipes for this one and so on.
    //output icon, quantity, name, rarity, type
    // else display "No recipe for this item."



});