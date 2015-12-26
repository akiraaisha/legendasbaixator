# Presentation #

Legendas Baixator is a [Vuze](http://www.vuze.com) plugin for downloading video subtitles automatically when a torrent finishes downloading.

# Configuration #

After install the plugin, start using it is very simple, you just have to active it on Vuze Plugins Configuration and when a download is finished the plugin will find the subtitle.

## Websites search ##

After activating the plugin, the websites to look for subtitles must be selected with language, extension/format and fill user/password if necessary.

The following websites are supported:

[![](http://thesubdb.com/subdb-logo.png)](http://thesubdb.com)
[![](http://static.opensubtitles.org/gfx/logo-transparent.png)](http://www.opensubtitles.org)
[![](http://legendas.tv/images/ltv_logo.png)](http://www.legendas.tv)

## Save subtitles with movie's file name ##

When activated, the subtitle will be saved with video's file name and the extension will be the selected on website.

When not activated, the subtitle will be saved with the name returned by website, but in a complete search for subtitles the video may be considered without subtitle.

## Categories ##

The torrent files can be filtered by category, so the videos that don't need subtitles will not enter on the search.

## Download subtitles ##

On the configuration you can do a search for all completed videos without subtitles, this search works exactly as individual search.

## Exclude files according to Regex ##

A regex can be done to exclude files from search, the file according to regex will be excluded.

The regex is tested with video's file name and not with torrent name.

This is useful to ignore samples files that come with some movies.

# How it works #

The search is done to files with following extensions:

AJP, ASF, ASX, AVCHD, AVI, BIK, BIX, BOX, CAM, DAT, DIVX, DMF, DV, VO, LC, FLI, FLIC, FLV, FLX, GVI, GVP, H264, M1V, M2P, M2TS, M2V, M4E, M4V, MJP, MJPEG, MJPG, MKV, MOOV, MOV, MOVHD, MOVIE, MOVX, MP4, MPE, MPEG, MPG, MPV, MPV2, MXF, NSV, NUT, OGG, OGM, OMF, PS, QT, RAM, RM, RMVB, SWF, TS, VFW, VID, VIDEO, VIV, VIVO, VOB, VRO, WM, WMV, WMX, WRAP, WVX, WX, X264, XVID.

A video file is considered with subtitle when, on the same folder exists a file with same name in one of the following extensions:

SRT, SUB, SMI, TXT, SSA, ASS, MPL

# Versions #

**0.3**
```
* Included support for Legendas.TV
* Added option to append language code to subtitle file and save to disk
* Option to configure periodic checking for subtitles
* Fixed OpenSubTitles search
* Fixed some minor bugs
* Included Basque Translation (thanks to azpidatziak)
```

**0.2**
```
* Regex to exclude files from search
* Removed user/password from sites that don't need them
```

**0.1**
```
* Initial Release
```