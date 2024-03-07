package arrays;

import interfaces.IArrayBase;

public abstract class ArrayBase implements IArrayBase {
    protected abstract void fillArrayFromUserInput();

    protected abstract void fillArrayWithRandomValues();
}