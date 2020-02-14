package teste.example.login.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import teste.example.login.exceptions.InvalidDocumentTemplateException;
import teste.example.login.models.DocumentTemplateRequest;

@Aspect
@Component
public class ComponentValidationAspect {

    @Before("@annotation(teste.example.login.aspects.annotations.ComponentValidationAdvice) && args(@RequestBody documentTemplateRequest)")
    public void tokenValidation(JoinPoint joinPoint, DocumentTemplateRequest documentTemplateRequest) {
        try {
            new ObjectMapper().treeToValue(documentTemplateRequest.getTreeNode(), Component.class);
        } catch (JsonProcessingException e) {
            throw new InvalidDocumentTemplateException("Invalid tree object! "+e);
        }
    }

}