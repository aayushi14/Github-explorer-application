# Github-explorer-application
Search JavaScript and PHP repositories in Github 

Steps to run (Windows OS):
Clone the repository

cd into the server folder:
$ cd server
$ java -jar target\demo-0.0.1-SNAPSHOT.jar

cd into the client folder:
$ cd client
$ npm install
$ npm start
Open in browser[ http://localhost:8081 ]

Default username and password to log in the application:
Username: user
Password: user123

API endpoints:
Open in browser (for example strings "cup" or "react ")
[ http://localhost:9000/api/repositories?q=cup ]
[ http://localhost:9000/api/repositories?q=react ]
