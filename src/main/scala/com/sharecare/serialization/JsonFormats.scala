package com.sharecare.serialization

import com.sharecare.error.RealAgeError
import play.api.libs.json.{Format, Json}

object JsonFormats {

  implicit val RealAgeError_JsonFormat  = Json.format[RealAgeError]
}
