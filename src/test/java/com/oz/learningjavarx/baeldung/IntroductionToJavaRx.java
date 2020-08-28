package com.oz.learningjavarx.baeldung;

import org.junit.Test;
import rx.Observable;

import static org.junit.Assert.assertEquals;

public class IntroductionToJavaRx {

  private String result = "";
  private String resultTwo = "";

  @Test
  public void testMethodsOfObservable() {
    String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
    Observable<String> observable = Observable.from(letters);
    observable.subscribe(
        i -> result += i,  //OnNext
        Throwable::printStackTrace, //OnError
        () -> result += "_Completed" //OnCompleted
    );
    observable.subscribe(
        i -> resultTwo += i,  //OnNext
        Throwable::printStackTrace, //OnError
        () -> resultTwo += "_Completed2" //OnCompleted
    );
    assertEquals("abcdefg_Completed", result);
    assertEquals("abcdefg_Completed2", resultTwo);
  }
}
