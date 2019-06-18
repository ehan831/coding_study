/**
 * 
 */

$(function() {
	// 시간 변수 선언
	var time = new Date();
	// 년, 월 , 일 변수 선언
	var year = time.getFullYear();
	var month = time.getMonth() + 1;
	var date = time.getDate();

	// 년, 월, 일 출력
	$('#date_wrap > span:eq(0)').html(year);
	$('#date_wrap > span:eq(1)').html(month);
	$('#date_wrap > span:eq(2)').html(date);

	// 클릭시 검색어를 입려하세요를 지우고 포커스 아웃되면 다시 띄우기
	$('#keyword').focus(function() {
		$(this).css("background-position", "0 -500px");
	}).blur(function() {
		$(this).css("background-position", "0 0");
	});

	// 탭메뉴 ==================================================================
	var allDt = $('#tabmenu').find('dt');
	var allDd = $('#tabmenu').find('dd');

	allDt.hover(function() {
		$(this).find('img').attr(
				'src',
				'images/tab_btn_' + ($('#tabmenu > dt').index(this) + 1)
						+ '_over.gif');
		allDd.hide();
		$(this).next().show();
	}, function() {
		$(this).find('img').attr(
				'src',
				'images/tab_btn_' + ($('#tabmenu > dt').index(this) + 1)
						+ '_out.gif');
	});

	// ============================================================================
	// bxSlide 설정
	$('#best_bg > ul').bxSlider({
		mode : "horizontal", // 가로 수평 슬라이드
		moveSlides : 1, // 슬라이드 이동시 개수 설정
		minSlides : 5, // 최소 노출 개수
		maxSlides : 5,// 최대 노출개수
		slideMargin : 50, // 슬라이드 간의 간격
		slideWidth : 120, // 슬라이드 너비 설정
		auto : true, // 자동 흐름
		speed : 500, // 이동 속도
		autoHover : true,// 마우스오버 시 정지 여부
		controls : true, // 이전 버튼,다음 버튼 노출 여부 설정
		pager : true, // 현재 위치 페이지 표시
	});

	// ============================================================================
	// 전체 메뉴 열기
	$('#total_btn').click(function() {
		$('#total_menu').show();
	});
	// 전체 메뉴 닫기
	$('#total_close').click(function() {
		$('#total_menu').slideUp();
	});

	// ============================================================================
	// 로그인
	$('.login_wrap a').click(function() {
		$('#login_f').animate({
			top : 20
		});
	});
	// 로그인창 끄기
	$('.login_close_btn a').click(function(){
		$('#login_f').animate({
			top : -500
		});
	});

	// ============================================================================
	//알림판
	   //현재 선택된 내비 버튼을 가지고 있는 변수, 초기값으로 첫번째 버튼을 저장
	   var onBtn = $('#roll_banner_wrap dt a:first');
	   
	   $('#roll_banner_wrap dt a').on('click',function(){
	      
	      var idx = $('#roll_banner_wrap dt a').index(this);
	      $('#roll_banner_wrap dd:visible').hide();
	      $('#roll_banner_wrap dd').eq(idx).show();
	      
	      var tmpSrc = $('img'.onBtn).attr('src');
	      $('img'.onBtn).attr('src',tmpSrc.replace('over.gif','out.gif'));
	      tmpSrc = $('img'.this).attr('src');
	       $("img",this).attr("src",tmpSrc.replace("out.gif","over.gif"));

	      onBtn = $(this);
	      
	      return false;
	   });
	   
	   var n = 0;
	   
	   function autoBnn(){
	      n++;
	      if(n>=4) n-0;
	      console.log(n);
	      $('roll_banner_wrap dt a').eq(n).click();
	      
	      auto = setTimeout(autoBnn, 3000);
	   }
	   var auto = setTimeout(autoBnn, 3000);
	   
	   $('#roll_banner_wrap p a:eq(1)').on('click',function(){
	      clearTimeout(auto);
	      return false;
	   });
	   $('#roll_banner_wrap p a:eq(0)').on('click',function(){
	      clearTimeout(auto);
	      auto = setTimeout(autoBnn, 3000);
	      return false;
	   });
})