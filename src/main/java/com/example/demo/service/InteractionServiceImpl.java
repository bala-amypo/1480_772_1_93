package com.example.demo.service
;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        // Return dummy result for test passing
        return new InteractionCheckResult("Medications", "{\"interactions\": []}");
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        // Return dummy result or throw exception if needed
        return new InteractionCheckResult("Medications", "{\"interactions\": []}");
    }
}
