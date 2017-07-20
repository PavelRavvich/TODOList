/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Get from server json with all tasks.
 */
$(document).ready(function () {

    //button id.
    $("#get_all_task_but").click(function () {

        // URL of servlet.
        $.ajax({
            url: 'get_all_tasks',
            type: "post",

            //dataType (default: Intelligent Guess (xml, json, script, or html)),
            dataType: 'json',

            //function (data) параметр ответ от сервера может быть html json что угодно/
            //data это данные пришедшие с сервера.
            success: function (data) {
                console.log(data);

                //очистка области с id = #all_tasks
                $('#all_tasks').empty();

                // коллекция объектов в json data
                $.each(data, function (key, value) {
                    printTask(key, value);
                });


                $('.check-box').on('change', function (e) {

                    var checked;
                    if ($(this).attr("checked") !== 'checked') {
                        checked = 0;
                    } else {
                        checked = 1;
                    }


                    $.ajax({
                        url: "update_done_status",
                        data: {
                            id: $(this).attr("data-id"),
                            done: checked
                        },
                        type: "post"
                    });

                });
            }
        });
    });
});

/* value это объект пришедший с сервера Task поля объета Task представлены
в виде массива value а доступ к полям производится по ключу-именя поля :
                                                             value['fieldName'].
 */
function printTask(key, value) {

    // checkboxHtml это объект страницы инкапсулированный html тегом.
    //Создание  объекта чекбокса и формирование его состояния.
    var checkboxHtml = $(

        // 1-ый параметр это тэг или тип объекта который создаем.
        "<input>",

        //Для установки состояния объекта делаем инъекцию состояний (потдерживаемые тегом-объектом)
        {
            class: 'check-box',
            type : 'checkbox',

            //Помимо стандартных полей тегу-объекту можно присваивать дополнительные,
            //с помощью префикса data-.
            'data-id' : value['id'],

            value : value['done']

    });

    //Проверка атрибута boolean done который был записан сервером в объект.
    if(value['done']) {
        checkboxHtml.attr( 'checked', 'checked' );
    }

    //привязавшись к id-шнику части html страницы #all_tasks пишем в него данные
    $('#all_tasks').append(
        checkboxHtml).append(
        "</ br>").append(
        value['id']).append(
        value['']).append(
        'desc').append(
        value['create']);
}


