# Introdução #

O Legendas Baixator é um plugin do [Vuze](http://www.vuze.com) para baixar a legenda de um filme automaticamente quando o download do torrent terminar e assim você não ter que procurar pela internet.

# Configuração #

Após a instalação do plugin, para iniciar o seu uso é muito simples basta ativar o plugin na configuração de plugins do Vuze.

## Sites de busca ##

Após a ativação devem ser selecionados os sites em que a legenda será buscada, em qual idioma, em qual extensão/formato e configurar login e senha se necessário.

## Salvar legenda com o mesmo do video ##

Quando configurada a legenda será gravada com o mesmo nome do arquivo do video e com a extensão escolhida para o site.

Quando a flag não estiver marcada a legenda será salva com o nome retornado pelo site, porém numa busca completa o video será considerado sem legenda.

## Categorias ##

Pode ser feito um filtro por categoria de torrent, assim os videos que não necessitam de legenda não entrarão na busca.

## Baixar Legendas ##

Na página de configuração pode ser feita uma busca de legendas para todos os videos que estão baixados e ainda estão sem legendas, essa busca segue a mesma regra da busca individual.

Os seguintes sites são suportados:

[![](http://30.media.tumblr.com/avatar_9259f7abc816_128.png)](http://blog.thesubdb.com)
[![](http://static.opensubtitles.org/gfx/logo-transparent.png)](http://www.opensubtitles.org)

## Excluir arquivos da busca - regex ##

É possível configurar um regex para excluir arquivos da busca, tudo o que bater com o regex será excluído da busca por legendas.

O que será validado com o regex é o nome do arquivo do torrent e não o nome do torrent.

Isto é bastante útil para excluir arquivos sample que vem em alguns filmes.

# Funcionamento #

A busca é feita para os arquivos com as seguintes extensões:

AJP, ASF, ASX, AVCHD, AVI, BIK, BIX, BOX, CAM, DAT, DIVX, DMF, DV, VO, LC, FLI, FLIC, FLV, FLX, GVI, GVP, H264, M1V, M2P, M2TS, M2V, M4E, M4V, MJP, MJPEG, MJPG, MKV, MOOV, MOV, MOVHD, MOVIE, MOVX, MP4, MPE, MPEG, MPG, MPV, MPV2, MXF, NSV, NUT, OGG, OGM, OMF, PS, QT, RAM, RM, RMVB, SWF, TS, VFW, VID, VIDEO, VIV, VIVO, VOB, VRO, WM, WMV, WMX, WRAP, WVX, WX, X264, XVID.

Um video é considerado com legenda quando, na mesma pasta existir um arquivo de mesmo nome em alguma das seguintes extensões:

SRT, SUB, SMI, TXT, SSA, ASS, MPL

# Versões #

**0.2**
```
* Regex para excluir arquivos de busca
* Retirados campos usuário/senha de sites que não necessitam de login
```

**0.1**
```
* Versão inicial
```