package ex05;

import java.util.Scanner;

public class Program {
    final static String[] weekDays = new String[]{"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
    static String[] students = new String[10];
    static boolean[][] timetable = new boolean[7][7];
    static String[][][] attendances = new String[10][31][7];

    public static void main(String[] args) {
        init();
        printTimetable();
        printAttendances();
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; !sc.hasNext("\\."); i++)
            students[i] = sc.next();

        sc.next();

        while (!sc.hasNext("\\.")) {
            int hour = sc.nextInt();
            int weekDay = indexOf(weekDays, sc.next());
            timetable[weekDay][hour] = true;
        }
        sc.next();

        while (!sc.hasNext("\\.")) {
            int student = indexOf(students, sc.next());
            int hour = sc.nextInt();
            int dayOfMonth = sc.nextInt();
            attendances[student][dayOfMonth][hour] = sc.next().equals("HERE") ? "1" : "-1";
        }
        sc.close();
    }

    static int indexOf(String[] ss, String s) {
        for (int i = 0; i < ss.length; i++)
            if (s.equals(ss[i]))
                return i;
        return -1;
    }

    static void printTimetable() {
        System.out.printf("%10s", "");
        for (int d = 1; d <= 30 ; d++) {
            int weekDay = d % 7;
            for (int h = 1; h <= 6; h++)
                if (timetable[weekDay][h])
                    System.out.printf("%d:00 %s %2d|", h, weekDays[weekDay], d);
        }
        System.out.println();
    }

    static void printAttendances() {
        for (int i = 0; students[i] != null; i++) {
            System.out.printf("%10s", students[i]);
            for (int d = 1; d <= 30 ; d++) {
                int weekDay = d % 7;
                for (int h = 1; h <= 6; h++)
                    if (timetable[weekDay][h])
                        System.out.printf("%10s" + "|", attendances[i][d][h] == null ? "" : attendances[i][d][h]);
            }
            System.out.println();
        }
    }

}
