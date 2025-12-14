package memento;

import chain.PageContext;

import java.util.Stack;

public class PageHistory {
    private final Stack<PageContext.Memento> history = new Stack<>();

    public void save(PageContext.Memento m) {
        history.push(m);
    }

    public PageContext.Memento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
