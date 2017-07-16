/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Addition new task to server.
 */
$(document).ready(function(){

    //"#send_task" == id кнопки-input'а.
    $("#send_task").click(function(){

        // '#data' == input для данных.
        var data = $('#data').val();

        // 'add_task' == url сервлета.
        $.post('add_task', {

            //первое значение==ключ для HttpServletRequest.getParameter("data").
            //второе переменная полученная из var data = $('#data').val();
            data : data

        }, function(result){

            // #answer_from_server == id области в которую будет помещен ответ.
            $("#result_from_server").html(result);
        });
    })
});