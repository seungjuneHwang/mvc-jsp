package com.google.mvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", value = "*.gg")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("헬로 월드");
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("getRequestURI: " + uri);
        out.println("<br>");
        out.println("getRequestURL: " + url);
        String path = null;
        // 만약에 main.gg 가 들어오면 메인 페이지 화면
        if (uri.equals("/main.gg")) {
            //out.println("<br>메인페이지");
            path = "main.jsp";
        } else if (uri.equals("/movie.gg")) {
//            out.println("<br>영화 페이지");
            path = "movie.jsp";
        } else if (uri.equals("/search.gg")) {
//            out.println("<br>검색 페이지");
            path = "search.jsp";
        } else if (uri.equals("/foodrandom.gg")) {
//            out.println("<br>음식을 랜덤으로 골라주는 페이지");
            path = "/FoodRandomServlet";
        } else if (uri.equals("/login.gg")) {
//            out.println("<br>로그인 페이지");
            path = "login.jsp";
        } else if (uri.equals("/naver.gg")) {
            response.sendRedirect("https://www.naver.com");
        } else {
//            out.println("잘못 접근 페이지");
            path = "404.jsp";
        }
        // movie.gg 가 들어오면 영화정보
        // search.gg 가 들어오면 검색화면
        // foodrandom.gg 가 들어오면 음식을 랜덤으로 골라주는 페이지
        // login.gg 가 들어오면 로그인창
        // 회원가입 등등...
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
