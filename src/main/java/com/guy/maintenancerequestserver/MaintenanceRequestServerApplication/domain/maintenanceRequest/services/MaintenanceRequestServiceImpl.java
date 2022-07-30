package com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.maintenanceRequest.services;

import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.core.ResourceCreationException;
import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.core.ResourceNotFoundException;
import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.maintenanceRequest.models.MaintenanceRequest;
import com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {

    private MaintenanceRequestRepo maintenanceRequestRepo;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo){
        this.maintenanceRequestRepo = maintenanceRequestRepo;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Email already exist");
        return maintenanceRequestRepo.save(maintenanceRequest);
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Maintenance Request with id: " + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Request with email: " + email));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest requestDetail) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(requestDetail.getFirstName());
        maintenanceRequest.setLastName(requestDetail.getLastName());
        maintenanceRequest.setEmail(requestDetail.getEmail());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequestRepo.delete(maintenanceRequest);
    }
}
