package com.example.community.mapper;

import com.example.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);


    //需要将下划线与驼峰匹配
    //@Results(@Result(property = "modifierTime",column = "modifier time"))
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size")Integer size);


    @Select("select count(1) from question")
    Integer count();
}


