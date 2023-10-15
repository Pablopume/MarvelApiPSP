package modelo;

import java.util.List;
@lombok.Data
public class Data{
	private int total;
	private int offset;
	private int limit;
	private int count;
	private List<Character> results;

}