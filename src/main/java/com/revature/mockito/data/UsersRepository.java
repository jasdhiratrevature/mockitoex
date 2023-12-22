package com.revature.mockito.data;

import com.revature.mockito.model.User;

public interface UsersRepository {
    boolean save(User user);
}
