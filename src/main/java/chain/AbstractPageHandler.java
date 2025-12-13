package chain;

public abstract class AbstractPageHandler implements PageHandler {

    protected PageHandler nextHandler;

    public AbstractPageHandler setNext(PageHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this;
    }

    protected void handleNext(PageContext context) {
        if (nextHandler != null) {
            nextHandler.handle(context);
        }
    }
}
