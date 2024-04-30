
public class Stuff {



	public static void main(String[] args) {
				
	   Member member = new Member("Nelson", 29, "grade 7");
	   RoleChecker role = new RoleChecker(member);
	   System.out.println(member.getName());
       System.out.println(role.toString());
	}


}
class Member{
	private String name;
	private int age;
	private String qualification;
	
	public Member(String name, int age,String qualification){
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
class RoleChecker{
	private Member member;

	RoleChecker(Member member){
		this.member = member;
	}
	
	public boolean isHeadOfDepartment() {
		String education = member.getQualification();
		return education.equals("P.H.D");
	}
	public boolean isSecretary() {
		String education = member.getQualification();
		return education.equals("Masters") || education.equals("P.H.D");
	}
	public boolean isOrdinaryLecturer() {
		String education = member.getQualification();
		return education.equals("Masters") || education.equals("P.H.D");
	}
	public boolean isCleaner() {
		String education = member.getQualification();
		return education.equals("High school diploma") || education.equals("junior high school diploma")|| education.equals("P.H.D")|| education.equals("Masters");
	}

	public String toString() {
		if(isHeadOfDepartment()) {
			return "you are qualified to be the" + "\n" +"HOD" + "\n" + "secretary" + "\n" + "Ordinary lecturer";
		}
		else if(isSecretary()) {
			return "you are qualified to be a" +"\n" + "secretary" +  "\n" + "Ordinary lecturer";
		}
		else if(isOrdinaryLecturer()) {
			return "you are qualified to be a "  +  "\n" + "Ordinary lecturer" + "\n" + "Secretary";
		}
		else if(isCleaner()) {
			return "You are qualified to be a cleaner";
		}
		else
			return "There is no job for you here";
	}
	
}
