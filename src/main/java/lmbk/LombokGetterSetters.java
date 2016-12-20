package lmbk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */

@lombok.Getter
@lombok.Setter
@lombok.ToString(exclude = "stringList")
@lombok.RequiredArgsConstructor
@lombok.EqualsAndHashCode(of = {"number", "text"})
public class LombokGetterSetters {
    private final int number = 20;
    private final String text = "hello";
    private boolean flag;
    private List<String> stringList = new ArrayList<>();


}
