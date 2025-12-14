package chain;

import memento.PageHistory;

public class ScriptCleanerHandler extends AbstractPageHandler {

    private final PageHistory history;

    public ScriptCleanerHandler(PageHistory history) {
        this.history = history;
    }

    @Override
    public void handle(PageContext context) {
        history.save(context.save());

        System.out.println("Видаляємо <script> теги");
        context.setHtmlContent(
                context.getHtmlContent().replaceAll("<script.*?</script>", "")
        );

        handleNext(context);
    }
}
