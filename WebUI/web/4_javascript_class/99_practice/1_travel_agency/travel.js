window.onload = function () {

    document.getElementById('frmInput').addEventListener('blur', myBlurFunction, true);

    function myBlurFunction() {
        var ps1 = document.getElementById('textfield').value;
        var ps2 = document.getElementById('textfield2').value;
        var ps3 = document.getElementById('textfield3').value;

        var totalPrice = (ps1 * 39000) + (ps2 * 29000) + (ps3 * 19000);
        // alert(ps1);

        document.getElementById("textfield4").value = totalPrice;
    }

    // 숫자만 정규식
    var regexp = /[^0-9]/g;


    // 체크 필수    // 버튼 누를 시 페이지 이동
    document.getElementById('btn1').onsubmit = function (ev) {
        ev.preventDefault();
        var agree1 = document.getElementById('checkbox');
        var agree2 = document.getElementById('checkbox2');
        alert(agree1.checked);
        alert(agree2.checked);

        if (agree1.checked && agree2.checked) {
            document.getElementById('btn1').submit();
            var result = confirm("결제 하시겠습니까?");
            // alert(result);
            if (result == true) {
                location.href = "http://nate.com";
            }
        } else {
            alert("계속 진행하시려면 약관 및 개인보호정책에 모두 동의해주세요.");
            return;
        }
    }
}

document.getElementById('btn2').onclick = function () {
    var result = confirm("예약 하시겠습니까?");
    // alert(result);
    if (result == true) {
        location.href = "http://daum.net";
    }
}
