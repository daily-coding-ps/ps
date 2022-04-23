class Solution_tuple {
    public int[] solution(String s) {
        
    	int[] answer;

    	s = s.substring(2,s.length()-2).replace("},{", "-");
    	
    	// 숫자만 저장
    	String []comma = s.split("-");
    	
    	// 문자열 길이 정렬
    	Arrays.sort(comma, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
    		
    	});
    	
    	ArrayList<Integer> arr = new ArrayList<>();
    	
    	for(int i=0;i<comma.length;i++) {
    		System.out.println(comma[i]);
    		String[] numbers = comma[i].split(",");

        	for(int j=0;j<numbers.length;j++) {
        		int num = Integer.parseInt(numbers[j]);
        		
        		if(!arr.contains(num)) {
        			arr.add(num);
        		}
        	}
    	}
    	
    	answer = new int[arr.size()];
    	
    	for(int i=0;i<arr.size();i++) {
    		answer[i]=arr.get(i);
    	}
    	return answer;
    }
}
