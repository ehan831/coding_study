

$(function () {

    var anchors = $(".tabSet ").find('a');
    var panelDivs = $('.tabSet').find('div.panel') ;

    anchors.show();
    panelDivs.hide();

    var lastAnchor = anchors.filter(".on");
    var lastPanel = $(lastAnchor.attr('href')); // 최초값 : #panel1-1
    $(lastPanel).show();

    anchors.click( function () {
        // panelDivs.hide(); // 일단 다 닫고
        // anchors.attr('class', ''); // 기존 체크 없애고
        // $(this).attr('class', 'on'); // 누른 거 on 되게 하고
        // $($(this).attr('href')).show();

        lastPanel.hide();   // 기존 내용 삭제
        lastAnchor.removeClass('on'); // 기존 클래스 삭제

        lastAnchor = $(this); // 새로 부여
        lastAnchor.addClass('on'); // 새로 클래스 부여
        lastPanel = $(lastAnchor.attr('href')); // 새로 부여
        lastPanel.show(); // 내용 보이기

    }); // anchors end






}); // function end