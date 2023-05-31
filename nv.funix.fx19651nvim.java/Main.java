import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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
        int menuOption = 0;
        boolean isValidInput = false;
        do {
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| DIGITAL BANKING | FX19651- Beta version             |");
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| 1.Enter Citizen Identification Number.              |");
            System.out.println("| 0.Quit.                                             |");
            System.out.println("+-----------------+--------------------+--------------+");
            try {
                System.out.println("Enter option: ");
                menuOption = myScanner.nextInt();
                myScanner.nextLine();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("You can't input a character!");
                myScanner.nextLine();
            } catch (Exception e) {
                System.out.println("Somthing went wrong!!!");
                myScanner.nextLine();
            }
        } while (!isValidInput || menuOption != 0 && menuOption != 1);
        return menuOption;
    }

    public static void ValidVerificationCode(Scanner sc) {
        int menuOption = 0;
        boolean isValidInput = false;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rng = new Random();
        int length = 6;
        boolean match = false;
        char[] text = new char[length];
        char[] confirmtext;
        int rngNumber, userConfirm;

        System.out.println("Chon chuc nang:");
        System.out.println("1. Xac thuc 3 ky tu so.");
        System.out.println("2.Xac thuc 6 ky tu.");
        System.out.println("0. Thoat chuong trinh.");
        do {
            try {
                System.out.println("Enter option: ");
                menuOption = sc.nextInt();
                sc.nextLine();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("You can't input a character!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Somthing went wrong!!!");
                sc.nextLine();
            }

        } while (!isValidInput || menuOption < 0 || menuOption > 2);

        switch (menuOption) {
            case 1:
                do {
                    rngNumber = rng.nextInt(1000);
                    System.out.println("Verification number: " + rngNumber);
                    System.out.println("Enter the verification number above: ");
                    userConfirm = sc.nextInt();
                    sc.nextLine();

                } while (rngNumber != userConfirm);

                break;
            case 2:
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

                break;

            case 0:
                System.exit(0);
                break;
        }

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
        int menuOption = 0;
        boolean isValidInput = false;
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
            try {
                System.out.println("Enter a number:");
                menuOption = scanner.nextInt();
                scanner.nextLine();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong!");
                scanner.nextLine();
            }
        } while (!isValidInput || menuOption < 0 || menuOption > 3);
        return menuOption;
    }

    public static String showRegion(String clientId, ArrayList<String> regionCodes) {
        String getRegion = clientId.substring(0, 3);
        String birthPlace = null, extraRegionCodes;
        String regionName;
        int strlen;
        for (String regionCode : regionCodes) {
            extraRegionCodes = regionCode.substring(0, 3);// lay ra ma tinh trong arraylist
            strlen = regionCode.length();
            regionName = regionCode.substring(4, strlen);
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
        ArrayList<String> regionCodes = new ArrayList<>(Arrays.asList(
                "001,Ha Noi",
                "002,Ha Giang",
                "004,Cao Bang",
                "006,Bac Kan",
                "008,Tuyen Quang",
                "010,Lao Cai",
                "011,Dien Bien",
                "012,Lai Chau",
                "014,Son La",
                "015,Yen Bai",
                "017,Hoa Binh",
                "019,Thai Nguyen",
                "020,Lang Son",
                "22,Quang Ninh",
                "024,Bac Giang",
                "025,Phu Tho",
                "026,Vinh Phuc",
                "027,Bac Ninh",
                "030,Hai Duong",
                "031,Hai Phong",
                "033,Hung Yen",
                "034,Thai Binh",
                "035,Ha Nam",
                "036,Nam Dinh",
                "037,Ninh Binh",
                "038,Thanh Hoa",
                "040,Nghe An",
                "042,Ha Tinh",
                "044,Quang Binh",
                "045,Quang Tri",
                "046,Thua Thien-Hue",
                "048,Da Nang",
                "049,Quang Nam",
                "051,Quang Ngai",
                "052,Binh Dinh",
                "054,Phu Yen",
                "056,Khanh Hoa",
                "058,Ninh Thuan",
                "060,Binh Thuan",
                "062,Kon Tum",
                "064,Gia Lai",
                "066,Dak Lak",
                "067,Dak Nong",
                "068,Lam Dong",
                "070,Binh Phuoc",
                "072,Tay Ninh",
                "074,Binh Duong",
                "075,Dong Nai",
                "077,Ba Ria-Vung Tau",
                "080,Long An",
                "082,Tien Giang",
                "083,Ben Tre",
                "084,Tra Vinh",
                "086,Vinh Long",
                "087,Dong Thap",
                "089,An Giang",
                "091,Kien Giang",
                "092,Can Tho",
                "093,Hau Giang",
                "094,Soc Trang",
                "095,Bac Lieu",
                "096,Ca Mau"));
        return regionCodes;
    }

}
