public class ArmstrongNumber {

    public static void main(String[] args) {
        int number = 153; // Example input
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }


    /*
     * Input: 1634
     * Output: Yes
     * 1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4 = 1634
    */

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();  //int p = (int)Math.log10(n)+1;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }
}
