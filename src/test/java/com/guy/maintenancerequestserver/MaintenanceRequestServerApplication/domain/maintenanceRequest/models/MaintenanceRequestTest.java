package com.guy.maintenancerequestserver.MaintenanceRequestServerApplication.domain.maintenanceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaintenanceRequestTest {
    @Test
    @DisplayName("Maintenance Request Lombok Constructor test")
    public void constructorTest01(){
        // Given
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest("Test","User","test@user.com","5B","Bottom Floor");
        maintenanceRequest.setId(1L);

        // When
        String expected = "1 Test User test@user.com 5B Bottom Floor";
        String actual = maintenanceRequest.toString();

        // Then
        Assertions.assertEquals(expected, actual);
    }
}
