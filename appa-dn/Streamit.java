import java.util.stream.Stream;

class Streamit {
	public static void main(String[] args) {
		Stream.of(
			new Enrolment("a1", "e1", 1),
			new Enrolment("a2", "e2", 10),
			new Enrolment("a3", "e3", 1),
			new Enrolment("",   "e4", 42),
			new Enrolment("a5", "e5", 0)
		)
		.filter(e -> e.count() > 0)
		.map(e -> e.enrol() == "" ? e.withUsage("e0") : e)
		.forEach(System.out::println);
	}
}

		
