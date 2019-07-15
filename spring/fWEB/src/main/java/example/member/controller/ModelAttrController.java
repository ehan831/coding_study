package example.member.controller;

import example.member.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttrController {


    @ModelAttribute("message")
    public String attr1() {
        return "행복 수요일";
    }

    @ModelAttribute("memberVO")
    public MemberVO attr2() {
        MemberVO vo = new MemberVO();
        vo.setId( "003" );
        vo.setAge( 20 );
        vo.setName( "홍동범" );
        return vo;
    }

    @RequestMapping("modelAttr.do")
    public void test() {
        // 뷰로 데이터를 전달하는 방법
        // 1. Map
        // 2. ModelAndView
        // 3. Model

    }
}
