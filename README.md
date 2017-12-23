# 20171218-tcadm

These directions assume you've downloaded and extracted Apache Tomcat 8.5 to /usr/local, and made a symlink pointing /usr/local/tomcat to it. You can use these commands to do this:

````bash

# Download and install JDK8u151 - you are accepting their license agreement in doing this
wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u151-b12/e758a0de34e24606bca991d704f6dcbf/jdk-8u151-linux-x64.rpm
sudo yum install -y jdk-8u151-linux-x64.rpm

# Download, unpack, and symlink Apache Tomcat 8.5.24 to /usr/local/tomcat.
wget http://apache.mirrors.hoobly.com/tomcat/tomcat-8/v8.5.24/bin/apache-tomcat-8.5.24.tar.gz
sudo tar -C /usr/local/ -xvf apache-tomcat-8.5.24.tar.gz
sudo ln -s /usr/local/apache-tomcat-8.5.24 /usr/local/tomcat

# Create a tomcat user and give it ownership of the Tomcat installl dir
sudo adduser tomcat
sudo chown -R tomcat:tomcat /usr/local/*tomcat*

# Add environment variables to our ~/.bashrc and activate them for this session
echo '
export TOMCAT_HOME="/usr/local/tomcat"
export PATH=$PATH:$TOMCAT_HOME/bin
'>> ~/.bashrc

source ~/.bashrc

# Add the current user to the tomcat group - you'll need to logout and back in for it to take effect
sudo usermod -aG tomcat `whoami` 
````

It also assumes you've downloaded, built, and deployed the latest OpenSSL and the native extension (Apache Portable Runtime, APR-iConv, APR-util, and Tomcat Native). It's always best to download the source and build them yourself (verify checksums of the files you download!) for security, performance, and compatibility. The optimized binary builds are CPU-specific and can vary even from AMD to Intel and from Core7 to Xeon

	http://tomcat.apache.org/native-doc/

After cloning this repo, do a clean/package/copy (the initial "clean" is unnecessary after the initial clone, but you should do it after every successive build to make sure there are no lingering artifacts in the target/ directory from previous builds):

````bash
mvn clean
mvn package
sudo cp target/jee-demo.war $TOMCAT_HOME/webapps
sudo chown tomcat:tomcat $TOMCAT_HOME/webapps/jee-demo.war
````

In src/main/tomcat, there are two files, server.xml and logging.properties that should be copied (or merged into the existing files) into $TOMCAT_HOME/conf).

````bash
sudo cp src/main/tomcat/{server.xml,logging.properties} $TOMCAT_HOME/conf
sudo chown tomcat:tomcat $TOMCAT_HOME/conf/{server.xml,logging.properties}
````

If you've just unpacked tomcat to $TOMCAT_HOME, you'll want to start it as a service. Assuming you're running CentOS/RHEL 7 (or a SystemD distro), there's a tomcat.service file, which should be installed in /usr/lib/systemd/system, then enabled with systemctl (verify contents match your setup first):

````bash
sudo cp src/main/tomcat/tomcat.service /usr/lib/systemd/system
sudo systemctl enable tomcat
sudo systemctl start tomcat
````

If you're using a CentOS/RHEL 6 distro (including Amazon Linux AMI), you'll want to use the tomcat-service.sh instead. It goes in /etc/init.d, and chkconfig to enable (verify contents match your setup first).

````bash
sudo cp src/main/tomcat/tomcat-service.sh /etc/init.d/tomcat
sudo chkconfig tomcat
sudo service tomcat start
````

You'll need to copy the mariadb driver to $TOMCAT_HOME/lib.

````bash
sudo cp mariadb-java-client-2.2.0.jar $TOMCAT_HOME/lib
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/mariadb-java-client-2.2.0.jar
````

Happy Serving!

-Calvin
