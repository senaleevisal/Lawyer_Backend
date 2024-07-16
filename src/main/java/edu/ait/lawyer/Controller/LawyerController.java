package edu.ait.lawyer.Controller;

import edu.ait.lawyer.Service.LawyerService;
import edu.ait.lawyer.dao.Lawyer;
import edu.ait.lawyer.dto.ResponseBody.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Lawyer")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    @PostMapping()
    public ResponseBody addLawyer(@RequestBody Lawyer lawyer) {
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
}
