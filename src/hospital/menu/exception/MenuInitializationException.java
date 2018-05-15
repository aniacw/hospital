package hospital.menu.exception;

public class MenuInitializationException extends RuntimeException {
    public MenuInitializationException() {
    }

    public MenuInitializationException(String message) {
        super(message);
    }
}
