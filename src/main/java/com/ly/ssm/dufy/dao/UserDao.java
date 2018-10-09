package com.ly.ssm.dufy.dao;

import com.ly.ssm.dufy.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mfl
 */
@Repository
public interface UserDao {


    ////////////  注解方式  ////////////

    /**
     * 注册用户信息
     *
     * @param user
     * @return
     */
    @Insert("insert into my_t_user(id_, name_, age_, address_) values (#{id}, #{name}, #{age}, #{address})")
    int insertUserInfoAnnotation(User user);

    @Delete("delete from my_t_user where id_ = #{id}")
    int deleteUserById(String id);

    @Update("update my_t_user t set t.name_ = #{name} where t.id_ = #{id}")
    int updateUserById(User user);

//  该方式与下面@ResultMap注解作用是一样的
//    @Results({
//            @Result(property = "id", column = "id_", jdbcType = JdbcType.VARCHAR),
//            @Result(property = "name", column = "name_",jdbcType = JdbcType.VARCHAR),
//            @Result(property = "age", column = "age_",jdbcType = JdbcType.INTEGER),
//            @Result(property = "address", column = "address_",jdbcType = JdbcType.VARCHAR)
//    })


    @ResultMap("userResultMap")
    @Select("select * from my_t_user t where t.id_ = #{id}")
    User getUserById(String id);

    @ResultMap("userResultMap")
    @Select("select * from my_t_user")
    List<User> listUsers();

    @Delete("delete from my_t_user")
    int removeUser();








    ////////////  XML方式  ////////////

    /**
     * 添加用户信息（xml）
     * @param user
     * @return
     */
    int insertUserInfoXml(User user);

    int insertUserBatch(List<User> userList);



}
