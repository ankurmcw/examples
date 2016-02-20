package com.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test7 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			String[] rectParams = s.split(" ");
			if (rectParams.length == 8) {
				System.out.println(Test7.isOverlapping(
						Integer.parseInt(rectParams[0]), Integer.parseInt(rectParams[1]),
						Integer.parseInt(rectParams[2]), Integer.parseInt(rectParams[3]),
						Integer.parseInt(rectParams[4]), Integer.parseInt(rectParams[5]),
						Integer.parseInt(rectParams[6]), Integer.parseInt(rectParams[7])));
			}
		}
	}

	public static String isOverlapping(int X1, int Y1, int W1, int H1, int A1, int B1, int W2, int H2) {
		if ((X1 == A1) && (Y1 == B1)) {
			return "true";
		}

		int X2 = X1 + W1;
		int Y2 = Y1 + H1;

		String lowerLeft = X1 + "," + Y1;
		String lowerRight = X2 + "," + Y1;
		String upperLeft = X1 + "," + Y2;
		String upperRight = X2 + "," + Y2;

		List<String> rectACoordinates = new ArrayList<>();
		rectACoordinates.add(upperLeft);
		rectACoordinates.add(lowerRight);
		rectACoordinates.add(upperLeft);
		rectACoordinates.add(upperRight);

		int A2 = A1 + W2;
		int B2 = B1 + H2;

		if (rectACoordinates.contains(A1 + "," + B1)) {
			return "true";
		} else if (rectACoordinates.contains(A2 + "," + B1)) {
			return "true";
		} else if (rectACoordinates.contains(A1 + "," + B2)) {
			return "true";
		} else if (rectACoordinates.contains(A2 + "," + B2)) {
			return "true";
		}

		return "false";
	}
}
