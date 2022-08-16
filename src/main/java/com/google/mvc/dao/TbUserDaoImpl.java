package com.google.mvc.dao;

import com.google.mvc.dto.TbFoodDto;
import com.google.mvc.dto.TbUserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TbUserDaoImpl implements TbUserDao {
    @Override
    public void save() {

    }

    @Override
    public TbUserDto findEmailPw(String email, String userpw) {
        TbUserDto dto = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = DB.conn();
        try {
            String sql = "SELECT * FROM tb_user WHERE email = ? AND userpw = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, userpw);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new TbUserDto();
                dto.setId(rs.getInt("id"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }
}
