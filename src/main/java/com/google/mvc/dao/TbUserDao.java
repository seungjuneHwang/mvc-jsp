package com.google.mvc.dao;

import com.google.mvc.dto.TbUserDto;

public interface TbUserDao {
    // 회원가입
    public void save();
    // 로그인 체크 ID PW가 있냐
    public TbUserDto findEmailPw(String email, String userpw);
}
