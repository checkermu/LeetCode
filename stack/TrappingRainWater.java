/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年5月9日上午10:51:05
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		System.out.println(trapOK(height));
//		trap(height);
		trapTwo(height);
	}

	/**
	 * 第一个，用栈解决，找到最高点，左右进行
	 * @param height
	 * @return
	 */
	public static int trap(int[] height) { //329ms
        int total=0;
        
        if(height.length>0){
        	int maxIndex = 0;
        	for (int j=1; j<height.length; j++){
            	if(height[j]>height[maxIndex]){
            		maxIndex=j;
            	}
            }
            Stack<Integer> tmpStack = new Stack<Integer>();
    		for(int i=0; i<=maxIndex; i++){
    			
    			if(tmpStack.isEmpty()){
    				tmpStack.add(height[i]);
    			}else{
    				if(height[i]<tmpStack.firstElement()){
    					tmpStack.add(height[i]);
    				}else{
    					while(!tmpStack.isEmpty()){
    						total += tmpStack.firstElement()-tmpStack.pop();
    					}
    					tmpStack.add(height[i]);
    				}
    			}
    		}
    		tmpStack.clear();
    		for(int k=height.length-1; k>=maxIndex; k--){
    			
    			if(tmpStack.isEmpty()){
    				tmpStack.add(height[k]);
    			}else{
    				if(height[k]<tmpStack.firstElement()){
    					tmpStack.add(height[k]);
    				}else{
    					while(!tmpStack.isEmpty()){
    						total += tmpStack.firstElement()-tmpStack.pop();
    					}
    					tmpStack.add(height[k]);
    				}
    			}
    		}
    		System.out.println("total:"+total);
    		return total;
        }else{
        	return total;
        }
        
		
    }
	
	// AC 319ms
	/**
	 * 木桶理论，此点两边最高点maxLeft, maxRight, 存水量min(maxLeft, maxRight)-height[i]
	 * @param height
	 * @return
	 */
	public int trapAC1(int[] height){
		int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int total=0;
        if(height.length > 0){
            int max = height[0];
            for(int i=1; i<height.length; i++){
                maxLeft[i]=max;
                if(height[i]>max){
                    max = height[i];
                }
            }
            max = height[height.length-1];
            for(int j=height.length-2; j>=0; j--){
                maxRight[j]=max;
                if(height[j]>max){
                    max = height[j];
                }
            }

            for(int k=1; k<height.length-1; k++){
                int tmp = Math.min(maxLeft[k], maxRight[k]) - height[k];
                if(tmp>0){
                    total += tmp;
                }
            }
            
            return total;
        }else{
            return total;
        }
	}
	
	//AC  387ms
	/**
	 * 最高点分隔，左边h是左边最高点， h比[i]大，则water+=h-[i]
	 * @param height
	 * @return
	 */
	public static int trapTwo(int[] height){
		int n = height.length;
		int total = 0;
		if(n>0){
			int maxIndex=0;
			for(int i=0; i<n; i++){
				if(height[i]>height[maxIndex]){
					maxIndex=i;
				}
			}
			int h=0;
			for (int i=0; i<maxIndex; i++){
				if(h>height[i])
					total += h-height[i];
				else
					h=height[i];
			}
			h=0;
			for (int i=n-1; i>maxIndex; i--){
				if(h>height[i])
					total += h-height[i];
				else
					h=height[i];
			}
			System.out.println("total:"+total);
			return total;
		}else
			return total;
		
	}
	
}