# Introduction

Apache Hadoop is an open-source software framework for storage and large-scale processing of data-sets on clusters of commodity hardware.The basic principle of working behind  Apache Hadoop is to break up unstructured data and distribute it into many parts for concurrent data analysis. There are mainly five building blocks inside this runtime envinroment (from bottom to top):

![Alt text](src/main/resources/images/hadoop-architecture-oveview.png?raw=true "hadoop architecture oveview")

## Hadoop Configurations

We can operate Hadoop cluster in any of the following mode:

***Local/Standalone Mode :*** After downloading Hadoop in your system, by default, it is configured in a standalone mode and can be run as a single java process.

### Configuration for Windows
set HADOOP_HOME & path in enviornment variable for windows

***core-site.xml*** <br/>
  <property>
    <name>hadoop.tmp.dir</name>
     <value>F:\tools\tools\hadoop-2.7.3\tmp</value>
  </property>
  <property>
    <name>fs.defaultFS</name>
    <value>hdfs://localhost:9000</value>
  </property>
***hdfs-site.xml*** <br/>
  <property>
	    <name>dfs.replication</name>
	    <value>1</value>
  </property>  
  <property>
    <name>dfs.namenode.name.dir</name>
    <value>F:/tools/tools/hadoop-2.7.3/node/nameNode</value>
   </property>
   <property>
       <name>dfs.datanode.data.dir</name>
     <value>F:/tools/tools/hadoop-2.7.3/node/dataNode</value>
   </property>
***mapred-site.xml*** <br/>
 <property>
		<name>mapreduce.framework.name</name>
		<value>yarn</value>
	</property>
***yarn-site.xml*** <br/>
  <property>
       <name>yarn.nodemanager.aux-services</name>
       <value>mapreduce_shuffle</value>
   </property>
   <property>
       <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>
       <value>org.apache.hadoop.mapred.ShuffleHandler</value>
   </property>
**set JAVA_HOME in hadoop-env.cmd**

set HADOOP_PREFIX=F:/tools/tools/hadoop-2.7.3
set HADOOP_CONF_DIR=F:/tools/tools/hadoop-2.7.3/etc/hdoop
set YARN_CONF_DIR=F:/tools/tools/hadoop-2.7.3/etc/hdoop
set PATH=%PATH%;F:/tools/tools/hadoop-2.7.3/bin

***Pseudo Distributed Mode :*** It is a distributed simulation on single machine. Each Hadoop daemon such as hdfs, yarn, MapReduce etc., will run as a separate java process. This mode is useful for development.

***Fully Distributed Mode :*** This mode is fully distributed with minimum two or more machines as a cluster. We will come across this mode in detail in the coming chapters.


# HDFS High Availability 
Prior to Hadoop 2.0.0, the NameNode was a single point of failure (SPOF) in an HDFS cluster. Each cluster had a single NameNode,and if that machine or process became unavailable, the cluster as a whole would be unavailable until the NameNode was either restarted or brought up on a separate machine.

This impacted the total availability of the HDFS cluster in two major ways:

* In the case of an unplanned event such as a machine crash, the cluster would be unavailable until an operator restarted the NameNode.
* Planned maintenance events such as software or hardware upgrades on the NameNode machine would result in window of cluster downtime.

The HDFS High Availability feature addresses the above problems by providing the option of running two redundant NameNodes in the same cluster in an Active/Passive configuration with a hot standby. This allows a fast failover to a new NameNode in the case that a machine crashes, or a graceful administrator-initiated failover for the purpose of planned maintenance.

## Configurations Required for high availability

# References
Reference tutorials

https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm <br/>
https://hadoop.apache.org/docs/r2.4.1/hadoop-project-dist/hadoop-hdfs/HDFSHighAvailabilityWithQJM.html
http://ercoppa.github.io/HadoopInternals/HadoopArchitectureOverview.html
