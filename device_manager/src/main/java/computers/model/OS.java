package computers.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/*
OS enum osztály a számítógép Windows buildjeinek lekezeléséhez
JsonProperty annotacio segitsegevel(konstans ertekek)
 */
public enum OS {

    @JsonProperty("19042") WINDOWS_10_20H2,

    @JsonProperty("19043") WINDOWS_10_21H1,

    @JsonProperty("17763") WINDOWS_10_1809,

    @JsonProperty("19041") WINDOWS_10_2004,
    @JsonProperty("18362") WINDOWS_10_1903,
    @JsonProperty("") UNKNOWN

}
