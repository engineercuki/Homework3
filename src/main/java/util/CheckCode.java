package util;

import java.util.Random;

public class CheckCode {
			
			//設計6位亂數輸出
			//field-自定義數字0-9+英文大小寫對應亂數26+26
				int code=6;
				String characters="AaB1bCc2DdEe3FfGg4HhIi5JjK6kLlM7mNnOo8PpQq9RrSsTtUuVvWwX0xYyZz";
				String result;
				String bkimg;
					
				//constructors
				public CheckCode() {
				StringBuilder sb=new StringBuilder();
				Random random=new Random();
				
					for(int i=0;i<code;i++) {
						int index=random.nextInt(characters.length());
						sb.append(characters.charAt(index));
					}
				
				result=sb.toString();
				
				
				// 隨機選擇背景圖
		        int imageIndex = random.nextInt(20) + 1; // 1~20
		        String imageName = String.format("ckimg%02d.jpg", imageIndex); // cking01.jpg ~ P20.jpg
		       //其中- %d：代表要輸出一個整數（decimal） / - 0：代表用 0 來補足位數 / - 2：代表總共要輸出 2 位數
		        bkimg = "/image/" + imageName;
		        
				}
			
				//methods
				public String show(){
					return result;
				}
				
			    // 回傳背景圖路徑
			    public String getCheckImage() {
			        return bkimg;
			    }

}
