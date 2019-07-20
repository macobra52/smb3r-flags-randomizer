
public class flagRater {
	
	public static void main(String[] args) {
		
		FlagsGUI gui = new FlagsGUI();
		String flags = gui.generateFlags(false, false);	//includePermanent, includeOhko
		System.out.println(flags);
	}
}
