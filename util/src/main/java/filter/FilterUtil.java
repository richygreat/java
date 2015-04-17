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
		Collection<User> authorizedUsers = filter(allUsers, isAuthorized);
		System.out.println(authorizedUsers);
	}

	public static <T> Collection<T> filter(Collection<T> target,
			IPredicate<T> predicate) {
		Collection<T> result = getCollectionInstance(target);
		for (T element : target) {
			if (predicate.apply(element)) {
				result.add(element);
			}
		}
		return result;
	}

	private static <T> Collection<T> getCollectionInstance(Collection<T> target) {
		Collection<T> result;
		if(Vector.class.equals(target.getClass())) {
			result = new Vector<T>();
		}else if(ArrayList.class.equals(target.getClass())) {
			result = new ArrayList<T>();
		}else if(HashSet.class.equals(target.getClass())) {
			result = new HashSet<T>();
		}else if(LinkedHashSet.class.equals(target.getClass())) {
			result = new LinkedHashSet<T>();
		}else if(LinkedList.class.equals(target.getClass())) {
			result = new LinkedList<T>();
		}else {
			result = new ArrayList<T>();
		}
		return result;
	}

}
