package com.example.RemitlyTask.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record Statement(
        @NotBlank(message = "Sid must not be blank") String sid,
        @NotBlank(message = "Effect must not be blank") String effect,
        @NotEmpty(message = "Action must not be blank") List<String> action,
        String resource) {}
