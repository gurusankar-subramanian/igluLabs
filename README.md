# springboot-jwt
## An Spring Boot Application for Securing a REST API with JSON Web Token (JWT)
 
### Basic pieces of information:

 * client: testjwtclientid
 * secret: XY7kmzoNzl100
 * Non-admin username and password: user and jwtpass
 * Admin user: user and jwtpass 
 
 1. Generate an access token
 
   For this specific application, to generate an access token for the non-admin user john.doe, run:
   `$ curl testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=jwtpass`
    You'll receive a response similar to below

    `
    {
      "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0MjgyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIwYmQ4ZTQ1MC03ZjVjLTQ5ZjMtOTFmMC01Nzc1YjdiY2MwMGYiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.rvEAa4dIz8hT8uxzfjkEJKG982Ree5PdUW17KtFyeec",
      "token_type": "bearer",
      "expires_in": 43199,
      "scope": "read write",
      "jti": "0bd8e450-7f5c-49f3-91f0-5775b7bcc00f"
    }`

 2. Use the token to access resources through the other RESTful API's    
