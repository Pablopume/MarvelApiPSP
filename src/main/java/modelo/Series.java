package modelo;

import lombok.Data;

import java.util.List;
@Data
public class Series {
	private Next next;
	private Thumbnail thumbnail;
	private Stories stories;
	private Previous previous;
	private Creators creators;
	private Comics comics;
	private String startYear;
	private String rating;
	private String description;
	private String resourceURI;
	private String title;
	private String endYear;
	private Characters characters;
	private List<UrlsItem> urls;
	private String modified;
	private String id;
	private Events events;

}