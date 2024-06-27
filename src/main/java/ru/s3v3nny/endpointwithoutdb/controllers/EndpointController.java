package ru.s3v3nny.endpointwithoutdb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.s3v3nny.endpointwithoutdb.dto.Response;
import ru.s3v3nny.endpointwithoutdb.services.EndpointService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EndpointController {
    private final EndpointService service;

    @GetMapping("/check-status")
    public ResponseEntity checkServicesStatus () {
        Response response = service.checkServicesStatus();
        return ResponseEntity.ok().body(response);
    }
}
