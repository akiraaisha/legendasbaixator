package Utils;

import Model.MovieFileVO;
import org.gudy.azureus2.plugins.PluginInterface;
import org.gudy.azureus2.plugins.disk.DiskManagerFileInfo;
import org.gudy.azureus2.plugins.download.Download;
import org.gudy.azureus2.plugins.torrent.TorrentAttribute;
import static ch.lambdaj.Lambda.*;
import org.hamcrest.Matchers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Bruno
 * Date: 24/03/2010
 * Time: 15:35:42
 * To change this template use File | Settings | File Templates.
 */
public class TorrentUtils {

    public static TorrentAttribute getCategoryAttr(PluginInterface pluginInterface) {
        return pluginInterface.getTorrentManager().getAttribute(TorrentAttribute.TA_CATEGORY);
    }

    public static List<MovieFileVO> getMovieFiles(PluginInterface pluginInterface) {
        List<MovieFileVO> listaMovies = new ArrayList<MovieFileVO>();
        // Filtra somente os que est�o completos
        List<Download> listaTorrent = filter(having(on(Download.class).isComplete(), Matchers.equalTo(true)), pluginInterface.getDownloadManager().getDownloads());
        // Pega somente o que � Video
        listaTorrent = filter(having(FileUtils.isMovieFile(on(Download.class).getName()), Matchers.equalTo(true)), listaTorrent);

        for (Download item : listaTorrent) {
            listaMovies.addAll(torrentMovieToMovieFileVO(item, pluginInterface));
        }
        return listaMovies;
    }

    public static MovieFileVO torrentMovieToMovieFileVO(DiskManagerFileInfo fileInfo, PluginInterface pluginInterface) {
        try {
            File diskFile = fileInfo.getFile();
            MovieFileVO movieFileVO = new MovieFileVO();
            movieFileVO.setFileName(diskFile.getName());
            movieFileVO.setPathDir(FileUtils.getPathWithoutFileName(diskFile.getPath()));
            movieFileVO.setCategory(fileInfo.getDownload().getAttribute(getCategoryAttr(pluginInterface)));
            movieFileVO.setHasSubTitle(FileUtils.hasSubTitleFile(movieFileVO.getPathDir(), movieFileVO.getFileName()));
            movieFileVO.setSize(diskFile.length());
            movieFileVO.setTorrentName(fileInfo.getDownload().getTorrent().getName());
            movieFileVO.setFile(fileInfo.getFile());
            return movieFileVO;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static List<MovieFileVO> torrentMovieToMovieFileVO(Download download, PluginInterface pluginInterface) {
        List<MovieFileVO> movieList = new ArrayList<MovieFileVO>();
        for (DiskManagerFileInfo fileTorrent : download.getDiskManagerFileInfo())
            if ((!fileTorrent.isSkipped()) && (!fileTorrent.isDeleted()) && (FileUtils.isMovieFile(fileTorrent.getFile().getName()))) {
                MovieFileVO movieVO = torrentMovieToMovieFileVO(fileTorrent, pluginInterface);
                movieList.add(movieVO);
            }
        return movieList;
    }

    public static boolean hasMovieFile(Download download) {
        DiskManagerFileInfo[] filesTorrent = download.getDiskManagerFileInfo();
        for (DiskManagerFileInfo fileTorrent : filesTorrent)
            if ((!fileTorrent.isSkipped()) && (!fileTorrent.isDeleted()) && (FileUtils.isMovieFile(fileTorrent.getFile().getName()))) {
                return true;
            }
        return false;
    }
}
