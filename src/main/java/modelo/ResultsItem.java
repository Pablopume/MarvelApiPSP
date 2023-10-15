package modelo;

import lombok.Data;

import java.util.List;
@Data
public class ResultsItem{
	private Creators creators;
	private String issueNumber;
	private String isbn;
	private String description;
	private List<VariantsItem> variants;
	private String title;
	private String diamondCode;
	private Characters characters;
	private List<UrlsItem> urls;
	private String ean;
	private List<CollectionsItem> collections;
	private String modified;
	private String id;
	private List<PricesItem> prices;
	private Events events;
	private List<CollectedIssuesItem> collectedIssues;
	private String pageCount;
	private Thumbnail thumbnail;
	private List<ImagesItem> images;
	private Stories stories;
	private List<TextObjectsItem> textObjects;
	private String digitalId;
	private String format;
	private String upc;
	private List<DatesItem> dates;
	private String resourceURI;
	private String variantDescription;
	private String isnn;
	private Series2 series2;
}