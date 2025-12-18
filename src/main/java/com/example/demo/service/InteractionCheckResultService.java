package com.example.demo.service;

import java.util.List;
import com.example.demo.model.InteractionCheckResultModel;

public interface InteractionCheckResultService {

    InteractionCheckResultModel saveResult(
            InteractionCheckResultModel result);

    List<InteractionCheckResultModel> getAllResults();

    InteractionCheckResultModel getResultById(Long id);
}
