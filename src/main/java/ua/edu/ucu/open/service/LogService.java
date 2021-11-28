package ua.edu.ucu.open.service;

import java.util.List;

public interface LogService {

    List<String> getAll();
    void add(String log, int ordinal);
}
