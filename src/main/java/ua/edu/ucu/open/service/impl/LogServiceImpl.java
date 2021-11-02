package ua.edu.ucu.open.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.ucu.open.repo.LogRepository;
import ua.edu.ucu.open.service.LogService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Override
    public List<String> getAll() {
        return logRepository.getAll();
    }

    @Override
    public void add(String log) {
        logRepository.add(log);
    }
}
