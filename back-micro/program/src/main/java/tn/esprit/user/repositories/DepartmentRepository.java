package tn.esprit.user.repositories;

import tn.esprit.user.entities.schedule.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DepartmentRepository extends MongoRepository<Department, String> {
    List<Department> findByName(String name);

}
