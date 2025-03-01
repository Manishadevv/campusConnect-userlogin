package com.example.demo.Repository;

import com.example.demo.Domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    @Query("SELECT l FROM Login l WHERE l.rollNo = :rollNo AND l.mobileNo = :mobileNo")
    Login findByRollNoAndMobileNo(@Param("rollNo") String rollNo, @Param("mobileNo") String mobileNo);
}

