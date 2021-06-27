package com.team03.airbnb.oauth.github;

public class Github {
    private String client_id = "5d8cecb4786f22ad30eb";
    private String client_secret = "57f85e469322dd406098c11cd07158b35ffc23aa";
    private String redirect_uri = "http://15.165.235.96/callback";
    private String access_token = "";

    public String getUrlForAccesToken(String code) {
        return "https://github.com/login/oauth/access_token?&client_id="+client_id+"&client_secret="+client_secret+"&code="+code;
    }

    public String getAccess_token() {
        return access_token;
    }

    @Override
    public String toString() {
        return "Github{" +
                "client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}


// https://github.com/login/oauth/authorize?&client_id=5d8cecb4786f22ad30eb&scope=user&redirect_uri=http://15.165.235.96/callback
