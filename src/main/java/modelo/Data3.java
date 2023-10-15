package modelo;

import java.util.List;
@lombok.Data
public class Data3 {
	private String total;
	private String offset;
	private String limit;
	private String count;
	private List<Series> results;


}