# Documentation for projects

## 1. Word Count
* Given a file, count the frequency of words, which are separated by `\t`;
* Print the word count result to console
* Create the Java project framework by executing:
  ```
  mvn archetype:generate \
    -DarchetypeGroupId=org.apache.flink \
    -DarchetypeArtifactId=flink-quickstart-java \
    -DarchetypeVersion=1.7.0 \
    -DarchetypeCatalog=local \
    -DgroupId=com.yuyue.flink.java \
    -DartifactId=flink-train-java \
    -Dversion=1.0 \
    -Dpackage=com.yuyue.flink.java \
    -DinteractiveMode=false
  ```
* Create the Scala project framework by executing:
  ```
  mvn archetype:generate \
    -DarchetypeGroupId=org.apache.flink \
    -DarchetypeArtifactId=flink-quickstart-scala \
    -DarchetypeVersion=1.7.0 \
    -DarchetypeCatalog=local \
    -DgroupId=com.yuyue.flink.scala \
    -DartifactId=flink-train-scala \
    -Dversion=1.0 \
    -Dpackage=com.yuyue.flink.scala \
    -DinteractiveMode=false
  ```
* How to develop a Batch Job
  * Set up the batch execution environment;
  * Read the data.
  * Transform operations, which the developing business logic lives.
    * For every line, split the string into different words per delimiter;
    * Map every word's frequency to 1.
    * Reduce on the frequency for each word.
  * Execute program