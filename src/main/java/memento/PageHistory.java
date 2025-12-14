package memento;

import chain.PageContext;

import java.util.Stack;

public class PageHistory {
    private final Stack<PageContext.Memento> history = new Stack<>();

    public void save(PageContext.Memento m) {
        history.push(m);
    }

    public PageContext.Memento undo() {
        return history.isEmpty() ? null : history.pop();
    }

    public void printHistory() {
        System.out.println("\n=== Історія HTML ===");
        int step = 1;
        for (PageContext.Memento m : history) {
            System.out.println("Крок " + step + ": " + m.getHtmlContent());
            step++;
        }
    }
}
