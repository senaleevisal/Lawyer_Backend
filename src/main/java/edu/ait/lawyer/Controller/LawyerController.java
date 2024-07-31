package edu.ait.lawyer.Controller;

import edu.ait.lawyer.Service.LawyerService;
import edu.ait.lawyer.dao.Lawyer;
import edu.ait.lawyer.dto.ResponseBody.ResponseBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Lawyer")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    @PostMapping("/Register")
    public ResponseBody addLawyer(@Valid @RequestBody Lawyer lawyer) {
        if(lawyerService.addLawyer(lawyer)){
            ResponseBody responseBody = new ResponseBody();
            responseBody.addResponse("message", "Lawyer added successfully");
            return responseBody;
        }else{
            ResponseBody responseBody = new ResponseBody();
            responseBody.addResponse("error", "Lawyer not added");
            return responseBody;
        }
    }

    @GetMapping("/{page}/{size}")
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

    @PostMapping("/Login")
    public ResponseBody loginLawyer(@RequestParam String lawyer_email, @RequestParam String lawyer_password) {
        ResponseBody responseBody = new ResponseBody();
        if(lawyerService.loginLawyer(lawyer_email, lawyer_password)){
            responseBody.addResponse("message", "Lawyer logged in successfully");
        }else{
            responseBody.addResponse("error", "Invalid credentials");
        }
        return responseBody;
    }
}
