package teste.example.login.strategies.outputs;

import teste.example.login.strategies.StrategyConfig;
import teste.example.login.strategies.outputs.strategies.*;

public enum CompositionStrategyConfig
    implements StrategyConfig<CompositionStrategy> 
{
    console(new ConsoleCompositionStrategy())
    , pdf(new PDFCompositionStrategy())
    , text(new TextCompositionStrategy())
    , defaultComposition(DefaultCompositionStrategy.getInstance());

    CompositionStrategy strategy;

    CompositionStrategyConfig(
        CompositionStrategy strategy
    ) {
        this.strategy = strategy;
    }

    public CompositionStrategy getStrategy() {
        return this.strategy;
    }

}