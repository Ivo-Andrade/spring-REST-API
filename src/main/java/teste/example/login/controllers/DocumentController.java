package teste.example.login.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import teste.example.login.models.Document;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @PostMapping("")
    public Boolean buildDocument(@RequestBody @Valid Document document) {
        document.getTree().traverse(document.getTree());
        return true;
    }

}