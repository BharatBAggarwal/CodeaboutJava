package com.amarjefferson.codeabout.java.classes.chair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.amarjefferson.codeabout.java.classes.chair.ChairConstants.Styles;

/**
 * File Name: Chair.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair
 * Class: Chair
 *
 */
public class Chair {
	/**
	 *  Instance variables
	 */
	private ChairConstants.Colors aColor;  // color of a chair
	private ChairConstants.Styles aStyle;  // style of a chair
	private boolean broken;                // is the chair broken?
	private boolean refurbished;           // is the chair refurbished?
	private double currentLoad;            // current total weight on chair
	private double capacity;               // weight capacity of the chair
	private double personWeight;           // weight of person sitting on chair
							               // Set to -1 when no one sitting on chair
	private double otherWeight;            // additional weight added to chair
	private String className;              // name of class

	/**
	 *  Default Constructor
	 */
	public Chair() {
		this(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	/**
	 * @param aColor
	 * @param aStyle
	 */
	public Chair(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		this.initialize();
		setColor(aColor);
		setStyle(aStyle);
		className = this.getClass().getSimpleName();
		System.out.println(this.className + " : Chair(params)");
	}
 
	/**
	 * @return
	 */
	protected double setCurrentWeight() {
		if (this.personWeight < 0.0) {              // if no one sitting on the chair
			this.currentLoad = this.otherWeight;
		}
		else {                                      // if someone is sitting on the chair
			this.currentLoad = this.personWeight + this.otherWeight;
		}

		if (this.currentLoad > capacity) {          // if total weight exceeds capacity
			this.broken = true;
			System.out.println(this.className + " : Weight > capacity. The Chair broke!");
		}
		return this.currentLoad;
	}

	/**
	 * @param weightOfPerson
	 * @return
	 */
	public double sit(double weightOfPerson) {
		if (this.broken) {                 // cannot sit on a broken chair
			System.out.println(this.className + " : Cannot sit on a broken chair!");
			return this.currentLoad;
		}

		if (!(this.personWeight < 0.0)) {  // someone sitting on chair
			System.out.println(this.className + " : This chair is taken!");
			return this.currentLoad;
		}

		this.personWeight = weightOfPerson;
		return setCurrentWeight();
	}

	/**
	 * @return
	 */
	public double getOff() {
		if (this.broken || personWeight < 0.0) {
			return this.currentLoad;
		}

		this.personWeight = -1.0;
		return setCurrentWeight();
	}

	/**
	 * @param stuffWeight
	 * @return
	 */
	public double addStuff(double stuffWeight) {
		if (this.broken) // do not add weight to a broken chair
		{
			return this.currentLoad;
		}

		this.otherWeight += stuffWeight;
		return setCurrentWeight();
	}

	/**
	 * @param stuffWeight
	 * @return
	 */
	public double removeStuff(double stuffWeight) {
		if (this.broken) {
			System.out.println(this.className + " : The Chair is broken!");
			return this.currentLoad;
		}

		this.otherWeight -= stuffWeight;
		if (this.otherWeight < 0.0) {
			this.otherWeight = 0.0;
		}

		return this.setCurrentWeight();
	}

	/**
	 * @return
	 */
	public double currentLoad() {
		return this.currentLoad;
	}

	/**
	 * @return
	 */
	public double personWeight() {
		return this.personWeight;
	}

	/**
	 * @return
	 */
	public double otherWeight() {
		return this.otherWeight;
	}

	/**
	 * @return
	 */
	public boolean isBroken() {
		return this.broken;
	}

	/**
	 * @return
	 */
	protected void setBroken(boolean isBroken) {
		this.broken = isBroken;
	}

	/**
	 * @return
	 */
	public boolean isRefurbished() // true if broken
	{
		return this.refurbished;
	}

	/**
	 * @return
	 */
	protected void setRefurbished(boolean isRefurbished) {
		this.refurbished = isRefurbished;
	}

	/**
	 * @return
	 */
	public boolean isSitting() {
		if (this.personWeight < 0.0)
			return false;
		else
			return true;
	}

	/**
	 * 
	 * 
	 */
	public void clearLoads() {
		this.currentLoad = 0.0;
		this.personWeight= -1.0;
		this.otherWeight = 0.0;
	}

	protected void initialize() {
		this.aColor = ChairConstants.Colors.BLACK;
		this.aStyle = ChairConstants.Styles.BASIC;
		this.broken = false;      // set broken to false
		this.capacity = 0.0;    // set weight capacity to 100.0
	}

	/**
	 * 
	 */
	public void refurbish() {
		this.broken = false;      // set broken to false
		this.clearLoads();
		this.refurbished = true;  // set refurbished to true
	}

	/**
	 * @return
	 */
	public ChairConstants.Colors color() {
		return this.aColor;
	}

	/**
	 * @param aColor
	 * @return
	 */
	public Chair setColor(ChairConstants.Colors aColor) {
		this.aColor = aColor;
		return this;
	}

	/**
	 * @return
	 */
	public ChairConstants.Styles style() {
		return this.aStyle;
	}

	public Optional<ChairConstants.Styles> styleOp() {
		return Optional.ofNullable(this.aStyle);
	}

	/**
	 * @param aStyle
	 * @return
	 */
	public Chair setStyle(ChairConstants.Styles aStyle) {
		this.aStyle = aStyle;
		return this;
	}

	/**
	 * @return
	 */
	public double capacity() {
		return this.capacity;
	}

	/**
	 * @param limit
	 * @return
	 */
	public Chair setCapacity(double limit) {
		this.capacity = limit;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "State of the Chair:\n" +
				     "   Color : "  + this.color().name() + "\n" +
		             "   Style : "  + this.style().name() + "\n" +
                     "   Capacity : " + this.capacity() + "\n" +
		             "   Weight : " + this.currentLoad() + "\n" +
		             "   Broken? : " + this.isBroken() + "\n" +
                     "   Refurbished? : " + this.isRefurbished() + "\n" +
                     "-------------------\n";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Chair chair1 = new Chair();             // use default constructor
		// Chaining of function calls.
		chair1.setCapacity(100.0);                      // person of weight 50 sits on chair
		chair1.setColor(ChairConstants.Colors.GREEN).setStyle(ChairConstants.Styles.MODERN);
		chair1.sit(150.0);                      // the chair will break. Capacity = 100.0
		System.out.println(chair1.toString());  // explicit use of toString()
		chair1.refurbish();                     // make the chair new again
		System.out.println(chair1.toString());  // explicit use of toString()

		// Use constructor with parameters
		Chair chair2 = new Chair(ChairConstants.Colors.RED, ChairConstants.Styles.BASIC);
		chair2.setCapacity(150.0);                      // person of weight 50 sits on chair
		chair2.sit(50.0);                      // person of weight 50 sits on chair
		chair2.addStuff(25.0);                 // add 25 additional weight
		System.out.println(chair2);            // toString() method called by default

		// Use constructor with parameters
		Chair chair3 = new Chair(ChairConstants.Colors.BLUE, ChairConstants.Styles.TRADITIONAL);
		chair3.setCapacity(180.0);                      // person of weight 50 sits on chair
		System.out.println(chair3);            // toString() method called by default

		// Use constructor with parameters
		
		  Chair chair4 = new Chair(ChairConstants.Colors.WHITE, ChairConstants.Styles.MODERN);
		  chair4.setCapacity(50.0); 
		  System.out.println(chair4);
		  
		  List<Chair> chairs = new ArrayList<Chair>();
		  chairs.add(chair1);
		  chairs.add(chair2);
		  chairs.add(chair3);
		  chairs.add(chair4);
		  
		  // display sorted list of distinct styles
		  chairs.stream()  // source of chair elements
		        .filter(t -> t.capacity() >= 50) // chairs with capacity over 50
		        .map(Chair::style) // get the style of the chair
		        .distinct()        // eliminate duplicates
		        .sorted()          // sort values
		        .forEach(System.out::println); // print list
		 
		  String style = chairs.stream()  // source of chair elements
				  .filter(t -> t.capacity() >= 50) // chairs with capacity over 50
				  .findFirst()
				  .map(Chair::style) // get the style of the chair
				  .map(Styles::toString) // get the style of the chair
				  .orElse("Style not found"); // print list
		  System.out.println("\nSelected style (map): " + style);

		  style = chairs.stream()  // source of chair elements
				  .filter(t -> t.capacity() >= 50) // chairs with capacity over 50
				  .findFirst()
				  .flatMap(Chair::styleOp) // get the style of the chair
				  .map(Styles::toString) // get the style of the chair
				  .orElse("Style not found"); // print list
		  System.out.println("\nSelected style (flatMap): " + style);

		  // Reduction operations - select chair with the largest capacity
		  chairs.stream()  // source of chair elements
		        .reduce((c1, c2) -> c1.capacity() > c2.capacity() ? c1 : c2)
		        .ifPresent(System.out::println);
		  
		  // Reduction operations - create chair with sum of capacities
		  Chair ch1 = chairs.stream()  // source of chair elements
				  .reduce(new Chair(), 
						  (c1, c2) -> {
							  c1.setCapacity(c1.capacity() + c2.capacity());
					    	  System.out.println("accumulator: c1: " + c1.capacity() + " Added: " + c2.capacity() + " from " + c2.color() + " chair");
							  return c1;
						  });
		  System.out.println(ch1);
		  
		  // Reduction operations - code without printing
		  Chair ch1a = chairs.stream()  // source of chair elements
				  .reduce(new Chair(), 
						  (c1, c2) -> c1.setCapacity(c1.capacity() + c2.capacity()));
		  System.out.println(ch1a);
		  
		  // Reduction operations - create chair with sum of capacities
		  Chair ch2 = chairs.parallelStream()  // source of chair elements
				  .reduce(new Chair(), 
						  (c1, c2) -> {
						    	  c1.setCapacity(c1.capacity() + c2.capacity());
						    	  System.out.println("accumulator: c1: " + c1.capacity() + " Added: " + c2.capacity() + " from " + c2.color() + " chair"
						    			             + " on thread " + Thread.currentThread().getName());
						    	  return c1;
						      },
						  (c1, c2) -> {
								  c1.setCapacity(c2.capacity()); 
						    	  System.out.println("combiner: c1: " + c1.capacity() + " combined on thread " + Thread.currentThread().getName());
						    	  return c1;
							  });
		  System.out.println(ch2);
		  
		  // Reduction operations - code without printing
		  Chair ch3 = chairs.parallelStream()
				  .reduce(new Chair(), 
						  (c1, c2) -> c1.setCapacity(c1.capacity() + c2.capacity()),
						  (c1, c2) -> c1.setCapacity(c2.capacity()));
		  System.out.println(ch3);

		  // collect operations - Form 1
		  List<String> styles = chairs.stream()  // source of chair elements 
				  .map(Chair::style)              // get the style of the chair 
				  .map(Styles::toString)          // convert to String 
				  .collect(Collectors.toList());  // store styles in List 
		  System.out.println(styles);

		  // collect operations - Form 2
		  List<String> styles1 = chairs.stream()   // source of chair elements 
				  .map(Chair::style)                // get the style of the chair 
				  .map(Styles::toString)            // convert to String
				  .collect(() -> new ArrayList<>(), (c, e) -> c.add(e.toString()),
						  (c1, c2) -> c1.addAll(c2) );
		  System.out.println(styles1);

		  List<String> styles2 = chairs.parallelStream()   // source of chair elements 
						  .map(Chair::style)                // get the style of the chair 
						  .map(Styles::toString)            // convert to String
						  .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		  System.out.println(styles2);

  // collect operations - groupingBy
		  Map<Double, List<Chair>> groupByCapacity = 
		             chairs.stream()
		                   .collect(Collectors.groupingBy(ch -> ch.capacity()));
		  groupByCapacity.forEach((capacity, ch) -> System.out.format("capacity %s: %s\n", capacity, ch));
		  
		  // collect operations - toMap
		  Map<String, String> mapOfChairs = 
		             chairs.stream().collect(Collectors.toMap(ch -> ch.color().toString(),
		            		                                  ch -> ch.style().toString(),
		            		                                  (style1, style2) -> style1 + "|" + style2));
		  System.out.println(mapOfChairs);

		  // collect operations - joining
		  String styles3 = chairs.stream()   // source of chair elements 
				  .map(Chair::style)                // get the style of the chair 
				  .map(Styles::toString)            // convert to String
				  .collect(Collectors.joining(" | ", "Available styles are: ", ""));
          System.out.println(styles3);

		  // custom collector
		  Collector<Chair, StringJoiner, String> styleCollector = 
			         Collector.of(
			         () -> new StringJoiner(" | ", "Available styles are: ", ""),  // supplier 
			         (j, ch) -> j.add(ch.style().toString()),  // accumulator
			         (j1, j2) -> j1.merge(j2),                 // combiner
			         StringJoiner::toString);                  // finisher
		  String availableStyles = chairs.stream().collect(styleCollector);
		  System.out.println(availableStyles);		  
		  
		  // flatMap
		  IntStream.range(1, 4)
		    .mapToObj(i -> new Room("Room" + i))
		    .peek(f -> IntStream.range(1, 4)
		        .mapToObj(i -> new Person("Person" + i + " in room " + f.name))
		        .forEach(f.people::add))
		    .flatMap(f -> f.people.stream())
		    .forEach(b -> System.out.println(b.name));		  
		  
		  Pattern p = Pattern.compile("match\\s\\D{3,}\\sstring"); // compiled pattern
		  Matcher m1 = p.matcher("match this string"); 
		  boolean b1 = m1.matches(); 
		  System.out.println(b1);
		  Matcher m2 = p.matcher("match one string"); 
		  boolean b2 = m2.matches(); 
		  System.out.println(b2);
		  Matcher m3 = p.matcher("match to string"); 
		  boolean b3 = m3.matches(); 
		  System.out.println(b3);
		  boolean b4 = Pattern.matches("match \\D{3,} string", "match this string"); 
		  System.out.println(b4);
		  System.out.println(p.toString());

		  Stream.of("match as string", "please match one String",
				    "match this string")
				.filter(p.asPredicate())
				.forEach(System.out::println); // prints the first two strings

		  Stream.of("match as string", "match one String",
				    "match this string")
				.filter(p.asMatchPredicate())
				.forEach(System.out::println); // prints only the first string
	}

}

class Room {
    String name;
    List<Person> people = new ArrayList<>();

    Room(String name) {
        this.name = name;
    }
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

