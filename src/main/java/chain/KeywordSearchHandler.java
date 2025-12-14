package chain;

import memento.PageHistory;

public class KeywordSearchHandler extends AbstractPageHandler {
    public KeywordSearchHandler(PageHistory history) {
        super(history);
    }

    @Override
    public void handle(PageContext context) {
        saveState(context);

        System.out.println("Пошук ключового слова: " + context.getKeyword());
        if (context.getHtmlContent().contains(context.getKeyword())) {
            System.out.println("Ключове слово знайдено!");
        } else {
            System.out.println("Ключове слово не знайдено");
        }

        handleNext(context);
    }
}
