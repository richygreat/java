package filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Vector;

import bean.User;

public class FilterUtil<T> {

	public static void main(String[] args) {
		IPredicate<User> isAuthorized = new IPredicate<User>() {
		    public boolean apply(User user) {
		        // binds a boolean method in User to a reference
		        return "INACTIVE".equalsIgnoreCase(user.getStatus());
		    }
		};
		
		Vector<User> allUsers = new Vector<User>();
		User u = new User();
		u.setId(1);
		u.setName("Richy Great");
		u.setStatus("ACTIVE");
		allUsers.add(u);
		u = new User();
		u.setId(2);
		u.setName("Kuchi Great");
		u.setStatus("INACTIVE");
		allUsers.add(u);
		Collection<User> authorizedUsers = filter(allUsers, isAuthorized, Vector.class);
		System.out.println(authorizedUsers);
	}

	public static <T, C> Collection<T> filter(Collection<T> target,
			IPredicate<T> predicate, Class<C> clazz) {
		Collection<T> result = getCollectionInstance(clazz);
		for (T element : target) {
			if (predicate.apply(element)) {
				result.add(element);
			}
		}
		return result;
	}

	private static <T, C> Collection<T> getCollectionInstance(Class<C> clazz) {
		Collection<T> result;
		if(Vector.class.equals(clazz)) {
			result = new Vector<T>();
		}else if(ArrayList.class.equals(clazz)) {
			result = new ArrayList<T>();
		}else if(HashSet.class.equals(clazz)) {
			result = new HashSet<T>();
		}else if(LinkedHashSet.class.equals(clazz)) {
			result = new LinkedHashSet<T>();
		}else if(LinkedList.class.equals(clazz)) {
			result = new LinkedList<T>();
		}else {
			result = new ArrayList<T>();
		}
		return result;
	}

}
