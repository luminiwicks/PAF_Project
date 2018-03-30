package User;

public class Book {
	private String name,author,category,price;
	private int book_id; 

	

public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

public Book(int book_id, String name, String author, String category, String price) {
		super();
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.book_id = book_id;
	}

public Book(String name, String author,String category,String price) {
	super();
	this.name = name;
	this.author = author;
	this.category = category;
	this.price = price;
}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
