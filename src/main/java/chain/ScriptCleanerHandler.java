package chain;

import composite.HtmlLeaf;
import memento.PageHistory;

public class ScriptCleanerHandler extends AbstractPageHandler {
    public ScriptCleanerHandler(PageHistory history) {
        super(history);
    }

    @Override
    public void handle(PageContext context) {
        saveState(context);

        System.out.println("Видаляємо <script> теги");
        String html = context.getHtmlContent();
        html = html.replaceAll("<script.*?</script>", "");
        context.setHtmlStructure(new HtmlLeaf(html));

        handleNext(context);
    }
}