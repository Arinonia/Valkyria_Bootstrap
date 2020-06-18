package fr.arinonia.valkyria.bootstrap.updater;

/**
 * Created by Arinonia on 18/05/2020 inside the package - fr.arinonia.updater
 */
public interface DownloadListener {
    public void onDownloadJobFinished(DownloadJob job);
    public void onDownloadJobProgressChanged(DownloadJob job);
}
