public int solution(int n, int k) {
        int count=0;
        String num="";
        
        //k진수로 바꾸기
        while(n>0) {
        	num=n%k+num;
        	n/=k;
        }
        
       int j=0;
       for(int i = 0; i < num.length(); i = j) {
           for(j = i + 1; j < num.length() && num.charAt(j) != '0'; j++);
           if(sosu(Long.parseLong(num.substring(i,j))))
               count++;
       }
       
       return count;
    }
    
    // 소수인지 판단
    private boolean sosu(long n) {
    	 if(n <= 1) return false;
         else if(n == 2) return true;
         for(int i = 2; i <= Math.sqrt(n); i++)
             if(n % i == 0) 
                 return false;
         return true;
    }
