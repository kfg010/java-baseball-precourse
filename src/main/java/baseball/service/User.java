package baseball.service;

import baseball.component.PublicComponent;
import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashSet;
import java.util.Set;

public class User {

    private final int USER_MAX_VALUE = 3;

    private int[] userInputNumber = new int[USER_MAX_VALUE];
    private Set<Integer> userNumberSet = new LinkedHashSet<Integer>();

    private PublicComponent publicComponent;

    public User(PublicComponent publicComponent) {
        this.publicComponent = publicComponent;
    }

    public String[] createUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String[] userInputValue = new String[USER_MAX_VALUE];
        String inputValue = Console.readLine();
        userInputValue = inputValue.split("");
        return userInputValue;
    }

    public int[] getInputNumber() throws IllegalArgumentException {
        userNumberSet.clear();
        String[] userNumber = createUserNumber();
        for (String str : userNumber) {
            userNumberSet.add(Integer.parseInt(str));
        }
        return publicComponent.generateNumber(userNumberSet);
    }
}
