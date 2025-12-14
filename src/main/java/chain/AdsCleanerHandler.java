package chain;

import memento.PageHistory;

public class AdsCleanerHandler extends AbstractPageHandler {

    public AdsCleanerHandler(PageHistory history) {
        super(history);
    }

    @Override
    public void handle(PageContext context) {
        saveState(context);

        System.out.println("Видаляємо рекламні блоки");
        context.setHtmlContent(
                context.getHtmlContent().replaceAll("<div class=\"ads\">.*?</div>", "")
        );

        handleNext(context);
    }
}
