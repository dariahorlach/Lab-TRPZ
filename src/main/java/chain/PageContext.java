package chain;

public class PageContext {
    private String htmlContent;
    private final String keyword;

    public PageContext(String htmlContent, String keyword) {
        this.htmlContent = htmlContent;
        this.keyword = keyword;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getKeyword() {
        return keyword;
    }

    public Memento save() {
        return new Memento(htmlContent);
    }

    public void restore(Memento memento) {
        this.htmlContent = memento.htmlContent;
    }

    public static class Memento {
        private final String htmlContent;

        private Memento(String htmlContent) {
            this.htmlContent = htmlContent;
        }
    }
}