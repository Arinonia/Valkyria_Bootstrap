package fr.arinonia.valkyria.bootstrap.ui;

import fr.arinonia.valkyria.bootstrap.Main;
import fr.arinonia.valkyria.bootstrap.utils.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

/**
 * Created by Arinonia on 18/06/2020 inside the package - fr.arinonia.valkyria.bootstrap.ui
 */
public class BootstrapFrame extends JFrame {

    public BootstrapFrame()  {
        this.setTitle(Constants.NAME + "-Bootstrap | V-" + Constants.VERSION);
        this.setSize(Constants.WITH, Constants.HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        try {
            this.setIconImage(ImageIO.read(Main.class.getResourceAsStream("/img/icon.png")));
        } catch (IOException e) {
            Constants.LOGGER.log(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur-" + Constants.NAME, JOptionPane.ERROR_MESSAGE);
        }
        this.setContentPane(new BootstrapPanel());
        this.setVisible(true);
    }

}
