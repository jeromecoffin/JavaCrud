package javaCrud;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

	private Map<String, Movie> movieMap = new HashMap<>();
	
	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}

	private DataStore(){
		movieMap.put("ForrestGump", new Movie(1, "ForrestGump"));
		movieMap.put("SpiritedAway", new Movie(2, "SpiritedAway"));
		movieMap.put("NoCountryforOldMen", new Movie(3, "NoCountryforOldMen"));
	}

	public Movie getMovie(String title) {
		return movieMap.get(title);
	}
	
	public Movie getMovieId(String id) {
		return movieMap.get(id);
	}

	public void putMovie(Movie movie) {
		movieMap.put(movie.getTitle(), movie);
	}
}