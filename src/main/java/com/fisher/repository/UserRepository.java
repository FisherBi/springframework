package com.fisher.repository;

import com.fisher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fisbii on 16-11-28.
 */
public interface UserRepository extends JpaRepository<User,Long>{

    @Modifying // 说明该方法是修改操作
    @Transactional // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update User us set us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
    public void updateUser(@Param("qFirstName") String firstName,
                           @Param("qLastName") String qLastName,
                           @Param("qPassword") String password,
                           @Param("qId") Long id);
}
