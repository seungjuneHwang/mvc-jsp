package com.google.mvc.dao;

import com.google.mvc.dto.TbFoodDto;

public interface TbFoodDao {
    public void save();
    public TbFoodDto findRandOne();
    public void update();
}
