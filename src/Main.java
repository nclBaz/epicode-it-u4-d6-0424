public class Main {
	public static void main(String[] args) {
		// --------------------------------------- ERRORS -----------------------------------------------
		// Gli errori, come lo StackOverflowError sono dei problemi irrecuperabili a livello di gestione errori.
		// Nel senso che non si può scrivere semplicemente del codice che li gestica, se c'è un problema di questo
		// genere bisogna intervenire proprio modificando il codice (oppure in casi più gravi se c'è un problema hw,
		// fixare il problema prima di eseguire il codice)
		print("Hello world!");

		// --------------------------------------- ECCEZIONI UNCHECKED -----------------------------------------------
		// Sono eccezioni che NON ci costringono a doverle gestire (tipo con un try-catch). Invece queste sono problematiche
		// solitamente prevenibili con qualche accorgimento e controllo in più (ad esempio un qualche if(...) )

		int[] numbers = {1, 2, 3, 4, 5};
		int index = -5;
		if (index > 4 || index < 0) System.out.println("Numero inserito non valido");
		else System.out.println(numbers[index]); // ArrayIndexOutOfBoundsException

		System.out.println("Caro utente dammi un numero");
		String input = "Un numero";
		/*	System.out.println(Integer.parseInt(input)); // NumberFormatException*/

		String str = "sapodpksdop";
		str = null;
		if (str != null) System.out.println(str.length()); // NullPointerException

		int num1 = 5;
		int num2 = 0;

		if (num2 != 0) System.out.println(num1 / num2); // ArithmeticException
		else System.out.println("Non si può dividere per zero");


		// --------------------------------------- ECCEZIONI CHECKED -----------------------------------------------
		// Questo tipo di eccezioni ci obbliga a doverle gestire se voglio far partire il codice. In questo caso non
		// posso scrivere dei controlli per prevenire l'eccezione, quindi questa potrebbe capitare comunque e di conseguenza
		// farci esplodere l'applicazione

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// throw new RuntimeException(e);
			System.out.println("C'è stato un problema");
		}

		System.out.println("CIAO");

	}

	public static void print(String str) {
		// print(str); // <-- StackOverflowError
	}

}