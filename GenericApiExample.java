package generics;

class ApiResponse<T> {
	public ApiResponse(boolean seccess, String message, T data) {

		this.seccess = seccess;
		this.message = message;
		this.data = data;
	}

	private boolean seccess;
	private String message;
	private T data;

	public void showResponse() {
		System.out.println("✅ Success: " + seccess);
		System.out.println("📩 Message: " + message);
		System.out.println("📦 Data: " + data);
	}
}

class User {
	String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return "User:" + name;
	}
}

class Product {
	String title;

	public Product(String title) {
		super();
		this.title = title;
	}

	public String toString() {
		return "Product: " + title;
	}

}

public class GenericApiExample {
	public static void main(String[] args) {
		ApiResponse<User> userResponse = new ApiResponse<>(true, "\"User fetched successfully\"", new User("Chirayu"));

		ApiResponse<Product> productResponse = new ApiResponse<>(true, "\"Product fetched successfully\"",
				new Product("Leptop"));

		userResponse.showResponse();
		System.out.println("------------------------------------");
		productResponse.showResponse();
	}

}
