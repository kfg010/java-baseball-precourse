package baseball.component;

import java.util.Iterator;
import java.util.Set;

public class PublicComponent {

    public int[] generateNumber(Set<Integer> inputValue) throws IllegalArgumentException {
        if (inputValue.size() != 3) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int[] resultValue = new int[3];
        Iterator<Integer> it = inputValue.iterator();
        while (it.hasNext()) {
            resultValue[i++] = it.next().intValue();
        }
        return resultValue;
    }
}
