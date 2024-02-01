package payloads;

import payloads.model.LoginModel;
import com.google.gson.Gson;

public class LoginPayload {
  public static String toJson(String username, String password){
    LoginModel login = new LoginModel(username, password);
    return new Gson().toJson(login);
  }
}