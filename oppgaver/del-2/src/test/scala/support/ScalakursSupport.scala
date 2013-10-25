package support

import org.scalatest.matchers.Matcher
import org.scalatest.exceptions.TestPendingException


trait ScalakursSupport {

  def  __ : Matcher[Any] = {
    throw new TestPendingException
  }

  protected class ___ extends Exception {
    override def toString = "___"
  }

}
