package computers.model;

import lombok.*;

/*
Network interface-eket megvalósító osztály.
Az egyedi kulcs itt a mac cím hiszen annak egyedinek kéne lennie.
Tartalmaz még egy interface nevetet
illetve adatatviteli sebességet MB-ban mérve

Lombok annotációkkal ellátva
 */

@Builder
@Value
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true )

public class NIC {

    @EqualsAndHashCode.Include
       String macaddress;

       String name;

       double datatransmission;






       // Kiiratás emészthetőbb formában
    @Override
    public String toString() {



        final StringBuilder sb = new StringBuilder();
        sb.append("\n")

        .append("\tName: "+name+"\n")
                .append("\tMac address: "+macaddress+"\n")
                .append("\tData transmission: "+datatransmission+" Mbps\n");

        return sb.toString();
    }
}
