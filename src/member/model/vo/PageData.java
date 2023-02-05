package member.model.vo;

import java.util.List;

public class PageData {
    private String pageNavigator;
    private List<Border> bList;

    public String getPageNavigator() {
        return pageNavigator;
    }

    public void setPageNavigator(String pageNavigator) {
        this.pageNavigator = pageNavigator;
    }

    public List<Border> getbList() {
        return bList;
    }

    public void setbList(List<Border> bList) {
        this.bList = bList;
    }

    public PageData(String pageNavigator, List<Border> bList) {
        this.pageNavigator = pageNavigator;
        this.bList = bList;
    }
}
