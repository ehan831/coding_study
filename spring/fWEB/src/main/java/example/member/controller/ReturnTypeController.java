package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ReturnTypeController {

    @RequestMapping("map.do")
    public Map<String, String> test() {
        Map<String, String> m = new HashMap(  );
        m.put( "age", "22" );
        m.put( "hobby", "구기종목");
        return m;
    }

    @RequestMapping("model.do")
    public void test2(Model m) {
        // Model 인자에 지정 = 값을 넘겨받는 것이 아니라, 뷰쪽으로 전달하는 객체
        m.addAttribute( "message", "오늘 점심은 뭐? " );
        m.addAttribute( "addr", "구주소 신주소" );
    }

}
