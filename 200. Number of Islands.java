public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                /*find a cell belong to an island, then disappear the whole 
                  island and increase count*/
                if(grid[i][j] == '1'){
                    disappear(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    //Use for disapearing an island
    public void disappear(int i, int j, char[][] grid){
        //array edge detect
        if(i < 0 || i >= grid.length){
            return;
        }
        if(j < 0 || j >= grid[i].length){
            return;
        }
        //island edge detect
        if(grid[i][j] == '0'){
            return;
        }

        //disapear this cell
        grid[i][j] = '0';
        //disapear other cell in the same island
        disappear(i + 1, j, grid);
        disappear(i - 1, j, grid);
        disappear(i, j + 1, grid);
        disappear(i, j - 1, grid);
    }
}
