package member.controller;

import member.model.service.BorderService;
import member.model.vo.Border;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/border")
public class BorderViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int borderNo = 0;
        if (Integer.parseInt(request.getParameter("no")) > 0) {
            borderNo = Integer.parseInt(request.getParameter("no"));
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        BorderService bService = new BorderService();
        Border border = bService.borderView(borderNo);
        request.setAttribute("border",border);
        request.getRequestDispatcher("/WEB-INF/view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
