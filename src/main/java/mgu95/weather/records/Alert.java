package mgu95.weather.records;

import java.time.LocalDateTime;

public record Alert(String headline,
                    String msgType,
                    String severity,
                    String urgency,
                    String areas,
                    String category,
                    String certainty,
                    String event,
                    String note,
                    LocalDateTime startEvent,
                    LocalDateTime endEvent,
                    String description,
                    String instruction) {

}
