package member.model.vo;

import oracle.sql.DATE;

import java.sql.Date;
import java.sql.Timestamp;

public class Border {
    private int borderNo;
    private String borderSubject;
    private String borderContent;
    private int borderCount;
    private String borderDate;
    private String memberNickname;
    private int categoryNo;

    public Border() {
    }

    public Border(String borderSubject, String borderContent, String memberNickname, int categoryNo) {
        this.borderSubject = borderSubject;
        this.borderContent = borderContent;
        this.memberNickname = memberNickname;
        this.categoryNo = categoryNo;
    }

    public int getBorderNo() {
        return borderNo;
    }

    public void setBorderNo(int borderNo) {
        this.borderNo = borderNo;
    }

    public String getBorderSubject() {
        return borderSubject;
    }

    public void setBorderSubject(String borderSubject) {
        this.borderSubject = borderSubject;
    }

    public String getBorderContent() {
        return borderContent;
    }

    public void setBorderContent(String borderContent) {
        this.borderContent = borderContent;
    }

    public int getBorderCount() {
        return borderCount;
    }

    public void setBorderCount(int borderCount) {
        this.borderCount = borderCount;
    }

    public String getBorderDate() {
        return borderDate;
    }

    public void setBorderDate(String borderDate) {
        this.borderDate = borderDate;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }
}
