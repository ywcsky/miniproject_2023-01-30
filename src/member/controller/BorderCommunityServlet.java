package member.controller;

import member.model.service.BorderService;
import member.model.vo.PageData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/border/community")
public class BorderCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryNum = 2;
        int currentPage = 1;

        if(request.getParameter("page")!=null){
            currentPage = Integer.parseInt(request.getParameter("page"));
        }
        BorderService bService = new BorderService();
        PageData pageData = bService.getBorderList(categoryNum, currentPage);
        request.setAttribute("bList",pageData.getbList());
        request.setAttribute("pageNavi",pageData.getPageNavigator());
        request.getRequestDispatcher("/WEB-INF/community.jsp").forward(request,response);
    }
}
