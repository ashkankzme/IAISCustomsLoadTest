FROM ubuntu:14.04.3
MAINTAINER Doro Wu <fcwu.tw@gmail.com>

ENV DEBIAN_FRONTEND noninteractive
ENV HOME /root

RUN apt-get update \
    && apt-get install -y --force-yes --no-install-recommends supervisor \
        openssh-server pwgen sudo vim-tiny \
        net-tools \
        lxde x11vnc xvfb \
        gtk2-engines-murrine ttf-ubuntu-font-family \
        libreoffice firefox \
        fonts-wqy-microhei \
        language-pack-zh-hant language-pack-gnome-zh-hant firefox-locale-zh-hant \
        nginx \
        python-pip python-dev build-essential \
        mesa-utils libgl1-mesa-dri \
    && apt-get autoclean \
    && apt-get autoremove \
    && rm -rf /var/lib/apt/lists/*

ADD https://dl.dropboxusercontent.com/u/23905041/x11vnc_0.9.14-1.1ubuntu1_amd64.deb /tmp/
ADD https://dl.dropboxusercontent.com/u/23905041/x11vnc-data_0.9.14-1.1ubuntu1_all.deb /tmp/
RUN dpkg -i /tmp/x11vnc*.deb

ADD web /web/
RUN pip install -r /web/requirements.txt

ADD noVNC /noVNC/
ADD nginx.conf /etc/nginx/sites-enabled/default
ADD startup.sh /
ADD supervisord.conf /etc/supervisor/conf.d/
ADD doro-lxde-wallpapers /usr/share/doro-lxde-wallpapers/

EXPOSE 6080
WORKDIR /root
RUN chmod 755 /startup.sh
ENTRYPOINT ["/startup.sh"]

# adding things for testing

#RUN apt-get update
#RUN apt-get install -y --force-yes software-properties-common
#RUN add-apt-repository ppa:webupd8team/java
#RUN apt-get update
#RUN apt-get install -y --force-yes oracle-java8-installer
RUN apt-get update && apt-get install -y maven
ADD test-configs /test-configs/
RUN chmod -R 755 /test-configs
RUN chmod -R 755 /web/
RUN chmod -R 755 /noVNC/
RUN chmod -R 755 /home/
ADD src /home/ubuntu/src/
ADD pom.xml /home/ubuntu

# end
