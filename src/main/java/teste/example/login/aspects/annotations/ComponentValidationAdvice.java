package teste.example.login.aspects.annotations;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Component
public @interface ComponentValidationAdvice { }