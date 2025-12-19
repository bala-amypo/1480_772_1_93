package com.example.demo.service;

import com.example.demo.model.InteractionRuleModel;
import java.util.List;

public interface InteractionRuleService {

    InteractionRuleModel addRule(InteractionRuleModel rule);

    List<InteractionRuleModel> getAllRules();

    InteractionRuleModel getRuleById(Long id);
}
