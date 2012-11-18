
public class KlokBerekenen {
	public String[] process(String in){
		String[] sIn = receiveInput(in);
		if (sIn == null){return null;}
		int TempHour = Integer.parseInt(sIn[0]);
		int TempMinute = Integer.parseInt(sIn[1]);
		int Hour = correctHour(TempMinute,TempHour);
		int Minute = correctMinute(TempMinute);
		KlokCijfers output = new KlokCijfers(Hour,Minute,TempHour,TempMinute);
		return output.getFormattedTime();
	}
	
	public static String[] receiveInput(String in){
		
		if (!checkValidInput(in)){
			return null;
		}
		return in.split(":");
	}
	
	public static boolean checkValidInput(String in){
		if (!in.contains(":")){
			return false;
		}
		int H = Integer.parseInt(in.split(":")[0]);
		if (H > 23 || H < 0 ){
			return false;
		}
		int M = Integer.parseInt(in.split(":")[1]);
		if (M > 59 || M < 0 ){
			return false;
		}
		return true;
	}
	
	public static int correctHour(int minute, int hour){
		if (minute > 15){
			return hour+1;
		}
		return hour;
	}
	
	public static int correctMinute(int min){
		if (min > 0 && min < 15){return min;}
		if (min > 15 && min < 30){return 30-min;}
		if (min > 30 && min < 45){return min-30;}
		if (min > 45){return 60-min;}
		return min;
	}
}
