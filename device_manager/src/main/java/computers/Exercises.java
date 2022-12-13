package computers;

import computers.model.Device;
import computers.model.NIC;
import computers.model.OS;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
A feladatokat megvalosito osztaly.
A metodusok csak definialasra kerulnek benne csak a fejreszuk van itt.
A Solution osztaly fogja vegezni az implementalasat ezeknek
 */

public interface Exercises {

    /*
    paraméterül megkap egy Device típusu listát és megkeresi benne
    a legkisebb processzor órajelet

     */
    double minimumClockSpeed(List<Device> devices);

    /*
    Visszatér azokanak a gépneveknek a listájával amelyekre illeszkedik a 2. paraméterként
    kapott BUILD
    Az első paraméter a DEVICE típusú lista
     */


    List<String> get_byOSBuild_build_devices(List<Device> devices, OS os);


    /*
    Viasszaadja egy szotarban A gepneveket es a hozzajuk tartozo OS buildet
    kulcs-ertek parokba
     */

    Map<String,String> DevicesWithOS(List<Device> devices);

    /*
    Megnezi melyik gepek CPU-nak kisebb az orajele mint a megadott orajel es azoknak
    kiszamolja az atlagat
     */

    double belowGHZAvarage(List<Device> device,double ghz);

    /*
    Eloszor berendezi a gepeket CPU orajel sebessege szerint. Ha 2 ugyan olyat talal akkor a ResourceID-jukat
     hasonlitja ossze(Ezek unique ertekek igy nem lehet 2 ugyan olyan)
     */

    List<Device> SortByClockSpeedThenResourceID(List<Device> devices);

    /*
    OS verzio altal csoportositva kiirja a resourceID-t es gepnevet kulcs-ertek parokba
     */

    Map<OS,Map<String,String>>GroupyByBuild(List<Device> devices);


    /*
    Visszaadja a gepeket resourceID alapjan leszurve az OS verziora
    Egy szotarral ter vissza ami tartlamaz egy Stringet illetve egy halmazt
     */

    public Map<String, Set<Device>> getDevicesByResourceID(List<Device> countries, OS os);



}
