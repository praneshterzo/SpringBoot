package com.example.Employee.Services;

import com.example.Employee.Models.User;

public interface UserServices {
    public void save(User users);

    public User getByUserId(int id);
}
