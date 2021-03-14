# invetory-REST-Api
 
This is an inventory rest api

# VERY IMPORTANT TO FOLLOW THESE STEPS IN ORDER TO USE THIS APP PROPERLY:
1. Install docker desktop

2. Pull the image by typing: "docker pull avivjan1234/inventory_rest_api:firstimage" in the terminal/command prompt

3. Run by typing: "docker run -itd -p 8080:8080 avivjan1234/inventory_rest_api:firstimage" in the terminal/command prompt

4. In your browser go to : "http://localhost:8080/h2-console" 

5. Log in using these details:
              
              
                Saved settings = Generic H2 (Embedded)
              
                Setting name = Generic H2 (Embedded)
                
                Driver class = org.h2.Driver
                
                JDBC URL = jdbc:h2:file:~/data/demo
                
                User Name = sa
                
                Password = password
             

6. Run this command :
```
    CREATE TABLE IF NOT EXISTS ITEM
    (
        item_no LONG AUTO_INCREMENT PRIMARY KEY,
        name TEXT NOT NULL,
        amount INT NOT NULL,
        inventory_code LONG DEFAULT NULL
    )
```
 
   

7. In your browser go to : "http://localhost:8080/swagger-ui.html" 



Now You can use the app from swagger.
#GOOD LUCK!




                
