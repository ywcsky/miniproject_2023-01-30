package member.model.service;

import common.JDBCTemplate;
import member.model.dao.BorderDao;
import member.model.vo.Border;
import member.model.vo.PageData;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class BorderService {
    private BorderDao bDao;

    public BorderService() {
        bDao = new BorderDao();
    }

    public PageData getBorderList(int categoryNum, int currentPage) {
        Connection conn = JDBCTemplate.getConnection();
        List<Border> bList = bDao.selectListByCategory(conn, categoryNum, currentPage);
        String pageNavigator = bDao.pageNavigator(conn, categoryNum,currentPage);
        PageData pageData = new PageData(pageNavigator,bList);

        return pageData;
    }

    public HashMap<Integer, List<Border>> getIndexBorderList(){
        Connection conn = JDBCTemplate.getConnection();
         return bDao.selectAllList(conn);
    }

    public Border borderView(int borderNo) {
        Connection conn = JDBCTemplate.getConnection();
        return bDao.selectBorderView(conn, borderNo);
    }

    public int writeBorder(Border border) {
        Connection conn = JDBCTemplate.getConnection();
        int result = bDao.insertBorder(conn, border);
        if(result > 0){
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        return result;
    }
}
