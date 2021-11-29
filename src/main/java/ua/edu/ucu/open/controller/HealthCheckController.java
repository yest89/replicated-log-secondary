package ua.edu.ucu.open.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ucu.open.model.HealthCheckStatus;

@Slf4j
@RestController
@RequestMapping("/api/v1/healthcheck")
@RequiredArgsConstructor
public class HealthCheckController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>(HealthCheckStatus.Healthy.toString(), HttpStatus.OK);
    }
}