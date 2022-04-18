package baseball.service;

import baseball.constant.MessageTypes;
import org.apache.commons.lang3.ArrayUtils;

public class GameService {

    private int strikeCnt = 0;
    private int ballCnt = 0;

    public boolean playGame(int[] userInputNumber, int[] computerRandomNumber) {
        initialize();
        for (int i = 0; i < userInputNumber.length; i++) {
            checkCount(userInputNumber[i], i, computerRandomNumber);
        }
        System.out.println(getMsg());
        if (3 == strikeCnt) {
            System.out.println("3개의숫자를모두맞히셨습니다!게임끝");
            return true;
        }
        return false;
    }

    private void checkCount(int value, int order, int[] computerRandomNumber) {
        if (computerRandomNumber[order] == value) {
            strikeCnt++;
            return;
        }
        int index = ArrayUtils.indexOf(computerRandomNumber, value);
        if (index > -1) {
            ballCnt++;
        }
    }

    private String getMsg() {
        String msg = MessageTypes.getResultMessage(strikeCnt, ballCnt);
        if (msg.isEmpty()) {
            msg = MessageTypes.Nothing.getMessage();
        }
        return msg;
    }

    private void initialize() {
        strikeCnt = 0;
        ballCnt = 0;
    }

}