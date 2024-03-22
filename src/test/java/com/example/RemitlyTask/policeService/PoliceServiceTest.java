package com.example.RemitlyTask.policeService;

import com.example.RemitlyTask.model.PolicyDocument;
import com.example.RemitlyTask.model.RolePolicy;
import com.example.RemitlyTask.model.Statement;
import com.example.RemitlyTask.service.PoliceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class PoliceServiceTest {
    @Autowired
    PoliceService policeService;
    RolePolicy rolePolicyWithSingleAsterisk;
    RolePolicy rolePolicyWithoutSingleAsterisk;
    RolePolicy rolePolicyWithSingleAndDoubleAsterisk;


    @Test
    void verifyResources_ShouldReturnTrueWhenInputContainsNoSingleAsterisk(){
        Statement statement6 = new Statement(null,null,null,"");
        Statement statement13 = new Statement(null,null,null,"a");
        Statement statement7 = new Statement(null,null,null,"**");
        Statement statement12 = new Statement(null,null,null,"*a*");
        Statement statement8 = new Statement(null,null,null,"*a*a");
        Statement statement9 = new Statement(null,null,null,"a*a*");
        Statement statement10 = new Statement(null,null,null,"a**");
        Statement statement11 = new Statement(null,null,null,"**a");

        PolicyDocument policyDocument2 = new PolicyDocument(null, List.of(statement6,statement7,statement8,statement9,statement10,statement11,statement12,statement13));
        rolePolicyWithoutSingleAsterisk = new RolePolicy(null,policyDocument2);

        assertTrue(policeService.verifyResources(rolePolicyWithoutSingleAsterisk));
    }

    @Test
    void verifyResources_ShouldReturnFalseWhenInputContainsSingleAsterisk(){

        Statement statement1 = new Statement(null,null,null,"*");
        Statement statement2 = new Statement(null,null,null,"a*");
        Statement statement3 = new Statement(null,null,null,"*a");
        Statement statement4 = new Statement(null,null,null,"a*a");
        Statement statement5 = new Statement(null,null,null," * ");
        PolicyDocument policyDocument1 = new PolicyDocument(null, List.of(statement1));
        rolePolicyWithSingleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAsterisk));


         policyDocument1 = new PolicyDocument(null, List.of(statement1));
        rolePolicyWithSingleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAsterisk));

         policyDocument1 = new PolicyDocument(null, List.of(statement2));
        rolePolicyWithSingleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAsterisk));

         policyDocument1 = new PolicyDocument(null, List.of(statement3));
        rolePolicyWithSingleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAsterisk));

        policyDocument1 = new PolicyDocument(null, List.of(statement4));
        rolePolicyWithSingleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAsterisk));

        policyDocument1 = new PolicyDocument(null, List.of(statement5));
        rolePolicyWithSingleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAsterisk));
    }


    @Test
    void verifyResources_ShouldReturnFalseWhenInputContainsSingleAsteriskAndDoubleAsterisk() {
        Statement statement1 = new Statement(null,null,null,"*");
        Statement statement2 = new Statement(null,null,null,"**");

        PolicyDocument policyDocument1 = new PolicyDocument(null, List.of(statement1,statement2));
        rolePolicyWithSingleAndDoubleAsterisk = new RolePolicy(null,policyDocument1);
        assertFalse(policeService.verifyResources(rolePolicyWithSingleAndDoubleAsterisk));
    }



}

