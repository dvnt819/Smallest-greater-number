#include<stdio.h>
int main()
{
    int number,input,a,n=0,count=0,check=1;

    printf("Enter any number : ");
    scanf("%d",&input);

    // to find how many digits of number entered by user.
    number=input;
    for(;number>0;)
    {
        number=number/10;
        n=n+1;
    }

    //declaring an array of total digits.
    int num[n];
    
    //save digits of number at differnt index in array.
    for(int i=n-1;i>=0;i--)
    {
        a =input%10;
        num[i]=a;
        input=input/10;
    }

    //check if the entered number is the greatest or not.
    for(int i=0;i<n-1;i++)
    {
        if(num[i]>=num[i+1])
        {
            check=check+1;
        }
    }
    if(check==n)
    {   
        printf("no grater no. possible.");
        goto exit;
    }


    //checking from right, at which index in array, the right-side digit is greater then the left one.
    for(int i=n-1;i>=0;i--)
    {
        if(num[i]<=num[i-1])
        {
            count=count+1;
        }
        else
        {
            break;
        }
    }
    
    //accending the right side digits from above count.
    for(int i=n-count-1;i<n;i++)
    {
        for(int j=n-count-1;j<n;j++)
        {
            if(num[i]<num[j])
            {
                num[i]=(num[i]+num[j])-(num[j]=num[i]);
            }
        }
    }

    //swapping the counted-digit with the firt greater digit from accending digits.
    for(int i=n-count-1;i<n;i++)
    {
        if(num[i]>num[n-count-2])
        {
            num[i]=(num[i]+num[n-count-2])-(num[n-count-2]=num[i]);
            break;
        }
    }

    //print the array.
    printf("smallest possible greater number : ");
    for(int i=0;i<n;i++)
    {
        printf("%d",num[i]);
    }
    exit:
    return 0;
}
