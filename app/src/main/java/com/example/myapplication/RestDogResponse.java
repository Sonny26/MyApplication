package com.example.myapplication;

import java.util.List;


public class RestDogResponse {

    private Integer count;
    private String next;
    private String previous;
    private List<Dog> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
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

    public List<Dog> getResults() {
        return results;
    }

    public void setResults(List<Dog> results) {
        this.results = results;
    }
}
