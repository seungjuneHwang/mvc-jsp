package com.google.mvc.dao;

import com.google.mvc.dto.TbFoodDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TbFoodDaoImpl implements TbFoodDao{
        @Override
    public int save(TbFoodDto dto) {
        int result = 0;  // 저장 성공 or 실패
        PreparedStatement pstmt = null;
        Connection conn = DB.conn();
        try {
            String sql = "INSERT INTO `tb_food` (`name`, `img`) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getImg());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
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
        return result;
    }

    @Override
    public TbFoodDto findRandOne() {
        TbFoodDto dto = new TbFoodDto();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = DB.conn();
        try {
            String sql = "SELECT * FROM tb_food ORDER BY RAND() LIMIT 1";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
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

    @Override
    public void update() {

    }

    @Override
    public List<TbFoodDto> findAll() {
        List<TbFoodDto> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = DB.conn();
        try {
            String sql = "SELECT * FROM tb_food";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TbFoodDto dto = new TbFoodDto();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
                list.add(dto);
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
        return list;
    }
}
