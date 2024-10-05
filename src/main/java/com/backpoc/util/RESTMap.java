package com.backpoc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RESTMap extends HashMap {

    public <T> T get(String k) {
        Object o = super.get(k);
        if (o == null || "".equals(o) || "null".equals(o)) {
            return null;
        }

        return (T) o;
    }

    public Long getLong(String k) {
        Object o = this.get(k);
        if (o == null) {
            return null;
        }

        return Long.parseLong(o.toString());
    }

    public Integer getInteger(String k) {
        Object o = this.get(k);
        if (o == null) {
            return null;
        }
        return Integer.parseInt(o.toString());
    }

    public Date getDate(String k) {
        Object o = this.get(k);
        if (o == null) {
            return null;
        }
        String s = o.toString();

        String sample = "2019-01-03T23:00:00.000Z";
        if (s.length() == sample.length() && s.indexOf("T") == sample.indexOf("T")) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(s);
            } catch (ParseException e) {
            }
        }

        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(o.toString());
        } catch (ParseException e) {
        }

        Long millis = Long.parseLong(o.toString());
        return new Date(millis);
    }

    public Boolean getBoolean(String k) {
        Object o = this.get(k);
        if (o == null) {
            return null;
        }

        String s = o.toString();

        if ("true".equals(s) || "1".equals(s)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

}
