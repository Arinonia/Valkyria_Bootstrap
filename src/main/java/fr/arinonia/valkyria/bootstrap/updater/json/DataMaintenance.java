package fr.arinonia.valkyria.bootstrap.updater.json;

/**
 * Created by Arinonia on 24/05/2020 inside the package - fr.arinonia.updater.json
 */
public class DataMaintenance {
    private boolean maintenance;
    private String message;

    public boolean isMaintenance() {
        return maintenance;
    }

    public String getMessage() {
        return message;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
