

$(function () {
    $
    $('#bio div').hide();
    $('#bio div:first').show();
    $('#bio h3').css('cursor', 'pointer');

    $('#bio h3').click( function () {
       // alert('click');
       $(this).next().animate( {'height':'toggle'}, 500 );
    });
});