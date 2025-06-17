import java.util.*;

class User {
    String username;
    String password;

    User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
}

public class OnlineExamination {
    static Scanner sc = new Scanner(System.in);
    static User user;
    static boolean sessionActive = false;

    public static void main(final String[] args) {
        System.out.println("Create your account");
        System.out.print("Enter username: ");
        final String uname = sc.nextLine();
        System.out.print("Enter password: ");
        final String pass = sc.nextLine();
        user = new User(uname, pass);

        if (login()) {
            sessionActive = true;
            int choice;
            do {
                System.out.println("\n1. Update Profile");
                System.out.println("2. Take Exam");
                System.out.println("3. Logout");
                System.out.print("Choose option: ");
                choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    updateProfile();
                } else if (choice == 2) {
                    startExam();
                }
            } while (choice != 3);
            System.out.println("Session closed. Logged out.");
        } else {
            System.out.println("Login failed.");
        }
    }

    static boolean login() {
        System.out.println("\nLogin to continue");
        System.out.print("Enter username: ");
        final String uname = sc.nextLine();
        System.out.print("Enter password: ");
        final String pass = sc.nextLine();
        return uname.equals(user.username) && pass.equals(user.password);
    }

    static void updateProfile() {
        System.out.print("Enter new username: ");
        final String newUname = sc.nextLine();
        System.out.print("Enter new password: ");
        final String newPass = sc.nextLine();
        user.username = newUname;
        user.password = newPass;
        System.out.println("Profile updated.");
    }

    static void startExam() {
        final String[] questions = {
            "1. Capital of India?\n a) Delhi\n b) Mumbai\n c) Kolkata\n d) Chennai",
            "2. Red Planet?\n a) Venus\n b) Earth\n c) Mars\n d) Saturn",
            "3. Author of Ramayana?\n a) Vyasa\n b) Valmiki\n c) Tulsidas\n d) Kalidas"
        };
        final char[] answers = {'a', 'c', 'b'};
        final char[] userAnswers = new char[questions.length];

        System.out.println("Exam Started. You have 30 seconds.");

        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            userAnswers[i] = sc.nextLine().charAt(0);

            final long elapsed = (System.currentTimeMillis() - startTime) / 1000;
            if (elapsed > 30) {
                System.out.println("Time is up! Auto-submitting.");
                break;
            }
        }

        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (userAnswers[i] == answers[i]) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + answers.length);
    }

}
