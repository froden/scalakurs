package support

import org.scalatest.matchers.{MatchResult, Matcher}
import org.scalatest.exceptions.TestPendingException
import java.net.URL
import scala.util.{Success, Try, Failure}


trait ScalakursSupport {

  def __ : Matcher[Any] = {
    throw new TestPendingException
  }

  protected class ___ extends Exception {
    override def toString = "___"
  }

  def *** : Try[URL] = {
    new Failure(new Throwable)
  }

  def _t_ = new Throwable

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
  def replaceWithImplementation = throw new TestPendingException

}
