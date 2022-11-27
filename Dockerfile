FROM docker-registry-iris.groupement.systeme-u.fr/iris-onbuild/springbatch:openjdk11-ubi7

LABEL MAINTAINER="claude.croguennoc@systeme-u.fr"

ENV MAIN_CLASS=fr.su.smartnewsmaintenancebatch.SmartnewsMaintenanceBatchApplication