package com.aiu.schedule.repo;

import com.aiu.schedule.models.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
