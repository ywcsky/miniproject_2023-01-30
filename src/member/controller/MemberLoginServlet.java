package member.controller;

import member.model.service.MemberService;
import member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("memberId");
        String memberPw = request.getParameter("memberPw");
        MemberService mService = new MemberService();
        Member member = mService.findOneById(memberId);
        if(memberPw.equals(member.getMemberPw())){
            HttpSession session = request.getSession();
            session.setAttribute("memberId",memberId);
            response.sendRedirect("/index.jsp");
        }else {
            response.sendRedirect("/WEB-INF/join.jsp");
        }

    }
}
