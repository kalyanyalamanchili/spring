Path Finder application

This app determines if two cities are connected. Two cities are connected if there's a series of roads that can be travelled from one city to another.

List of roads is given as input from a file. File contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

It will be deployed as a spring-boot app and expose one endpoint:
http://localhost:8080/connected?origin=city1&destination=city2

This program responds with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2.
Any unexpected input results in a ’no’ response.

Example:
city.txt content is:

Boston, New York

Philadelphia, Newark

Newark, Boston

Trenton, Albany


http://localhost:8080/connected?origin=Boston&destination=Newark
Should return yes


http://localhost:8080/connected?origin=Boston&destination=Philadelphia
Should return yes


http://localhost:8080/connected?origin=Philadelphia&destination=Albany
Should return no


Swagger Url: http://localhost:8080/swagger-ui.html

