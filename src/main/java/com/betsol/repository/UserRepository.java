package com.betsol.repository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.betsol.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Long> {
    
    UserDao findByUsername(String username);

    @Transactional
    @Query(value = "select * from user where user.username = :username", nativeQuery = true)
    Long findUserId(@Param("username") String username);
}