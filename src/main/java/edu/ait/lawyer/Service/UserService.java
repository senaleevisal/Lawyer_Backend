package edu.ait.lawyer.Service;

import edu.ait.lawyer.dao.User;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {
    boolean RegisterUser(User user);

    int loginUser(String userEmail, String userPassword);

    User getUser(int id);
}
