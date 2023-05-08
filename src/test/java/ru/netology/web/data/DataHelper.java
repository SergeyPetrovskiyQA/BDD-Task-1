package ru.netology.web.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
  private DataHelper() {}

  public static AuthInfo getAuthInfo() {

    return new AuthInfo("vasya", "qwerty123");
  }
  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

    return new VerificationCode("12345");
  }

  public static CardInfo getFirstCard() {
    return new CardInfo ("5559 0000 0000 0001","92df3f1c-a033-48e6-8390-206f6b1f56c0");
  }
  public static CardInfo getSecondCard() {
    return new CardInfo ("5559 0000 0000 0002","0f3f5c2a-249e-4c3d-8287-09f7a039391d");
  }

  public static int generateValidAmount(int balance){
      return new Random().nextInt(balance) + 1;
  }
   public static int generateInvalidAmount(int balance) {
    return Math.abs(balance) + new Random().nextInt(1000);
   }
  public static AuthInfo getOtherAuthInfo() {

    return new AuthInfo("petya", "123qwerty");
  }
  @Value
  public static class AuthInfo {
    private String login;
    private String password;

  }
  @Value
  public static class CardInfo {
    private String number;
    private String testId;
  }
  @Value
  public static class VerificationCode {
    private String code;
  }

}