import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class FlagsGUI {

	private JFrame frmSmbrFlagsRandomizer;
	private JTextField textField;
	private final JLabel lblCopiedToClipboard = new JLabel("Copied to Clipboard!");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlagsGUI window = new FlagsGUI();
					window.frmSmbrFlagsRandomizer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FlagsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSmbrFlagsRandomizer = new JFrame();
		frmSmbrFlagsRandomizer.setTitle("SMB3R Flags Randomizer 1.1");
		frmSmbrFlagsRandomizer.setBounds(100, 100, 426, 301);
		frmSmbrFlagsRandomizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSmbrFlagsRandomizer.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea txtrFlagsRandomizerBy = new JTextArea();
		txtrFlagsRandomizerBy.setBounds(10, 11, 390, 112);
		txtrFlagsRandomizerBy.setEditable(false);
		txtrFlagsRandomizerBy.setText("SMB3R Flags Randomizer by MaCobra52\r\n1. Click 'Surprise Me!' to produce a random SMB3R flagset.\r\n2. Paste the flagset into Fred's SMB3 Randomizer. (no peeking!)\r\n3. Click Generate and Play!\r\n\r\nSee Readme for full details on implementation. Enjoy!");
		panel.add(txtrFlagsRandomizerBy);
		
		JCheckBox chckbxIncludePermanentMario = new JCheckBox("Include chance for Permanent Mario");
		chckbxIncludePermanentMario.setSelected(true);
		chckbxIncludePermanentMario.setBounds(20, 130, 258, 23);
		panel.add(chckbxIncludePermanentMario);
		
		JCheckBox chckbxIncludeChanceFor = new JCheckBox("Include chance for OHKO Mode");
		chckbxIncludeChanceFor.setBounds(20, 156, 258, 23);
		panel.add(chckbxIncludeChanceFor);
		
		JButton btnNewButton = new JButton("Surprise Me!");
		btnNewButton.setBounds(10, 192, 129, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = generateFlags(chckbxIncludePermanentMario.isSelected(), chckbxIncludeChanceFor.isSelected());
				textField.setText(s);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(new StringSelection(s), null);
				lblCopiedToClipboard.setVisible(true);
			}
		});
		
		JLabel lblYourFlagsAre = new JLabel("Your Flags Are:");
		lblYourFlagsAre.setBounds(149, 196, 83, 15);
		lblYourFlagsAre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblYourFlagsAre);
		
		textField = new JTextField();
		textField.setBounds(241, 194, 129, 20);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		lblCopiedToClipboard.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCopiedToClipboard.setForeground(new Color(0, 255, 0));
		lblCopiedToClipboard.setBounds(131, 230, 134, 14);
		lblCopiedToClipboard.setVisible(false);
		
		panel.add(lblCopiedToClipboard);
	}
	
	public String generateFlags(boolean includePermanent, boolean includeOhko) {
		
		//Name, Flags, Weight, Enabled Chance
		Flags[] flags = new Flags[26];
		flags[0] = new Flags("Shuffle Regular Stages", "SG", 3, 75);
		flags[1] = new Flags("Add Lost Levels", "1", 1, 75);
		flags[2] = new Flags("Shuffle Fortresses", "74", 2, 75);
		flags[3] = new Flags("Shuffle World 8 Ships", "2HWCG", 2, 50);
		flags[4] = new Flags("Shuffle Castles", "E8", 2, 50);
		flags[5] = new Flags("Random Hammer Bros Levels", "9ZLDS", 2, 50);
		flags[6] = new Flags("Shuffle World Locations", "JZ6RK0", 4, 75);
		flags[7] = new Flags("Level Appearance", "27WR280", 3, 50);	//?'s minus forts - 27WR280, Hands minus forts - 4FTI4G0,
		flags[8] = new Flags("Change Forts as Well", "6NQ96O0", 2, 75);
		
		flags[9] = new Flags("Shuffle Overworld Pipes", "1EKG", 2, 50);
		flags[10] = new Flags("Shuffle World Order", "5M9S", 3, 75);
		flags[11] = new Flags("Make Levels Frog Friendly", "JZ6RK", 1, 50);
		
		flags[12] = new Flags("Randomize Enemies", "6BK", 3, 75);
		flags[13] = new Flags("Randomize Koopa Earthquakes", "1KW", 1, 75);
		flags[14] = new Flags("Randomize Koopa Kid HP", "2", 2, 50);
		flags[15] = new Flags("Randomize Hammer Bros", "4", 3, 75);
		
		flags[16] = new Flags("Randomize N Game Prizes", "CN4", 2, 50);
		flags[17] = new Flags("Randomize Castle Items", "8", 2, 50);
		flags[18] = new Flags("Randomize Anchor Ability", "MH34", 2, 75);
		flags[19] = new Flags("Randomize Item Blocks", "4ZSOW", 2, 50);
		flags[20] = new Flags("Remove N Game", "13YDJ40", 1, 50);
		flags[21] = new Flags("Shuffle chest Items", "3K", 2, 50);
		flags[22] = new Flags("Shuffle Toad Houses", "W", 2, 50);
		flags[23] = new Flags("Let Hammers Break Locks", "18Y68", 2, 50);
		
		flags[24] = new Flags("One Hit Knockout", "13YDJ4", 1, 25);
		flags[25] = new Flags("Permanent Mario Status", "0", 2, 50);
		
		//Minimum score to be valid
		final int totalScore = getTotal(flags, includePermanent, includeOhko);
		final int minScore = (int) totalScore * 3/5;
		String flagsString = null;
		
		System.out.println("totalScore: " + totalScore);
		System.out.println("minScore: " + minScore);
		System.out.println();
		
		int score = getTotalEnabled(flags);
		//System.out.println("score: " + score);
		
		int attempts = 1;
		
		while(score <= minScore) {
			flags = generateFlags(flags, includePermanent, includeOhko);
			score = getTotalEnabled(flags);
			
			for(Flags flag : flags) {
				System.out.println(flag);
			}
			
			flagsString = calcFlags(flags);
			System.out.println("Flags: " + flagsString);
			System.out.println("Flags Score: " + score);
			System.out.println();
			
			if(score <= minScore) {
				resetFlags(flags);
				++attempts;
			}
		}
		
		System.out.println("Total attempts: " + attempts);
		
		return flagsString;
	}
	
	public static Flags[] generateFlags(Flags[] flags, boolean includePermanent, boolean includeOhko) {
		
		for(Flags flag : flags) {
			//Shuffle Regular Stages must be enabled to toggle Add Lost Levels
			if(flag.getName().equals("Add Lost Levels")) {
				if(! flags[0].isEnabled())
					flag.setEnabled(false);
				else
					flag.rollEnabled();
			}
			
			//Shuffle Regular Stages must be enabled to toggle Shuffle Fortresses (possible bug. may be fixed later)
			else if(flag.getName().equals("Shuffle Fortresses")) {
				if(! flags[0].isEnabled())
					flag.setEnabled(false);
				else
					flag.rollEnabled();
			}
			
			//Shuffle Regular Stages or Shuffle Fortresses must be enabled to toggle Shuffle World 8 Ships
			else if(flag.getName().equals("Shuffle World 8 Ships")) {
				if (! flags[0].isEnabled() && ! flags[2].isEnabled())
					flag.setEnabled(false);
				else
					flag.rollEnabled();
			}
			
			//Decide how Level Appearance is changed if enabled
			else if(flag.getName().equals("Level Appearance")) {
				flag.rollEnabled();
				if(flag.isEnabled())
					flag.rollLevelAppearanceChoice();
			}
			
			//Level Appearance must be enabled to include forts
			else if(flag.getName().equals("Change Forts as Well")) {
				if(! flags[7].isEnabled())
					flag.setEnabled(false);
				else
					flag.rollEnabled();
			}
			
			//Roll One Hit Knockout only if Selected
			else if(flag.getName().equals("One Hit Knockout") && ! includeOhko)
				continue;
				
			//Decide which Permanent Mario is selected if Selected and Enabled
			else if(flag.getName().equals("Permanent Mario Status")) {
				if(! includePermanent)
					continue;
				else {
					flag.rollEnabled();
					if(flag.isEnabled()) {
						flag.rollPermanentChoice();
						////Forces frog friendly to true if needed
						if(flag.getChoice().equals("Big Mario") || flag.getChoice().equals("Fire Mario") || flag.getChoice().equals("Frog Mario") || flag.getChoice().equals("Hammer Mario"))
						flags[11].setEnabled(true);
					}
				}
			}
			
			else
				flag.rollEnabled();
		}
		
		return flags;
	}
	
	public static int getTotal(Flags[] flags, boolean includePermanent, boolean includeOhko) {
		int total = 0;
		
		for(Flags flag : flags) {
			total += flag.getRating();
		}
		
		if(! includePermanent)
			total -= 2;
		if(! includeOhko)
			total -= 1;
		
		return total;
	}
	
	public static int getTotalEnabled(Flags[] flags) {
		int total = 0;
		
		for(Flags flag : flags) {
			if(flag.isEnabled()) {
				//If flag is remove N cards, invalidate Random N game prizes
				if(flag.getName().equals("Remove N Game") && flags[16].isEnabled())
					total -= 2;
				total += flag.getRating();
			}
		}
		
		return total;
	}
	
	public static void resetFlags(Flags[] flags) {
		//Reset Level Appearance choice
		flags[7].setChoice("");
		//Reset Permanent Mario choice
		flags[25].setChoice("");
	}
	
	public static String calcFlags (Flags[] flags) {
		String baseFlags = "E4W0";
		long value = Long.valueOf(baseFlags, 36);
		
		for(Flags flag : flags) {
			if(flag.isEnabled()) {
				value += Long.valueOf(flag.getValue(), 36);
			}
		}
		
		String flag = Long.toString(value, 36).toUpperCase();
		return flag.replace("O", "!");
	}
}
