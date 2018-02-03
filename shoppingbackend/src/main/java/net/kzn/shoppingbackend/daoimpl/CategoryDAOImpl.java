package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	static {
		Category cat1 = new Category();
		cat1.setId(1);
		cat1.setName("Television");
		cat1.setDescription("This is some description for Television");
		cat1.setImageURL("CAT_1.png");
		
		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Mobile");
		cat2.setDescription("This is some description for Mobile");
		cat2.setImageURL("CAT_2.png");
		
		Category cat3 = new Category();
		cat3.setId(3);
		cat3.setName("Laptop");
		cat3.setDescription("This is some description for Laptop");
		cat3.setImageURL("CAT_3.png");
		
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
	}

	@Override
	public List<Category> list() {
		return categories;
	}
	
	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {
//		Category category = null;
//		category = categories.get(id);
		
		for(Category category: categories) {
			if(category.getId() == id) return category;
		}
		return null;

	}
}