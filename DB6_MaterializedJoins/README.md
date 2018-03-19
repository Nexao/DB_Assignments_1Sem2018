# DB_Assignment6
## Materialized Joins

_Your job is to 1) describe the content and function of an index, 2) analyse a join query on some tables in the f1db schema and 3) create a materialised view of it. You will have to_

1. On the table circuits report:
- What type of indices exists for the table and why they are of that type (and not some other type)
- The amount of space each index takes up
2. We are talent scouts looking to win over some of the best new drivers there are. But we don't want them too old! Write a query that finds the winner of all the races, but only if they are younger than 38 years. The query should give return the date, driver surname, driver age, track time in milliseconds, race name and circuit name for all races.
3. Describe the query using EXPLAIN ANALYZE with at least 5 lines of text. Answer at least the following:
- How many calls are you making?
- How long does it take to perform the query?
4. Create a materialized view of your query. Using EXPLAIN ANALYZE try to query the view. Write at least 5 lines of text explaining what's going on and why the query execution time changed.

### Solution: 
_See here: _



### Important Commands:
- `docker pull jegp/soft2018-data `<br>
- `docker pull jegp/soft2018-jupyter`<br>
- `docker run -p 5432:5432 --name data -d jegp/soft2018-data`<br>
- `docker exec -it data bash -c "psql -U appdev"`<br>
- `docker run -p 8888:8888 --name jupyter --link data -it jegp/soft2018-jupyter`
  or <br>
`docker run -p 8888:8888 -v /vagrant/jupyter:/home/jovyan --name jupyter --link data -it jegp/soft2018-jupyter `<br>
- use the generated token as the login
