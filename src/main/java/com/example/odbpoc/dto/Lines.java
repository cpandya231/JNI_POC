package com.example.odbpoc.dto;

public class Lines {
    private Long id;
    private Coordinates start;
    private Coordinates end;
    private Long symbolIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordinates getStart() {
        return start;
    }

    public void setStart(Coordinates start) {
        this.start = start;
    }

    public Coordinates getEnd() {
        return end;
    }

    public void setEnd(Coordinates end) {
        this.end = end;
    }

    public Long getSymbolIndex() {
        return symbolIndex;
    }

    public void setSymbolIndex(Long symbolIndex) {
        this.symbolIndex = symbolIndex;
    }
}
