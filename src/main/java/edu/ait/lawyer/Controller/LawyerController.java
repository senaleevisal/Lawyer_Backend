package edu.ait.lawyer.Controller;

import edu.ait.lawyer.Service.LawyerService;
import edu.ait.lawyer.dao.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Lawyer")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    @PostMapping()
    public boolean addLawyer(@RequestBody Lawyer lawyer) {
        return lawyerService.addLawyer(lawyer);
    }
}
