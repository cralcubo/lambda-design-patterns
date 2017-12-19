package com.chris.lambda.patterns;

import java.util.ArrayList;
import java.util.List;

public class CommandLambda {
	
	/*
	 *  Commands
	 */
	public static void log(String msg) {
		System.out.println("Logging:" + msg);
	}
	
	public static void save(String msg) {
		System.out.println("Saving:" + msg);
	}
	
	public static void send(String msg) {
		System.out.println("Sending:" + msg);
	}
	
	
	/*
	 * Executor
	 */
	public static void executor(List<Runnable> commands) {
		commands.forEach(Runnable::run);
	}
	
	
	public static void main(String[] args) {
		List<Runnable> commands = new ArrayList<>();
		commands.add(() -> log("Running command log"));
		commands.add(() -> save("Running command save"));
		commands.add(() -> send("Running command send"));
		
		executor(commands);
	}
}
