package com.water.jdk.java8.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers.parallelStream().filter(n -> n % 2 == 1).map(n -> n * n).reduce(0, Integer::sum);
		System.out.println(sum);
		System.out.println("==========================================================================");

		List<Integer> numbers1 = Arrays.asList(3, 7, 9, 3, 1, 2, 1, 2, 3, 4, 5);
		numbers1.stream().filter(n -> n % 2 == 1).sorted().forEach(System.out::println);
		System.out.println("==========================================================================");

		Optional.of("java2s.com").ifPresent(value -> System.out.println("Optional contains " + value));
		System.out.println("==========================================================================");

		Stream<String> stream = Stream.of("XML", "Java", "CSS", "SQL");
		stream = Stream.<String> builder().add("XML").add("Java").add("CSS").add("SQL").build();
		stream.forEach(System.out::println);
		System.out.println("==========================================================================");

		Stream<Integer> tenNaturalNumbers = Stream.iterate(1, n -> n + 1).filter(Main::isOdd).skip(100).limit(10);
		tenNaturalNumbers.forEach(System.out::println);
		System.out.println("==========================================================================");

		Stream.generate(Main::next).limit(5).forEach(System.out::println);
		IntStream.generate(() -> 0).limit(5).forEach(System.out::println);
		System.out.println("==========================================================================");

		String str1 = "5 123,123,qwe,1,123, 25";
		str1.chars().filter(n -> !Character.isDigit((char) n) && !Character.isWhitespace((char) n))
				.forEach(n -> System.out.print((char) n));
		Pattern.compile(",").splitAsStream(str1).forEach(System.out::println);
		System.out.println("==========================================================================");

		Files.lines(
				Paths.get("C:\\Users\\yl70801.NAM\\git\\water\\java\\src\\main\\java\\com\\water\\jdk\\java8\\stream\\Main.java"))
				.forEach(System.out::println);
		Files.walk(Paths.get("."), 1).forEach(System.out::println);
		System.out.println("==========================================================================");

		sum = Stream.of(1, 2, 3, 4, 5).peek(e -> System.out.println("Taking integer: " + e)).filter(n -> n % 2 == 1)
				.peek(e -> System.out.println("Filtered integer: " + e)).map(n -> n * n)
				.peek(e -> System.out.println("Mapped integer: " + e)).reduce(0, Integer::sum);
		System.out.println("Sum = " + sum);
		System.out.println("==========================================================================");

		Employee.persons().stream().filter(Employee::isFemale).forEach(System.out::println);
		System.out.println("==========================================================================");

		Stream.of("XML", "Java", "CSS").map(name -> name.chars())
				.flatMap(intStream -> intStream.mapToObj(n -> (char) n)).forEach(System.out::println);
		System.out.println("==========================================================================");

		Employee.persons().stream().reduce(0.0, (partialSum, person) -> partialSum + person.getIncome(), Double::sum);
		Employee.persons()
				.parallelStream()
				.reduce(0.0,
						(Double partialSum, Employee p) -> {
							double accumulated = partialSum + p.getIncome();
							System.out.println(Thread.currentThread().getName() + "  - Accumulator: partialSum  = "
									+ partialSum + ",  person = " + p + ", accumulated = " + accumulated);
							return accumulated;
						},
						(a, b) -> {
							double combined = a + b;
							System.out.println(Thread.currentThread().getName() + "  - Combiner:  a  = " + a
									+ ", b  = " + b + ", combined  = " + combined);
							return combined;
						});
		Employee.persons().stream().mapToDouble(Employee::getIncome).sum();
		Employee.persons().stream().max(Comparator.comparingDouble(Employee::getIncome));
		Employee.persons().stream().mapToDouble(Employee::getIncome).max();

		Employee.persons().stream().map(Employee::getName)
				.collect(ArrayList<String>::new, ArrayList::add, ArrayList::addAll);
		Employee.persons().stream().map(Employee::getName).collect(Collectors.toList());
		Employee.persons().stream().map(Employee::getName).collect(Collectors.toCollection(TreeSet<String>::new));
		Employee.persons().stream().collect(Collectors.summarizingDouble(Employee::getIncome));
		Employee.persons().stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		Employee.persons()
				.stream()
				.collect(
						Collectors.toMap(Employee::getGender, Employee::getName,
								(oldValue, newValue) -> String.join(", ", oldValue, newValue)));
		Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		Employee.persons().stream().collect(Collectors.partitioningBy(Employee::isFemale));
		Employee.persons()
				.stream()
				.map(Employee::getName)
				.collect(
						Collectors.collectingAndThen(Collectors.toList(),
								result -> Collections.unmodifiableList(result)));

	}

	static int i = 0;

	private static int next() {
		i++;
		return i;
	}

	public static boolean isOdd(long number) {
		if (number % 2 == 0) {
			return false;
		}
		return true;
	}
}

class Employee {
	public static enum Gender {
		MALE, FEMALE
	}

	private long id;
	private String name;
	private Gender gender;
	private LocalDate dob;
	private double income;

	public Employee(long id, String name, Gender gender, LocalDate dob, double income) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.income = income;
	}

	public boolean isFemale() {
		return this.gender == Gender.FEMALE;
	}

	public static List<Employee> persons() {
		Employee p1 = new Employee(1, "Jake", Gender.MALE, LocalDate.of(1971, Month.JANUARY, 1), 2343.0);
		Employee p2 = new Employee(2, "Jack", Gender.MALE, LocalDate.of(1972, Month.JULY, 21), 7100.0);
		Employee p3 = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1973, Month.MAY, 29), 5455.0);
		Employee p4 = new Employee(4, "Jode", Gender.MALE, LocalDate.of(1974, Month.OCTOBER, 16), 1800.0);
		Employee p5 = new Employee(5, "Jeny", Gender.FEMALE, LocalDate.of(1975, Month.DECEMBER, 13), 1234.0);
		Employee p6 = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1976, Month.JUNE, 9), 3211.0);

		List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

		return persons;
	}

	public double getIncome() {
		return income;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDob() {
		return dob;
	}
}