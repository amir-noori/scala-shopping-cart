import io.estatico.newtype.macros.newtype

import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.collection.Contains
import eu.timepit.refined.types.string.NonEmptyString

object Types {

  type EmailString = String Refined Contains['@']

  @newtype case class Username(value: NonEmptyString)

  @newtype case class Email(value: EmailString)

  case class User(username: Username, email: Email)

  
  def testTypes(): Unit = {
    val username = Username("admin")
    val email = Email("test@test.com")

    (username, email) match {
      case (u, e) => println(s"$u, $e")
    }

    lookup(username) match {
      case user: User => println(s"user = ${user.username}, ${user.email}")
      case _ => println("user not found")
    }

  }

  def lookup(user: Username): User = {
    User(user, Email("default@test.com"))
  }


}

