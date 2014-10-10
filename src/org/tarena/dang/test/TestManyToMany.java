package org.tarena.dang.test;

import org.hibernate.Session;
import org.junit.Test;
import org.tarena.dang.entity.Category;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.HibernateUtil;

public class TestManyToMany {
	public static void main(String args[]){
		Session session=HibernateUtil.getSession();
		Category cat=(Category) session.get(Category.class, 9);
		System.out.println(cat.getId()+" "+cat.getName());
		System.out.println("---该类别所包含图书---");
		for(Product pro:cat.getPros()){
			System.out.println(pro.getId()+"  "+pro.getProductPic());
		}
		HibernateUtil.closeSession();
	}
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		Product pro=(Product) session.get(Product.class, 23);
		System.out.println(pro.getId()+" "+pro.getProductPic());
		System.out.println("---该图书别所包属的所有类别---");
		for(Category cat:pro.getCats()){
			System.out.println(cat.getId()+"  "+cat.getName());
		}
		HibernateUtil.closeSession();
		
	}
}
