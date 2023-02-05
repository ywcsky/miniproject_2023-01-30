package member.model.service;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

import java.sql.Connection;

public class MemberService {
    private MemberDao mDao;
    public MemberService(){
        mDao = new MemberDao();
    }

    public int registerMember(Member member){
        Connection conn = JDBCTemplate.getConnection();
        int result = mDao.insertMember(conn, member);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        return result;
    }

    public Member findOneById(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        return mDao.selectOneById(conn, memberId);
    }
}
