/**
 * 
 */

$(function () {
    $('#navigation ul li').hover( function () {
        $(this).animate({'paddingLeft':"+=15px"});
    }, function () {
        $(this).animate({'paddingLeft':"-=15px"});
    });

    // quick menu
    $(window).scroll( function () {
       $('#navigation').css('top', $(document).scrollTop());
    });





}); // function end