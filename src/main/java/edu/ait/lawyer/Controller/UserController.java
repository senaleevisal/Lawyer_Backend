package edu.ait.lawyer.Controller;


import edu.ait.lawyer.Service.UserService;
import edu.ait.lawyer.dao.User;
import edu.ait.lawyer.dto.ResponseBody.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseBody RegisterUser(@RequestBody User user){
        ResponseBody response = new ResponseBody();
        if (userService.RegisterUser(user)){
            response.addResponse("status", "success");
            response.addResponse("message", "User registered successfully");
        }else {
            response.addResponse("status", "error");
            response.addResponse("error", "User not added");
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseBody loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        ResponseBody response = new ResponseBody();
        int userId = userService.loginUser(email, password);
        if (userId != -1) {
            response.addResponse("status", "success");
            response.addResponse("message", "User logged in successfully");
            response.addResponse("id", String.valueOf(userId));
        } else {
            response.addResponse("status", "error");
            response.addResponse("message", "User not found");
        }
        return response;
    }

    @GetMapping("/getbyid/{id}")
    public ResponseBody getUser(@PathVariable int id){
        ResponseBody response = new ResponseBody();
        User user = userService.getUser(id);
        if (user != null){
            response.addResponse("status", "success");
            response.addUser("user", user);
        }else {
            response.addResponse("status", "error");
            response.addResponse("error", "User not found");
        }
        return response;
    }


}
