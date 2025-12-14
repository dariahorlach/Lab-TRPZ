import chain.*;
import p2p.PeerNode;
import proxy.*;
import memento.*;
import template.*;

public class WebCrawlerApp {
    public static void main(String[] args) {
        PeerNode peer1 = new PeerNode("Peer-1");
        PeerNode peer2 = new PeerNode("Peer-2");

        peer1.connect(peer2);
        peer2.connect(peer1);

        PageFetcher realFetcher = new HttpPageFetcher();
        PageFetcherProxy proxy = new PageFetcherProxy(realFetcher);

        PageHistory history = new PageHistory();

        ScriptCleanerHandler scriptHandler = new ScriptCleanerHandler(history);
        AdsCleanerHandler adsHandler = new AdsCleanerHandler(history);
        KeywordSearchHandler keywordHandler = new KeywordSearchHandler(history);

        scriptHandler.setNext(adsHandler);
            adsHandler.setNext(keywordHandler);

        SimpleWebCrawler crawler1 =
                new SimpleWebCrawler(proxy, scriptHandler, peer1);

        crawler1.crawl("https://example.com");

        history.printHistory();
    }
}