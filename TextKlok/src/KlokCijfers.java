
public class KlokCijfers {

	int Hour;
	int Minute;
	int TempHour;
	int TempMinute;
	
	public KlokCijfers(int Uur,int Minuteuut, int tempuur, int tempminuut){
		Hour = Uur;
		Minute = Minuteuut;
		TempHour = tempuur;
		TempMinute = tempminuut;
	}

	public String getHourName(){
		switch(Hour){
		case 0 : return "Twaalf";
		case 1 : return "Een";
		case 2 : return "Twee";
		case 3 : return "Drie";
		case 4 : return "Vier";
		case 5 : return "Vijf";
		case 6 : return "Zes";
		case 7 : return "Zeven";
		case 8 : return "Acht";
		case 9 : return "Negen";
		case 10 : return "Tien";
		case 11 : return "Elf";
		case 12 : return "Twaalf";
		case 13 : return "Een";
		case 14 : return "Twee";
		case 15 : return "Drie";
		case 16 : return "Vier";
		case 17 : return "Vijf";
		case 18 : return "Zes";
		case 19 : return "Zeven";
		case 20 : return "Acht";
		case 21 : return "Negen";
		case 22 : return "Tien";
		case 23 : return "Elf";
		}
		return null;
	}
	
	public String getMinuteuteName(){
		switch(Minute){
	case 1 : return "Een";
	case 2 : return "Twee";
	case 3 : return "Drie";
	case 4 : return "Vier";
	case 5 : return "Vijf";
	case 6 : return "Zes";
	case 7 : return "Zeven";
	case 8 : return "Acht";
	case 9 : return "Negen";
	case 10 : return "Tien";
	case 11 : return "Elf";
	case 12 : return "Twaalf";
	case 13 : return "Dertien";
	case 14 : return "Veertien";
		}
		return null;
	}
	
	public String getTimeString(){
		if (TempMinute == 00){ return "Null";}
		if (TempMinute == 15){return "kwart over";}
		if (TempMinute == 45){return "kwart voor";}
		if (TempMinute == 30){ return "half";}
		if (TempMinute > 0 && TempMinute < 15){return "over";}
		if (TempMinute > 15 && TempMinute < 30){return "voor half";}
		if (TempMinute > 30 && TempMinute < 45){return "over half";}
		if (TempMinute > 45 ){return "voor";}
		return null;
	}
	
	public String[] getFormattedTime(){
		if (getTimeString().equals("Null")){
			String[] a = {"1",this.getHourName()};
			return a;
		}
		if (getTimeString().equals("kwart over")||getTimeString().equals("kwart voor")||getTimeString().equals("half")){
			String[] a = {"2",getTimeString(),this.getHourName()};
			return a;
		}
		String[] a = {"3",this.getMinuteuteName(),this.getTimeString(),this.getHourName()};
		return a;
	}

}
