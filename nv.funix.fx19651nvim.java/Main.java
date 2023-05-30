import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> regionCodes = initRegionCode();
        int userSelection = ClientOption(scanner);
        String userIDNumber;
        switch (userSelection) {
            case 1 -> {
                boolean isContinue = true;
                ValidVerificationCode(scanner);
                userIDNumber = GetIdentifyNumber(scanner);
                int displayOption = DisplayOption(userIDNumber, scanner);
                do {
                    System.out.println("Option: " + displayOption);
                    switch (displayOption) {
                        case 1:
                            System.out.println("Noi sinh: " + showRegion(userIDNumber, regionCodes));
                            break;
                        case 2:
                            showGenderandBirths(userIDNumber);
                            break;
                        case 3:
                            System.out.println("Random number: " + showRandomNumber(userIDNumber));
                            break;
                        case 0:
                            isContinue = false;
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    
                    if (isContinue) {
                        displayOption = DisplayOption(userIDNumber, scanner);
                    }
                } while (isContinue);

            }
            case 0 -> System.exit(0);
        }
    }

    public static int ClientOption(Scanner myScanner) {
        int menuOption;
        do {
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| DIGITAL BANKING | FX19651- Beta version             |");
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| 1.Enter Citizen Identification DisplayOptionber.    |");
            System.out.println("| 0.Quit.                                             |");
            System.out.println("+-----------------+--------------------+--------------+");

            System.out.println("Enter option: ");
            menuOption = myScanner.nextInt();
            myScanner.nextLine();
        } while (menuOption != 0 && menuOption != 1);
        return menuOption;
    }

    public static void ValidVerificationCode(Scanner sc) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rng = new Random();
        int length = 5;
        boolean match = false;
        char[] text = new char[length];
        char[] confirmtext;
        do {
            for (int i = 0; i < length; i++) {
                text[i] = characters.charAt(rng.nextInt(characters.length()));
            }
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.print("The verification code: ");
            for (int i = 0; i < length; i++) {
                System.out.print(text[i]);
            }

            System.out.println("\nEnter the code: ");
            String userInput = sc.next();
            confirmtext = userInput.toCharArray();
            if (Arrays.equals(confirmtext, text)) {
                match = true;
            } else {
                System.out.println("Invalid verification code. Please enter again.");
            }
        } while (!match);

    }

    public static String GetIdentifyNumber(Scanner idScanner) {
        String clientId;
        do {
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("Enter your ID: ");
            clientId = idScanner.next();
            if (clientId.length() != 12 || !clientId.matches("\\d+")) {
                System.out.println("Invalid ID. Please enter a 12-digit numeric ID.");
            }
        } while (clientId.length() != 12 || !clientId.matches("\\d+"));
        return clientId;
    }

    public static int DisplayOption(String userIDNumber, Scanner scanner) {
        int menuOption;
        do {
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| DIGITAL BANKING | FX19651- Beta version             |");
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| 1.Enter Citizen Identification number.              |");
            System.out.println("| 0.Quit.                                             |");
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("Your ID number: " + userIDNumber);
            System.out.println("\t| 1. Kiem tra noi sinh");
            System.out.println("\t| 2. Kiem tra tuoi,gioi tinh");
            System.out.println("\t| 3. Kiem tra so ngau nhien");
            System.out.println("\t| 0. Thoat");
            System.out.println("Nhap vao lua chon:");
            menuOption = scanner.nextInt();
        } while (menuOption < 0 || menuOption > 3);
        scanner.nextLine();
        return menuOption;
    }

    public static String showRegion(String clientId, ArrayList<String> regionCodes) {
        String getRegion = clientId.substring(0, 2);
        String birthPlace = "0", extraRegionCodes;
        for (String regionCode : regionCodes) {
            extraRegionCodes = regionCode.substring(0, 2);// lay ra ma tinh trong arraylist
            int strlen = regionCode.length();
            String regionName = regionCode.substring(4, strlen);
            if (getRegion.equals(extraRegionCodes)) {
                birthPlace = regionName;
                break;
            }
        }
        return birthPlace;
    }

    public static void showGenderandBirths(String clientId) {

        int getGender = Character.getNumericValue(clientId.charAt(3));

        String getBirths = clientId.substring(4, 6);
        switch (getGender) {
            case 0 -> System.out.println("Gender: Male - Birth: 19" + getBirths);
            case 1 -> System.out.println("Gender: Female - Birth: 19" + getBirths);
            case 2 -> System.out.println("Gender: Male - Birth: 20" + getBirths);
            case 3 -> System.out.println("Gender: Female - Birth: 20" + getBirths);
            case 4 -> System.out.println("Gender: Male - Birth: 21" + getBirths);
            case 5 -> System.out.println("Gender: Female - Birth: 21" + getBirths);
            case 6 -> System.out.println("Gender: Male - Birth:22" + getBirths);
            case 7 -> System.out.println("Gender: Female - Birth: 22" + getBirths);
            case 8 -> System.out.println("Gender: Male - Birth: 23" + getBirths);
            case 9 -> System.out.println("Gender: Female - Birth: 23" + getBirths);
        }
    }

    public static String showRandomNumber(String clientId) {

        return clientId.substring(6, 12);
    }

    public static ArrayList<String> initRegionCode() {
        ArrayList<String> regionCodes = new ArrayList<>();
        regionCodes.add("001,Ha Noi");
        regionCodes.add("002,Ha Giang");
        regionCodes.add("004,Cao Bang");
        regionCodes.add("006,Bac Kan");
        regionCodes.add("008,Tuyen Quang");
        regionCodes.add("010,Lao Cai");
        regionCodes.add("011,Dien Bien");
        regionCodes.add("012,Lai Chau");
        regionCodes.add("014,Son La");
        regionCodes.add("015,Yen Bai");
        regionCodes.add("017,Hoa Binh");
        regionCodes.add("019,Thai Nguyen");
        regionCodes.add("020,Lang Son");
        regionCodes.add("22,Quang Ninh");
        regionCodes.add("024,Bac Giang");
        regionCodes.add("025,Phu Tho");
        regionCodes.add("026,Vinh Phuc");
        regionCodes.add("027,Bac Ninh");
        regionCodes.add("030,Hai Duong");
        regionCodes.add("031,Hai Phong");
        regionCodes.add("033,Hung Yen");
        regionCodes.add("034,Thai Binh");
        regionCodes.add("035,Ha Nam");
        regionCodes.add("036,Nam Dinh");
        regionCodes.add("037,Ninh Binh");
        regionCodes.add("038,Thanh Hoa");
        regionCodes.add("040,Nghe An");
        regionCodes.add("042,Ha Tinh");
        regionCodes.add("044,Quang Binh");
        regionCodes.add("045,Quang Tri");
        regionCodes.add("046,Thua Thien-Hue");
        regionCodes.add("048,Da Nang");
        regionCodes.add("049,Quang Nam");
        regionCodes.add("051,Quang Ngai");
        regionCodes.add("052,Binh Dinh");
        regionCodes.add("054,Phu Yen");
        regionCodes.add("056,Khanh Hoa");
        regionCodes.add("058,Ninh Thuan");
        regionCodes.add("060,Binh Thuan");
        regionCodes.add("062,Kon Tum");
        regionCodes.add("064,Gia Lai");
        regionCodes.add("066,Dak Lak");
        regionCodes.add("067,Dak Nong");
        regionCodes.add("068,Lam Dong");
        regionCodes.add("070,Binh Phuoc");
        regionCodes.add("072,Tay Ninh");
        regionCodes.add("074,Binh Duong");
        regionCodes.add("075,Dong Nai");
        regionCodes.add("077,Ba Ria-Vung Tau");
        regionCodes.add("080,Long An");
        regionCodes.add("082,Tien Giang");
        regionCodes.add("083,Ben Tre");
        regionCodes.add("084,Tra Vinh");
        regionCodes.add("086,Vinh Long");
        regionCodes.add("087,Dong Thap");
        regionCodes.add("089,An Giang");
        regionCodes.add("091,Kien Giang");
        regionCodes.add("092,Can Tho");
        regionCodes.add("093,Hau Giang");
        regionCodes.add("094,Soc Trang");
        regionCodes.add("095,Bac Lieu");
        regionCodes.add("096,Ca Mau");

        return regionCodes;
    }

}
