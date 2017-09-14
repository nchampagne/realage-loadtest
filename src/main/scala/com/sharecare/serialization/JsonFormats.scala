package com.sharecare.serialization

import com.sharecare.error.RealAgeError
import com.sharecare.realage.PageOfAnswers.PageOfAnswers
import com.sharecare.realage.{Answer, Page, Question}
import play.api.libs.json.Json

object JsonFormats {

  implicit val RealAgeError_JsonFormat  = Json.format[RealAgeError]

  implicit val Answer_JsonFormat        = Json.format[Answer]

  implicit val Question_JsonFormat      = Json.format[Question]

  implicit val Page_JsonFormat          = Json.format[Page]

//  implicit val FactEntry_JsonFormat     = Json.format[FactEntry]

//  implicit val PageOfAnswers_JsonFormat = Json.format[PageOfAnswers]
}
