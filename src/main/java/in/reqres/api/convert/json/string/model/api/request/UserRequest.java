package in.reqres.api.convert.json.string.model.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserRequest {

    private Integer page;

    @JsonProperty(value = "per_page")
    private Integer perPage;

    private Integer total;

    @JsonProperty(value = "total_pages")
    private Integer totalPages;

    private List<DataRequest> data;

    private SupportRequest support;

    public UserRequest() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<DataRequest> getData() {
        return data;
    }

    public void setData(List<DataRequest> data) {
        this.data = data;
    }

    public SupportRequest getSupport() {
        return support;
    }

    public void setSupport(SupportRequest support) {
        this.support = support;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRequest{");
        sb.append("page=").append(page);
        sb.append(", perPage=").append(perPage);
        sb.append(", total=").append(total);
        sb.append(", totalPages=").append(totalPages);
        sb.append(", data=").append(data);
        sb.append(", support=").append(support);
        sb.append('}');
        return sb.toString();
    }
}
