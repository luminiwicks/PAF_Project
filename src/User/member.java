package User;

public class member {
	
	private String fullname,dob,paddress,caddress,mobile,homenumber,password,email,nic;
	private int member_id;
	
	
	public member(String fullname, String dob, String paddress, String caddress, String mobile, String homenumber,
			String password, String email, int member_id,String nic) {
		
		this.fullname = fullname;
		this.dob = dob;
		this.paddress = paddress;
		this.caddress = caddress;
		this.mobile = mobile;
		this.homenumber = homenumber;
		this.password = password;
		this.email = email;
		this.nic = nic;
		this.member_id = member_id;
	}


	public member(String fullname, String dob, String paddress, String caddress, String mobile, String homenumber,
			String password, String email,String nic) {
		this.fullname = fullname;
		this.dob = dob;
		this.paddress = paddress;
		this.caddress = caddress;
		this.mobile = mobile;
		this.homenumber = homenumber;
		this.password = password;
		this.email = email;
		this.nic = nic;
	}
    
	




	@Override
	public String toString() {
		return "member [fullname=" + fullname + ", dob=" + dob + ", paddress=" + paddress + ", caddress=" + caddress
				+ ", mobile=" + mobile + ", homenumber=" + homenumber + ", password=" + password + ", email=" + email
				+ ", nic=" + nic + ", member_id=" + member_id + "]";
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getPaddress() {
		return paddress;
	}


	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getHomenumber() {
		return homenumber;
	}


	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getMember_id() {
		return member_id;
	}


	public void setMember_id(int member_id) {
		this.member_id = member_id;
	} 
	
	
	
	
	

}
