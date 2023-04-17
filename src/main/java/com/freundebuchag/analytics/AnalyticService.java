package com.freundebuchag.analytics;

import com.freundebuchag.analytics.TopLongDino.TopLongDino;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Service
@Transactional
@RequiredArgsConstructor(access = PROTECTED)
public class AnalyticService {

    @NonNull
    private final AnalyticRepository analyticRepository;

    public List<TopLongDino> saveAll(List<TopLongDino> transientEntitiy) {
        return analyticRepository.saveAll(transientEntitiy);
    }
}
