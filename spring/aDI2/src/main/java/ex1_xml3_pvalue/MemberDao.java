package ex1_xml3_pvalue;

import ex1_xml4_list.MemberBean;

public class MemberDao {
    private MemberBean member;

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public MemberDao(MemberBean member) {
        this.member = member;
    }
    public MemberDao() {
    }

    public void insert() {
        System.out.println( member + "님의 정보가 입력 되었음" );
    }
}
