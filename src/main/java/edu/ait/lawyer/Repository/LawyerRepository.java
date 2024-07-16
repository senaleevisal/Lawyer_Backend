package edu.ait.lawyer.Repository;

import edu.ait.lawyer.dto.LawyerEntity;
import org.springframework.data.repository.CrudRepository;


public interface LawyerRepository extends CrudRepository<LawyerEntity,String> {
}
