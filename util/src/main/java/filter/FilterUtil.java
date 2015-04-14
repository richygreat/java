package filter;

import java.util.ArrayList;
import java.util.Collection;
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
		Collection<T> result = new ArrayList<T>();
		for (T element : target) {
			if (predicate.apply(element)) {
				result.add(element);
			}
		}
		return result;
	}

}
