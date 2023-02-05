package member.model.dao;

import member.model.vo.Border;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorderDao {

    public List<Border> selectListByCategory(Connection conn, int categoryNum,int currentPage) {
        String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY BORDER_NO DESC) AS NUM, BORDER_NO,BORDER_SUBJECT,MEMBER_NICKNAME,TO_CHAR(BORDER_DATE,'yyyy-mm-dd hh:mi:ss'),BORDER_COUNT,CATEGORY_NO FROM BORDER_TBL) WHERE CATEGORY_NO = ? AND NUM BETWEEN ? AND ?";
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
}
