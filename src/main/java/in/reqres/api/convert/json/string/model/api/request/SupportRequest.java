package in.reqres.api.convert.json.string.model.api.request;

public class SupportRequest {

    private String url;
    private String text;

    public SupportRequest() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SupportRequest{");
        sb.append("url='").append(url).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
