package chain;

public class AdsCleanerHandler extends AbstractPageHandler {

    @Override
    public void handle(PageContext context) {
        System.out.println("Видаляємо рекламні блоки");
        context.setHtmlContent(
                context.getHtmlContent().replaceAll("<div class=\"ads\">.*?</div>", "")
        );
        handleNext(context);
    }
}
