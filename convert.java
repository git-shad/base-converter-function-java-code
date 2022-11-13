
public class convert {
	public static int mode(String base) throws Exception {
		int bit = 0;
		switch(base) {
			case "bin"://base 2
				bit = 2;
				break;
			case "dec"://base 10
				bit = 10;
				break;
			case "oct"://base 8
				bit = 8;
				break;
			case "hex"://base 16
				bit = 16;
				break;
			default:
				throw new Exception("base code is not accepted");
		}
		return(bit);
	}
	
	public static String decTo(int mode,int dec) {
		double base = mode;
		double d = dec;
		double r = 0.0;
		
		int[] data = new int[1024];
		int  i = 0;
		
		while(true) {
			if((int)d == 0)break;
			System.out.print(" "+(int)d+" / "+(int)base+" = ");
			d = d / base;
			r = d - (int)d;
			System.out.print((int)d + " r "+r+" * "+(int)base+" = ");
			data[i] = (int)(r * base); 
			System.out.println(data[i]);
			++i;
		}
		String result = "";
		for(;i > 0 ;--i) {
			if(mode == 16) {
				switch(data[i - 1]) {
					case 10: result += "A"; break;
					case 11: result += "B"; break;
					case 12: result += "C"; break;
					case 13: result += "D"; break;
					case 14: result += "E"; break;
					case 15: result += "F"; break;
					default: result += data[i - 1];
				}
			}else
				result += data[i - 1];
		}
		return (result);
	}
	
	public static String binTo(int mode,String bin) throws Exception {
		char[] ch = bin.toCharArray();
		int[] data = new int[(int)ch.length];
		int a = ch.length - 1;
		
		//-----------------------------
		for(int i = 0; i < ch.length;i++) {
			if(ch[i] == '1' || ch[i] == '0') {//check if 1 or 0 is
				if(ch[i] == '1') {//locate and convert in to decimal
					int m = 2;
					for(int i1 = 0; i1 < (a - i - 1);++i1) {
						 m *= 2 ;
					}
					data[i] = m;
				}
			}else {
				throw new Exception("can't accept as binary");
			}
		}
		//-------------------------------
		
		int dec = 0;
		int stop = 0;
		for(int i: data) {
			System.out.print(i);
			dec += i;
			if(++stop < ch.length) {
				System.out.print(" + ");
			}
		}System.out.println(" = "+dec+"\n");
		
		return decTo(mode,dec);
	}
	
	public static void main(String[] args) throws Exception {
		//decTo(mode("hex"),431534);
		binTo(mode("hex"),"1100100");
	}

}
