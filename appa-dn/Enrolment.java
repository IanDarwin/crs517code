record Enrolment(String enrol, String usage, int count){
	Enrolment withUsage(String newUsage) {
		return new Enrolment(enrol, newUsage, count);
	}
}
