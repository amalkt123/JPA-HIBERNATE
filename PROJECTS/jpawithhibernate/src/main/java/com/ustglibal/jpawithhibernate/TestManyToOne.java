package com.ustglibal.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglibal.jpawithhibernate.manytoone.Pencil;
import com.ustglibal.jpawithhibernate.manytoone.PencilBox;

public class TestManyToOne {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction entityTransaction=null;
		PencilBox box=new PencilBox();
		box.setBid(4);
		box.setBname("nadaraj");
		Pencil pencil=new Pencil();
		pencil.setPid(17);
		pencil.setColor("black");
		pencil.setBox(box);
		Pencil pencil1=new Pencil();
		pencil1.setPid(18);
		pencil1.setColor("black");
		pencil1.setBox(box);
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(pencil);
            entityManager.persist(pencil1);
		   entityTransaction.commit();
		}catch (Exception e) {
			//entityTransaction.rollback();
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
