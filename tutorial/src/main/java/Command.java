import java.util.List;

/** 사용자 입력을 처리하는 로직 */
public interface Command {
    /**
     * 명령어를 의미하는 String 토큰이 선택되어야 함
     * (e.g.: "deposit", "withdraw")
     */
    String key();

    /** 명령 단어 외 나머지를 처리, 무언가를 한다 */
    Status handleInput(List<String> input);

    enum Status {
        INVALID,
        HANDLED
    }
}