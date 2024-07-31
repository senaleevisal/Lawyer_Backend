package edu.ait.lawyer.Controller;

import edu.ait.lawyer.Service.LawyerService;
import edu.ait.lawyer.dao.Lawyer;
import edu.ait.lawyer.dto.ResponseBody.ResponseBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/lawyer")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    @PostMapping("/register")
    public ResponseBody addLawyer(@Valid @RequestBody Lawyer lawyer) {
        if(lawyerService.addLawyer(lawyer)){
            ResponseBody responseBody = new ResponseBody();
            responseBody.addResponse("status", "success");
            responseBody.addResponse("message", "Lawyer added successfully");
            return responseBody;
        }else{
            ResponseBody responseBody = new ResponseBody();
            responseBody.addResponse("status", "error");
            responseBody.addResponse("error", "Lawyer not added");
            return responseBody;
        }
    }

    @GetMapping("/webpage/{page}/{size}")
    public ResponseBody getLawyers(@PathVariable int page, @PathVariable int size) {
        ResponseBody responseBody = new ResponseBody();
        List<Lawyer> lawyers = lawyerService.getAllLawyers(page, size);
        if(null != lawyers && !lawyers.isEmpty()) {
            responseBody.addResponse("message", "Lawyers fetched successfully");
            responseBody.addLawyers(lawyers);
        }else{
            responseBody.addResponse("error", "No Lawyers found");
        }

        return responseBody;
    }

    @PostMapping("/login")
    public ResponseBody loginLawyer(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        ResponseBody responseBody = new ResponseBody();
        int lawyerId = lawyerService.loginLawyer(email, password);
        if(-1 != lawyerId) {
            responseBody.addResponse("message", "Lawyer logged in successfully");
            responseBody.addResponse("id", String.valueOf(lawyerId));
        }else{
            responseBody.addResponse("error", "lawyer not found");
        }
        return responseBody;
    }

    @GetMapping("/getbyid/{id}")
    public ResponseBody getLawyer(@PathVariable int id) {
        ResponseBody responseBody = new ResponseBody();
        Lawyer lawyer = lawyerService.getLawyer(id);
        if(null != lawyer) {
            responseBody.addResponse("message", "Lawyer fetched successfully");
            responseBody.addLawyers(List.of(lawyer));
        }else{
            responseBody.addResponse("error", "Lawyer not found");
        }
        return responseBody;
    }
}
