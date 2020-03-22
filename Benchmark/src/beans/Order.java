package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order {
	
	public String book = "";
	public String chapter = "";
	public String verse = "";
	public String content = "";
	
	public Order() {
		
	}
	
	public Order(String book, String chapter, String verse, String content) {
		this.book = book;
		this.chapter = chapter;
		this.verse = verse;
		this.content = content;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getVerse() {
		return verse;
	}

	public void setVerse(String verse) {
		this.verse = verse;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	

}
