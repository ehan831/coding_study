package ex1_xml2_ref;

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


}
