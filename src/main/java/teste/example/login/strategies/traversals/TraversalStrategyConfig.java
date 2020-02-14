package teste.example.login.strategies.traversals;

import teste.example.login.strategies.StrategyConfig;
import teste.example.login.strategies.traversals.strategies.*;

public enum TraversalStrategyConfig
    implements StrategyConfig<TraversalStrategy> 
{
    compose(new ComposeTraversalStrategy())
    , conditionalCompose(new ConditionalComposeTraversalStrategy())
    , optionalCompose(new OptionalComposeTraversalStrategy())
    , defaultTraversal(DefaultTraversalStrategy.getInstance());

    TraversalStrategy strategy;

    TraversalStrategyConfig(TraversalStrategy strategy) {
        this.strategy = strategy;
    }

    public TraversalStrategy getStrategy() {
        return this.strategy;
    }

}