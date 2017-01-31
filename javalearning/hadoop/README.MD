# Introduction
We can operate Hadoop cluster in anhy of the three supported modes:

Local/Standalone Mode : After downloading Hadoop in your system, by default, it is configured in a standalone mode and can be run as a single java process.

Pseudo Distributed Mode : It is a distributed simulation on single machine. Each Hadoop daemon such as hdfs, yarn, MapReduce etc., will run as a separate java process. This mode is useful for development.

Fully Distributed Mode : This mode is fully distributed with minimum two or more machines as a cluster. We will come across this mode in detail in the coming chapters.
## Hadoop Configurations

# HDFS High Availability 
Prior to Hadoop 2.0.0, the NameNode was a single point of failure (SPOF) in an HDFS cluster. Each cluster had a single NameNode,and if that machine or process became unavailable, the cluster as a whole would be unavailable until the NameNode was either restarted or brought up on a separate machine.

This impacted the total availability of the HDFS cluster in two major ways:

* In the case of an unplanned event such as a machine crash, the cluster would be unavailable until an operator restarted the NameNode.
* Planned maintenance events such as software or hardware upgrades on the NameNode machine would result in windows of cluster downtime.

The HDFS High Availability feature addresses the above problems by providing the option of running two redundant NameNodes in the same cluster in an Active/Passive configuration with a hot standby. This allows a fast failover to a new NameNode in the case that a machine crashes, or a graceful administrator-initiated failover for the purpose of planned maintenance.

## Configurations Required for high availability

# References
Reference tutorials
https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm
https://hadoop.apache.org/docs/r2.4.1/hadoop-project-dist/hadoop-hdfs/HDFSHighAvailabilityWithQJM.html
