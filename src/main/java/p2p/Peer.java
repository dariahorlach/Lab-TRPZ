package p2p;

public interface Peer {
    String getId();

    void connect(Peer peer);

    void sendHtml(String url, String html);

    void receiveHtml(String url, String html);
}
