package edu.ait.lawyer.Service.IMPL;

import edu.ait.lawyer.Repository.UserRepository;
import edu.ait.lawyer.Service.UserService;
import edu.ait.lawyer.dao.User;
import edu.ait.lawyer.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modalMapper;

    @Override
    public boolean RegisterUser(User user) {
        UserEntity userEntity = modalMapper.map(user, UserEntity.class);
        return userRepository.save(userEntity) == userEntity;
    }

    @Override
    public int loginUser(String userEmail, String userPassword) {
        if (userRepository.existsByEmail(userEmail) &&
                userRepository.findByEmail(userEmail).getPassword().equals(userPassword)) {

            return userRepository.findByEmail(userEmail).getId();
        }
        return -1;
    }

    @Override
    public User getUser(int id) {
        return modalMapper.map(userRepository.findById(String.valueOf(id)).get(), User.class);
    }
}
