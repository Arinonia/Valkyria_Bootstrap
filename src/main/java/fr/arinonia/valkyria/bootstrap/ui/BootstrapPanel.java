package fr.arinonia.valkyria.bootstrap.ui;

import fr.arinonia.valkyria.bootstrap.ui.components.CustomButton;
import fr.arinonia.valkyria.bootstrap.updater.DownloadJob;
import fr.arinonia.valkyria.bootstrap.updater.DownloadListener;
import fr.arinonia.valkyria.bootstrap.updater.Updater;
import fr.arinonia.valkyria.bootstrap.utils.Constants;
import fr.arinonia.valkyria.bootstrap.utils.OsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Arinonia on 18/06/2020 inside the package - fr.arinonia.valkyria.bootstrap.ui
 */
public class BootstrapPanel extends JPanel implements DownloadListener {

    private final ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
    JProgressBar progressBar = new JProgressBar();


    public BootstrapPanel() {
        this.setLayout(null);
        this.setBackground(new Color(44,44,44));

        JLabel text = new JLabel();
        text.setText("<html>Bienvenue jeune aventurié sur Valkyria,<br>" +
                "Tu trouveras sur ce serveur différentes quêtes tout au long de ta progression, une économie stable, " +
                "un nouveau système de farme et des ajouts réellement inédit </html>");
        text.setForeground(new Color(92,227,246));
        text.setFont(text.getFont().deriveFont(18.0f));
        text.setBounds(10,10,590,140);
        this.add(text);

        progressBar.setBounds(10,242,400,36);
        progressBar.setForeground(new Color(21, 72, 161));
        progressBar.setBackground(new Color(74, 167, 232));
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(true);
        progressBar.setString("");
        this.add(progressBar);

        CustomButton launchButton = new CustomButton("Lancement !", 140, 40);
        launchButton.setBounds(450,240,140,40);
        launchButton.setLocation(450,240);
        launchButton.setForeground(Color.WHITE);
        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (launchButton.isEnabled()){
                    launchButton.setEnabled(false);
                    progressBar.setString("Recherche de mise à jour...");
                    start();
                }
            }
        });
        this.add(launchButton);
    }

    private void start(){
        DownloadJob gameJob = new DownloadJob("java", this);
        Updater updater = new Updater("http://dev.valkyria.fr/download/java/java_" + OsUtil.getOs().toString().toLowerCase() + ".json", createGameDir(), gameJob);
        updater.start();
        progressBar.setMaximum(gameJob.getAllFiles().size());
        gameJob.startDownloading(executorService);
    }

    @Override
    public void onDownloadJobFinished(DownloadJob job) {
        //TODO OUBLIE PAS FDP T'AS UN TRUC A METTRE MAIS JE SAIS PLUS QUOI
    }

    @Override
    public void onDownloadJobProgressChanged(DownloadJob job) {
        progressBar.setValue(job.getAllFiles().size()-job.getRemainingFiles().size());
        progressBar.setString("Téléchargement: " + job.getRemainingFiles().size() + " fichiers restants");
    }

    private File createGameDir() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
            return new File(System.getProperty("user.home") + "\\AppData\\Roaming\\." + Constants.NAME);
        else if (os.contains("mac"))
            return new File(System.getProperty("user.home") + "/Library/Application Support/" +  Constants.NAME);
        else
            return new File(System.getProperty("user.home") + "/." +  Constants.NAME);
    }
}
