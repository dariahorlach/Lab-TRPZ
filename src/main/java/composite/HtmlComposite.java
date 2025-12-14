package composite;

import java.util.ArrayList;
import java.util.List;

public class HtmlComposite implements HtmlComponent {
    private final List<HtmlComponent> children = new ArrayList<>();
    private final String tagName;

    public HtmlComposite(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public void add(HtmlComponent component) {
        children.add(component);
    }

    @Override
    public void remove(HtmlComponent component) {
        children.remove(component);
    }

    @Override
    public List<HtmlComponent> getChildren() {
        return children;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName).append(">");
        for (HtmlComponent child : children) {
            sb.append(child.render());
        }
        sb.append("</").append(tagName).append(">");
        return sb.toString();
    }
}