package ex1_xml4_list;

import ex1_xml2_ref.MemberBean;

import java.util.List;

public class ListBean {
    public ListBean(List<Integer> intList, List<MemberBean> memberList) {
        this.intList = intList;
        this.memberList = memberList;
    }
    public ListBean() {
    }

    private List<Integer> intList;
    private List<MemberBean> memberList;

    public List<Integer> getIntList() {
        return intList;
    }

    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }

    public List<MemberBean> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<MemberBean> memberList) {
        this.memberList = memberList;
    }
}
