package baseball.controller;

import baseball.component.PublicComponent;
import baseball.service.Computer;
import baseball.service.GameService;
import baseball.service.User;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private Computer computer;
    private User user;
    private GameService gameService;
    private PublicComponent publicComponent;

    private boolean gameResult = true;

    public GameController() {
        this.publicComponent = new PublicComponent();
        this.computer = new Computer(this.publicComponent);
        this.user = new User(this.publicComponent);
        this.gameService = new GameService();
    }

    public void gameStart() throws IllegalArgumentException {
        computer.initialize();
        int[] computerRandomNumber = computer.getComputerRandomNumber();
        while (!gameService.playGame(user.getInputNumber(), computerRandomNumber)) ;
        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        if ("1".equals(Console.readLine())) {
            gameStart();
        }
        System.out.println("게임 종료");
    }

}