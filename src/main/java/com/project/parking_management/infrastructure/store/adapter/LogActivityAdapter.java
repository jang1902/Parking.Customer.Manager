package com.project.parking_management.infrastructure.store.adapter;

import com.project.parking_management.core.domain.entity.LogActivity;
import com.project.parking_management.core.port.store.LogActivityStore;
import com.project.parking_management.infrastructure.store.repository.LogActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogActivityAdapter extends BaseJPAAdapter<LogActivity, Long, LogActivityRepository> implements LogActivityStore {

    @Override
    public List<LogActivity> findByVehicleId(Long vehicleId) {
        return this.repository.findByVehicleId(vehicleId);
    }

    @Override
    public void saveLog(LogActivity logActivity) {
        this.save(logActivity);
    }
}
