class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int arr[] = new int[3]; //3번의 기회
        int chance=0;
        String s="";
        
        for(int i=0;i<dartResult.length();i++) {
        	switch(dartResult.charAt(i)) {
        	case '*' :
        		arr[chance-1]=arr[chance-1]*2;
        		if(chance>1) arr[chance-2]=arr[chance-2]*2;
        		break;
        	case '#':
        		arr[chance-1]=arr[chance-1]*-1;
        		break;
        	case 'S':
        		arr[chance]=(int)Math.pow(Integer.parseInt(s), 1);
        		s="";
        		chance++;
        		break;
        	case 'D':
        		arr[chance]=(int)Math.pow(Integer.parseInt(s), 2);
        		chance++;
        		s="";
        		break;
        	case 'T':
        		arr[chance]=(int)Math.pow(Integer.parseInt(s), 3);
        		chance++;
        		s="";
        		break;
        	default:
        		s += String.valueOf(dartResult.charAt(i));
        		break;
        	}
        	
        }
        
        for(int i=0;i<arr.length;i++) {
        	answer+=arr[i];
        }
        return answer;
    }
}
