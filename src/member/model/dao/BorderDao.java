package member.model.dao;

import member.model.vo.Border;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BorderDao {

    public List<Border> selectListByCategory(Connection conn, int categoryNum,int currentPage) {
        String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY BORDER_NO DESC) AS NUM, BORDER_NO,BORDER_SUBJECT,MEMBER_NICKNAME,TO_CHAR(BORDER_DATE,'yyyy-mm-dd hh:mi:ss'),BORDER_COUNT,CATEGORY_NO FROM BORDER_TBL WHERE CATEGORY_NO = ?) WHERE NUM BETWEEN ? AND ?";
        List<Border> bList = null;
        int recordCountPerPage = 10;
        int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
        int end = currentPage*recordCountPerPage;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,categoryNum);
            pstmt.setInt(2,start);
            pstmt.setInt(3,end);
            ResultSet rset = pstmt.executeQuery();
            bList = new ArrayList<Border>();
            while (rset.next()){
                Border border = new Border();
                border.setBorderNo(rset.getInt("BORDER_NO"));
                border.setBorderSubject(rset.getString("BORDER_SUBJECT"));
                border.setBorderDate(rset.getString(5));
                border.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
                border.setBorderCount(rset.getInt("BORDER_COUNT"));
                bList.add(border);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bList;
    }
    public String pageNavigator(Connection conn, int categoryNum, int currentPage) {
        String sql = "SELECT COUNT(*) FROM BORDER_TBL WHERE CATEGORY_NO= ?";
        String category = "";
        int pageNaviCount = 0;
        int pageNaviCountPer = 10;
        int startNavi = ((currentPage - 1) / pageNaviCountPer) * pageNaviCountPer + 1;
        int endNavi = startNavi + pageNaviCountPer - 1;
        switch (categoryNum) {
            case 1:
                category = "qna";
                break;
            case 2:
                category = "community";
                break;
            case 3:
                category = "it";
                break;
            case 4:
                category = "notice";
                break;
        }
        StringBuilder sb = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,categoryNum);
            ResultSet rset = pstmt.executeQuery();
            if (rset.next()) {
                int totalCount = rset.getInt(1);
                if (totalCount % pageNaviCountPer > 0) {
                    pageNaviCount = (totalCount / pageNaviCountPer) + 1;
                } else {
                    pageNaviCount = totalCount / pageNaviCountPer;
                }
                if (endNavi > pageNaviCount) {
                    endNavi = pageNaviCount;
                }
                sb = new StringBuilder();
                for (int i = startNavi; i <= endNavi; i++) {
                    sb.append("<a href='/border/" + category + "?page=" + i + "'>" + i + "</a>");
                }
                rset.close();
                pstmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public HashMap<Integer, List<Border>> selectAllList(Connection conn) {
        String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY BORDER_NO DESC) AS NUM, BORDER_NO,BORDER_SUBJECT,MEMBER_NICKNAME,TO_CHAR(BORDER_DATE,'yyyy-mm-dd hh:mi:ss'),BORDER_COUNT,CATEGORY_NO FROM BORDER_TBL WHERE CATEGORY_NO = ?) WHERE NUM BETWEEN 1 AND 5";
        List<Border> bList = null;
        HashMap<Integer,List<Border>> hashMap = new HashMap<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Border border;
            for(int i = 1; i <= 4; i++){
                pstmt.setInt(1,i);
                ResultSet rset = pstmt.executeQuery();
                    bList = new ArrayList<>();
                    while(rset.next()){
                        border = new Border();
                        border.setBorderNo(rset.getInt(2));
                        border.setBorderSubject(rset.getString(3));
                        border.setMemberNickname(rset.getString(4));
                        border.setBorderDate(rset.getString(5));
                        bList.add(border);
                    }
                    hashMap.put(i,bList);
                rset.close();
            }
            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hashMap;
    }

    public Border selectBorderView(Connection conn, int borderNo) {
        String sql = "SELECT BORDER_NO,BORDER_SUBJECT,BORDER_CONTENT,BORDER_DATE,MEMBER_NICKNAME,BORDER_COUNT FROM BORDER_TBL WHERE BORDER_NO = ?";
        Border border = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, borderNo);
            ResultSet rset = pstmt.executeQuery();
            if(rset.next()){
                border = new Border();
                border.setBorderNo(rset.getInt(1));
                border.setBorderSubject(rset.getString(2));
                border.setBorderContent(rset.getString(3));
                border.setBorderDate(rset.getString(4));
                border.setMemberNickname(rset.getString(5));
                border.setBorderCount(rset.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return border;
    }

    public int insertBorder(Connection conn, Border border) {
        String sql = "INSERT INTO BORDER_TBL VALUES(SEQ_BORDER_NO.NEXTVAL,?,?,DEFAULT,?,?,DEFAULT)";
        int result = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,border.getBorderSubject());
            pstmt.setString(2,border.getBorderContent());
            pstmt.setString(3,border.getMemberNickname());
            pstmt.setInt(4,border.getBorderNo());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
