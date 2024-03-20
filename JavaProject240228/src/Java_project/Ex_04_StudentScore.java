package Java_project;

public class Ex_04_StudentScore {
    public static void main(String[] args) {
        int[][] scores = {
                {80, 60, 70},
                {90, 95, 80},
                {75, 80, 100},
                {80, 70, 95},
                {100, 65, 80}
        };
        
        printStudentScores(scores);
    }

    
    private static void printHeader() {
        System.out.println("학생번호   국어   영어   수학    총점    평균");
        System.out.println("=============================================");
    }

   
    private static void printStudentScores(int[][] scores) {
        for (int i = 0; i < scores.length; i++) {
            int studentNumber = i + 1;
            int korean = scores[i][0];
            int english = scores[i][1];
            int math = scores[i][2];

            int total = korean + english + math;
            double average = total / 3.0; 

            System.out.printf("%d번 학생:   %d     %d     %d     %d     %.1f\n",
                    studentNumber, korean, english, math, total, average);
        }
    }
}