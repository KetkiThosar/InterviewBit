package com.ib.arrays;

public class SpiralOrderMatrix2 {
	static void spiralPrint(int maxRow, int maxCol, int a[][])
	{
	    int i, row = 0, col = 0;
	 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
	 
	    while (row < maxRow && col < maxCol)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = col; i < maxCol; ++i)
	        {
	            System.out.print(a[row][i]+"\t");
	        }
	        row++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = row; i < maxRow; ++i)
	        {
	        	System.out.print(a[i][maxCol-1] +"\t" );
	        }
	        maxCol--;
	 
	        /* Print the last row from the remaining rows */
	        if ( row < maxRow)
	        {
	            for (i = maxCol-1; i >= col; --i)
	            {
	            	System.out.print( a[maxRow-1][i]+"\t");
	            }
	            maxRow--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (col < maxCol)
	        {
	            for (i = maxRow-1; i >= row; --i)
	            {
	            	System.out.print(a[i][col]+"\t");
	            }
	            col++;    
	        }        
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				  {133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
				  {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
				  {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}
				  };
		//int [][]arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		//int [][]arr={{1},{2},{3}};
		spiralPrint(arr.length,arr[0].length,arr);
	}

}
