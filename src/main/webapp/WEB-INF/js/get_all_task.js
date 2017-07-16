/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Get from server json with all tasks.
 */
$(document).ready(function(){

    //button id.
    $("#get_all_task_but").click(function(){

        // URL of servlet.
        $.post('get_all_tasks',


            function(result){

            $("#all_task_view").html(result);
        });
    });

});