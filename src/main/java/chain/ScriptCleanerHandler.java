package chain;

public class ScriptCleanerHandler extends AbstractPageHandler {

    @Override
    public void handle(PageContext context) {
        System.out.println("Видаляємо <script> теги");
        context.setHtmlContent(
                context.getHtmlContent().replaceAll("<script.*?</script>", "")
        );
        handleNext(context);
    }
}
