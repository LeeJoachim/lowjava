package ch16.bitwise;

import java.util.ArrayList;

/* bitwise operation */
/* and : &
 * or : |
 * negation : ~
 * shift : << , >>
 */

/* why use this?
 * when you save boolean data to memory,
 * you need to economize.
 */

/* waste of memory
 * true : 0000 0001
 * false : 0000 0000
 */

/* the mask : not 0 but 1 is hole */

/* boolean operation */
// class Student {
//     String name;
//     boolean isMale;
//     boolean isRich;
//     boolean isTall;
//     boolean isCute;

//     Student() {
//         this.name = null;
//         this.isMale = false;
//         this.isRich = false;
//         this.isTall = false;
//         this.isCute = false;
//     }

//     Student(String name, boolean isMale, boolean isRich, boolean isTall, boolean isCute) {
//         this.name = name;
//         this.isMale = isMale;
//         this.isRich = isRich;
//         this.isTall = isTall;
//         this.isCute = isCute;
//     }

//     public String getName() {
//         return name;
//     }
//     public boolean getIsMale() {
//         return isMale;
//     }    
//     public boolean getIsRich() {
//         return isRich;
//     }
//     public boolean getIsTall() {
//         return isTall;
//     }
//     public boolean getIsCute() {
//         return isCute;
//     }

//     void readDataFromConsole() {
//         String buffer = System.console().readLine();
//         String[]  arr = buffer.split(" ");

//         this.name = arr[0];
//         /* not working
//         if (arr[1] == "1") isMale = true; else isMale = false;
//         if (arr[2] == "1") isRich = true; else isRich = false;
//         if (arr[3] == "1") isTall = true; else isTall = false;
//         if (arr[4] == "1") isCute = true; else isCute = false;
//         */
//         if (arr[1].equals("1")) isMale = true; else isMale = false;
//         if (arr[2].equals("1")) isRich = true; else isRich = false;
//         if (arr[3].equals("1")) isTall = true; else isTall = false;
//         if (arr[4].equals("1")) isCute = true; else isCute = false;

//     }
//     @Override
//     public String toString() {
//         return "Student [name=" + name + ", isMale=" + isMale + ", isRich=" + isRich + ", isTall=" + isTall
//                 + ", isCute=" + isCute + "]";
//     }
// }


/* bitwise operation */
class Student {
    String name;
    static int MALE_MASK = 1<<3;
    static int RICH_MASK = 1<<2;
    static int TALL_MASK = 1<<1;
    static int CUTE_MASK = 1<<0;
    int data; // e.g. 1010, 1101, 0101... == 9, 13, 5

    Student() {
        this.name = null;
        this.data = 0;
    }

    Student(String name, boolean isMale, boolean isRich, boolean isTall, boolean isCute) {
        this.name = name;
        setMale(isMale); setRich(isRich); setTall(isTall); setCute(isCute);

    }

    void setMale(boolean isMale) {
        if (isMale) data = data |  MALE_MASK;
        else        data = data & ~MALE_MASK;
    }
    void setRich(boolean isRich) {
        if (isRich) data = data |  RICH_MASK;
        else        data = data & ~RICH_MASK;
    }

    void setTall(boolean isTall) {
        if (isTall) data = data |  TALL_MASK;
        else        data = data & ~TALL_MASK;
    }

    void setCute(boolean isCute) {
        if (isCute) data = data |  CUTE_MASK;
        else        data = data & ~CUTE_MASK;
    }


    public String getName() {
        return name;
    }
    public boolean IsMale() {
        if ((data & MALE_MASK) != 0) return true; else return false;
    }    
    public boolean IsRich() {
        if ((data & RICH_MASK) != 0) return true; else return false;
    }
    public boolean IsTall() {
        if ((data & TALL_MASK) != 0) return true; else return false;
    }
    public boolean IsCute() {
        if ((data & CUTE_MASK) != 0) return true; else return false;
    }

    void readDataFromConsole() {
        String buffer = System.console().readLine();
        String[]  arr = buffer.split(" ");

        this.name = arr[0];
        if (arr[1].equals("1")) setMale(true); else setMale(false);
        if (arr[2].equals("1")) setRich(true); else setRich(false);
        if (arr[3].equals("1")) setTall(true); else setTall(false);
        if (arr[4].equals("1")) setCute(true); else setCute(false);

    }
    @Override
    public String toString() {
        String temp = "";
        temp += name + ": ";
        if (IsMale()) temp += "male "; else temp += "female ";
        if (IsRich()) temp += "rich "; else temp += "Poor ";
        if (IsTall()) temp += "tall "; else temp += "short ";
        if (IsCute()) temp += "cute "; else temp += "ugly ";
        return temp;
    }
}

class TestDriver {
    public static void main(String[] args) {
        Student x = new Student("leeje", false, true, false, true);
        Student y = new Student("leegh", true, false, true, false);
        Student z = new Student("kangsn", false, false, false, true);

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        System.out.println("Type information for 2 students as \"park 0 1 0 1\"");
        Student[] students = new Student[2];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].readDataFromConsole();
        }
        System.out.println("== favorite spouse candidates list ==");
        for (int i = 0; i < students.length; i++) {
            if (students[i].IsMale() == false && 
                students[i].IsRich() == true  &&
                students[i].IsTall() == false &&
                students[i].IsCute() == true) {
            
                System.out.println(students[i].getName());                    
                
            }
        }

        for (int i = 0; i < students.length; i++) {   
            System.out.println(students[i]);                    
        }
    }
}
