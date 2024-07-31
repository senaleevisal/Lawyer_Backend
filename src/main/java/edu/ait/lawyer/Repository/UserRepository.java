package edu.ait.lawyer.Repository;

import edu.ait.lawyer.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
