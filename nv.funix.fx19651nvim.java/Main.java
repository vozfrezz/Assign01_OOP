import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> regionCodes = new ArrayList<>();
        int clientChoose = ClientOption(scanner);
        String clientIdNumber = "0";
        switch (clientChoose) {
            case 1:
                ValidSecurityCode(scanner);
                clientIdNumber = GetIdentifyNumber(scanner);

                System.out.println("+-----------------+--------------------+--------------+");
                System.out.println("| DIGITAL BANKING | FX19651- Beta version             |");
                System.out.println("+-----------------+--------------------+--------------+");
                System.out.println("| 1.Enter Citizen Identification number.             |");
                System.out.println("| 0.Quit.                                            |");
                System.out.println("+-----------------+--------------------+--------------+");
                System.out.println("Your ID number: " + clientIdNumber);
                System.out.println("\t| 1. Kiem tra noi sinh");
                System.out.println("\t| 2. Kiem tra tuoi,gioi tinh");
                System.out.println("\t| 3. Kiem tra so ngau nhien");
                System.out.println("\t| 0. Thoat");

                break;
            case 0:
                System.exit(0);
                break;
        }

        ////////////////////
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

    }

    public static int ClientOption(Scanner myScanner) {
        int num;
        do {
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| DIGITAL BANKING | FX19651- Beta version             |");
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| 1.Enter Citizen Identification number.             |");
            System.out.println("| 0.Quit.                                            |");
            System.out.println("+-----------------+--------------------+--------------+");

            System.out.println("Enter number: ");
            num = myScanner.nextInt();
        } while (num != 0 && num != 1);
        return num;
    }

    public static void ValidSecurityCode(Scanner sc) {
        Random random = new Random();
        int securityNumber, confirmSec;
        do {
            securityNumber = random.nextInt(1000);
            System.out.println("The secuirty number: " + securityNumber);
            System.out.println(" Nhap ma xac minh ben tren: ");
            confirmSec = sc.nextInt();
        } while (securityNumber != confirmSec);

    }

    // kiem tra ky lai doan code nay,
    public static String GetIdentifyNumber(Scanner idScanner) {
        int isIdValid = 0;
        String clientId;
        do {
            System.out.println("Enter your ID: ");
            clientId = idScanner.next();
            if (clientId.length() != 12) {
                isIdValid = 1;
            } else {
                for (int i = 0; i < clientId.length(); i++) {
                    char ch = clientId.charAt(i);
                    if (!Character.isDigit(ch)) {
                        isIdValid = 1;
                        break;
                    }
                }
            }
        } while (isIdValid == 1);
        return clientId;
    }

    //
    public static String showRegion(String clientId, ArrayList<String> regionCodes) {
        String getRegion = clientId.substring(0, 2);
        String quequan = "0";
        for (int i = 0; i < regionCodes.size(); i++) {
            String matinhthanhpho = (regionCodes.get(i)).substring(0, 2);// lay ra ma tinh trong arraylist
            int strlen = (regionCodes.get(i)).length();
            String tentinhthanhpho = (regionCodes.get(i)).substring(3, strlen);
            if (getRegion.equals(matinhthanhpho)) {
                quequan = tentinhthanhpho;
                break;
            }
            ;
        }
        return quequan;
    }

    public String ShowInfoClient() {

        char getGender = clientId.charAt(3);
        String getBirths = clientId.substring(4, 6);
        String getRadomId = clientId.substring(7, 11);
        switch (getGender) {
            case 0:
                System.out.println("Gioi tinh : Nam; sinh nam:19" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 1:
                System.out.println("Gioi tinh : Nu; sinh nam:19" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 2:
                System.out.println("Gioi tinh : Nam; sinh nam:20" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 3:
                System.out.println("Gioi tinh : Nu; sinh nam:20" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 4:
                System.out.println("Gioi tinh : Nam; sinh nam:21" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 5:
                System.out.println("Gioi tinh : Nu; sinh nam:21" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 6:
                System.out.println("Gioi tinh : Nam; sinh nam:22" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 7:
                System.out.println("Gioi tinh : Nu; sinh nam:22" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 8:
                System.out.println("Gioi tinh : Nam; sinh nam:23" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
            case 9:
                System.out.println("Gioi tinh : Nu; sinh nam:23" + getBirths);
                System.out.println("So ngau nhien:" + getRadomId);
                break;
        }
    }

}
