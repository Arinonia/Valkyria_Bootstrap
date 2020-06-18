package fr.arinonia.valkyria.bootstrap.utils;

/**
 * Created by Arinonia on 18/06/2020 inside the package - fr.arinonia.valkyria.bootstrap.utils
 */
public class OsUtil {
    public static EnumOS getOs(){
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win") ? EnumOS.WINDOWS
                :(os.contains("mac") ? EnumOS.MAC
                :(os.contains("linux") ? EnumOS.LINUX
                :(os.contains("unix") ? EnumOS.MAC : EnumOS.UNKNOWN)));
    }

    public static enum EnumOS {
        LINUX("LINUX", 0),
        WINDOWS("WINDOWS", 1),
        MAC("MAC", 2),
        UNKNOWN("UNKNOWN", 3);

        private EnumOS(String name, int id) {}
    }
}
