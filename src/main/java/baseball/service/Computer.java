package baseball.service;

import baseball.component.PublicComponent;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private final int COMPUTER_MAX_VALUE = 3;
    private final int RANDOM_MIN_VALUE = 1;
    private final int RANDOM_MAX_VALUE = 9;

    private int[] computerRandomNumberArray = new int[COMPUTER_MAX_VALUE];
    private Set<Integer> randomNumberSet = new LinkedHashSet<Integer>();

    PublicComponent publicComponent;

    public Computer(PublicComponent publicComponent) {
        this.publicComponent = publicComponent;
    }

    public void initialize() {
        randomNumberSet.clear();
        computerRandomNumberArray = publicComponent.generateNumber(createRandomNumber());
    }

    private Set<Integer> createRandomNumber() {
        while (randomNumberSet.size() < COMPUTER_MAX_VALUE) {
            randomNumberSet.add(Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE));
        }
        return randomNumberSet;
    }

    public int[] getComputerRandomNumber() {
        return computerRandomNumberArray;
    }
}
