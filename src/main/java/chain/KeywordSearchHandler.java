package chain;

public class KeywordSearchHandler extends AbstractPageHandler {

    @Override
    public void handle(PageContext context) {
        System.out.println("Пошук ключового слова: " + context.getKeyword());

        if (context.getHtmlContent().contains(context.getKeyword())) {
            System.out.println("Ключове слово знайдено!");
        } else {
            System.out.println("Ключове слово не знайдено");
        }

        handleNext(context);
    }
}
