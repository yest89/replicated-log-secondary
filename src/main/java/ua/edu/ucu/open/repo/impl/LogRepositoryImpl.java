package ua.edu.ucu.open.repo.impl;

import org.springframework.stereotype.Repository;
import ua.edu.ucu.open.repo.LogRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

@Repository
public class LogRepositoryImpl implements LogRepository {

    private final ConcurrentSkipListMap<Integer, String> storage = new ConcurrentSkipListMap<>();

    @Override
    public void add(String log, int ordinal) {
        storage.putIfAbsent(ordinal, log);
    }

    @Override
    public List<String> getAll() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, String> e : storage.entrySet()) {
            Map.Entry<Integer, String> next = storage.higherEntry(e.getKey()); // next
            if (next == null) {
                result.add(storage.get(e.getKey()));
                break;
            }
            if (e.getKey() + 1 == next.getKey()) {
                result.add(storage.get(e.getKey()));
            } else {
                break;
            }
        }
        return Collections.unmodifiableList(result);
    }
}
