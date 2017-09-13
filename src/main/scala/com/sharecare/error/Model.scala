package com.sharecare.error

/*
{
    "responseStatus": "FAILURE",
    "errors": [
        "Authentication Failed: Invalid credential"
    ],
    "errorCode": 401
}
 */
final case class RealAgeError(responseStatus: String, errors: List[String], errorCode: Int)
