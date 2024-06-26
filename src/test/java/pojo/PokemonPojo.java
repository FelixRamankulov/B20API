package pojo;

import java.util.List;
import java.util.Map;

public class PokemonPojo {

    private int count;
    private String next;
    private String previous;
    private List<ResultsPojo> results;


    public List<ResultsPojo> getResults() {
        return results;
    }

    public void setResults(List<ResultsPojo> results) {
        this.results = results;
    }

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

}
