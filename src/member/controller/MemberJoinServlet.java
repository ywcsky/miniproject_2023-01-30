package member.controller;

import member.model.service.MemberService;
import member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/join")
public class MemberJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/join.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("memberId");
        String memberPw = request.getParameter("memberPw");
        String memberNickName = request.getParameter("memberNickName");
        String memberEmail = request.getParameter("memberEmail");
        Member member = new Member(memberId,memberPw,memberNickName,memberEmail);
        MemberService mJoinService = new MemberService();
        int result = mJoinService.registerMember(member);
        if(result > 0){
            response.sendRedirect("/WEB-INF/index_1.jsp");
        }
    }
}
