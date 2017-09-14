package com.sharecare.domain

/*
{
  "firstName": "SSO",
  "lastName": "Test",
  "email": "ssotestuser_{{$timestamp}}@mailinator.com",
  "password": "p@ssw0rd",
  "gender": "MALE",
  "dateOfBirth": 101019600000,
  "height": 1.6764,
  "weight": 81.19303,
  "country": "United States",
  "postalCode": "30305",
  "phoneNumber": "7706396616",
  "rememberMe": false,
  "admin": false,
}
 */
final case class UserCreationRequest(firstName: String,
                                     lastName: String,
                                     email: String,
                                     password: String,
                                     dateOfBirth: Long,
                                     height: Float,
                                     weight: Float,
                                     country: String,
                                     postalCode: String,
                                     phoneNumber: String,
                                     rememberMe: Boolean)

/*
{
    "username":"{{user_email}}",
    "password":"{{user_password}}"
}
 */
final case class LoginRequest(username: String, password: String)

/*
{
    "access_token": "4qvkyqjRfF91eZHuCC5JwXwQUwL1wreU7X7rReKUdjE5QvF9sGE1wt3PAk6_9ZPWDkI9V-BNiRSAcxHMgDwCu3tBhUh_c069PrAHUNU8SFlWwLQvhuRIXijFJtKYI6T_JaSSltkxGQbnBIBxPABQPV82jrXJl5liTj83cyWGto5vYXfim9gOK26NSBlOl1jFlYt_mGfpOiLNWxvaHMY7Y50r7EZYKXV1iExP5JDan4MtAdReGAoKxSjQZKcpDV6RQM8r7LCUMCPH1cOhBQ",
    "token_type": "bearer",
    "expires_in": 3600,
    "refresh_token": "4qvkyqjRfAlyecrsAixJwSoSVwX1wubGv36zSeSSdmJvH_Qu4TM2x9ufUk6_9ZPWDkI9V-BNiRSAcxHMgDwCu3tBhUh_c069PrAHUNU8SFlWwLQvhuRIXijFJtKYI6T_JaSSltkxGQbnBIBxPABQPV82jrXJl5liTj83cyWGto5vYXfimdIPLWqNSBlOl1jFlYt_mGfpOiLNWxvaD8A-dIsrhkhWeGN3gkRE_sbCh8YmAtldFVhH1WneauksCVqMUc4ayqbTKH_A2Ny3HfY",
    "account_id": "4d9228c1-cb32-4433-b611-36c3dadeb8bf"
}
 */
final case class LoginResponse(access_token: String, token_type: String, expires_in: Long, refresh_token: String, account_id: String)

object SSO {

  private val ssoUrl        = "https://auth.stage.sharecare.com"
  private val loginPath     = "/access?grant_type=password"
  private val secureIdPath  = "/access/authorize"

  def createUser(userCreationRequest: UserCreationRequest) = {

  }

  def login(loginRequest: LoginRequest) = {

  }

  def requestSecureId(token: String) = {

  }
}
