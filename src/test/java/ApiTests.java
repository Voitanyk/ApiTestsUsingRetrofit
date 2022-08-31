import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitClient {
    ObjectMapper objectMapper = new ObjectMapper();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseClass.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TrelloApi trelloApiTests = retrofit.create(TrelloApi.class);
    String boardId;
    //  Call<Board> call = trelloApiTests.checkMyBoardInfo(BaseClass.name, BaseClass.key, BaseClass.token);
    //Response<Board> response = call. execute();


    public RetrofitClient() throws IOException {
    }


    @BeforeMethod
    public void createBoard() throws IOException {
  //  Response responses = trelloApiTests.createNewBoard(BaseClass.name, BaseClass.key, BaseClass.token).execute();
   // int actualStatus = responses.code();
        Response<Board> response = trelloApiTests.createNewBoard(BaseClass.name, BaseClass.key, BaseClass.token).execute();
       // Response<Board> response = call.execute();
        boardId = response.body().id;
        int actualStatus = response.code();
      // Board actualBoard = objectMapper.readValue(board, Board.class);
     //  boardId = actualBoard.getId();
    Assert.assertEquals(actualStatus,200);
}
@AfterMethod
public void deleteBoard() throws IOException {
   /* Call<Board> call = trelloApiTests.deleteMyBoard(boardId, BaseClass.name, BaseClass.key, BaseClass.token);
    Response<Board> response = call.execute();
    String board = response.toString();
    Board actualBoard = objectMapper.readValue(board, Board.class);
    int actualStatus = response.code();*/
    Response response = trelloApiTests.deleteMyBoard(boardId, BaseClass.name, BaseClass.key, BaseClass.token).execute();
    int actualStatus = response.code();
    Assert.assertEquals(actualStatus,200);
}

    @Test
    public void updateBoard() throws IOException {
        Board expectedBoard = new Board(boardId,"NewName", BaseClass.key, BaseClass.token);
        Response<Board> response = trelloApiTests.updateMyBoardInfo(boardId, "NewName", BaseClass.key, BaseClass.token).execute();
        String boardInfo = response.body().toString();
        Board actualBoard = objectMapper.readValue(boardInfo, Board.class);
        Assert.assertEquals(actualBoard,expectedBoard);

    }
    @Test
    public void checkBoardInfo() throws IOException {
        Board expectedBoard = new Board(boardId, BaseClass.name, BaseClass.key, BaseClass.token);
        Response<Board> response = trelloApiTests.checkMyBoardInfo(boardId, BaseClass.name, BaseClass.key, BaseClass.token).execute();
        String boardInfo = response.body().toString();
        Board actualBoard = objectMapper.readValue(boardInfo, Board.class);
        Assert.assertEquals(actualBoard,expectedBoard);
    }




}
