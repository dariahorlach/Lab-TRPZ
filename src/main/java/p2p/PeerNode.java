package p2p;

import java.util.HashMap;
import java.util.Map;

public class PeerNode implements Peer {

    private final String id;
    private final Map<String, String> sharedHtmlStorage = new HashMap<>();

    public PeerNode(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void connect(Peer peer) {
        System.out.println("[" + id + "] підключився до peer " + peer.getId());
    }

    @Override
    public void sendHtml(String url, String html) {
        System.out.println("[" + id + "] надсилає HTML для " + url + ": " + html);
        sharedHtmlStorage.put(url, html);
    }

    @Override
    public void receiveHtml(String url, String html) {
        System.out.println("[" + id + "] отримав HTML для " + url);
        sharedHtmlStorage.put(url, html);
    }

    public boolean hasPage(String url) {
        return sharedHtmlStorage.containsKey(url);
    }

    public String getPage(String url) {
        return sharedHtmlStorage.get(url);
    }
}
