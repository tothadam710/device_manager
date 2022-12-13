package computers.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
A Json allomany beolvasasaert felelos segedosztaly
 */

public final class Repository<T> {

    private static  final ObjectMapper obj = new ObjectMapper().registerModule(new JavaTimeModule());

    private final List<T> egyedek;

    /*
    A Json fajl beolvasasat biztosito Try-ctach block mely elkapja az esetleges kiveteleket
     */
    public Repository(@NonNull final Class<T> osztaly,@NonNull final String fajl){

        try {
            final var type = obj.getTypeFactory().constructCollectionType(List.class, osztaly);
            this.egyedek = obj.readValue(getClass().getClassLoader().getResourceAsStream(fajl), type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError("Nem sikerult beolvasni a " + fajl + " fajlt", e);
        }


    }
//Ennek a segitsegevel visszaadhato az osszes egyed
    public List<T> receive() {

        return new ArrayList<>(this.egyedek);
    }

}
