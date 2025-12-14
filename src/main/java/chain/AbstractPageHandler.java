package chain;

import memento.PageHistory;

public abstract class AbstractPageHandler implements PageHandler {

    protected PageHandler nextHandler;
    protected PageHistory history;

    protected AbstractPageHandler(PageHistory history) {
        this.history = history;
    }

    public AbstractPageHandler setNext(PageHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this;
    }

    protected void saveState(PageContext context) {
        history.save(context.save());
    }

    protected void handleNext(PageContext context) {
        if (nextHandler != null) {
            nextHandler.handle(context);
        }
    }
}
