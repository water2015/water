package com.water.collection.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobCandidate implements Comparable<JobCandidate> {
	private String name;
	private String gender;
	private int age;

	public JobCandidate(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(JobCandidate candidate) {
		return (this.getAge() < candidate.getAge() ? -1 : (this.getAge() == candidate.getAge() ? 0 : 1));
	}

	@Override
	public String toString() {
		return " Name: " + this.name + ", Gender: " + this.gender + ", age:" + this.age;
	}

	public static Comparator<JobCandidate> ageComparator = new Comparator<JobCandidate>() {
		@Override
		public int compare(JobCandidate jc1, JobCandidate jc2) {
			return (jc2.getAge() < jc1.getAge() ? -1 : (jc2.getAge() == jc1.getAge() ? 0 : 1));
		}
	};
	public static Comparator<JobCandidate> nameComparator = new Comparator<JobCandidate>() {
		@Override
		public int compare(JobCandidate jc1, JobCandidate jc2) {
			return (int) (jc1.getName().compareTo(jc2.getName()));
		}
	};

	public static void main(String[] args) {
		JobCandidate jobCandidate1 = new JobCandidate("Mark Smith", "Male", 26);
		JobCandidate jobCandidate2 = new JobCandidate("Sandy Hunt", "Female", 23);
		JobCandidate jobCandidate3 = new JobCandidate("Betty Clark", "Female", 20);
		JobCandidate jobCandidate4 = new JobCandidate("Andrew Styne", "Male", 24);
		List<JobCandidate> jobCandidateList = new ArrayList<JobCandidate>();
		jobCandidateList.add(jobCandidate1);
		jobCandidateList.add(jobCandidate2);
		jobCandidateList.add(jobCandidate3);
		jobCandidateList.add(jobCandidate4);

		Collections.sort(jobCandidateList);
		Collections.sort(jobCandidateList, Collections.reverseOrder());
		Collections.sort(jobCandidateList, JobCandidate.ageComparator);
		Collections.sort(jobCandidateList, JobCandidate.nameComparator);

		System.out.println("-----Sorted JobCandidate by age: Ascending-----");
		for (JobCandidate jobCandidate : jobCandidateList) {
			System.out.println(jobCandidate);
		}
	}
}
