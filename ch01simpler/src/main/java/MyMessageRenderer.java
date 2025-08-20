@Named
public class MessageRenderer {
	String message;
	public void setMessage(String message) {
		this.message = message;
	}
	public void renderMessage() {
		System.out.println(message);
	}
}
