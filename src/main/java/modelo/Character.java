package modelo;

import lombok.Data;

import java.util.List;
@Data
public class Character {
	private Thumbnail thumbnail;
	private List<UrlsItem> urls;
	private Stories stories;
	private Series2 series2;
	private Comics comics;
	private String name;
	private String description;
	private String modified;
	private int id;
	private String resourceURI;
	private Events events;
}