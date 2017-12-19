package com.chris.lambda.patterns;

import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyLambda {

	public static void publishText(String text, Predicate<String> filter, Function<String, String> formatter) {
		if (filter.test(text)) {
			System.out.println(formatter.apply(text));
		}
	}

	public static void main(String[] args) {
		publishText("ERROR: An error detected", s -> s.startsWith("ERROR"), String::toUpperCase);
	}
}
