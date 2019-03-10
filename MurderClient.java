
import java.util.*;

public class MurderClient {

	public static String appearance = "";
	public static String witness = "";
	public static String murder = "";
	public static String notes = "";

	public static void main(String[] args) {

		Witness michelle = new Witness1();
		Witness janelle = new Witness2();
		Witness justin = new Witness3();

// INTRODUCTION
		System.out.println(
				"You, Detective JJ Bittenbinder, are interrogating three key witnesses in the child homicide case of 5 year old Wally Flenderson, whose body was found in an abandoned alleyway. Your investigators have narrowed the suspects down to three key people of interest.");
		System.out.println();
		System.out
				.println("Your goal? Determine which suspect is guilty of the crime. Here is what you know for sure:");
		System.out.println();
		System.out.println("The hard facts of the case: " + "\n  Presumed time of death - 8:30 PM"
				+ "\n          Place of death - Alleyway near the local playground"
				+ "\n          Cause of death - blow to jaw (possibly an uppercut)"
				+ "\n Evidence found on scene - money clip, glass with victim's blood on it, victim's backpack");
		System.out.println();
		//
		System.out.println(
				"You will be able to take notes on your conversations with the witnesses in your notebook. Type \'NOTEBOOK\' to access it.");
		System.out.println(
				"If you feel like your interrogation is going nowhere, type \'RESTART\' to end your current game and restart.");
		System.out.println("    Type \'QUIT\' to end gameplay.");

		System.out.println("Let the questioning begin.");

		Scanner in = new Scanner(System.in);
		String statement = in.nextLine();

		while (!statement.equals("quit")) {
			System.out.println("Choose a witness to question: \'Michelle\', \'Janelle\', or \'Justin\'.");
			String statement1 = in.nextLine().toLowerCase();
			// different pathways for each witness
			if (statement1.equals("Michelle")) {
				resp(michelle);
			} else if (statement1.equals("Janelle")) {
				resp(janelle);
			} else if (statement1.equals("Justin")) {
				resp(justin);
			} else if (statement1.equals("notebook")) {
				notebook();
			}

		}

	}

	public static void resp(Witness o) {
		Scanner in = new Scanner(System.in);
		String ask = in.nextLine();
		while (!ask.equals("QUIT")) {
			System.out.println(parse(ask, o));
			ask = in.nextLine();
		}
		System.out.println("quit");
	}

	public static String parse(String words, Witness o) {
		words = words.trim();

		if (words.equals("")) {
			return "say something";
		}
		// parse for where
		else if (findKeyword(words, "where") > 0) {
			return o.location();
		} else if ((findKeyword(words, "sound") > 0) || (findKeyword(words, "hear") > 0)) {
			return o.sound();
		} else if ((findKeyword(words, "look") > 0) || (findKeyword(words, "see") > 0)) {
			return o.look();
		} else if (findKeyword(words, "NOTEBOOK") > 0) {
			notebook();
			return "****notebook closed****";
		} else {
			return o.what();
		}

	}

	public static int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);
		while (psn >= 0) {
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
			}
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return psn;
			}
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}

	public static int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	public static void notebook() {
		System.out.println("********NOTEBOOK:type quit to close********");
		System.out.println("Appearance: " + appearance);
		System.out.println("Witness info: " + witness);
		System.out.println("Murder details: " + murder);
		System.out.println("Notes: " + notes);
		System.out.println("type category to enter info");
		Scanner in = new Scanner(System.in);
		String nb = in.nextLine().toLowerCase();
		while(!nb.equals("quit")) {
			if (nb.equals("appearance")) {
				appearance += in.nextLine();
			}
			else if (nb.equals("witness info")) {
				witness += in.nextLine();
			}
			else if (nb.equals("murder details")) {
				murder += in.nextLine();
			}
			else if (nb.equals("notes")) {
				notes += in.nextLine();
			}
			nb = in.nextLine();
		}

	}
}
