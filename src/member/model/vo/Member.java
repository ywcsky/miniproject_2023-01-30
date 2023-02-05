package member.model.vo;

import java.sql.Timestamp;

public class Member {
    private String memberId;
    private String memberPw;
    private String memberNickName;
    private String memberEmail;
    private Timestamp memberDate;

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", memberNickName='" + memberNickName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberDate='" + memberDate + '\'' +
                '}';
    }

    public Member(String memberId, String memberPw, String memberNickName, String memberEmail) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberNickName = memberNickName;
        this.memberEmail = memberEmail;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public Timestamp getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(Timestamp memberDate) {
        this.memberDate = memberDate;
    }
}
