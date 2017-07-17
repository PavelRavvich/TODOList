/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Get from server json with all tasks.
 */
$(document).ready(function(){

    //button id.
    $("#get_all_task_but").click(function(){

        // URL of servlet.
        $.ajax({
            url : 'get_all_tasks',
            type : "post",
            success : function (data) {
                var data = JSON.parse(data);


                $.each( data, function( key, value ) {

                    //insert HTML into DOM here
                    var checkboxName = 'checkbox'+value['id'];
                    var checkboxValue = value['id'];
                    var checkboxHtml = '<input type="checkbox" class="check-box" data-id='+ checkboxValue+' name="'+checkboxName+'" value="'+checkboxValue+'" />';
                    $('#all_tasks').append(checkboxHtml).append(
                        "</ br>").append(
                            value['id']).append(
                                value['']).append(
                                    'desc').append(
                                        value['create']
                    );
                });

                $('.check-box').on('change', function(e) {

                    var checked;
                    if($(this).attr("checked") != 'checked') {
                        checked = 0;
                    } else {
                        checked = 1;
                    }
                    console.log(checked);
                    console.log($(this).attr("data-id"));
                    $.ajax({
                        url: "update_done_status",
                        data : {id : $(this).attr("data-id"),
                                done : checked},
                        type : "post"
                    });

                });
            }
        });
    });
});