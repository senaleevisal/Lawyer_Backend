package edu.ait.lawyer.Service.IMPL;

import edu.ait.lawyer.Repository.UserRepository;
import edu.ait.lawyer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;



}
