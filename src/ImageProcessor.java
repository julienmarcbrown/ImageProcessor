import java.awt.Color;

public class ImageProcessor {
	public static void main(String args[]) {
		bwImage(); // Calling the bwImage method from this class
		overlayImage(); // Calling the overlayImage method from this class
	}
	
	public static void bwImage() {
		// Create a new ImageMap object named im with a file as a parameter to the constructor
		ImageMap im = new ImageMap("bird.jpg");
		// Create a new ColorFilter of type BlackWhiteFilter named cf
		ColorFilter cf = new BlackWhiteFilter();
		// Get the original colors (a 2d array) from the ImageMap im
		Color[][] original = im.getColors();
		// Get the filtered colors from the filter method in the cf object
		// providing the original colors as a parameter
		Color[][] filtered = cf.filter(original);
		// Create a new ImageMap named im2 with the filtered colors as a parameter to the constructor
		ImageMap im2 = new ImageMap(filtered);
		// Write out the contents of im2 using the write method, providing a file name parameter
		im2.write("bird_bw.jpg");
	}
	
	public static void overlayImage()	{
		ImageMap im = new ImageMap("bird.jpg");
		ImageMap overlay = new ImageMap("overlay.jpg");
		OverlayFilter io = new OverlayFilter();
		Color[][] watermarked = io.filter(im.getColors(),overlay.getColors());
		ImageMap waterMap = new ImageMap(watermarked);
		waterMap.write("bird_overlay.jpg");
	}
}
