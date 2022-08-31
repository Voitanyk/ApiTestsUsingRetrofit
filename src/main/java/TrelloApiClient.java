import retrofit2.Call;
import retrofit2.http.*;

    public interface TrelloApiClient {

        @POST("1/boards/")
        Call<Board> createNewBoard(@Query("name") String name, @Query("key") String key, @Query("token") String token);

        @GET("1/boards/{id}")
        Call<Board> checkMyBoardInfo(@Path("id") String id, @Query("name") String name, @Query("key") String key, @Query("token") String token);

        @PUT("1/boards/{id}")
        Call<Board> updateMyBoardInfo(@Path("id") String id, @Query("name") String name, @Query("key") String key, @Query("token") String token);

        @DELETE("1/boards/{id}")
        Call<Board> deleteMyBoard(@Path("id") String id, @Query("name") String name, @Query("key") String key, @Query("token") String token);

    }

