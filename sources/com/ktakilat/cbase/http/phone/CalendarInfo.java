package com.ktakilat.cbase.http.phone;

import java.io.Serializable;

public class CalendarInfo implements Serializable {
    private static final long serialVersionUID = -1882087219320281789L;
    public String calendar_id;
    public String description;
    public String dtend;
    public String dtstart;
    public String eventTimezone;
    public String hasAlarm;
    public String title;
}
