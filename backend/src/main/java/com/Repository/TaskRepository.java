package com.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entities.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
