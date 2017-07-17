/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Addition new task to server.
 */
$(document).ready(function(){

    //'#result_from_server' == id of form
    $('#result_from_server').submit(function (e) {

        //отказались отстандарнтого поведения формы к ajax
        e.preventDefault();

        // собрали данные из формы
        var data = $(this).serialize();

        $.ajax({
            url: "add_task",
            data : data,
            //method
            type : "post",
            //ответ
            success : function (data) {
                //'#resp' == id of <div>
                $('#resp').text(data);
            }
        });

        // console.log(data);
    });
});