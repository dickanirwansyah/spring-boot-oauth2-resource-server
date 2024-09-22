package com.oauth2.resource_server.controller;

import com.oauth2.resource_server.dto.RestApiData;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/resource")
public class ResourceServerController {

    @GetMapping(value = "/check-session-user")
    public ResponseEntity<RestApiData> checkSessionUser(Authentication authentication){
        return ResponseEntity.ok(new RestApiData("success",
                "Hallo user there ! "+authentication.getName()));
    }

    @GetMapping(value = "/check-session-admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<RestApiData> checkSessionAdmin(Authentication authentication){
        return ResponseEntity.ok(new RestApiData("success",
                "Hallo admin there ! "+authentication.getName()));
    }
}
