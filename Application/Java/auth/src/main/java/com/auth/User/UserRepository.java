package com.auth.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value="DELETE FROM users WHERE email = ?1",nativeQuery = true)
    void deleteByEmail(@Param("email") String email );


    @Query(value="SELECT * FROM users WHERE email=?1",nativeQuery = true)
    User findByEmail(@Param("email") String email);
}