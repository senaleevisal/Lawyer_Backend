package edu.ait.lawyer.Service.IMPL;

import edu.ait.lawyer.Repository.LawyerRepository;
import edu.ait.lawyer.Service.LawyerService;
import edu.ait.lawyer.dto.LawyerEntity;
import edu.ait.lawyer.dao.Lawyer;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LawyerServiceIMPL implements LawyerService {
    @Autowired
    LawyerRepository lawyerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean addLawyer(Lawyer lawyer) {
        LawyerEntity lawyerEntity = modelMapper.map(lawyer, LawyerEntity.class);
        lawyerEntity.setSpeciality(String.join(",", lawyer.getSpeciality()));
        return lawyerRepository.save(lawyerEntity) == lawyerEntity;
    }

    @Override
    public List<Lawyer> getAllLawyers(int page, int size) {
        Page<LawyerEntity> lawyerEntityPage = lawyerRepository.findAll(Pageable.ofSize(size).withPage(page));
        List<LawyerEntity> lawyerEntities = lawyerEntityPage.getContent();
        return lawyerEntities.stream()
                .map(entity -> {
                    Lawyer lawyer = modelMapper.map(entity, Lawyer.class);
                    lawyer.setSpeciality(entity.getSpeciality().split(",")); // Convert String to String[]
                    return lawyer;
                })
                .collect(Collectors.toList());
    }

    @Override
    public int loginLawyer(String lawyerEmail, String lawyerPassword) {
        if (lawyerRepository.existsByEmail(lawyerEmail) &&
                lawyerRepository.findByEmail(lawyerEmail).getPassword().equals(lawyerPassword)) {
            return lawyerRepository.findByEmail(lawyerEmail).getId();
        }
        return -1;
    }

    @Override
    public Lawyer getLawyer(int id) {
        LawyerEntity lawyerEntity = lawyerRepository.findById(id);
        if (null != lawyerEntity) {
            Lawyer lawyer = modelMapper.map(lawyerEntity, Lawyer.class);
            lawyer.setSpeciality(lawyerEntity.getSpeciality().split(","));
            return lawyer;
        }
        return null;
    }
}
