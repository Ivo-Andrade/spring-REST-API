package teste.example.login.strategies.outputs.singletons;

import lombok.Data;

@Data
public class SingleComposition {

    private static SingleComposition instance = new SingleComposition();

    private String composition;

    private SingleComposition() {
        this.composition = "";
    }

    public static SingleComposition getInstance() {
        return instance;
    }

    public void resetComposition() {
        this.composition = "";
    }

    public void append( String append ) {
        composition = composition.concat(append);
    }

}