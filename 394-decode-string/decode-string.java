class Solution {
    public String decodeString(String s) {
     Stack<Integer> countstack=new Stack<>();
     Stack<StringBuilder> stringstack=new Stack<>();

     StringBuilder currentstring=new StringBuilder();
     int   currentnumber=0;
     for(char ch:s.toCharArray())
     {
        if(Character.isDigit(ch))
        {
            currentnumber=currentnumber*10+(ch-'0');
        }
        else if(ch=='[')
        {
            countstack.push(currentnumber);
            stringstack.push(currentstring);

            currentnumber=0;
            currentstring = new StringBuilder();

        }
        else if(ch==']')
        {
          int  repeat=countstack.pop();
          StringBuilder decode=stringstack.pop();

            for(int i=0;i<repeat;i++)
            {
                decode.append(currentstring);
            }

            currentstring=decode;
        }
        else
        currentstring.append(ch);
     }   
     return currentstring.toString();
    }
}