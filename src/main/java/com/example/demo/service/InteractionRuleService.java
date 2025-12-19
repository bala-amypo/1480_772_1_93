package com.example.demo.service;

import java.util.List;
import com.example.demo.model.InteractionRuleModel;

public interface InteractionRuleService {

    InteractionRuleModel saveRule(InteractionRuleModel rule);

    List<InteractionRuleModel> getAllRules();

    InteractionRuleModel checkInteraction(String medA, String medB);
}
