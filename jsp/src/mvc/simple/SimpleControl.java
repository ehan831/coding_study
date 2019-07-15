package mvc.simple;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class SimpleControl extends HttpServlet {
//    String jspDir = "/05_mvc_class/1_mvcSimple/";
//
//    public SimpleControl() {
//        super( );
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest( request, response );
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest( request, response );
//    }
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 이전 화면에서 넘겨받는 값을 받을 때 :  request.getParameter()
//        // request 에 데이터 저장할 때 : request.setAttribute("name", value)
//        // request 에서 데이터를 얻어올 때 : request.getAttribute("name")
//        request.setAttribute( "param", "오늘은화요일" );
//
//        // forwarding !! 마치 <jsp:forward>
//        RequestDispatcher dispatcher = request.getRequestDispatcher( jspDir + "simpleView.jsp" );
//        dispatcher.forward( request, response );
//    }
//}

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 주석 문 밑 골뱅이 getter 지우기

public class SimpleControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 경로 생성
    String jspDir = "/05_mvc_class/1_mvcSimple/";


    public SimpleControl() {
        super();
    }

    // 어떤 방식으로도 연결되게 processRequest 로 설정
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 이전 화면에서 넘겨 받는 값을 얻어올때 : request.getParameter()
        // request에 데이타 저장 : request.setAttribute("name",value) == session 과 같은 개념
        // request 에서 데이타를 얻어올때 : request.getAttribute("name")

        // 이전 화면 (start.jsp) 에서 type 을 type 변수에 받아옴
        String type = request.getParameter("type");
        String value = "오늘도 화이팅";

        if(type != null) value = "NN 우리조 단합";
        // 타입이 아니라면 오늘도 화이팅
        // 타입이라면 우리조 단합

        // getParameter setAttribute getAttribute 용도 파악 중요 (상황에 맞게 사용 )

        //request  라는 객체에 param 이라는 값으로 오늘도 화이팅 집어넣기
        request.setAttribute("param", value);

        // 포워딩 forwarding !!!
        // object 형이 들어간다 == ArrayList 가 들어간다! 즉 용이 하다.

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(jspDir + "simpleView.jsp");
        dispatcher.forward(request, response);
    }
    // 서블릿 요청 실행이 까다로움

}