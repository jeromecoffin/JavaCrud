package javaCrud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class MovieServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		String title = requestUrl.substring("/firstlab/movie/".length());
				
		Movie movie = DataStore.getInstance().getMovie(title);
				
		if(movie != null){
			String json = "{\n";
			json += "\"id\": " + JSONObject.quote(Integer.toString(movie.getId())) + ",\n";
			json += "\"title\": " + JSONObject.quote(movie.getTitle()) + ",\n";
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//That movie wasn't found, so return an empty JSON object.
			response.getOutputStream().println("{}");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		
		DataStore.getInstance().putMovie(new Movie(id, title));
	}
}