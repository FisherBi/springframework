package com.fisher.repository;

import com.fisher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fisbii on 16-11-28.
 */
public interface UserRepository extends JpaRepository<User,Long>{

}
