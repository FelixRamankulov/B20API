package pojo;

import java.util.List;

public class PokeapiPojo {

    private int count;
    private String next;
    private String previous;

    private List<PokeapiResultsPojo> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokeapiResultsPojo> getResults() {
        return results;
    }

    public void setResults(List<PokeapiResultsPojo> results) {
        this.results = results;
    }
}
