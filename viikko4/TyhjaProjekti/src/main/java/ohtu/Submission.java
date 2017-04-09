package ohtu;

import java.util.ArrayList;

public class Submission {
    private String student_number;
    private int week;
    private int hours;
    private int failed;
    private ArrayList<Integer> tasks;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    
    public Submission() {
        tasks = new ArrayList<>();
        
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä " 
                + completedTasks().size() +" , aikaa kului yhteensä " + hours + " tuntia, "
                + "tehdyt tehtävät: " + tasksToString() + ", maksimi määrä: " + (completedTasks().size() + failed);
    }
    
    public ArrayList<Integer> completedTasks() {
        
        if (a1) {
            tasks.add(1);
        } else if (a1 == false) {
            failed++;
        }
        if (a2) {
            tasks.add(2);
        } else if (a2 == false) {
            failed++;
        }
        if (a3) {
            tasks.add(3);
        } else if (a3 == false) {
            failed++;
        }
        if (a4) {
            tasks.add(4);
        } else if (a4 == false) {
            failed++;
        }
        if (a5) {
            tasks.add(5);
        } else if (a5 == false) {
            failed++;
        }
        if (a6) {
            tasks.add(6);
        } else if (a6 == false) {
            failed++;
        }
        if (a7) {
            tasks.add(7);
        } else if (a7 == false) {
            failed++;
        }
        if (a8) {
            tasks.add(8);
        } else if (a8 == false) {
            failed++;
        }
        if (a9) {
            tasks.add(9);
        } else if (a9 == false) {
            failed++;
        }
        if (a10) {
            tasks.add(10);
        } else if (a10 == false) {
            failed++;
        }
        if (a11) {
            tasks.add(11);
        } else if (a11 == false) {
            failed++;
        }
        if (a12) {
            tasks.add(12);
        } else if (a12 == false) {
            failed++;
        }
        if (a13) {
            tasks.add(13);
        } else if (a13 == false) {
            failed++;
        }
        
        return tasks;
    }
    
    public String tasksToString() {
        String string = "";
        for (Integer nro : tasks) {
            string = string + nro + " ";
        }
        return string;
    }
    
}