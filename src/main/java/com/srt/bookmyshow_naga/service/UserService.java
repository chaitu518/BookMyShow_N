package com.srt.bookmyshow_naga.service;



import com.srt.bookmyshow_naga.model.User;

import java.util.List;

public interface UserService {
    public User getUser(int id);
    public User createUser(User user);
    public List<User> getAllUsers();
}
