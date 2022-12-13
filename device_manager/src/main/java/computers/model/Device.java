package computers.model;
import lombok.*;


import java.util.List;

/*
A Device osztály amely a számítógépeket reprezentálja
Lombok annotációkkal ellátva
 */

@Builder
@Value
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class Device {

    //egyedi azonosító
    @EqualsAndHashCode.Include
    String resourceid;

    //számítógépnév, Névkonvenció alapján: DESKTOP-<gyártási sorozatszám> (ez később kerül kozzáfűzésre)
    String netbiosname;

    //processzor órajel
    double cpuclockspeed;

    // A windows verziók(külön Enum)
    OS buildnumber;

    //Halozati interface adatok külön osztály
    List<NIC> networkinterface;



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();


    //Olvashatóbb kiiratás
        sb.append("\n")

      .append("ResourceID: "+resourceid+"\n")
              .append("NetBiosName: DESKTOP-"+netbiosname+"\n")
              .append("CpuClockSpeed: "+cpuclockspeed+" GHZ\n")
              .append("OS_Version: "+buildnumber+"\n")
              .append("\nNetwork_Interface(s): \n");

              for(NIC n : networkinterface){
                  sb.append(n);
              }



        return sb.toString();
    }
}
