package edu.ait.lawyer.Repository;

import edu.ait.lawyer.dto.LawyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface LawyerRepository extends JpaRepository<LawyerEntity,String> {
    boolean existsByEmail(String email);
    LawyerEntity findByEmail(String email);
    LawyerEntity findById(int id);
}