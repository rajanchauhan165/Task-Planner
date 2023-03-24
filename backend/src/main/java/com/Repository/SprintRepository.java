package com.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entities.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer>{

}
