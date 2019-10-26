//Name: Abhishek Kumar
//Registration number : 1941012170
//Branch : CSE(1st yr)
//Section : R
package com.company;
import java.util.*;
public class full_working_model {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //taking required inputs
        System.out.print("Enter the message do u want to encrypt: ");
        String msg = sc.nextLine();
        msg = msg.toLowerCase();
        msg = msg.replaceAll(" ","");
        System.out.print("Enter the number of digits of pin : ");
        int n = sc.nextInt();
        System.out.print("Enter 1st number : ");
        int num1 = sc.nextInt();
        System.out.print("Enter 2nd number : ");
        int num2 = sc.nextInt();
        System.out.print("Enter 3rd number : ");
        int num3 = sc.nextInt();
        System.out.print("Enter 4th number : ");
        int num4 = sc.nextInt();

        //pin generation
        if (n == Integer.toString(num1).length() && n == Integer.toString(num2).length() && n == Integer.toString(num3).length() && n == Integer.toString(num4).length())
        {
            int a, b, c, d, pin = 0, i = 0;
            while (num1 != 0 && num2 != 0 && num3 != 0 && num4 != 0 && i < n) {
                a = num1 % 10;
                b = num2 % 10;
                c = num3 % 10;
                d = num4 % 10;
                num1 /= 10;
                num2 /= 10;
                num3 /= 10;
                num4 /= 10;
                int x = Math.min(a, Math.min(b, Math.min(c, d)));
                pin = x * (int) Math.pow(10, i) + pin;
                ++i;
            }

            //encryption part
            String pin_str = Integer.toString(pin);
            int f_pos = pin_str.length(),i_pos = 0,part;
            String final_msg = "";

            //for finding number of broken parts of message
            int i1 = msg.length() % pin_str.length();
            int i2 = msg.length()/pin_str.length();
            if(i1 ==0)
                part = i2;
            else part = i1 + i2;


            for(int p = 0;p<=part;p++){
                //for breaking the message:
                String new_msg = msg.substring(i_pos,f_pos);
                i_pos = f_pos;
                if(msg.length()-i_pos > pin_str.length())
                    f_pos += pin_str.length();
                else
                    f_pos = msg.length();

                //for adding pin to corresponding character:
                for (int j =0 ; j <= new_msg.length() - 1; j++) {
                    int num = 0;
                    char ch = 'a';
                    for(int k = 1;k < 26;k++)
                    {
                        if(new_msg.charAt(j) == ch)
                        {num = k;break;}
                        else
                            ch++;
                    }
                    //converting pin character to integer:
                    long digit = Integer.parseInt(String.valueOf(pin_str.charAt(j)));

                    num += digit;
                    num %= 26;
                    ch = 'a';
                    for (int k = 1;k < 26;k++){
                        if(num == k)
                            break;
                        else if(num == 0) ch = 'z';
                        else
                            ch++;
                    }
                    //replacing the jth character with new character:
                    new_msg = new_msg.substring(0, j) + ch + new_msg.substring(j + 1);
                }
                final_msg = final_msg.concat(new_msg);
            }
            System.out.println("Your encrypted message is "+final_msg.toUpperCase());
        }
        else System.out.println("Sorry.....Entered numbers are of not of equal length or it is not equal to number of digits you have entered...Try next time. ");
    }
}
