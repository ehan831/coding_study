/**
 *
 */
$(document).ready(function () {

    $('.accordion').each(function () {
        var allDt = $(this).find('dt');
        var allDd = $(this).find('dd');

        allDd.hide(); // dd 모두 안보이게 닫기

        allDt.css('cursor', 'pointer');

        allDt.click(function () {
            // alert('click'); // 동작하는지 확인
            allDd.slideUp(500); // 모두 닫고
            $(this).next().show(); // 걔만 열기
        });

        // toggle


    });


}); // function end