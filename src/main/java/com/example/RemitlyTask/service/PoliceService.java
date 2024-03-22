package com.example.RemitlyTask.service;

import com.example.RemitlyTask.model.RolePolicy;
import com.example.RemitlyTask.model.Statement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceService {
    public Boolean verifyResources(RolePolicy rolePolicy) {
        List<Statement> statements = rolePolicy.policyDocument().statement();
        for (Statement statement: statements
             ) {
            if(inputContainsSingleAsterisk(statement.resource())){
                return false;
            }
        }
        return true;
    }

    private boolean inputContainsSingleAsterisk(String input){
        return input.chars().filter(ch -> ch == '*').count() == 1;
    }
}
