package com.fisher.repository.spittle;

import com.fisher.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by fisbii on 16-12-7.
 */
public interface SpittleRepository extends JpaRepository<Spittle,Long>, SpittleCompicatedOperation {
}
