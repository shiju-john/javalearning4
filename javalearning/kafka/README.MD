# KAFKA
This project shows the examples of KAFKA producer and consumer, Which is integrate with a spring boot application 
## Configuration
### Step 1: Download Kafka
### Step 2: Start the server
*Start a ZooKeeper server; Kafka has a single node Zookeeper configuration built-in*
 
`bin/zookeeper-server-start.cmd config/zookeeper.properties`
*To start KAFKA server*

`bin/kafka-server-start.cmd config/server.properties`

### Step 3: Create the topics
The messages are organized by topics on which Producers post messages and from which Consumers read messages
*For create a topic with the name test_topic_kafka_sample*

`bin/kafka-topics.cmd --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_topic_kafka_sample`

*For List the created topics*

`bin/kafka-topics.cmd --list --zookeeper localhost:2181 `

## Kafka architecture
![Alt text](src/test/resources/kafka Arch.png?raw=true "Kafka architecture oveview")

###Zookeeper and Kafka

Consider a distributed system with multiple servers, each of which is responsible for holding data and performing operations on that data. Some potential examples are distributed search engine, distributed build system or known system like Apache Hadoop. One common problem with all these distributed systems is how would you determine which servers are alive and operating at any given point of time? Most importantly, how would you do these things reliably in the face of the difficulties of distributed computing such as network failures, bandwidth limitations, variable latency connections, security concerns, and anything else that can go wrong in a networked environment, perhaps even across multiple data centers? These types of questions are the focus of Apache ZooKeeper, which is a fast, highly available, fault tolerant, distributed coordination service. Using ZooKeeper you can build reliable, distributed data structures for group membership, leader election, coordinated workflow, and configuration services, as well as generalized distributed data structures like locks, queues, barriers, and latches. Many well-known and successful projects already rely on ZooKeeper. Just a few of them include HBase, Hadoop 2.0, Solr Cloud, Neo4J, Apache Blur (incubating), and Accumulo.

ZooKeeper is a distributed, hierarchical file system that facilitates loose coupling between clients and provides an eventually consistent view of its znodes, which are like files and directories in a traditional file system. It provides basic operations such as creating, deleting, and checking existence of znodes. It provides an event-driven model in which clients can watch for changes to specific znodes, for example if a new child is added to an existing znode. ZooKeeper achieves high availability by running multiple ZooKeeper servers, called an ensemble, with each server holding an in-memory copy of the distributed file system to service client read requests.
