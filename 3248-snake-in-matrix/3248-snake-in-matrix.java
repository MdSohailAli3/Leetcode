class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i=0, j=0;
        int len = commands.size();

        for(int idx = 0; idx<len; idx++){
            String curr = commands.get(idx);
            if(curr.equals("LEFT")) j--;
            else if(curr.equals("RIGHT")) j++;
            else if(curr.equals("UP")) i--;
            else if(curr.equals("DOWN")) i++;
        }
        return i*n + j;
    
    }

}