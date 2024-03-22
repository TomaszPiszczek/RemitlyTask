package com.example.RemitlyTask.controller;

import com.example.RemitlyTask.model.RolePolicy;
import com.example.RemitlyTask.service.PoliceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PolicyController {
    PoliceService policeService;
    @PostMapping(value ="/verifyResources" , consumes={"application/json"})
    public ResponseEntity<Boolean> verifyResources(@Valid @RequestBody RolePolicy rolePolicy){
        return ResponseEntity.ok(policeService.verifyResources(rolePolicy));
    }
}
