package com.project.parking_management.infrastructure.store.repository;

import com.project.parking_management.core.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}