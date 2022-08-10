package com.google.mvc.service;

import com.google.mvc.utils.NaverApiSearch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchServlet", value = "/SearchServlet2")
public class SearchServlet2 extends HttpServlet {
    private String search;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("여기 안오나?");
        String json = NaverApiSearch.newApi(search);
//        System.out.println(json);
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        search = request.getParameter("search");
        String json = NaverApiSearch.newApi(search);
//        System.out.println(json);
        response.sendRedirect("search.gg");
     }
}
