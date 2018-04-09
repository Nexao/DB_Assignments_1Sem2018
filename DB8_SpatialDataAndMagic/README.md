# DB_Assignment8

1. In the first part you'll be processing the data in the geonames table.<br>

    A. Find the tuple with the largest population<br>
    
    B. Now calculate the distance from all locations to the tuple above using the <-> function<br>
    
    C .Now calculate the distance from all locations to the tuple above using the haversine distance<br>
    
    > a. The haversine distance has been implemented in PL/PGSQL here: https://gist.github.com/carlzulauf/1724506<br>
    
    D. Plot the latitude and longitude of the largest 1000 populations on a 2-D scatter plot<br>
    > a. You can use IPython-SQL or Pandas to create the plot
    
2. In the second part your job is to work with JSON data from the magic schema. The schema is based on the game Magic: The gathering <br>

    A. Find all the cards that is made by Rob Alexander <br>
    
    B. Find all the cards that have the subtype "Human"  <br>
    
    C. Group all the cards based on the colour. Aggregate them by counting the number of cards per colour. <br>

# Hand-in: 

A. a 2-d plot of the latitude and longitudes of the 1000 largest populations from the geonames table 

![image](https://user-images.githubusercontent.com/16150075/38525445-a0cc32ec-3c52-11e8-9c5f-e5df0d7d4950.png)

B. a histogram that counts the number of cards for each colour

![image](https://user-images.githubusercontent.com/16150075/38525459-b26c08ce-3c52-11e8-89c1-9b5cf0f19afa.png)
