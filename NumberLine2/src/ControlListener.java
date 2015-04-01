
public interface ControlListener {

	public static final int CIRCLE = 0;
	public static final int SQUARE = 1;
	public static final int TRIANGLE = 2;
	
	void setFont(boolean bold, boolean italics, boolean underlined);
	void setShape(int shape);
	void setNumber(double num);
	
	
}