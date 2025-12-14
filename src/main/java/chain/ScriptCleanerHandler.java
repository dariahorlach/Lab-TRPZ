package chain;

import memento.PageHistory;

public class ScriptCleanerHandler extends AbstractPageHandler {

    public ScriptCleanerHandler(PageHistory history) {
        super(history);
    }

    @Override
    public void handle(PageContext context) {
        saveState(context);

        System.out.println("Видаляємо <script> теги");
        context.setHtmlContent(
                context.getHtmlContent().replaceAll("<script.*?</script>", "")
        );

        handleNext(context);
    }
}
