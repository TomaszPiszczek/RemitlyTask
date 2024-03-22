package com.example.RemitlyTask.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PolicyDocument(
        @NotBlank(message = "Version must not be blank") String version,
        @NotNull(message = "Statement must not be null") @Valid List<Statement> statement) {}
