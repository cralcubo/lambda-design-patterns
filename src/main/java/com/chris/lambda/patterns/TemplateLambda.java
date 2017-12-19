package com.chris.lambda.patterns;

import java.util.Random;
import java.util.function.Consumer;

public class TemplateLambda {

	public void execute(Consumer<Resource> resourceOperations) {
		Resource r = new Resource();
		r.open();
		try {
			resourceOperations.accept(r);
		} finally {
			r.close();
		}
	}

	private static class Resource {
		public void open() {
			System.out.println("Openning resource");
		}

		public void close() {
			System.out.println("Clossing resource");
		}

		public Resource useResource() {
			System.out.println("Ussing resource");
			return this;
		}

		public Resource employResource() {
			Random r = new Random();
			if (r.nextInt(3) == 0) {
				throw new RuntimeException("Random error");
			}
			System.out.println("Resource employed");
			return this;
		}

	}

	public static void main(String[] args) {
		TemplateLambda tl = new TemplateLambda();
		tl.execute(r -> r.useResource().employResource());
	}

}
