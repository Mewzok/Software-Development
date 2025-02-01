import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class PresidentQuiz {
    public static void main(String[] args) {
        // declare variables
        String[][] presidents = {
                { "1", "George Washington", "1789-1797", "No Party" },
                { "2", "John Adams", "1797-1801", "Federalist" },
                { "3", "Thomas Jefferson", "1801-1809", "Democratic-Republican" },
                { "4", "James Madison", "1809-1817", "Democratic-Republican" },
                { "5", "James Monroe", "1817-1825", "Democratic-Republican" },
                { "6", "John Quincy Adams", "1825-1829", "Democratic-Republican" },
                { "7", "Andrew Jackson", "1829-1837", "Democratic" },
                { "8", "Martin Van Buren", "1837-1841", "Democratic" },
                { "9", "William Henry Harrison", "1841", "Whig" },
                { "10", "John Tyler", "1841-1845", "Whig/Unaffiliated" },
                { "11", "James K. Polk", "1845-1849", "Democratic" },
                { "12", "Zachary Taylor", "1849-1850", "Whig" },
                { "13", "Millard Fillmore", "1850-1853", "Whig" },
                { "14", "Franklin Pierce", "1853-1857", "Democratic" },
                { "15", "James Buchanan", "1857-1861", "Democratic" },
                { "16", "Abraham Lincoln", "1861-1865", "Republican/National Union" },
                { "17", "Andrew Johnson", "1865-1869", "Democratic/National Union" },
                { "18", "Ulysses S. Grant", "1869-1877", "Republican" },
                { "19", "Rutherford B. Hayes", "1877-1881", "Republican" },
                { "20", "James A. Garfield", "1881", "Republican" },
                { "21", "Chester A. Arthur", "1881-1885", "Republican" },
                { "22, 24", "Grover Cleveland", "1885-1889, 1893-1897", "Democratic" },
                { "23", "Benjamin Harrison", "1889-1893", "Republican" },
                { "25", "William McKinley", "1897-1901", "Republican" },
                { "26", "Theodore Roosevelt", "1901-1909", "Republican" },
                { "27", "William Howard Taft", "1909-1913", "Republican" },
                { "28", "Woodrow Wilson", "1913-1921", "Democratic" },
                { "29", "Warren G. Harding", "1921-1923", "Republican" },
                { "30", "Calvin Coolidge", "1923-1929", "Republican" },
                { "31", "Herbert Hoover", "1929-1933", "Republican" },
                { "32", "Franklin D. Roosevelt", "1933-1945", "Democratic" },
                { "33", "Harry S. Truman", "1945-1953", "Democratic" },
                { "34", "Dwight D. Eisenhower", "1953-1961", "Republican" },
                { "35", "John F. Kennedy", "1961-1963", "Democratic" },
                { "36", "Lyndon B. Johnson", "1963-1969", "Democratic" },
                { "37", "Richard Nixon", "1969-1974", "Republican" },
                { "38", "Gerald Ford", "1974-1977", "Republican" },
                { "39", "Jimmy Carter", "1977-1981", "Democratic" },
                { "40", "Ronald Reagan", "1981-1989", "Republican" },
                { "41", "George H. W. Bush", "1989-1993", "Republican" },
                { "42", "Bill Clinton", "1993-2001", "Democratic" },
                { "43", "George W. Bush", "2001-2009", "Republican" },
                { "44", "Barack Obama", "2009-2017", "Democratic" },
                { "45, 47", "Donald Trump", "2017-2021, 2025-", "Republican" },
                { "46", "Joe Biden", "2021-2025", "Democratic" }
        };
        int mainMenuChoice = 0;
        String gamemodeY = "years served";
        String gamemodeN = "president number";
        String currentGamemode = "";
        String[] highscores = new String[5];

        String filePath = "config.properties";
        File file = new File(filePath);

        // check if config file exists and create if not
        if (!file.exists()) {
            manageProperties();
        }

        // load properties from file
        Properties p = loadProperties(file);

        // set starting current gamemode in program
        currentGamemode = p.getProperty("gamemode");

        // grab current high scores in program
        highscores = assignHighscores(p, currentGamemode);

        while (mainMenuChoice != 5) {
            System.out.println("Current gamemode: " + currentGamemode);
            // display main menu and return user input
            mainMenuChoice = displayMainMenu();

            if (mainMenuChoice == 1) {
                beginQuiz(presidents, highscores, currentGamemode);
            }

            if (mainMenuChoice == 2) {
                currentGamemode = changeMode(currentGamemode, gamemodeY, gamemodeN);

                saveNewProperties("gamemode", currentGamemode);
                loadProperties(file);
                assignHighscores(p, currentGamemode);
            }

            if (mainMenuChoice == 3) {
                p = loadProperties(file);

                displayHighscores(p);
            }

            if (mainMenuChoice == 4) {
                displayOptions(p);
            }
        }
    }

    public static int displayMainMenu() {
        // declare variables¡
        int userInput = -1;

        Scanner input = new Scanner(System.in);

        // display main menu options and accept input
        System.out.println("1) Begin Quiz");
        System.out.println("2) Change Mode");
        System.out.println("3) High Scores");
        System.out.println("4) Options");
        System.out.println("5) Exit");
        while (userInput == -1) {
            userInput = input.nextInt();

            if (userInput < 1 || userInput > 5) {
                System.out.println("Invalid input.");
                userInput = -1;
            }
        }

        return userInput;
    }

    public static void beginQuiz(String[][] pres, String[] hiScores, String gameMode) {
        String[][] randomPres = randomizePresidents(pres);
        String difficultyString = "";
        int difficulty = -1;
        int quizLength = -1;
        double score = 0.0;
        DecimalFormat df = new DecimalFormat("##.##");

        Scanner input = new Scanner(System.in);

        // display current gamemode
        System.out.println("\nCurrent game mode is " + gameMode);

        while (difficulty == -1) {
            System.out
                    .println("Select difficulty\n1) Easy\n2) Medium\n3) Hard\n4) All\n5) Custom\n6) Back to Main Menu");
            difficulty = input.nextInt();

            if (difficulty < 1 || difficulty > 6) {
                System.out.println("Invalid input.");
                difficulty = -1;
            }
        }

        switch (difficulty) {
            case 1:
                quizLength = 5;
                difficultyString = "easy";
                break;
            case 2:
                quizLength = 10;
                difficultyString = "medium";
                break;
            case 3:
                quizLength = 25;
                difficultyString = "hard";
                break;
            case 4:
                quizLength = pres.length;
                difficultyString = "all";
                break;
            case 5:
                System.out.println("Enter custom number: ");
                while (true) {
                    quizLength = input.nextInt();

                    if (quizLength >= 0 && quizLength <= pres.length) {
                        break;
                    }
                    System.out.println("Invalid number.");
                }
                difficultyString = "custom";
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid input.");
                difficulty = -1;
        }

        System.out.println("\nBeginning quiz with " + quizLength + " questions.");

        // display instructions
        displayInstructions(gameMode);

        // display current high score
        if (difficultyString.equals("custom")) {
            System.out.println(
                    "Note that custom difficulty is not an official game difficulty and therefore does not save your high score.");
        } else {
            System.out.println("Current high score for " + difficultyString + " difficulty: " +
                    df.format(Double.parseDouble(hiScores[difficulty - 1])) + "/" + quizLength);
        }
        System.out.println();
        input.nextLine();

        if (gameMode.equals("years served")) {
            score = yearsQuiz(quizLength, randomPres, score);
        } else {
            score = numberQuiz(quizLength, randomPres, score);
        }

        System.out.println("score: " + score);

        // display final score, save high score
        finalScore(score, quizLength, difficulty, difficultyString, hiScores, gameMode);
    }

    public static void displayInstructions(String gameMode) {
        System.out.println("Current game mode: " + gameMode);
        if (gameMode.equals("years served")) { // years served instructions
            System.out.println("Type dates as 0000-0000");
            System.out.println("For one year presidents, type dates as 0000");
            System.out.println("For non-consecutive term presidents, type dates as 0000-0000 0000-0000");
            System.out.println("If a president is still in office, type date as 0000-");
        } else { // number instructions
            System.out.println("Type president's number as 00");
            System.out.println("For non-consecutive term presidents, type numbers as 00 00");
        }
    }

    public static double yearsQuiz(int qzLength, String[][] rndmPres, double scre) {
        String userAnswer = "";
        boolean found = false;
        int correctAnswers = 0;
        int incorrectDates = 0;

        Scanner in = new Scanner(System.in);

        // determine questions at quiz length
        for (int i = 0; i < qzLength; i++) {
            System.out.println((i + 1) + ". " + rndmPres[i][1] + ", " + rndmPres[i][3]);
            userAnswer = in.nextLine();

            String[] correctDateRanges = rndmPres[i][2].split(", | "); // split by comma for non-consecutive

            String[] userDates = userAnswer.split("-| ");

            String[] correctDates = new String[0];

            for (String correctDateRange : correctDateRanges) {
                String[] rangeDates = correctDateRange.split("-");
                correctDates = Arrays.copyOf(correctDates, correctDates.length + rangeDates.length);
                System.arraycopy(rangeDates, 0, correctDates, correctDates.length - rangeDates.length,
                        rangeDates.length);
            }

            System.out.println(Arrays.toString(correctDates));

            for (String userDate : userDates) {
                found = false;
                for (String correctDate : correctDates) {
                    if (userDate.equals(correctDate)) {
                        correctAnswers++;
                        found = true;

                        System.out.println(correctAnswers);
                    }
                }
                if (!found) {
                    incorrectDates++;
                    System.out.println(incorrectDates);
                }
            }

            // add to score for correct dates
            if (correctAnswers > 0) {
                scre += (double) correctAnswers / (double) correctDates.length;
            }

            // subtract from score if user inputted extra dates
            if (userDates.length > correctDates.length) {
                scre -= (userDates.length - (double) correctDates.length) / (double) correctDates.length;

                // testing
                System.out.println("incorrect dates: " + incorrectDates);
                System.out.println("scre neg: " + scre);
            }

            System.out.println("first score: " + scre);

            if (correctAnswers == correctDates.length && userDates.length == correctDates.length) { // check for exact
                                                                                                    // correct answers
                System.out.println("Correct.");
            } else if (correctAnswers > 0) { // check for at least one correct answer but not spamming numbers to cheat
                System.out.println(
                        "Partially correct. Partial point awarded. The correct answer is " + rndmPres[i][2]);
            } else { // blanket incorrect statement
                System.out.println("Incorrect. The correct answer is " + rndmPres[i][2]);
            }

            if (userDates.length > correctDates.length) { // check if user spamming dates to cheat and deduct points
                System.out.println("Additional date entered. Points deducted.");
            }

            incorrectDates = 0;
            correctAnswers = 0;
        }

        return scre;

    }

    public static double numberQuiz(int qzLength, String[][] rndmPres, double scre) {
        String userAnswer = "";
        boolean found = false;
        int correctAnswers = 0;
        int incorrectNumbers = 0;

        Scanner in = new Scanner(System.in);

        // determine questions at quiz length
        for (int i = 0; i < qzLength; i++) {
            System.out.println((i + 1) + ". " + rndmPres[i][1] + ", " + rndmPres[i][3]);
            userAnswer = in.nextLine();

            while (userAnswer.startsWith("0")) {
                userAnswer = userAnswer.substring(1);
            }

            String[] correctNumbers = rndmPres[i][0].split(", | "); // split by comma for non-consecutive

            String[] userNumbers = userAnswer.split("-|, | ");

            for (String userNum : userNumbers) {
                found = false;
                for (String correctNum : correctNumbers) {
                    if (userNum.equals(correctNum)) {
                        correctAnswers++;
                        found = true;
                    }
                }
                if (!found) {
                    incorrectNumbers++;
                }
            }

            // add to score for correct numbers
            if (correctAnswers > 0) {
                scre += (double) correctAnswers / (double) correctNumbers.length;
            }

            // subtract from score if user inputted extra numbers
            if (userNumbers.length > correctNumbers.length) {
                scre -= (double) incorrectNumbers / (double) correctNumbers.length;
            }

            if (correctAnswers == correctNumbers.length && userNumbers.length == correctNumbers.length) { // check for
                                                                                                          // exact
                                                                                                          // correct
                                                                                                          // answers
                System.out.println("Correct.");
            } else if (correctAnswers > 0) { // check for at least one correct answer but not spamming numbers to cheat
                System.out.println(
                        "Partially correct. Partial point awarded. The correct answer is " + rndmPres[i][0]);
            } else { // blanket incorrect statement
                System.out.println("Incorrect. The correct answer is " + rndmPres[i][0]);
            }

            if (userNumbers.length > correctNumbers.length) { // check if user spamming numbers to cheat and deduct
                                                              // points
                System.out.println("Additional number entered. Points deducted.");
            }

            incorrectNumbers = 0;
            correctAnswers = 0;
        }

        return scre;

    }

    public static String changeMode(String gameMode, String gm1, String gm2) {
        String userString = "";

        Scanner input = new Scanner(System.in);

        while (true) {
            if (gameMode.equals(gm1)) {
                System.out.println("Current game mode is years served.");
                System.out.println("Change to " + gm2 + "? (Y/N)");
                userString = input.nextLine();

                if (Character.toLowerCase((userString.charAt(0))) == 'y') {
                    gameMode = gm2;
                    System.out.println("\n-Gamemode set to " + gameMode);
                    break;
                }
            } else if (gameMode.equals(gm2)) {
                System.out.println("Current game mode is president number.");
                System.out.println("Change to " + gm1 + "? (Y/N)");
                userString = input.nextLine();

                if (Character.toLowerCase((userString.charAt(0))) == 'y') {
                    gameMode = gm1;
                    System.out.println("\n-Gamemode set to " + gameMode);
                    break;
                }
            }

            if (Character.toLowerCase((userString.charAt(0))) == 'n') {
                break;
            }

            System.out.println("\nInvalid input.");
            userString = "";
        }

        System.out.println();

        return gameMode;

    }

    public static void displayHighscores(Properties p) {
        DecimalFormat df = new DecimalFormat("##.##");
        Scanner in = new Scanner(System.in);

        // display high scores for years served mode
        System.out.println("High scores for \"years serves\" game mode: ");
        System.out.println("Easy: " + df.format(Double.parseDouble(p.getProperty("highscoreeasy"))) + "/5");
        System.out.println("Medium: " + df.format(Double.parseDouble(p.getProperty("highscoremedium"))) + "/10");
        System.out.println("Hard: " + df.format(Double.parseDouble(p.getProperty("highscorehard"))) + "/25");
        System.out.println("All: " + df.format(Double.parseDouble(p.getProperty("highscoreall"))) + "/45");
        System.out.println();

        // display high scores for number mode
        System.out.println("High scores for \"number\" game mode: ");
        System.out.println("Easy: " + df.format(Double.parseDouble(p.getProperty("numberhighscoreeasy"))) + "/5");
        System.out.println("Medium: " + df.format(Double.parseDouble(p.getProperty("numberhighscoremedium"))) + "/10");
        System.out.println("Hard: " + df.format(Double.parseDouble(p.getProperty("numberhighscorehard"))) + "/25");
        System.out.println("All: " + df.format(Double.parseDouble(p.getProperty("numberhighscoreall"))) + "/45");

        System.out.println("Press Enter key to continue...");
        in.nextLine();
    }

    public static void displayOptions(Properties props) {
        int userInput = -1;
        Scanner in = new Scanner(System.in);

        while (userInput == -1) {
            System.out.println("\nOptions: ");
            System.out.println("1) Delete High Scores");
            System.out.println("2) Back to Main Menu");
            userInput = in.nextInt();

            if (userInput == 1) {
                deleteHighscores(props);
            }
        }
    }

    public static String[][] randomizePresidents(String[][] pres) {
        // declare variables
        String[][] randomPres = new String[45][4];
        Random random = new Random();

        // copy array
        for (int i = 0; i < pres.length; i++) {
            randomPres[i] = pres[i].clone();
        }

        // randomize presidents
        for (int i = randomPres.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // swap
            String[] temp = randomPres[i];
            randomPres[i] = randomPres[j];
            randomPres[j] = temp;
        }

        // testing
        randomPres[0] = pres[0];
        randomPres[1] = pres[43];

        return randomPres;
    }

    public static void finalScore(double finalScoreNum, int totalScore, int diff, String difficultyName,
            String[] hiscoreStrings, String gameMode) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.##");
        String keyName = gameMode.equals("years served") ? "highscore" + difficultyName
                : "numberhighscore" + difficultyName;
        String scorePercent = String.format("%.2f%%", (finalScoreNum / totalScore) * 100);

        // print final score
        System.out.println("Final score: " + df.format(finalScoreNum) + "/" + totalScore + " - " + scorePercent);

        // save new high score
        if (!difficultyName.equals("custom")) {
            if (finalScoreNum > Double.parseDouble(hiscoreStrings[diff - 1])) {
                System.out.println("New high score");
                saveNewProperties(keyName, String.valueOf(finalScoreNum));
            }
        }

        System.out.println("Press Enter key to continue...");
        in.nextLine();
    }

    public static void manageProperties() {
        String filePath = "config.properties";
        Properties p = new Properties();

        p.setProperty("gamemode", "years served");
        p.setProperty("highscoreeasy", "0");
        p.setProperty("highscoremedium", "0");
        p.setProperty("highscorehard", "0");
        p.setProperty("highscoreall", "0");
        p.setProperty("numberhighscoreeasy", "0");
        p.setProperty("numberhighscoremedium", "0");
        p.setProperty("numberhighscorehard", "0");
        p.setProperty("numberhighscoreall", "0");

        try (FileOutputStream output = new FileOutputStream(filePath)) {
            p.store(output, "Default properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties loadProperties(File filePath) {
        // load properties
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(filePath)) {
            props.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }

    public static void saveNewProperties(String key, String value) {
        String filePath = "config.properties";
        Properties p = new Properties();

        try (FileInputStream in = new FileInputStream(filePath)) {
            p.load(in);

            p.setProperty(key, value);

            try (FileOutputStream output = new FileOutputStream(filePath)) {
                p.store(output, "Updated high score");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] assignHighscores(Properties props, String gameMode) {
        String[] highscores = new String[5];

        if (gameMode.equals("years served")) {
            highscores[0] = props.getProperty("highscoreeasy");
            highscores[1] = props.getProperty("highscoremedium");
            highscores[2] = props.getProperty("highscorehard");
            highscores[3] = props.getProperty("highscoreall");
        } else {
            highscores[0] = props.getProperty("numberhighscoreeasy");
            highscores[1] = props.getProperty("numberhighscoremedium");
            highscores[2] = props.getProperty("numberhighscorehard");
            highscores[3] = props.getProperty("numberhighscoreall");
        }

        return highscores;
    }

    public static void deleteHighscores(Properties props) {
        char userInput = ' ';
        Scanner in = new Scanner(System.in);

        System.out.println("Are you sure you want to delete high scores? (Y/N)"); // confirm deletion of high scores
        userInput = in.nextLine().charAt(0);

        if (userInput == 'Y' || userInput == 'y') {
            props.setProperty("highscoreeasy", "0");
            props.setProperty("highscoremedium", "0");
            props.setProperty("highscorehard", "0");
            props.setProperty("highscoreall", "0");
            props.setProperty("numberhighscoreeasy", "0");
            props.setProperty("numberhighscoremedium", "0");
            props.setProperty("numberhighscorehard", "0");
            props.setProperty("numberhighscoreall", "0");

            try (FileOutputStream output = new FileOutputStream("config.properties")) {
                props.store(output, "Updated high score");
                System.out.println("High scores deleted successfully.\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (userInput == 'N' || userInput == 'n') {
            System.out.println("High scores not deleted. Returning to options menu.\n");
            displayOptions(props);
        } else {
            System.out.println("Invalid input. Returning to options menu.\n");
            displayOptions(props);
        }
    }
}