package com.klef.fsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;  // <--- Add this import
import org.springframework.stereotype.Repository;

import com.klef.fsd.sdp.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

    @Query("SELECT m FROM Manager m WHERE TRIM(m.username) = TRIM(:username) AND TRIM(m.password) = TRIM(:password)")
    Manager login(@Param("username") String username, @Param("password") String password);

    @Query("select count(m) from Manager m")
    public long managercount();
}
