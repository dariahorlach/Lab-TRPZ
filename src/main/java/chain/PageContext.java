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
}
