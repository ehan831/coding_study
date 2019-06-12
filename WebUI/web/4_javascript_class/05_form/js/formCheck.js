window.onload = function () {

    var frm = document.getElementById('frm');
    // var inputs = document.querySelectorAll("input");

    // var frm = document.querySelector('#frm');
    // var inputs = document.querySelectorAll("input");

    frm.onsubmit = function (e) {
        e.preventDefault(); // submit 등의 동작을 막음
        var agree = frm.agree;
        // alert(agree.checked);
        if (!agree.checked) {
            alert('계속 진행하시려면 반드시 동의해야합니다.');
            return;
        }
        // 특정 별칭만 허용해주기
        var nickList = ['aaa','bbb','ccc'];
        if(!nickList.includes(frm.nickname.value)){
            alert('닉네임을 확인해주세요');
            return;
        }
        frm.submit(); // 위에서 막았으면, 다 끝나고 다시 열여줘야한다.

    }
}