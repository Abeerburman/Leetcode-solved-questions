class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;
        int d = 0;
        while(x>0)
        {
            d = x%10;
            rev = rev*10+d;
            x = x/10;
        }
        if(temp==rev)
        return true;
        else
        return false;
    }
}