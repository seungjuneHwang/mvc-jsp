package com.google.mvc.service;

import com.google.mvc.dao.TbFoodDao;
import com.google.mvc.dao.TbFoodDaoImpl;
import com.google.mvc.dto.TbFoodDto;
import com.google.mvc.utils.NaverApiSearch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("여기 안오나?");
        request.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");
        String json = NaverApiSearch.newApi(search);
//        System.out.println(json);
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
