package com.sharecare.http

import java.util.concurrent.TimeUnit

import akka.actor.{ActorSystem, Terminated}
import akka.stream.ActorMaterializer
import com.sharecare.error.RealAgeError
import play.api.libs.json.{Format, JsValue, Json}
import play.api.libs.ws.ahc.StandaloneAhcWSClient

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.JsonBodyWritables._
import play.api.libs.ws.StandaloneWSRequest

object Http {

  implicit lazy val system        = ActorSystem()
  implicit lazy val materializer  = ActorMaterializer()

  private lazy val wsClient       = StandaloneAhcWSClient()

  def GET[T](url: String, headers: (String, String)*)(implicit f: Format[T], ec: ExecutionContext): Future[Either[RealAgeError, Option[T]]] = {
    wsClient.url(url).withHttpHeaders(headers: _*).get().map(toResponse(_))
  }

  def POST[A, B](body: A, url: String, headers: (String, String)*)(implicit f0: Format[A], f1: Format[B], ec: ExecutionContext) = {
    wsClient.url(url).withHttpHeaders(headers: _*).post(Json.toJson(body)).map(toResponse[B](_))
  }

  def close(): Terminated = {
    wsClient.close()
    Await.result(system.terminate(), Duration(10, TimeUnit.SECONDS))
  }

  // TODO - Move to implicit class
  private def toResponse[T](response:  StandaloneWSRequest#Response)(implicit f: Format[T]): Either[RealAgeError, Option[T]] = {
    import com.sharecare.serialization.JsonFormats.RealAgeError_JsonFormat
    response.status match {
      case 200  => Right(response.body[JsValue].asOpt[T])
      case _    => Left(response.body[JsValue].as[RealAgeError])
    }
  }
}
