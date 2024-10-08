package com.backpoc.util;

import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
@Data
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
    public LocalDateTime getLocalDateTime(String k){
        Object o = this.get(k);
        if (o == null) {
            return null;
        }
        return LocalDateTime.parse(o.toString());
    }

    public LocalTime getLocalTime(String k){
        Object o = this.get(k);
        if (o == null) {
            return null;
        }
        return LocalTime.parse(o.toString());
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
