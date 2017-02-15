/**
 * Created by YE on 2016/12/19.
 */


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebSpiderVerOne {

    private String url;
    private List<DataModel> dataModelList = new ArrayList<DataModel>();
    // private Set<String> urlSet = new HashSet<String>();
    private Connection connection = null;
    private Elements links = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<DataModel> getDataModelList() {
        return dataModelList;
    }

    public void setDataModelList(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    public Elements getLinks() {
        return links;
    }

    public void CaputerData() throws IOException {
        try {
            connection = Jsoup.connect(url);
            Document document = connection.get();
             Elements lis = document.getElementsByTag("tr");
            for (int i = 0; lis != null && i < lis.size(); i++) {
                Element li = lis.get(i);
                Elements spans = li.getElementsByTag("td");
                if (spans != null && spans.size() == 6) {
                    DataModel dataModel = new DataModel();
                    dataModel.setJobID(spans.get(0).text());
                    dataModel.setDescription(spans.get(1).text());
                    dataModel.setDuration(spans.get(3).text());
                    Element lii = spans.get(1);
                    Elements spanss = lii.getElementsByTag("a");
                    dataModel.setStageUrl(spanss.attr("abs:href"));
                    dataModelList.add(dataModel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
