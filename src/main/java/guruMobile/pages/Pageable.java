package guruMobile.pages;

import org.openqa.selenium.WebDriver;

public interface  Pageable<T> {
	T init();
	boolean isSuitable();




}
