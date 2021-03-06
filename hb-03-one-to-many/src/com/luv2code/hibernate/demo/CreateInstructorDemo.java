package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = 
					new Instructor("Susan", "Public", "susan.public@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"https://www.youtube.com",
							"Playing game");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// (link them up. 이 두 객체가 memory에서 연관됨)
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note : this will ALSO save the details object
			// because of CascadeType.ALL
			//
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			//한번의 save로 2개의 table에 정보 저장.
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			//add clean up code
			session.close();

			factory.close();
		}
	}

}
