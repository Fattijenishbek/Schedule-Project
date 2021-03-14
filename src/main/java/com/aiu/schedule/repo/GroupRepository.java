package com.aiu.schedule.repo;

import com.aiu.schedule.models.Groups;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Groups, Long> {
}
