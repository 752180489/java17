package com.turing.sb.mapper;

import com.turing.sb.entity.Emp;
import com.turing.sb.entity.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
    //分页查询
    @Select("select * from emp limit #{arg0},#{arg1}")
    List<Emp> selectByPage(int pageNum,int pageSize);

    //查询总条数
    @Select("select count(*) from emp")
    int selectCount();

    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}