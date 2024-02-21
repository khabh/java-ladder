package ladder.view;

import ladder.exception.InvalidHeightNumberException;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public String readParticipantsName() {
        System.out.println(REQUEST_PARTICIPANTS_NAME);
        return scanner.nextLine();
    }

    public int readLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
        final String input = scanner.nextLine();
        return convertToHeight(input);
    }

    private int convertToHeight(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidHeightNumberException();
        }
    }

    public void closeResource() {
        scanner.close();
    }
}