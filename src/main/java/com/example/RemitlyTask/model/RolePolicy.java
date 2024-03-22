package com.example.RemitlyTask.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RolePolicy(
        @NotBlank(message = "PolicyName must not be blank") String policyName,
        @NotNull(message = "PolicyDocument must not be null") @Valid PolicyDocument policyDocument) {}
