package aims.screen.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.LimitExceededException;

import aims.cart.Cart;
import aims.media.DigitalVideoDisc;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.screen.customer.controller.CartController;
import aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCart extends Application{
	private static Cart cart;
	private static Store store;
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String CART_FXML_FILE_PATH = "/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController cartController = new CartController(cart,store);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
	
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) {
		cart = new Cart();
		store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Action", 19.99f, 136, "Wachowski Brothers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Inception", "Sci-Fi", 24.99f, 148, "Christopher Nolan");
	    CompactDisc cd1 = new CompactDisc(1, "Thriller", "Pop", 14.99f, 42, "Michael Jackson", "Various Artists");
	    CompactDisc cd2 = new CompactDisc(2, "Abbey Road", "Rock", 18.99f, 47, "The Beatles", "The Beatles");
	    ArrayList<String> authors1 = (ArrayList<String>) Arrays.asList("J.K. Rowling","J.K.K Rowling");
	    Book book1 = new Book(1, "Harry Potter and the Sorcerer's Stone", "Fantasy", 29.99f, authors1);
	    ArrayList<String> authors2 = (ArrayList<String>) Arrays.asList("George Orwell", "Joseph Stalin");
	    Book book2 = new Book(2, "1984", "Dystopian", 19.99f, authors2);
	    try {
		    cart.addMedia(book2);
		    cart.addMedia(book1);
		    cart.addMedia(cd1);
		    cart.addMedia(cd2);
		    cart.addMedia(dvd1);
		    cart.addMedia(dvd2);
		} catch (LimitExceededException e) {
			e.getStackTrace();
		}
		launch(args);
	}
}
