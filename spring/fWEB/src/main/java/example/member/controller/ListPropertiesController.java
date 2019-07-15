package example.member.controller;

import example.member.model.MemberVO;
import example.member.model.MemberVOList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListPropertiesController {

    @RequestMapping("/multuInsert.do")
    public void test(MemberVOList memberVOList) {
        System.out.println( "multiInsert.do calls" );
        for(MemberVO vo : memberVOList.getList()) {
            System.out.printf("state=%s, id=%s, name=%s, age=%d",
                    vo.isState(), vo.getId(), vo.getName(), vo.getAge());
        }  // for
    } // test
}
