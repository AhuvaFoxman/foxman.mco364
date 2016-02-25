package foxman.toDo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoServiceTest {

	@Test
	public void testListToDos() throws IOException {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://jsonplaceholder.typicode.com")
				.addConverterFactory(GsonConverterFactory.create()).build();

		ToDoService service = retrofit.create(ToDoService.class);

		Call<List<Todo>> call = service.listTodos();
		Response<List<Todo>> response = call.execute();// returns a response of
														// listTodo
		// can do two things with a call object
		// execute-doing something
		// enqueue- adding to it

		List<Todo> list = response.body();
		Assert.assertEquals(200, list.size());
	}

}
