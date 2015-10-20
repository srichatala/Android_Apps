package com.example.assignment3;

import java.util.ArrayList;

import android.widget.TextView;

public class MagicSquare {
	
	public String getMagicSquare(int size) {
		StringBuilder sb = new StringBuilder();
  	  	if (size%2==0){
			//System.out.println("The size should be odd!");
			//System.exit(0);
  	  		sb.append("Please enter odd number!");
  	  		return sb.toString();
		}
		int [] [] square= new int [size][size];
		int col = size/2;
		square [0][col]=1;
		square[size-1][col]=size*size;
		square[size-1][(size/2)+1] =2;  
		int row =(size-1)-1;
		col=((size/2)+1)+1;
		for (int i=3; i<((size*size)); i++){		
			if (col>size-1&&row<0){				
				row=row+2;
				col=col-1;				
				square[row][col]=i;
				row=row-1;
				col=col+1;
				}	
		
			else if (row<0){			
			row=size-1;			
		    square[row][col]=i;
		    row=row-1;
			col=col+1;
			}
			
			else if (col>size-1){			
			col=0;			
			square[row][col]=i;
			row=row-1;
			col=col+1;
			}
			
			else if (square[row][col]>0){			
			row=row+2;
			col=col-1;			
			square[row][col]=i;
			row=row-1;
			col=col+1;			
			}	
		else{			
			square[row][col]=i;
			row=row-1;
			col=col+1;
			}		
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
          	  
            	sb.append(square[i][j]);
            	sb.append("  ");
            }
            sb.append('\n');
        }
		return sb.toString();
				
   }

}
