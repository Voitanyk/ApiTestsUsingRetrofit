import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ApiTests extends BaseClass{
    ObjectMapper objectMapper = new ObjectMapper();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseClass.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    TrelloApiClient trelloApiTests = retrofit.create(TrelloApiClient.class);
    String boardId;


    @BeforeMethod
    public void createBoardTest() throws IOException {
        Response<Board> response = trelloApiTests.createNewBoard(name, key, token).execute();
        boardId = response.body().id;
        int actualStatus = response.code();
    Assert.assertEquals(actualStatus,200);
}
    @AfterMethod
    public void deleteBoardTest() throws IOException {
    int actualStatus = trelloApiTests.deleteMyBoard(boardId, name, key, token).execute().code();
    Assert.assertEquals(actualStatus,200);
}

    @Test
    public void updateBoardTest() throws IOException {
        Board expectedBoard = new Board(boardId,"NewName", key, token);
        String boardInfo = trelloApiTests.updateMyBoardInfo(boardId, "NewName", key, token).execute().body().toString();
        Board actualBoard = objectMapper.readValue(boardInfo, Board.class);
        Assert.assertEquals(actualBoard,expectedBoard);

    }
    @Test
    public void checkBoardInfoTest() throws IOException {
        Board expectedBoard = new Board(boardId, name, key, token);
        String boardInfo = trelloApiTests.checkMyBoardInfo(boardId, name, key, token).execute().body().toString();
        Board actualBoard = objectMapper.readValue(boardInfo, Board.class);
        Assert.assertEquals(actualBoard,expectedBoard);
    }
}
