package member.controller;

import member.model.service.BorderService;
import member.model.vo.Border;
import member.model.vo.PageData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/index.jsp")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BorderService bService = new BorderService();
        HashMap<Integer,List<Border>> hashMap =  bService.getIndexBorderList();
//        for(int i = 1; i  < 5; i++){
//            request.setAttribute("bList_"+i,hashMap.get(i-1));
//        }
        request.setAttribute("bList_1", hashMap.get(1));
        request.setAttribute("bList_2", hashMap.get(2));
        request.setAttribute("bList_3", hashMap.get(3));
        request.setAttribute("bList_4", hashMap.get(4));
        request.getRequestDispatcher("/WEB-INF/index_1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
