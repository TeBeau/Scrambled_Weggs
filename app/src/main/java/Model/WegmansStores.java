package Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.LinkedList;

public interface WegmansStores {
    @Headers({
            "Cache-Control", "no-cache"
    })
    @Headers({
            "Cache-Control", "no-cache"
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })
    @GET("/stores/?api-version=2018-10-18")
    Call<LinkedList<Store>> wegmans_stores();
}
