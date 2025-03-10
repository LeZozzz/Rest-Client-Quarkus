package fr.univtln.lezozzz.samples.iss.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {

    @JsonProperty("iss_position")
    private ISSPosition issPosition;


    @JsonProperty
    private String message;

    public String getMessage() {
        return message;
    }

    @JsonProperty
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public ISSPosition getIssPosition() {
        return issPosition;
    }

    public static class ISSPosition {

        @JsonProperty
        private String latitude;

        @JsonProperty
        private String longitude;

        public String getLatitude() {
            return latitude;
        }

        public String getLongitude() {
            return longitude;
        }
    }
}
