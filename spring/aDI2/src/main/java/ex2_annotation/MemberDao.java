package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MemberDao {

    // 생성자와 세터 없이도 값을 지정 !?
//    @Autowired    // 개수가 안맞으면 에러남, 그래서 Qualifier 를 붙이던가 Resource 로 이름 지정
//    @Qualifier("memberBean2")

    @Resource(name="memberBean2")
    private MemberBean member;

    public MemberBean getMember() {
        return member;
    }

    public void insert() {
        System.out.println( member.getName() + "인서서서서트" );
    }

//    public void setMember(MemberBean member) {
//        this.member = member;
//    }
//
//    public MemberDao(MemberBean member) {
//        this.member = member;
//    }
//
//    public MemberDao() {
//    }
}
