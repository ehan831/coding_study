package example.member.controller;

import example.member.model.MemberVO;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

public class ParameterController {

    @RequestMapping("param.do")
    public String test(String id, int age) {
        return "param";
    }

    @RequestMapping("paramForm.do")
    public void test2(MemberVO vo, HttpSession session) {
        String dbId = "001";
        String dbName = "홍길동범";

        // 입력값과 DB값이 동일하면 세션에 저장
        if(vo.getId().equals( dbId ) && vo.getName().equals( dbName )) {
            session.setAttribute( "login", dbId + "로그인" );
        }
    }
}
