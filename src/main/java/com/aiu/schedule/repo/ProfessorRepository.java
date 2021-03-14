package com.aiu.schedule.repo;

import com.aiu.schedule.models.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
