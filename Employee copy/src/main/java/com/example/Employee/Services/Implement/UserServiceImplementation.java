package com.example.Employee.Services.Implement;

import com.example.Employee.Models.User;
import com.example.Employee.Repoistry.Userrepoistry;
import com.example.Employee.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserServices {
    Userrepoistry userrepo;
    @Autowired
    public UserServiceImplementation(Userrepoistry userrepo){this.userrepo=userrepo;}
    @Override
    public void save(User user){userrepo.save(user);
    }

    @Override
    public User getByUserId(int id) {
        return userrepo.findById(id);
    }

}
