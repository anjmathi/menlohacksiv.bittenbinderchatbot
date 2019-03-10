
public class Witness {

	private String name;

	public Witness(String name) {
		this.name = name;
	}

	//what did the suspect look like?
	public String look() {

		return "I don't know, I was sitting on the bench";
	}

	//what did he sound like?
   public String sound() {

		return "Well, I was sitting on the bench!";
	}

    //where were you?
    public String location() {

		return "Shut up, I was on the bench.";
	}

    //what else do you know?
    public String what() {

		return "Well if you must know... I was on the bench...";
	}

}
