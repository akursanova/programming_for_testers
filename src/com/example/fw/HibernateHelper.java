package com.example.fw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.ContactParameters;
import com.example.tests.GroupParameters;
import com.example.utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public List<GroupParameters> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<GroupParameters>(
              (List<GroupParameters>) session.createQuery("from GroupParameters").list());
		} finally {
          trans.commit();
		}
	}

	public List<ContactParameters> listContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<ContactParameters>(
              (List<ContactParameters>) session.createQuery("from ContactParameters").list());
		} finally {
          trans.commit();
		}
	}
	
}
