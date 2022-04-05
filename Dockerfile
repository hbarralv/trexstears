#Create MySQL Image for Trex's Tears
FROM mysql
MAINTAINER hbarral@uoc.edu

ENV MYSQL_ROOT_PASSWORD trexstearspassword
ADD trexstears_backup.sql /docker-entrypoint-initdb.d

EXPOSE 3306
