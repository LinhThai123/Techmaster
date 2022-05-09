package vn.techmaster.job_hunt.request;

import vn.techmaster.job_hunt.model.City;

public class SearchRequest  {
    private String keyword ;
    private City city ;

    public SearchRequest() {
    }

    public SearchRequest(String keyword, City city) {
        this.keyword = keyword;
        this.city = city;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
