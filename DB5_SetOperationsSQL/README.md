# DB_Assignment5
## Algebraic Modelling

_Use the set notations (union, intersect or except) on the Chinook dataset to find the following_<br>
1. The union of all the tracks with genreid 18 and 20
- Write a line of text in the notebook: What did you find?<br><br>
2. The intersection of all the invoices that are cheaper than 10 dollars and the invoices that are more expensive than 5 dollars
- Write a line of text in the notebook: What did you find?<br><br>
3. The set of all customers from USA, subtracted by the set of all customers with an email ending in 'yahoo.com'
- Write a line of text in the notebook: What did you find?<br><br>
4. The union of the set of all albums playing something by Mozart and the set of all albums playing something with Bach
- Write a line of text in the notebook: What did you find?

### Solution: 
_See here: https://github.com/cph-cs241/DB_Assignments_1Sem2018/blob/master/DB5_SetOperationsSQL/ChinookData.ipynb_

###### SETUP:
- `docker pull jegp/soft2018-data `<br>
- `docker pull jegp/soft2018-jupyter`<br>
- `docker run -p 5432:5432 --name data -d jegp/soft2018-data`<br>
- `docker exec -it data bash -c "psql -U appdev"`<br>
- `docker run -p 8888:8888 --name jupyter --link data -it jegp/soft2018-jupyter`
  or <br>
`docker run -p 8888:8888 -v /vagrant/jupyter:/home/jovyan --name jupyter --link data -it jegp/soft2018-jupyter `<br>
- use the generated token as the login

_IMPORTANT COMMANDS_
- `docker ps`or `docker ps -a`<br>
- `docker start <name/hash of the container running>`<br>
- `docker logs <name/hash of the container running>` <br>



_Start running SQL commands:_

`%load_ext sql` <br>
`%sql postgresql://appdev@data/appdev`<br>
`%sql SELECT * FROM information_schema.tables;`<br>
`%sql SELECT * FROM information_schema.tables  WHERE table_schema='chinook';`<br>
