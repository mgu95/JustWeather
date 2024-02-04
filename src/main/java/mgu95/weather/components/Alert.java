package mgu95.weather.components;

import java.time.LocalDateTime;

public class Alert {

    private String headline;
    private String msgType;
    private String severity;
    private String urgency;
    private String areas;
    private String category;
    private String certainty;
    private String event;
    private String note;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private String description;
    private String instruction;

    public Alert(String headline, String msgType, String severity, String urgency, String areas, String category,
                 String certainty, String event, String note, LocalDateTime startEvent, LocalDateTime endEvent,
                 String description, String instruction) {
        this.headline = headline;
        this.msgType = msgType;
        this.severity = severity;
        this.urgency = urgency;
        this.areas = areas;
        this.category = category;
        this.certainty = certainty;
        this.event = event;
        this.note = note;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.description = description;
        this.instruction = instruction;
    }

    public String getHeadline() {
        return headline;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getAreas() {
        return areas;
    }

    public String getCategory() {
        return category;
    }

    public String getCertainty() {
        return certainty;
    }

    public String getEvent() {
        return event;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getStartEvent() {
        return startEvent;
    }

    public LocalDateTime getEndEvent() {
        return endEvent;
    }

    public String getDescription() {
        return description;
    }

    public String getInstruction() {
        return instruction;
    }
}
