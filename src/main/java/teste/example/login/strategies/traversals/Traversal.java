package teste.example.login.strategies.traversals;

import com.fasterxml.jackson.databind.JsonNode;

import teste.example.login.models.Component;

public interface Traversal {
    
    public abstract void traverse(
        Component node
        , JsonNode inputContext
    );

}