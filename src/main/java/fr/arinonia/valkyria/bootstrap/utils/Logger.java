package fr.arinonia.valkyria.bootstrap.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Arinonia on 18/06/2020 inside the package - fr.arinonia.valkyria.bootstrap.utils
 */
public class Logger {

    public void log(String s, Object... format) {
        System.out.println(genPrefix() + "[INFO] " + String.format(s, format));
    }

    public void warn(String s, Object... format) {
        System.err.println(genPrefix() + "[WARN] " + String.format(s, format));
    }

    private String genPrefix() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append("Valkyria-Bootstrap").append("]").append(" [");
        String pattern = "dd/MM/YYYY HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        builder.append(date).append("] ");
        return builder.toString();
    }

}
