import java.util.Scanner;

public class next_greater_number {

    //returns the number of digits in the number
    private static int find_length(long num){
        int len=0;
        while(num!=0){
            num=num/10;
            len++;
        }
        return len;
    }

    //returns the result of given power 'power' of given number 'num'
    private static long power_function(long num , int power){
        long result=1;
        while(power>0){
            result *= num;
            power--;
        }
        return result;
    }

    //returns 'num' after swapping 'curr_digit' and 'prev_digit'
    private static long swap_digits(long num, int curr_digit, int prev_digit, int power){
    
        num = (num / power_function(10, power))*power_function(10, power) + prev_digit*power_function(10, power-1) + curr_digit*power_function(10, power-2) + num%power_function(10, power-2);

        return num;
    }

    //sorts the ramaining digits right-side of the swap positions.
    private static long sort_remaining_digits(long num , int power){

        int [] arr = {0,0,0,0,0,0,0,0,0,0};
        num = num % power_function(10, power);
        long result = num / power_function(10, power-1);
        num = num % power_function(10, power-1);

        while (num!=0){
            arr[(int) (num % 10)] += 1;
            num /= 10; 
        }

        for ( int index = 0 ; index < 10 ; index++){
            while( arr[index] != 0){
                result = (result*10)+index;
                arr[index] = arr[index]-1;
            }
        }
        
        return result;
    }
    public static void main (String[] args){
        Scanner kbd = new Scanner(System.in);
        long num = kbd.nextLong();
        //293541
        //find the length of num for one time and use it.
        long length_of_num = find_length(num);

        int curr_digit;
        int prev_digit;

        int power;  
        //starts from LSB
        for(power = 2; power <= length_of_num; power++){

            curr_digit = (int) (num % (power_function(10,power)) / power_function(10,power-1));
            prev_digit = (int) (num % (power_function(10, power-1)) / power_function(10, power-2));

            if(curr_digit < prev_digit){
                num = swap_digits(num, curr_digit, prev_digit, power);
                num = ((num / power_function(10, power)) * power_function(10, power)) + sort_remaining_digits(num, power);
                break;
            }
        }
        System.out.println(num);
    }
}

// return the same number if the Next Greater Number is not possible.(given number is the greatest).
