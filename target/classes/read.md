How to setup and start application

-----------------------------------KAFKA Setup------------------------------------------------------------

checkk resourses folder

Zookeeper will be available at $DOCKER_HOST_IP:2181
Kafka will be available at $DOCKER_HOST_IP:9092
Run with:

docker compose -f zk-single-kafka-single.yml up
docker compose -f zk-single-kafka-single.yml down


some basic command

https://www.conduktor.io/kafka/kafka-topics-cli-tutorial/
https://www.conduktor.io/kafka/kafka-consumer-cli-tutorial/

cd /var

cd ../

./bin/kafka-topics --bootstrap-server localhost:9092 --topic csv-events --create --partitions 3 --replication-factor 1


Producer

cd /var

cd ../
./bin/kafka-console-producer --bootstrap-server localhost:9092 --topic csv-events


cd /var

cd ../
./bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic csv-events


./bin/kafka-consumer-groups --bootstrap-server localhost:9092 --list



-----------------------------------------------------------------------------------------------
API

http://localhost:8080/execute/csv-events

http://localhost:8080/receive


http://localhost:8080/send/{topicName}  -d{}

