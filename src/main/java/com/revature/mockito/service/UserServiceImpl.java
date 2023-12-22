package com.revature.mockito.service;


import com.revature.mockito.data.UsersRepository;
import com.revature.mockito.data.UsersRepositoryImpl;
import com.revature.mockito.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String repeatPassword) {

        if(firstName == null || firstName.trim().length() == 0) {
            throw new IllegalArgumentException("User's first name is empty");
        }

        if(lastName == null || lastName.trim().length() == 0) {
            throw new IllegalArgumentException("User's last name is empty");
        }

     //   return new User(firstName, lastName, email, UUID.randomUUID().toString());
        User user=new User(firstName, lastName, email, UUID.randomUUID().toString());
       // UsersRepository usersRepository=new UsersRepositoryImpl();
        boolean isUserCreated=usersRepository.save(user);
        if(!isUserCreated) throw new UserServiceException("Could not Create User");
        return user;
    }
}
