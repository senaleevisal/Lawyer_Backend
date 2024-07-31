package edu.ait.lawyer.Service;


import edu.ait.lawyer.dao.Lawyer;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface LawyerService {
    boolean addLawyer(Lawyer lawyer);

    List<Lawyer> getAllLawyers(int page, int size);

    boolean loginLawyer(String lawyerEmail, String lawyerPassword);
}
