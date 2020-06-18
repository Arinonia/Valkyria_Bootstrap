package fr.arinonia.valkyria.bootstrap;

import fr.arinonia.valkyria.bootstrap.ui.BootstrapFrame;
import fr.arinonia.valkyria.bootstrap.utils.Constants;

/**
 * Created by Arinonia on 18/06/2020 inside the package - fr.arinonia.valkyria.bootstrap
 */
public class Main {

    public static void main(String[] args) {
        Constants.LOGGER.log("Lancement du bootstrap.");
        new BootstrapFrame();
    }

}
