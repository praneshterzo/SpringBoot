package com.example.Employee.Repoistry;

import com.example.Employee.Models.Employee;
import com.example.Employee.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepoistry extends JpaRepository<User,Integer> {
    public User findById(int id);

}

