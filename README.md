# Flink IMooc Course Notes and Source Code

## Setup and Installation
* Install Java 8 JDK from Oracle official website. A sample download link is: https://www.oracle.com/cn/java/technologies/javase/javase-jdk8-downloads.html
* Install Maven from https://maven.apache.org/download.cgi. Unzip and put maven under `~/app` by executing `tar -zxvf apache-maven-3.6.3-bin.tar.gz -C ~/app`. 
  * Change `localRepository` section in `conf/settings.xml` to `~/maven_repos` directory.
  * Add `/Users/yyu196/app/apache-maven-3.6.3/bin` to environmental PATH.
* Java 8.x and Maven 3.0.4 is the minimal version required for 