package com.google.mvc.service;

import com.google.mvc.dao.TbFoodDao;
import com.google.mvc.dao.TbFoodDaoImpl;
import com.google.mvc.dao.TbUserDao;
import com.google.mvc.dao.TbUserDaoImpl;
import com.google.mvc.dto.TbFoodDto;
import com.google.mvc.dto.TbUserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginOkServlet", value = "/LoginOkServlet")
public class LoginOkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   // 한글 설정
        String email = request.getParameter("email");
        String userpw = request.getParameter("userpw");
        System.out.println(email);
        System.out.println(userpw);

        // TbUserDao 만들고 TbUserDto 만들고
        TbUserDao dao = new TbUserDaoImpl();
        // findEmailPw(email, userpw); 이런 메소드 만들면 될 것 같은데
        TbUserDto dto = dao.findEmailPw(email, userpw);
        // 유저 정보가 있는지 검색하는 디비 쿼리 만들어서
        // 아이디와 패스워드가 디비에 있으면 로그인 성공
        // 아니면 로그인 실패
        if (dto != null) {
            System.out.println("성공");
            HttpSession session = request.getSession();
            session.setAttribute("username", dto.getName());
            response.sendRedirect("main.gg");
        } else {
            System.out.println("실패");
            response.sendRedirect("login.gg");
        }



//        TbFoodDao dao = new TbFoodDaoImpl();
//        int result = dao.save(dto);
        // ajax에 result 정보 전달
        PrintWriter out = response.getWriter();
//        out.println(result);   // 0이면 실패, 1이면 성공

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
