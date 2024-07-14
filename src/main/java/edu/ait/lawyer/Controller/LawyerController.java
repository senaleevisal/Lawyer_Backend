package edu.ait.lawyer.Controller;

import edu.ait.lawyer.Service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/Lawyer")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

}
