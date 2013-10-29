package support

import org.scalatest.matchers.{MatchResult, Matcher}
import org.scalatest.exceptions.TestPendingException
import java.net.URL
import scala.util.{Success, Try, Failure}
import org.scalatest.{FunSuiteLike, Tag}


trait ScalakursSupport extends FunSuiteLike {

  def ____ : Matcher[Any] = {
    throw new TestPendingException
  }

  def checkImplemented[R](block: => R): R = {
    try {
      block
    } catch {
      case e : scala.NotImplementedError => fail(e)
    }
  }

  protected override def test(testName: String, testTags: Tag*)(testFun: => Unit) {
    super.test(testName, testTags: _*) {
      checkImplemented(testFun)
    }
  }

  class URLFailureMatcher(right: Failure[URL]) extends Matcher[Try[URL]] {

    def apply(left: Try[URL]) = {

      val sameFailureMessage = left match {
        case f: Failure[_] => f.exception.getMessage == right.exception.getMessage
        case s: Success[_] => false
      }

      val failureMessageSuffix =
        left + "wasn't equal to" + right

      val negatedFailureMessageSuffix =
        left + "was equal to" + right

      MatchResult(
        sameFailureMessage,
        "The " + failureMessageSuffix,
        "The " + negatedFailureMessageSuffix,
        "the " + failureMessageSuffix,
        "the " + negatedFailureMessageSuffix
      )
    }
  }

  def hasSameExceptionMessage(right: Failure[URL]) = new URLFailureMatcher(right)

}
