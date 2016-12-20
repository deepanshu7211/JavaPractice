package lmbk;

import lombok.Getter;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */

@Getter
public class Triple<X, Y, Z> {
    private final X first;
    private final Y second;
    private final Z third;

    public Triple(X first, Y second, Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
