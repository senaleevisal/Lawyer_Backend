package edu.ait.lawyer.Service.IMPL;

import edu.ait.lawyer.Repository.LawyerRepository;
import edu.ait.lawyer.Service.LawyerService;
import edu.ait.lawyer.dto.LawyerEntity;
import edu.ait.lawyer.dao.Lawyer;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LawyerServiceIMPL implements LawyerService {
    @Autowired
    LawyerRepository lawyerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean addLawyer(Lawyer lawyer) {
        lawyerRepository.save(modelMapper.map(lawyer, LawyerEntity.class));
        return true;
    }
}
