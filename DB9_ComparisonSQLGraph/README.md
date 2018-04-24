## Exercise - Technical Comparison of an SQL and Graph Database
#### Setup:
- Import the data from the social network (endorsement graph https://github.com/datsoftlyngby/soft2018spring-databases-teaching-material/raw/master/data/archive_graph.tar.gz) into a Neo4j database and into an SQL database respectively.

My solution uses this IP for the server:

- 167.99.249.26:8888 - PostGreSQL _(After so much time spent for connecting sql, I ended up using Emmely's database)_
- localhost:7687 - Neo4J

FOR Neo4J setup:<br>
- After downloading the data set, unpack:
```
sed -i -E '1s/.*/:ID,name,job,birthday/' social_network_nodes.csv
sed -i -E '1s/.*/:START_ID,:END_ID/' social_network_edges.csv
```

- Creating a container for neo4j and import the data:
```
docker run \
    -d --name neo4j \
    --rm \
    --publish=7474:7474 \
    --publish=7687:7687 \
    --volume=$(pwd)/import:/import \
    --volume=$(pwd)/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/class \
    --env=NEO4J_dbms_security_procedures_unrestricted=apoc.\\\*,algo.\\\* \
    --env=NEO4J_dbms_memory_pagecache_size=6G \
    --env=NEO4J_dbms_memory_heap_max__size=10G \
    neo4j

docker exec neo4j sh -c 'neo4j stop'
docker exec neo4j sh -c 'rm -rf data/databases/graph.db'

docker exec neo4j sh -c 'neo4j-admin import \
    --nodes:Person /import/social_network_nodes.csv \
    --relationships:ENDORSES /import/social_network_edges.csv \
    --ignore-missing-nodes=true \
    --ignore-duplicate-nodes=true \
    --id-type=INTEGER'
```
##### TASK:
    A. all persons that a person endorses, i.e., endorsements of depth one.
    B. all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
    C. endorsements of depth three.
    D. endorsements of depth four.
    E. endorsements of depth five.
    
QUERRIES' RESULT:
![QUERRIES' RESULT](https://github.com/cph-cs241/DB_Assignments_1Sem2018/blob/master/DB9_ComparisonSQLGraph/QUERIES_Result.png) <br>

RANDOM 20 NODES:
![RANDOM 20 NODES](https://github.com/cph-cs241/DB_Assignments_1Sem2018/blob/master/DB9_ComparisonSQLGraph/random.png)<br>

RUNNING TIME EXECUTION:
![RUNNING TIME EXECUTION](https://github.com/cph-cs241/DB_Assignments_1Sem2018/blob/master/DB9_ComparisonSQLGraph/Time.png)<br>

_Unfortunately, I wasn't able to finish all the requirements in the Assignment - the implementation of Benchmark with the average and meridian, which it doesn't give me much good basis to conclude.But as you can see in running time execution above, Neo4j is a way much better in performing such querries._ 

_This assignment is quite big and encountered so many issues when it comes to connecting to the database, especially in SQL._

SEE IMPLEMENTATION [HERE.](https://github.com/cph-cs241/DB_Assignments_1Sem2018/tree/master/DB9_ComparisonSQLGraph/src/main/java/data)
