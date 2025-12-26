package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class InteractionRequest {
    private List<Long> medicationIds;
}