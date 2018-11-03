package com.employee.app.Employee.app.service.interfaces;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserByLoginRequest {

    @Headers({"Content-Type: application/json"})
    @GET("/info_by_login")
    Call<UserByLoginRequest.UserInfo> userByLogin(@Query("login") String login);

    public class UserInfo {
        @SerializedName("error")
        @Expose
        private String error;
        @SerializedName("access_rights_id")
        @Expose
        private int accessRightsId;
        @SerializedName("login")
        @Expose
        private String login;
        @SerializedName("password_hash")
        @Expose
        private String passwordHash;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public int getAccessRightsId() {
            return accessRightsId;
        }

        public void setAccessRightsId(int accessRightsId) {
            this.accessRightsId = accessRightsId;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPasswordHash() {
            return passwordHash;
        }

        public void setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
        }
    }
}