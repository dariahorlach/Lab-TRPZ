package chain;

import memento.PageHistory;
import composite.*;

public class PageContext {
    private HtmlComponent htmlStructure;
    private final String keyword;

    public PageContext(String htmlContent, String keyword) {
        this.keyword = keyword;
        this.htmlStructure = new HtmlLeaf(htmlContent);
    }

    public HtmlComponent getHtmlStructure() {
        return htmlStructure;
    }

    public void setHtmlStructure(HtmlComponent htmlStructure) {
        this.htmlStructure = htmlStructure;
    }

    public String getHtmlContent() {
        return htmlStructure.render();
    }

    public String getKeyword() {
        return keyword;
    }

    public Memento save() {
        return new Memento(getHtmlContent());
    }

    public void restore(Memento memento) {
        this.htmlStructure = new HtmlLeaf(memento.getHtmlContent());
    }

    public static class Memento {
        private final String htmlContent;

        private Memento(String htmlContent) {
            this.htmlContent = htmlContent;
        }

        public String getHtmlContent() {
            return htmlContent;
        }
    }
}