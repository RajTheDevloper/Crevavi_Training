package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Pract {

	public static void main(String[] args) {

//		mathFuntions();
//		enhancedSwitch();
//		fileWriteOperation();
//		fileReadOperation();
//		audioFileReader();
//		dateTime();
		schedulerTimer();
		
	}

//------------------------------------------------------------------------------------------------------------------------	

	static void mathFuntions() {

		Random ran = new Random();
		double discountPercent = Math.round(ran.nextDouble(50, 75) * 100.0) / 100.0;

		System.out.printf("%.2f%%%n", discountPercent);
		System.out.println("Got it");
	}

	static void enhancedSwitch() {

		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the day");
		String day = in.nextLine();

		switch (day) {
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> System.out.printf("ohh it's %s ", day);
		case "Saturday", "Sunday" -> System.out.printf("hureeyy it's %s ", day);

		}
		in.close();
	}
	
	static void fileWriteOperation() {
	//	How to write a file using java(4 popular option)
	//	FileWritter = Good for small or medium size text files
	//	BufferWritter = Better performance for large amount of data
	//	PrintWriter = Best for structured data, like report or logs
	//	FileOutPutStream = Best for binary files (e.g., image, audio files)
		
	String path = "C:\\Users\\Admin\\Desktop\\test.txt";
	String note = """ 
			This is demo text I'm writing here!
			""";
		
	try(FileWriter writer = new FileWriter(path)){
		writer.write(note);
		System.out.println("File as been written");
	}
	catch(IOException e) {
		System.out.println(e.getMessage());
	}
	
	}
	
	static void fileReadOperation() {
		
//		How to read a file using java (3 popular options)
//		BufferedReader + FileReader: Best for reading text file line by line 
//		FileInputStream : Best for Binary files (e.g., image, audio files)
//		RandomAccessFile : Best for read & write specific portion of a large file 
		
		String filePath = "C:\\Users\\Admin\\Desktop\\test.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			System.out.println("The file is exist");
			
			String read;
			while((read = br.readLine()) != null) {
				
				System.out.println(read);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	static void audioFileReader() {
		String filePath = "C:\\Users\\Admin\\Downloads\\Blue Deer.wav";
		 File file = new File(filePath);
		 
		 try (Scanner in = new Scanner(System.in);){
			 
			 AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			 
			 Clip clip = AudioSystem.getClip();
			 clip.open(audioStream);
	
			 
			 System.out.println("enter the responce");
			 String res = " ";
			 while(!res.equals("Q")) {
				 res = in.next().toUpperCase();
				 
				 switch(res) {
				 case "P" -> clip.start();
				 case "S" -> clip.stop();
				 case "R" -> clip.setMicrosecondPosition(0);
				 case "Q" -> clip.close();
				 }
			 }
			
			 
			 
			 
		 }catch(Exception e ) {
			 System.out.println(e.getMessage());
		 }finally {
			 System.out.println("BYE");
		 }
	}
	
	static void dateTime() {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalTime time = LocalTime.now();
		System.out.println(time);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
	}
	
	static void schedulerTimer() {
		
		Timer timer = new Timer();
		
		TimerTask task =new TimerTask(){
			@Override
			public void run() {
				System.out.println("run");
			}
		};
		timer.schedule(task, 3000);
	}
	
}
