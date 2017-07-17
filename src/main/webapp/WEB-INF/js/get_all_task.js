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
                    var checkboxValue = value['desc'];
                    var checkboxHtml = '<input type="checkbox" name="'+checkboxName+'" value="'+checkboxValue+'" />';
                    $('#all_tasks').append(checkboxHtml).append(
                        "</ br>").append(
                            value['id']).append(
                                value['']).append(
                                    'desc').append(
                                        value['create']
                    );

                });

                $('input[type="checkbox"]').on('change', function(e) {

                    var data = $(this).value;
                    console.log(data);

                    $.ajax({
                        url: "add_task",
                        data : data,
                        type : "post"
                    });
                });


            }
        });
    });
});