package com.info.userbean;

public class User {
	private String username;
	private String password;
	private int age;
	private String topic;

	public User(String username, String password, int age, String topic) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.topic = topic;
	}

	public String getUsername() {
		return username;
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public User() {
	}

	public boolean validateUser() throws Exception {
		if (age < 18)
			throw new InvalidAgeException();
		else
			return true;
	}

	public void r()
	{
		
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", topic=" + topic + ", age=" + age + "]";
	}

}
