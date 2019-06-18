/**
 * 
 */


$(function () {
    $('.rollover').each( function () {
       var a = $(this);
       var img = a.find('img');

       // img attr src change
       //  replace('a','b') : a to b

        var src_off = img.attr('src'); // img src 얻어오기
        var src_on = src_off.replace('_off', '_on'); // 해당 src 중에 off > on 으로 바꾼 값

        $('<img/>').attr('src', src_on); // image loading in advance 이미지 미리 로딩해놓으려면 이렇게

        a.hover( function () {
            img.attr('src', src_on); // 마우스 오버 시 : on 값으로
        }, function () {
            img.attr('src', src_off); // 마우스 아웃 시 : off 원래 값으로
        }); // hover end
    });
});