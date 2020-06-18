package fr.arinonia.valkyria.bootstrap.launcher;

import fr.arinonia.valkyria.bootstrap.utils.OsUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arinonia on 19/06/2020 inside the package - fr.arinonia.valkyria.bootstrap.launcher
 */
public class Launcher {

    public void launchJar(File jarFile) throws Exception {
        List<String> javaArgs = new ArrayList<String>();

        if (OsUtil.getOs() == OsUtil.EnumOS.WINDOWS) {
            javaArgs.add("javaw");
        }
        else {
            javaArgs.add("java");
        }
        javaArgs.add("-jar");
        javaArgs.add(jarFile.getPath());

        ProcessBuilder processBuilder = new ProcessBuilder(javaArgs);
        Process process = processBuilder.start();

        if (process == null) {
            throw new Exception("Unable to launch " + jarFile.getAbsolutePath());
        }
        Thread.sleep(2000);
        System.exit(0);
    }

}
