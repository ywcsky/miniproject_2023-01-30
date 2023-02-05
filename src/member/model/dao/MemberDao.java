package member.model.dao;

import member.model.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    public int insertMember(Connection conn, Member member) {
        String sql = "INSERT INTO MEMBER_TBL VALUES (?,?,?,?,DEFAULT)";
        int result = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,member.getMemberId());
            pstmt.setString(2,member.getMemberPw());
            pstmt.setString(3,member.getMemberNickName());
            pstmt.setString(4,member.getMemberEmail());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Member selectOneById(Connection conn, String memberId) {
        String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
        Member member = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,memberId);
            ResultSet rset = pstmt.executeQuery();
            member = new Member();
            if(rset.next()){
                member.setMemberId(rset.getString(1));
                member.setMemberPw(rset.getString(2));
                member.setMemberNickName(rset.getString(3));
                member.setMemberEmail(rset.getString(4));
                member.setMemberDate(rset.getTimestamp(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return member;
    }
}
