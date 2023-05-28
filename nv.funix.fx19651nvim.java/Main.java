import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        String IDnumber = GetIdentifyNumber();
        System.out.println("ID number: " + IDnumber);
    }

    public static int ClientOption() {
        Scanner myScanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| DIGITAL BANKING | FX19651- Beta version             |");
            System.out.println("+-----------------+--------------------+--------------+");
            System.out.println("| 01.Enter Citizen Identification number.             |");
            System.out.println("| 02.Quit.                                            |");
            System.out.println("+-----------------+--------------------+--------------+");

            System.out.println("Enter number: ");
            num = myScanner.nextInt();
        } while (num != 0 && num != 1);
        myScanner.close();
        return num;
    }

    public static void ValidSecurityCode() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int securityNumber, confirmSec;
        do {
            securityNumber = random.nextInt(1000);
            System.out.println("The secuirty number: " + securityNumber);
            System.out.println(" Nhap ma xac minh ben tren: ");
            confirmSec = sc.nextInt();
        } while (securityNumber != confirmSec);
        sc.close();
    }

    // kiem tra ky lai doan code nay,
    public static String GetIdentifyNumber() {
        Scanner idScanner = new Scanner(System.in);
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
        idScanner.close();
        return clientId;
    }
    //
    // public void RegionCode() {
    // ArrayList<String> regionCodes = new ArrayList<>();
    // regionCodes.add(1, "Ha Noi");
    // regionCodes.add(2, "Ha Giang");
    // regionCodes.add(4, "Cao Bang");
    // regionCodes.add(6, "Bac Kan");
    // regionCodes.add(8, "Tuyen Quang");
    // regionCodes.add(10, "Lao Cai");
    // regionCodes.add(11, "Dien Bien");
    // regionCodes.add(12, "Lai Chau");
    // regionCodes.add(14, "Son La");
    // regionCodes.add(15, "Yen Bai");
    // regionCodes.add(17, "Hoa Binh");
    // regionCodes.add(19, "Thai Nguyen");
    // regionCodes.add(20, "Lang Son");
    // regionCodes.add(22, "Quang Ninh");
    // regionCodes.add(24, "Bac Giang");
    // regionCodes.add(25, "Phu Tho");
    // regionCodes.add(26, "Vinh Phuc");
    // regionCodes.add(27, "Bac Ninh");
    // regionCodes.add(30, "Hai Duong");
    // regionCodes.add(31, "Hai Phong");
    // regionCodes.add(33, "Hung Yen");
    // regionCodes.add(34, "Thai Binh");
    // regionCodes.add(35, "Ha Nam");
    // regionCodes.add(36, "Nam Dinh");
    // regionCodes.add(37, "Ninh Binh");
    // regionCodes.add(38, "Thanh Hoa");
    // regionCodes.add(40, "Nghe An");
    // regionCodes.add(42, "Ha Tinh");
    // regionCodes.add(44, "Quang Binh");
    // regionCodes.add(45, "Quang Tri");
    // regionCodes.add(46, "Thua Thien-Hue");
    // regionCodes.add(48, "Da Nang");
    // regionCodes.add(49, "Quang Nam");
    // regionCodes.add(51, "Quang Ngai");
    // regionCodes.add(52, "Binh Dinh");
    // regionCodes.add(54, "Phu Yen");
    // regionCodes.add(56, "Khanh Hoa");
    // regionCodes.add(58, "Ninh Thuan");
    // regionCodes.add(60, "Binh Thuan");
    // regionCodes.add(62, "Kon Tum");
    // regionCodes.add(64, "Gia Lai");
    // regionCodes.add(66, "Dak Lak");
    // regionCodes.add(67, "Dak Nong");
    // regionCodes.add(68, "Lam Dong");
    // regionCodes.add(70, "Binh Phuoc");
    // regionCodes.add(72, "Tay Ninh");
    // regionCodes.add(74, "Binh Duong");
    // regionCodes.add(75, "Dong Nai");
    // regionCodes.add(77, "Ba Ria-Vung Tau");
    // regionCodes.add(80, "Long An");
    // regionCodes.add(82, "Tien Giang");
    // regionCodes.add(83, "Ben Tre");
    // regionCodes.add(84, "Tra Vinh");
    // regionCodes.add(86, "Vinh Long");
    // regionCodes.add(87, "Dong Thap");
    // regionCodes.add(89, "An Giang");
    // regionCodes.add(91, "Kien Giang");
    // regionCodes.add(92, "Can Tho");
    // regionCodes.add(93, "Hau Giang");
    // regionCodes.add(94, "Soc Trang");
    // regionCodes.add(95, "Bac Lieu");
    // regionCodes.add(96, "Ca Mau");
    //
    // }
    //
    public void ShowInfoClient() {
    String getRegion = clientId.substring(0, 2);
    int clientCode = Integer.parseInt(getRegion);
    System.out.println("Noi sinh:" + regionCodes.get(clientCode));
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
