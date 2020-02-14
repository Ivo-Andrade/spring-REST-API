package teste.example.login.strategies.outputs;

import java.io.File;

import javax.validation.constraints.NotBlank;

import teste.example.login.strategies.Strategy;

public abstract class CompositionStrategy 
    implements Strategy
    , Composition
{
    public abstract File print( @NotBlank String documentName );
}