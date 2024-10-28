package ru.malykhnik.endpointwithoutdb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.malykhnik.endpointwithoutdb.dto.AuthData;
import ru.malykhnik.endpointwithoutdb.dto.Response;
import ru.malykhnik.endpointwithoutdb.services.EndpointService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EndpointController {
    private final EndpointService service;

    @GetMapping("/check-status")
    public ResponseEntity checkServiceStatus (@RequestHeader("token") String token) {
        Response response = service.checkServiceStatus(token);
        return response.getError() == null ? ResponseEntity.ok().body(response.getValue())
                : ResponseEntity.badRequest().body(response.getError());
    }

    @PostMapping("/get-token")
    public ResponseEntity getToken (@RequestBody AuthData authData) {
        Response response = service.getToken(authData);
        return response.getError() == null ? ResponseEntity.ok().body(response.getValue())
                : ResponseEntity.badRequest().body(response.getError());
    }
}
