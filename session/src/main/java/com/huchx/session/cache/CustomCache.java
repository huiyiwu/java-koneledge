package com.huchx.session.cache;

public class CustomCache {
    public CustomCache() {
    }

    private String key;
    private Object value;
    private Long timeOut;

    public CustomCache(String key, Object value, Long timeOut) {
        this.key = key;
        this.value = value;
        this.timeOut = timeOut;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }
}
