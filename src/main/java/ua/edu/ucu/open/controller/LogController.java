package ua.edu.ucu.open.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ucu.open.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @RequestMapping(
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<String>> getLogs() {
        return new ResponseEntity<>(logService.getAll(), HttpStatus.OK);
    }
}
