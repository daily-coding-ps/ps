class Solution_shopping {
    public int[] solution(String[] gems) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int start = 0;
        int startPoint=0;
        int end = Integer.MAX_VALUE;
        
        int[] answer = {};
        
        
        for(int i=0;i<gems.length;i++) {
        	hs.add(gems[i]);
        }
       

        for(int i=0;i<gems.length;i++) {
        	hm.put(gems[i], hm.getOrDefault(gems[i],0)+1);
        	
        	q.add(gems[i]);
        	
        	while(true) {
        		String temp = q.peek();
        		if(hm.get(temp)>1) {
        			//2이상 있으면
        			q.poll();
        			start++;
        			hm.put(temp, hm.get(temp)-1);
        		}else break;
        	}
        	
        	if(hm.size() == hs.size() && end > q.size()) {
        		end = q.size();
        		startPoint = start;
        	}
        	
        }
        
        return new int[] {startPoint+1, startPoint+end}; 
    }
}
