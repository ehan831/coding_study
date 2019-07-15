package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;


@Controller
@RequestMapping("/user/")
public class MemberController {

//	user /userJoin.do 요청일 경우 user/userJoin.jsp 뷰를 지정하기
//	@RequestMapping("/userJoin.do")
//	public void common() {
//	System.out.println("요청2");
//	}
//	
	@RequestMapping(value="{url}.do")
	public String common(@PathVariable String url) {
		System.out.println(url+"요청");
		return "/user/"+url;
	}
	
//	
	@Autowired
	MemberService memberService;
	
	
//	회원 가입
	@RequestMapping("userInsert.do")
	public ModelAndView insert(MemberVO vo) {
		int result = memberService.userInsert(vo);
		System.out.println("userInsert.do 호");
		String message = "가입되지 않았습니다.";
		if( result > 0 ) {
			message = vo.getUserName()+"님의 가입을 축하합니다.";
		}
	ModelAndView mv = new ModelAndView();
	mv.addObject("result", result);
	mv.addObject("message", message);
	mv.setViewName("user/userJoin_ok");
	return mv;
	}
	
	@RequestMapping("idCheck.do")
	@ResponseBody 
	//ResponseBody => ajax 인 경우 반드시 해야 비동기 통신을 함
	public String idcheck(MemberVO vo) {
		MemberVO memberVO = memberService.idCheck_Login(vo);
		String result = "ID 사용 가능합니다";
		if(memberVO != null) result = "중복된 ID 입니다.";
		return result;
	}
	
	@RequestMapping("login.do")
	public String login(MemberVO vo, HttpSession session) {
		MemberVO result = memberService.idCheck_Login(vo);
		if( result == null || result.getUserId() == null ) {
			return "/user/userLogin";
		} else {
			// 로그인 성공
			session.setAttribute("sessionTime", new Date().toLocaleString());
			session.setAttribute("userName", result.getUserName());
		}
		return "/user/Main";
	}
	
}

