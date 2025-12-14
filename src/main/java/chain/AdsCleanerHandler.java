package chain;

import composite.HtmlLeaf;
import memento.PageHistory;

public class AdsCleanerHandler extends AbstractPageHandler {
    public AdsCleanerHandler(PageHistory history) {
        super(history);
    }

    @Override
    public void handle(PageContext context) {
        saveState(context);

        System.out.println("Видаляємо рекламні блоки");
        String html = context.getHtmlContent();
        html = html.replaceAll("<div class=\"ads\">.*?</div>", "");
        context.setHtmlStructure(new HtmlLeaf(html));

        handleNext(context);
    }
}
