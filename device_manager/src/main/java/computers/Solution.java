package computers;

import com.sun.tools.javac.Main;
import computers.common.Repository;
import computers.model.Device;
import computers.model.NIC;
import computers.model.OS;

import java.util.*;
import java.util.stream.Collectors;

//A megoldasokat megvalosito osztaly. Itt kerulnek implementalasra az Exercises interfaceben definialt metodusok
//Hogy mind a 2 paradigmabol legyen benne a Solution tartalmaz fukncionalis es nem funkcionalis megoldasokat is(De probaltam ramenni inkabb a streamekre)


/*
Sajnos az adatok terjedelme miatt eleg combos a kimenet.
De ha lista szeruen irattam volna ki meghosszabb lenne (hosszu stringek miatt PL Halozati kartya nevek)
 */

public class Solution implements Exercises {



    public  double minimumClockSpeed(List<Device> devices) {

        double min = devices.get(0).getCpuclockspeed();

        for(int i = 0;i<devices.size();i++){
            if(devices.get(i).getCpuclockspeed()<min){
                min = devices.get(i).getCpuclockspeed();
            }
        }
        return min;
    }

    public List<String> get_byOSBuild_build_devices(List<Device> devices, OS os){

        List<String> result = new ArrayList<>();

        for(int i = 0;i<devices.size();i++){
            if(devices.get(i).getBuildnumber().equals(os)){
                result.add("DESKTOP-"+devices.get(i).getNetbiosname());
            }
        }

        return result;

    }


    @Override
    public Map<String, String> DevicesWithOS(List<Device> devices) {
        Map<String,String> op = new HashMap<>();

        for(Device d : devices){

                    op.put(d.getNetbiosname(), d.getBuildnumber().name());

        }

        return op;
    }


    @Override
    public double belowGHZAvarage(List<Device> device, double ghz) {
        return device.stream().filter(device1 -> device1.getCpuclockspeed()<3).mapToDouble(Device::getCpuclockspeed).average().orElse(0);
    }

    @Override
    public List<Device> SortByClockSpeedThenResourceID(List<Device> devices) {
        return devices.stream().sorted(Comparator.comparing(Device::getCpuclockspeed).thenComparing(Device::getResourceid)).toList();
    }


    @Override
    public Map<OS, Map<String, String>> GroupyByBuild(List<Device> devices) {
        return devices.stream().collect(Collectors.groupingBy(Device::getBuildnumber, Collectors.toMap(Device::getResourceid, Device::getNetbiosname)));
    }

    @Override
    public Map<String, Set<Device>> getDevicesByResourceID(List<Device> devices,OS os_version) {
         return devices.stream().filter(device -> device.getBuildnumber().equals(os_version)).collect(Collectors.groupingBy(Device::getResourceid, Collectors.toSet()));
    }



    public static void main(String[] args) {

        final Repository<Device> repository = new Repository<>(Device.class,"devices.json");

        //repository.receive().forEach(System.out::println);

        final List<Device> devices = repository.receive();

        Exercises exc = new Solution();

        System.out.println("A legkisebb orajel: "+exc.minimumClockSpeed(devices)+" GHZ");
        System.out.println("A megadott Build-el rendelkezo gepek: "+exc.get_byOSBuild_build_devices(devices,OS.WINDOWS_10_1903));
        System.out.println("A gepek a hozzajuk tartozo OS build-el: "+exc.DevicesWithOS(devices));
        System.out.println("A megadott orajeltol kisebbek atlaga: "+exc.belowGHZAvarage(devices,3)+" GHZ");
        System.out.println("Gepek OS altal csoportositva: "+exc.GroupyByBuild(devices));

        System.out.println("\n");
        System.out.println("A gepek 2 szempont szerint rendezve:");
        System.out.println(exc.SortByClockSpeedThenResourceID(devices));
        System.out.println("\n");
        System.out.println("A gepek OS build altal csoportositva:");

        System.out.println(exc.GroupyByBuild(devices));
        System.out.println("\n");
        System.out.println("A megadott OS Build-el rendelkezo gepek resourceID szerint:");
        System.out.println(exc.getDevicesByResourceID(devices,OS.WINDOWS_10_2004));




    }
}
