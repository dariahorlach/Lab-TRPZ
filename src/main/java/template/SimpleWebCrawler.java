package template;

import chain.*;
import p2p.PeerNode;
import proxy.PageFetcherProxy;

import java.util.Collections;
import java.util.List;

public class SimpleWebCrawler extends AbstractCrawler {

    private final PageFetcherProxy proxy;
    private final PageHandler htmlProcessor;
    private final PeerNode peer;

    public SimpleWebCrawler(PageFetcherProxy proxy, PageHandler htmlProcessor, PeerNode peer)  {
        this.proxy = proxy;
        this.htmlProcessor = htmlProcessor;
        this.peer = peer;
    }

    @Override
    protected String fetchPage(String url) {
        proxy.fetchPage(url);
        return proxy.getPageContent(url);
    }


    @Override
    protected String processHtml(String html) {
        PageContext context = new PageContext(html, "example");
        htmlProcessor.handle(context);
        return context.getHtmlContent();
    }


    @Override
    protected void saveHtml(String url, String html) {
        System.out.println("[" + peer.getId() + "] зберігає HTML");
        peer.sendHtml(url, html);
    }

    @Override
    protected void collectStats(String url) {
        System.out.println("[" + peer.getId() + "] статистика для " + url);
    }

    @Override
    protected List<String> extractLinks(String html) {
        return Collections.emptyList();
    }
}
