import entities.User;
import exceptions.StringNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

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

/*		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// throw new RuntimeException(e);
			System.out.println("C'è stato un problema");
		}

		System.out.println("CIAO");*/


		// --------------------------------------- ECCEZIONI CUSTOM -----------------------------------------------
		// throw new NumberLessThanZeroException(-20);

		User aldo = new User("Aldo", "Baglio");
		try {
			aldo.setName("A");
		} catch (StringNotValidException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(aldo);


		// --------------------------------------- TRY-CATCH -----------------------------------------------
		User giova = new User("Giovanni", "Storti");
		try {
			giova.setName("G");
		} catch (StringNotValidException | ArithmeticException e) {
			// catch multi-eccezione. Serve per gestire due o più tipi di eccezione alla stessa maniera
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
		} catch (Exception e) {
			System.out.println("C'è stato un errore generico");
		}        // Fare più catch mi serve per gestire errori di tipologie diverse in maniere diverse

		Scanner scanner = new Scanner(System.in);
		int[] numbers2 = {0, 1, 2, 3, 4};
		System.out.println("Inserisci un numero da 1 a 4");
		int i = scanner.nextInt();
		try {
			System.out.println(5 / numbers2[i]);
		} catch (Exception e) { // Catch polimorfico, ovvero mi consente di catchare tutti i tipi di eccezione e gestirli alla stessa maniera
			System.out.println("Ti avevo detto di inserire un numero da 1 a 4. Il numero che hai inserito è: " + i);
		} finally { // Il blocco finally serve per eseguire determinato codice sia se siamo finiti nei catch sia se è andato tutto liscio
			scanner.close(); // Non importa se ci sono state eccezioni oppure no, lo scanner andrebbe comunque chiuso

		}

		logger.info("Ciao da Logback");
		logger.error("Ciao sono un errore brutto brutto");


	}

	public static void print(String str) {
		// print(str); // <-- StackOverflowError
	}

}