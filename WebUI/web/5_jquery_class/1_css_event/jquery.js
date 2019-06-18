/**
 *
 */

$(function () {

    // 1. table odd background color change
    // 단순 css 로 바로 적용 시키면 밑의 마우스 오버랑 같이 작동하지 않는다. >> 이것도 addClass 로 적용시키면 해결
    // $('#celebs tbody tr:odd').css('background', '#e9ced7');
    $('#celebs tbody tr:odd').addClass('table_striping');


    // 2. in base.css - mouse hover
    $('#celebs table tbody tr').mouseover(function () {
        $(this).addClass('td_mouseover');
    }).mouseout(function () {
        $(this).removeClass('td_mouseover');
    });

    // 3. toggle button
    // $('#toggleButton').click(function () {
    //     $("#intro > img").toggle();
    // });

    $('#toggleButton').click( function () {

        var img = $('#intro > img');
        if(img.is(':visible')) {
            img.slideUp(1000);
        } else {
            img.slideDown(1000);
        }
    });

    // var click = $('#hideButton');
    // click(function () {
    //     $('#intro image').hide();
    // });








}); // function end