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
