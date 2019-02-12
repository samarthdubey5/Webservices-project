# WebService Assignment

## setup: 
    - clone project
    - use maven to build project with pom.xml
    - run as server
    
## Database
    - hosted database online on http://freemysqlhosting.net
    - created classes like
        * Driver (for connection with mysql database)
        * Operation(that contain methods for signup, addComment, readCommentTable, getPassword, readCommentByUser)
        * Main (to debug the above classes by main function)
        
## Webservice
    - created classes such as for endpoints
        * AddComment - POST
        * GetAllComments - GET
        * GetCommentByUser - GET
        * Login - POST
        * SignUp - POST

## Endpoints
    - baseURL/login
    - baseURL/signup
    - baseURL/addcomment
    - baseURL/allcomments
    - baseURL/comments?uemail=