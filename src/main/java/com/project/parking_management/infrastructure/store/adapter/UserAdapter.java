package com.project.parking_management.infrastructure.store.adapter;

import com.project.parking_management.core.domain.entity.User;
import com.project.parking_management.core.port.store.UserStore;
import com.project.parking_management.infrastructure.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAdapter extends BaseJPAAdapter <User, Long, UserRepository> implements UserStore {
}
