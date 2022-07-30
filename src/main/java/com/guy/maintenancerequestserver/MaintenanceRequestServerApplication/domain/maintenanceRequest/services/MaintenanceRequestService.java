package com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.maintenanceRequest.services;

import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.core.ResourceCreationException;
import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.core.ResourceNotFoundException;
import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest requestDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
