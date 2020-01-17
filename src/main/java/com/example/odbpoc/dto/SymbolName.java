package com.example.odbpoc.dto;

import java.util.Map;

public class SymbolName {
   private String type;
   private Map<String,Long> params;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Long> getParams() {
        return params;
    }

    public void setParams(Map<String, Long> params) {
        this.params = params;
    }
}
