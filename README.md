# event-processing-kafka-springboot
Process the kafka event,filter data and Integrate with API 

# Setup PG Admin  

Run below commad 

$ cd src/main/resources/PGAdmin/

$ docker-compose up .

# Kafka Setup 

Run below commad :

$ cd src/main/resources/kafka

$ docker compose -f zk-single-kafka-single.yml up 

$ docker compose -f zk-single-kafka-single.yml down



